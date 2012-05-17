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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Map;

import org.junit.Test;

import com.navnorth.learningregistry.LRActivity;

import uk.ac.bolton.spaws.model.impl.Ratings;

public class RatingsTest {
	
	@Test
	public void create(){
		Ratings ratings = new Ratings();
		assertTrue(ratings.getAverage()==0.0);
		assertEquals(0, ratings.getSample());
		assertEquals(0, ratings.getMin());
		assertEquals(5, ratings.getMax());
		assertEquals("allrated", ratings.getVerb());
	}
	
	@Test
	public void update(){
		Ratings ratings = new Ratings();
		
		ratings.setAverage(3.2);
		ratings.setSample(34);
		ratings.setMin(0);
		ratings.setMax(4);
		
		assertTrue(ratings.getAverage()==3.2);
		assertEquals(34, ratings.getSample());
		assertEquals(0, ratings.getMin());
		assertEquals(4, ratings.getMax());
		assertEquals("allrated", ratings.getVerb());
	}

	
	@Test
	public void activity(){
		LRActivity activity = new LRActivity("http://opera.com/widgets/bubbles", "SPAWS-TEST", "agent", null, "SPAWS-TEST", "SPAWS-TEST");
		activity.addVerb(Ratings.VERB, new Date(), null, null, null);
		
		Ratings ratings = new Ratings();
		ratings.addMeasure(activity);
		@SuppressWarnings("rawtypes")
		Map map = (Map) ((Map) ((Map) ((Map) activity.getResourceData()).get("activity")).get("verb")).get("measure");
		assertEquals(0, map.get("sampleSize"));
		assertEquals(0, map.get("scaleMin"));
		assertEquals(5, map.get("scaleMax"));
		assertEquals(0.0, map.get("value"));
	}
	
	@Test
	public void content(){
		Ratings ratings = new Ratings();
		assertNull(ratings.getContent());
	}
}
