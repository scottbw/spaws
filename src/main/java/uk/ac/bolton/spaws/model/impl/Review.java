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

import com.navnorth.learningregistry.LRActivity;

import uk.ac.bolton.spaws.model.IReview;

/**
 * Review implementation
 */
public class Review extends Paradata implements IReview {
	
	public Review(){
	}
	
	public static final String VERB = "reviewed";
	
	public Review(String comment){
		setComment(comment);
	}

	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.IReview#getComment()
	 */
	public String getComment() {
		return getContent();
	}

	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.IReview#setComment(java.lang.String)
	 */
	public void setComment(String comment) {
		this.setContent(comment);
	}

	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.IParadata#getVerb()
	 */
	public String getVerb() {
		return VERB;
	}

	public void addMeasure(LRActivity activity) {
		// TODO Auto-generated method stub
	}	

}
