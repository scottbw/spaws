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

import org.junit.Test;

import uk.ac.bolton.spaws.model.impl.Actor;

public class ActorTest {
	
	@Test
	public void create(){
		Actor actor = new Actor("Bob");
		assertEquals("Bob", actor.getName());
		assertNull(actor.getUrl());
	}
	
	@Test
	public void update(){
		Actor actor = new Actor();
		actor.setName("Chris");
		actor.setUrl("http://spaws-test.com/profiles/chris");
		assertEquals("Chris", actor.getName());
		assertEquals("http://spaws-test.com/profiles/chris", actor.getUrl());
	}



}
