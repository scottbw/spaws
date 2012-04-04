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

import uk.ac.bolton.spaws.model.ISubmitter;

/**
 * Model for a submitter - an organisation that publishes submissions to a node
 */
public class Submitter implements ISubmitter {
	
	private String signer = "SPAWS-TEST";
	private String submitter = "SPAWS-TEST";
	private String submitterType = "agent";
	private String submissionTOS = "http://creativecommons.org/licenses/by/3.0/";
	private String submissionAttribution = "SPAWS-TEST";
	
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.impl.ISubmitter#getSigner()
	 */
	public String getSigner() {
		return signer;
	}
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.impl.ISubmitter#setSigner(java.lang.String)
	 */
	public void setSigner(String signer) {
		this.signer = signer;
	}
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.impl.ISubmitter#getSubmitter()
	 */
	public String getSubmitter() {
		return submitter;
	}
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.impl.ISubmitter#setSubmitter(java.lang.String)
	 */
	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.impl.ISubmitter#getSubmitterType()
	 */
	public String getSubmitterType() {
		return submitterType;
	}
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.impl.ISubmitter#setSubmitterType(java.lang.String)
	 */
	public void setSubmitterType(String submitterType) {
		this.submitterType = submitterType;
	}
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.impl.ISubmitter#getSubmissionTOS()
	 */
	public String getSubmissionTOS() {
		return submissionTOS;
	}
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.impl.ISubmitter#setSubmissionTOS(java.lang.String)
	 */
	public void setSubmissionTOS(String submissionTOS) {
		this.submissionTOS = submissionTOS;
	}
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.impl.ISubmitter#getSubmissionAttribution()
	 */
	public String getSubmissionAttribution() {
		return submissionAttribution;
	}
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.impl.ISubmitter#setSubmissionAttribution(java.lang.String)
	 */
	public void setSubmissionAttribution(String submissionAttribution) {
		this.submissionAttribution = submissionAttribution;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object) {
		if (this.submitter.equals(((ISubmitter)object).getSubmitter())){
			if (this.getSubmitterType().equals(((ISubmitter)object).getSubmitterType())){
				return true;
			}
		}
		return false;
	}	

}
