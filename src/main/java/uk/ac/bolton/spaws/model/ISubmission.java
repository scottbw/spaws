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


import java.util.Date;

import uk.ac.bolton.spaws.Submitter;

import com.navnorth.learningregistry.LRActivity;

public interface ISubmission {

	public abstract LRActivity getActivity();

	/**
	 * Set the submitter for the submission
	 * @param submitter
	 */
	public abstract void setSubmitter(Submitter submitter);
	
	/**
	 * Get the submitter for this submission
	 * @return
	 */
	public abstract Submitter getSubmitter();
	
	/**
	 * @return the action
	 */
	public abstract IParadata getAction();

	/**
	 * @param action the action to set
	 */
	public abstract void setAction(IParadata action);

	/**
	 * @return the actor
	 */
	public abstract IActor getActor();

	/**
	 * @param actor the actor to set
	 */
	public abstract void setActor(IActor actor);

	/**
	 * @return the resourceURL
	 */
	public abstract String getResourceURL();

	/**
	 * @param resourceURL the resourceURL to set
	 */
	public abstract void setResourceURL(String resourceURL);
	
	/**
	 * Get the rating of the submission, if this is a valid type
	 * @return
	 */
	public abstract IRating getRating();
	
	/**
	 * Get the date the submission was published
	 * @return
	 */
	public abstract Date getUpdated();
	
	/**
	 * Set the data the submission was published
	 * @param date
	 */
	public abstract void setUpdated(Date date);
}