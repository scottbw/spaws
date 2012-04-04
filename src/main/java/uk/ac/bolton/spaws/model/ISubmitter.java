package uk.ac.bolton.spaws.model;

public interface ISubmitter {

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

}