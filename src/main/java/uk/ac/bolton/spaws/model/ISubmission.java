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


import com.navnorth.learningregistry.LRActivity;

public interface ISubmission {

	public abstract LRActivity getActivity();

	/**
	 * @return the signer
	 */
	public abstract String getSigner();

	/**
	 * @param signer the signer to set
	 */
	public abstract void setSigner(String signer);

	/**
	 * @return the submitter
	 */
	public abstract String getSubmitter();

	/**
	 * @param submitter the submitter to set
	 */
	public abstract void setSubmitter(String submitter);

	/**
	 * @return the submitterType
	 */
	public abstract String getSubmitterType();

	/**
	 * @param submitterType the submitterType to set
	 */
	public abstract void setSubmitterType(String submitterType);

	/**
	 * @return the submissionTOS
	 */
	public abstract String getSubmissionTOS();

	/**
	 * @param submissionTOS the submissionTOS to set
	 */
	public abstract void setSubmissionTOS(String submissionTOS);

	/**
	 * @return the submissionAttribution
	 */
	public abstract String getSubmissionAttribution();

	/**
	 * @param submissionAttribution the submissionAttribution to set
	 */
	public abstract void setSubmissionAttribution(String submissionAttribution);

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

}