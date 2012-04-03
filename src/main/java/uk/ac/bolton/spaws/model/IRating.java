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

public interface IRating extends IParadata {
	
	public abstract int getRating();
	public abstract void setRating(int rating);
	
	public abstract int getMin();
	public abstract void setMin(int min);
	
	public abstract int getMax();
	public abstract void setMax(int max);
	
	public abstract int getSample();
	public abstract void setSample(int sample);
	

}
