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

import uk.ac.bolton.spaws.model.IRating;

public class Rating implements IRating {
	
	public Rating(int rating){
		this.sample = 1;
		this.min = 0;
		this.max = 5;
		this.rating = rating;		
	}
	
	private int rating;
	private int min;
	private int max;
	private int sample;
	
	public Rating(){
		this.sample = 1;
		this.min = 0;
		this.max = 5;
		this.rating = 0;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getSample() {
		return sample;
	}

	public void setSample(int sample) {
		this.sample = sample;
	}

	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.IParadata#getVerb()
	 */
	public String getVerb() {
		return "rated";
	}

	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.IParadata#addMeasure(com.navnorth.learningregistry.LRActivity)
	 */
	public void addMeasure(LRActivity activity) {
		activity.addMeasureToVerb("rated", getRating(), getMin(), getMax(), getSample());
	}

}
