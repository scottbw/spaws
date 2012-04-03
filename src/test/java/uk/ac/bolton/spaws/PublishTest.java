package uk.ac.bolton.spaws;

import java.security.KeyStoreException;

import org.junit.BeforeClass;
import org.junit.Test;

import uk.ac.bolton.spaws.model.ISubmission;
import uk.ac.bolton.spaws.model.impl.Actor;
import uk.ac.bolton.spaws.model.impl.Rating;
import uk.ac.bolton.spaws.model.impl.Submission;

import com.navnorth.learningregistry.*;

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
public class PublishTest {
	
	private static final String MIMAS_TEST_NODE_URL = "alpha.mimas.ac.uk";
	private static final String WIDGET_URI = "http://wookie.apache.org/widgets/youtube";
	
	private static ParadataPublisher publisher;
	
	@BeforeClass
	public static void setup(){
		publisher = new ParadataPublisher(MIMAS_TEST_NODE_URL);
		publisher.setUsername("fred");
		publisher.setPassword("flintstone");
	}

	@Test
	public void publish1() throws KeyStoreException, LRException{
		Rating rating = new Rating(4);
		Actor actor = new Actor("Bill");
		ISubmission submission = new Submission(actor, rating, WIDGET_URI);
		publisher.publish(submission);
	}

	@Test
	public void publish2() throws KeyStoreException, LRException{
		Rating rating = new Rating(2);
		Actor actor = new Actor("Amy");
		ISubmission submission = new Submission(actor, rating, WIDGET_URI);
		publisher.publish(submission);
	}

	@Test
	public void publish3() throws KeyStoreException, LRException{
		Rating rating = new Rating(3);
		Actor actor = new Actor("Chloe");
		ISubmission submission = new Submission(actor, rating, WIDGET_URI);
		publisher.publish(submission);
	}	
	
}