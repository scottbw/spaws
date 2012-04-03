package uk.ac.bolton.spaws;

import java.util.List;
import java.util.logging.Logger;

import uk.ac.bolton.spaws.model.ISubmission;

import com.navnorth.learningregistry.LRActivity;
import com.navnorth.learningregistry.LREnvelope;
import com.navnorth.learningregistry.LRException;
import com.navnorth.learningregistry.LRExporter;
import com.navnorth.learningregistry.LRResponse;
import com.navnorth.learningregistry.LRSigner;

public class ParadataPublisher {
	
	/**
	 * If true we'll output some debug code
	 */
	private boolean debug = true;
	
	/**
	 * The LR Node we publish to
	 */
    private String nodeDomain;	
    
    /**
     * The LR Signer that signs the envelope
     */
    private LRSigner signer;
    
    private String username;
    
    private String password;

	
	public ParadataPublisher(){
	}

	public ParadataPublisher(String nodeDomain){
		this.nodeDomain = nodeDomain;
	}
	
	/**
	 * Publish a paradata submission, consisting of an author, action and object
	 * 
	 * @param submission
	 * @throws LRException
	 */
	public void publish(ISubmission submission) throws LRException{	
		publish(submission.getActivity());
	}
	
	public void publish(LRActivity activity) throws LRException{
		
		// Setup exporter
		int batchSize = 1;
		LRExporter exporterLR = new LRExporter(batchSize, this.nodeDomain);
		if (username != null) exporterLR.setPublishAuthUser(username);
		if (password != null) exporterLR.setPublishAuthPassword(password);
		
		// Configure exporter
		try {
			exporterLR.configure();
		} 
		catch (LRException e) {
			return;
		}
		
		LREnvelope doc = activity;

		// TODO sign the doc
		if (this.signer != null){
			try {
				doc = this.signer.sign(doc);
			} catch (LRException e) {
				return;
			}
		}

		// Add envelope to exporter
		exporterLR.addDocument(doc);
		
		// Send data and get responses
		List<LRResponse> responses;
		try {
			responses = exporterLR.sendData();
		}
		catch(LRException e) {
			e.printStackTrace();
			throw e;
		}

		if (debug) output(responses);
		
	}
	
	public void output(List<LRResponse> responses){
		for (LRResponse res : responses)
		{
			System.out.print("<h2>Batch Results</h2>");
			System.out.print("Status Code: " + res.getStatusCode() + "<br/>");
			System.out.print("Status Reason: " + res.getStatusReason() + "<br/>");
			System.out.print("Batch Success: " + res.getBatchSuccess() + "<br/>");
			System.out.print("Batch Response: " + res.getBatchResponse() + "<br/><br/>");

			System.out.print("<h3>Published Resource(s)</h3>");        
			for(String id : res.getResourceSuccess())
			{
				System.out.print("Id: <a href=\"http://" + nodeDomain + "/harvest/getrecord?by_doc_ID=T&request_ID=" + id + "\" target=_\"blank\">" + id + "</a><br/>");
			}

			if (!res.getResourceFailure().isEmpty())
			{
				System.out.print("<br/>");
				System.out.print("<h3>Publish Errors</h3>");

				for(String message : res.getResourceFailure()) 
				{
					System.out.print("Error: " + message);
					System.out.print("<br/>");
				}
			}
		}
		System.out.print("</div><hr />");

	}
	
	/**
	 * @return the nodeDomain
	 */
	public String getNodeDomain() {
		return nodeDomain;
	}

	/**
	 * @param nodeDomain the nodeDomain to set
	 */
	public void setNodeDomain(String nodeDomain) {
		this.nodeDomain = nodeDomain;
	}

	/**
	 * @return the signerLR
	 */
	public LRSigner getSigner() {
		return signer;
	}

	/**
	 * @param signerLR the signerLR to set
	 */
	public void setSigner(LRSigner signer) {
		this.signer = signer;
	}

	/**
	 * @return the debug
	 */
	public boolean isDebug() {
		return debug;
	}

	/**
	 * @param debug the debug to set
	 */
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
