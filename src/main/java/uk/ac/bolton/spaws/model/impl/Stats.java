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

import uk.ac.bolton.spaws.model.IStats;

public class Stats extends Paradata implements IStats {
	
	private int downloads;
	private int embeds;
	private int likes;
	private int views;

	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.IParadata#getVerb()
	 */
	public String getVerb() {
		return VERB;
	}

	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.IParadata#addMeasure(com.navnorth.learningregistry.LRActivity)
	 */
	public void addMeasure(LRActivity activity) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.IParadata#getContent()
	 */
	public String getContent() {
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.IStats#getDownloads()
	 */
	public int getDownloads() {
		return downloads;
	}

	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.IStats#setDownloads(int)
	 */
	public void setDownloads(int downloads) {
		this.downloads = downloads;
	}

	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.IStats#getEmbeds()
	 */
	public int getEmbeds() {
		return embeds;
	}

	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.IStats#setEmbeds(int)
	 */
	public void setEmbeds(int embeds) {
		this.embeds = embeds;
	}

	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.IStats#getLikes()
	 */
	public int getLikes() {
		return likes;
	}

	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.IStats#setLikes(int)
	 */
	public void setLikes(int likes) {
		this.likes = likes;
	}

	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.IStats#getViews()
	 */
	public int getViews() {
		return views;
	}

	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.IStats#setViews(int)
	 */
	public void setViews(int views) {
		 this.views = views;
	}

}
