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
package uk.ac.bolton.spaws.model.impl;

import uk.ac.bolton.spaws.model.IActor;

public class Actor implements IActor {
	
	public Actor(){	
	}
	
	public Actor(String name){
		this.name = name;
	}	
	
	private String name;
	private String url;
	
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.IActor#getUrl()
	 */
	public String getUrl() {
		return url;
	}

	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.IActor#setUrl(java.lang.String)
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.IActor#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.IActor#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	

}
