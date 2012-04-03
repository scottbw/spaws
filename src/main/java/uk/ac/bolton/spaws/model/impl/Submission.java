package uk.ac.bolton.spaws.model.impl;

import com.navnorth.learningregistry.LRActivity;

import uk.ac.bolton.spaws.model.IActor;
import uk.ac.bolton.spaws.model.IParadata;
import uk.ac.bolton.spaws.model.ISubmission;

public class Submission implements ISubmission {
	
	private String signer = "SPAWS-TEST";
	private String submitter = "SPAWS-TEST";
	private String submitterType = "agent";
	private String submissionTOS = "http://creativecommons.org/licenses/by/3.0/";
	private String submissionAttribution = "SPAWS-TEST";
	private String resourceURL;
	private IParadata action;
	private IActor actor;
	
	public Submission(){
		
	}
	
	public Submission(Actor actor, Rating rating, String resourceUrl){
		setActor(actor);
		setAction(rating);
		setResourceURL(resourceUrl);
	}
	
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.impl.ISubmission#getActivity()
	 */
	public LRActivity getActivity(){
		LRActivity activity = new LRActivity(getResourceURL(), getSubmitter(), getSubmitterType(), getSubmissionTOS(), getSubmissionAttribution(), getSigner());
		activity.addActor("actor", getActor().getName(), null, null);
		activity.addVerb(getAction().getVerb(), null, null, null, null);
		getAction().addMeasure(activity);
		activity.addObject(null, null, getResourceURL());
		return activity;
	}
	
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.impl.ISubmission#getSigner()
	 */
	public String getSigner() {
		return signer;
	}
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.impl.ISubmission#setSigner(java.lang.String)
	 */
	public void setSigner(String signer) {
		this.signer = signer;
	}
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.impl.ISubmission#getSubmitter()
	 */
	public String getSubmitter() {
		return submitter;
	}
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.impl.ISubmission#setSubmitter(java.lang.String)
	 */
	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.impl.ISubmission#getSubmitterType()
	 */
	public String getSubmitterType() {
		return submitterType;
	}
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.impl.ISubmission#setSubmitterType(java.lang.String)
	 */
	public void setSubmitterType(String submitterType) {
		this.submitterType = submitterType;
	}
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.impl.ISubmission#getSubmissionTOS()
	 */
	public String getSubmissionTOS() {
		return submissionTOS;
	}
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.impl.ISubmission#setSubmissionTOS(java.lang.String)
	 */
	public void setSubmissionTOS(String submissionTOS) {
		this.submissionTOS = submissionTOS;
	}
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.impl.ISubmission#getSubmissionAttribution()
	 */
	public String getSubmissionAttribution() {
		return submissionAttribution;
	}
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.impl.ISubmission#setSubmissionAttribution(java.lang.String)
	 */
	public void setSubmissionAttribution(String submissionAttribution) {
		this.submissionAttribution = submissionAttribution;
	}
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.impl.ISubmission#getAction()
	 */
	public IParadata getAction() {
		return action;
	}
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.impl.ISubmission#setAction(uk.ac.bolton.spaws.model.IParadata)
	 */
	public void setAction(IParadata action) {
		this.action = action;
	}
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.impl.ISubmission#getActor()
	 */
	public IActor getActor() {
		return actor;
	}
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.impl.ISubmission#setActor(uk.ac.bolton.spaws.model.IActor)
	 */
	public void setActor(IActor actor) {
		this.actor = actor;
	}
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.impl.ISubmission#getResourceURL()
	 */
	public String getResourceURL() {
		return resourceURL;
	}
	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.impl.ISubmission#setResourceURL(java.lang.String)
	 */
	public void setResourceURL(String resourceURL) {
		this.resourceURL = resourceURL;
	}

}
