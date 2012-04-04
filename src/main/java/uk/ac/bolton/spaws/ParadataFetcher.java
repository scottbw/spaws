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


import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.navnorth.learningregistry.LRImporter;
import com.navnorth.learningregistry.LRResult;

import uk.ac.bolton.spaws.model.ISubmission;
import uk.ac.bolton.spaws.model.util.SubmissionFactory;

/**
 * Fetches submissions from a node
 */
public class ParadataFetcher {
	
	/*
	 * The identifier for the widget, e.g. http://incubator.apache.org/wookie/widgets/youtube
	 */
	private String widgetIdentifier;
	
	/*
	 * The LR Node we pull from
	 */
    private String nodeDomain;	
    
    /*
     * The protocol, e.g. "https"
     */
    private String nodeProtocol;
	
    /**
     * Construct a new ParadataFetcher
     * @param protocol the node protocol, e.g. "https"
     * @param host the node host, e.g. "my.node.edu"
     * @param identifier the resource identifier, e.g. "http://wookie.apache.org/widgets/youtube"
     */
	public ParadataFetcher(String protocol, String host, String identifier){
		this.nodeProtocol = protocol;
		this.nodeDomain = host;
		this.widgetIdentifier = identifier;
	}
	
	/**
	 * Get the submissions associated with the resource
	 * @return a List of ISubmission objects
	 * @throws Exception
	 */
	public List<ISubmission> getSubmissions() throws Exception{
		
		List<ISubmission> submissions = new ArrayList<ISubmission>();
		
		LRImporter importer = new LRImporter(nodeDomain, nodeProtocol);
		
		submissions = getMoreSubmissions(importer, submissions, null);
		
		return submissions;
	}
	
	/**
	 * Recursively add submissions by paging through a result set
	 * @param importer the LRImporter being used to obtain results
	 * @param submissions the List of submissions found so far
	 * @param resumptionToken the token from the last request made
	 * @return the updated List of ISubmissions
	 * @throws Exception
	 */
	private List<ISubmission> getMoreSubmissions(LRImporter importer, List<ISubmission> submissions, String resumptionToken) throws Exception{
		
		LRResult result;
		

		if (resumptionToken == null){
			//
			// If there is no resumption token, this is the first request so
			// supply all the parameters for the initial request
			//
			result = importer.getObtainJSONData(widgetIdentifier, true, false, false);
		} else {
			//
			// If there is a resumption token, use it to obtain the next paged set of results
			//
			result = importer.getObtainJSONData(resumptionToken);
		}
		
		//
		// If there are no results return the initial List without modification
		//
		if (result == null || result.getDocuments().size() == 0) return submissions;
		
		//
		// Get the result document
		//
		JSONArray records = result.getDocuments().get(0).getJSONArray("document");
		
		//
		// Creating submission objects for each record
		//
		for (int i=0;i<records.length();i++){
			JSONObject record = records.getJSONObject(i);
			ISubmission rating = SubmissionFactory.createSubmission(record, this.widgetIdentifier);
			if (rating != null){
				submissions.add(rating);
			}
		}
		
		//
		// If there is a resumption token, get the next result set by 
		// calling this method again and passing in both the token and
		// the submissions List
		//
		if (result.getResumptionToken() != null && !result.getResumptionToken().equals("null")){
			submissions = getMoreSubmissions(importer, submissions, result.getResumptionToken());
		}
		
		return submissions;
	}

}
