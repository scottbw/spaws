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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.Map;

import org.junit.Test;

import uk.ac.bolton.spaws.model.impl.Review;

import com.navnorth.learningregistry.LRActivity;

public class ReviewTest {
	
	@Test
	public void contruct(){
		Review review = new Review();
		assertNotNull(review);
	}
	
	@Test
	public void update(){
		Review review = new Review();
		review.setComment("test");
		assertEquals("test",review.getComment());
		assertEquals("test", review.getContent());
	}

	@Test
	public void activity(){
		LRActivity activity = new LRActivity("http://opera.com/widgets/bubbles", "SPAWS-TEST", "agent", null, "SPAWS-TEST", "SPAWS-TEST");
		
		Review review = new Review();
		review.setComment("test");
		
		activity.addVerb(Review.VERB, new Date(), null, null, review.getComment());
		activity.addContent(review.getContent());
		
		@SuppressWarnings("rawtypes")
		Map map = (Map) ((Map) ((Map) ((Map) activity.getResourceData()).get("activity")));		
		assertEquals("test", map.get("content"));
	}
}
