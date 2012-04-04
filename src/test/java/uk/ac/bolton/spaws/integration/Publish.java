/*
 *  (c) 2012 University of Bolton
 *  
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.ac.bolton.spaws.integration;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import uk.ac.bolton.spaws.ParadataFetcher;
import uk.ac.bolton.spaws.ParadataPublisher;
import uk.ac.bolton.spaws.model.ISubmission;
import uk.ac.bolton.spaws.model.ISubmitter;
import uk.ac.bolton.spaws.model.impl.Actor;
import uk.ac.bolton.spaws.model.impl.Rating;
import uk.ac.bolton.spaws.model.impl.Submission;
import uk.ac.bolton.spaws.model.impl.Submitter;
import uk.ac.bolton.spaws.model.util.RatingSubmissionsFilter;
import uk.ac.bolton.spaws.model.util.SubmitterSubmissionsFilter;

import com.navnorth.learningregistry.LRException;

public class Publish {
	
	private static final String MIMAS_TEST_NODE_URL = "alpha.mimas.ac.uk";
	private static final String WIDGET_URI = "http://wookie.apache.org/widgets/youtube";
	
	private static ParadataPublisher publisher;
	
	@BeforeClass
	public static void setup() throws LRException, InterruptedException{
		publisher = new ParadataPublisher(MIMAS_TEST_NODE_URL);
		publisher.setUsername("fred");
		publisher.setPassword("flintstone");

		Rating rating;
		Actor actor;
		ISubmission submission;
		
		rating = new Rating(1);
		actor = new Actor("Bill");
		submission = new Submission(actor, rating, WIDGET_URI);
		publisher.publish(submission);
		
		rating = new Rating(1);
		actor = new Actor("Amy");
		submission = new Submission(actor, rating, WIDGET_URI);
		publisher.publish(submission);
		
		rating = new Rating(1);
		actor = new Actor("Chloe");
		submission = new Submission(actor, rating, WIDGET_URI);
		publisher.publish(submission);
		
		Thread.sleep(2000);
	}

	@Test
	public void UpdateRatings() throws Exception{
		
		Rating rating;
		Actor actor;
		ISubmission submission;
		
		rating = new Rating(5);
		actor = new Actor("Bill");
		submission = new Submission(actor, rating, WIDGET_URI);
		publisher.publish(submission);
		
		rating = new Rating(5);
		actor = new Actor("Amy");
		submission = new Submission(actor, rating, WIDGET_URI);
		publisher.publish(submission);
		
		rating = new Rating(5);
		actor = new Actor("Chloe");
		submission = new Submission(actor, rating, WIDGET_URI);
		publisher.publish(submission);
		
		Thread.sleep(20000);
		
		ParadataFetcher fetcher = new ParadataFetcher("http", MIMAS_TEST_NODE_URL, WIDGET_URI);
		List<ISubmission> submissions = new RatingSubmissionsFilter().filter(fetcher.getSubmissions());
		System.out.println("\nRESULTS");		
		for (int i=0;i<submissions.size();i++){

			ISubmission s = submissions.get(i);
			System.out.println("Rating: "+s.getRating().getRating() + " From: " + s.getActor().getName() + " Date:"+s.getUpdated().toGMTString());			
		}
		
		assertEquals(5, submissions.get(0).getRating().getRating());
		assertEquals(5, submissions.get(1).getRating().getRating());
		assertEquals(5, submissions.get(2).getRating().getRating());		

	}
	
	@Test
	public void filterBySubmitter() throws Exception{
		ISubmitter submitter = new Submitter();
		submitter.setSubmitter("SPAWS-TEST");
		submitter.setSubmitterType("agent");
		
		ParadataFetcher fetcher = new ParadataFetcher("http", MIMAS_TEST_NODE_URL, WIDGET_URI);
		List<ISubmission> submissions = new SubmitterSubmissionsFilter().omit(new RatingSubmissionsFilter().filter(fetcher.getSubmissions()), submitter);
		assertEquals(0, submissions.size());
	}
	
	@Test
	public void filterBySubmitter2() throws Exception{
		ISubmitter submitter = new Submitter();
		submitter.setSubmitter("NOBODY");
		submitter.setSubmitterType("agent");
		
		ParadataFetcher fetcher = new ParadataFetcher("http", MIMAS_TEST_NODE_URL, WIDGET_URI);
		List<ISubmission> submissions = new SubmitterSubmissionsFilter().omit(new RatingSubmissionsFilter().filter(fetcher.getSubmissions()), submitter);
		assertEquals(3, submissions.size());
	}
}
