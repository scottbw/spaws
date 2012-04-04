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

/**
 * Model for a submitter - an organisation that publishes submissions to a node
 */
public class Submitter {
	
	private String signer = "SPAWS-TEST";
	private String submitter = "SPAWS-TEST";
	private String submitterType = "agent";
	private String submissionTOS = "http://creativecommons.org/licenses/by/3.0/";
	private String submissionAttribution = "SPAWS-TEST";
	
	/**
	 * @return the signer
	 */
	public String getSigner() {
		return signer;
	}
	/**
	 * @param signer the signer to set
	 */
	public void setSigner(String signer) {
		this.signer = signer;
	}
	/**
	 * @return the submitter
	 */
	public String getSubmitter() {
		return submitter;
	}
	/**
	 * @param submitter the submitter to set
	 */
	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}
	/**
	 * @return the submitterType
	 */
	public String getSubmitterType() {
		return submitterType;
	}
	/**
	 * @param submitterType the submitterType to set
	 */
	public void setSubmitterType(String submitterType) {
		this.submitterType = submitterType;
	}
	/**
	 * @return the submissionTOS
	 */
	public String getSubmissionTOS() {
		return submissionTOS;
	}
	/**
	 * @param submissionTOS the submissionTOS to set
	 */
	public void setSubmissionTOS(String submissionTOS) {
		this.submissionTOS = submissionTOS;
	}
	/**
	 * @return the submissionAttribution
	 */
	public String getSubmissionAttribution() {
		return submissionAttribution;
	}
	/**
	 * @param submissionAttribution the submissionAttribution to set
	 */
	public void setSubmissionAttribution(String submissionAttribution) {
		this.submissionAttribution = submissionAttribution;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object) {
		if (this.submitter.equals(((Submitter)object).getSubmitter())){
			if (this.getSubmitterType().equals(((Submitter)object).getSubmitterType())){
				return true;
			}
		}
		return false;
	}	

}
