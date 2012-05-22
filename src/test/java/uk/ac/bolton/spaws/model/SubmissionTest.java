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
package uk.ac.bolton.spaws.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Map;

import org.junit.Test;

import com.navnorth.learningregistry.LRActivity;

import uk.ac.bolton.spaws.model.impl.Actor;
import uk.ac.bolton.spaws.model.impl.Rating;
import uk.ac.bolton.spaws.model.impl.Review;
import uk.ac.bolton.spaws.model.impl.Submission;
import uk.ac.bolton.spaws.model.impl.Submitter;

public class SubmissionTest {

	@Test
	public void create(){
		Submission submission = new Submission();
	}
	
	@Test
	public void create2(){
		Rating rating = new Rating(2);
		Actor actor = new Actor("Alice");
		String resourceUrl = "http://widgets.opera.com/bubbles";
		Submission submission = new Submission(actor, rating, resourceUrl);
		assertEquals("Alice", submission.getActor().getName());
		assertEquals("http://widgets.opera.com/bubbles", submission.getResourceURL());
		assertEquals("rated", submission.getAction().getVerb());
	}
	
	@Test
	public void create3(){
		Rating rating = new Rating(2);
		Actor actor = new Actor("Alice");
		String resourceUrl = "http://widgets.opera.com/bubbles";
		Submitter submitter = new Submitter();
		Submission submission = new Submission(submitter, actor, rating, resourceUrl);
		assertEquals("Alice", submission.getActor().getName());
		assertEquals("http://widgets.opera.com/bubbles", submission.getResourceURL());
		assertEquals("rated", submission.getAction().getVerb());
		assertEquals("SPAWS-TEST", submission.getSubmitter().getSubmitter());
	}
	
	@Test
	public void create4(){
		Rating rating = new Rating(2);
		Actor actor = new Actor("Alice");
		String resourceUrl = "http://widgets.opera.com/bubbles";
		Submitter submitter = new Submitter();
		Date date = new Date();
		Submission submission = new Submission(submitter, actor, rating, resourceUrl, date);
		assertEquals("Alice", submission.getActor().getName());
		assertEquals("http://widgets.opera.com/bubbles", submission.getResourceURL());
		assertEquals("rated", submission.getAction().getVerb());
		assertEquals("SPAWS-TEST", submission.getSubmitter().getSubmitter());
		assertEquals(date, submission.getUpdated());
	}
	
	@Test
	public void update(){
		Submission submission = new Submission();
		
		Rating rating = new Rating(2);
		Actor actor = new Actor("Alice");
		submission.setAction(rating);
		submission.setActor(actor);
		submission.setResourceURL("http://widgets.opera.com/bubbles");
		submission.setUpdated(new Date());
		
		assertEquals("Alice", submission.getActor().getName());
		assertEquals("http://widgets.opera.com/bubbles", submission.getResourceURL());
		assertEquals("rated", submission.getAction().getVerb());
	}
	
	
	@Test
	public void activity(){
		Rating rating = new Rating(2);
		Actor actor = new Actor("Alice");
		String resourceUrl = "http://widgets.opera.com/bubbles";
		Submitter submitter = new Submitter();
		Date date = new Date();
		Submission submission = new Submission(submitter, actor, rating, resourceUrl, date);
		
		LRActivity activity = submission.getActivity();
		@SuppressWarnings("rawtypes")
		Map map = (Map) ((Map) ((Map) ((Map) activity.getResourceData()).get("activity")).get("verb")).get("measure");
		assertEquals(1, map.get("sampleSize"));
		assertEquals(0, map.get("scaleMin"));
		assertEquals(5, map.get("scaleMax"));
		assertEquals(2, map.get("value"));
	}
	
	@Test
	public void activityContext(){
		Review review = new Review("OK");
		review.setContextUrl("http://mystore.com/widgets/3");
		Actor actor = new Actor("Alice");
		String resourceUrl = "http://widgets.opera.com/bubbles";
		Submitter submitter = new Submitter();
		Date date = new Date();
		Submission submission = new Submission(submitter, actor, review, resourceUrl, date);
		
		LRActivity activity = submission.getActivity();
		@SuppressWarnings("rawtypes")
		Map map = (Map) ((Map) ((Map) ((Map) activity.getResourceData()).get("activity")).get("verb")).get("context");
		assertEquals("http://mystore.com/widgets/3", map.get("id"));
		assertEquals("Widget", map.get("objectType"));
		assertEquals("Detail page", map.get("description"));
	}
	
	@Test
	public void equals(){
		Submission submission = new Submission();
		
		Rating rating = new Rating(2);
		Actor actor = new Actor("Alice");
		submission.setAction(rating);
		submission.setActor(actor);
		submission.setResourceURL("http://widgets.opera.com/bubbles");
		submission.setUpdated(new Date());
		
		Submission submission2 = new Submission();
		
		Rating rating2 = new Rating(2);
		Actor actor2 = new Actor("Alice");
		submission2.setAction(rating2);
		submission2.setActor(actor2);
		submission2.setResourceURL("http://widgets.opera.com/bubbles");
		submission2.setUpdated(new Date());
		
		assertTrue(submission.equals(submission2));
	}
	
	
	@Test
	public void equals2(){
		Submission submission = new Submission();
		
		Rating rating = new Rating(2);
		Actor actor = new Actor("Bob");
		submission.setAction(rating);
		submission.setActor(actor);
		submission.setResourceURL("http://widgets.opera.com/bubbles");
		submission.setUpdated(new Date());
		
		Submission submission2 = new Submission();
		
		Rating rating2 = new Rating(2);
		Actor actor2 = new Actor("Alice");
		submission2.setAction(rating2);
		submission2.setActor(actor2);
		submission2.setResourceURL("http://widgets.opera.com/bubbles");
		submission2.setUpdated(new Date());
		
		assertFalse(submission.equals(submission2));
	}

}
