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
package uk.ac.bolton.spaws;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.navnorth.learningregistry.LRSigner;

public class ParadataPublisherTest {
	
	
	@Test
	public void create(){
		ParadataPublisher publisher = new ParadataPublisher();
		publisher.setDebug(true);
		assertEquals(true, publisher.isDebug());
	}
	
	@Test
	public void signer(){
		ParadataPublisher publisher = new ParadataPublisher();
		LRSigner signer = new LRSigner("PUBLIC", "PRIVATE", "PASSPHRASE");
		publisher.setSigner(signer);
		assertEquals(signer.hashCode(), publisher.getSigner().hashCode());
	}

}
