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

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

import uk.ac.bolton.spaws.model.impl.Node;

public class NodeTest {
	
	@Test
	public void create() throws MalformedURLException{
		Node node = new Node(new URL("http://test.org"));
		assertEquals("test.org", node.getHost());
		assertEquals("http", node.getScheme());
	}
	
	@Test
	public void create2(){
		Node node = new Node("http", "test.org");
		assertEquals("test.org", node.getHost());
		assertEquals("http", node.getScheme());		
	}


	@Test
	public void modify(){
		Node node = new Node("http", "test.org");
		node.setHost("newhost.org");
		node.setScheme("https");
		assertEquals("newhost.org", node.getHost());
		assertEquals("https", node.getScheme());		
	}
	
	@Test
	public void modifyUsernamePassword() throws MalformedURLException{
		Node node = new Node(new URL("http://test.org"), "user", "password");
		assertEquals("user", node.getUsername());
		assertEquals("password", node.getPassword());
		node.setUsername("test");
		node.setPassword("test");
		assertEquals("test", node.getUsername());
		assertEquals("test", node.getPassword());
	}
	
}
