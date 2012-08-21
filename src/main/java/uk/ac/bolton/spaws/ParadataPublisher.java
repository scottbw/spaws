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

import java.util.List;

import uk.ac.bolton.spaws.model.INode;
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
    private INode node;	
    
    /**
     * The LR Signer that signs the envelope
     */
    private LRSigner signer;
	
	public ParadataPublisher(){
	}

	public ParadataPublisher(INode node){
		this.node = node;
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
		LRExporter exporterLR = new LRExporter(batchSize, this.node.getHost());
		if (this.node.getUsername() != null) exporterLR.setPublishAuthUser(this.node.getUsername());
		if (this.node.getPassword() != null) exporterLR.setPublishAuthPassword(this.node.getPassword());
		
		// Configure exporter
		try {
			exporterLR.configure();
		} 
		catch (LRException e) {
			return;
		}
		
		LREnvelope doc = activity;

		if (this.signer != null){
			doc = this.signer.sign(doc);
		}

		// Add envelope to exporter
		exporterLR.addDocument(doc);
		
		// Send data and get responses
		@SuppressWarnings("unused")
		List<LRResponse> responses;
		try {
			responses = exporterLR.sendData();
		}
		catch(LRException e) {
			e.printStackTrace();
			throw e;
		}
		
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

}
