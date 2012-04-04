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
package uk.ac.bolton.spaws.filter;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

import uk.ac.bolton.spaws.model.ISubmission;
import uk.ac.bolton.spaws.model.impl.Actor;
import uk.ac.bolton.spaws.model.impl.Rating;
import uk.ac.bolton.spaws.model.impl.Submission;
import uk.ac.bolton.spaws.model.impl.Submitter;

public class RatingSubmissionsFilterTest {
	
	@Test
	public void filterDuplicateSubmissions(){
		
		String resourceUrl = "TEST_RESOURCE";
		
		List<ISubmission> submissions = new ArrayList<ISubmission>();
		
		Date now = new Date();
		Date later = new Date(now.getTime()+100);
		
		submissions.add(new Submission(new Submitter(), new Actor("Alice"), new Rating(3), resourceUrl, now));
		submissions.add(new Submission(new Submitter(), new Actor("Bob"), new Rating(1), resourceUrl, now));	
		submissions.add(new Submission(new Submitter(), new Actor("Bob"), new Rating(5), resourceUrl, later));	
		
		List<ISubmission> results = new RatingSubmissionsFilter().filter(submissions);
		
		assertEquals(2, results.size());
		
		ISubmission alice = null;
		ISubmission bob = null;
		
		for (ISubmission submission: results){
			if (submission.getActor().getName().equals("Alice")){
				alice = submission;
			} else {
				bob = submission;
			}
		}
		
		assertEquals(5, bob.getRating().getRating());
		assertEquals(3, alice.getRating().getRating());
	}

}
