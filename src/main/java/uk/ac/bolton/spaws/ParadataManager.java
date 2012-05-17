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

import uk.ac.bolton.spaws.filter.NormalizingFilter;
import uk.ac.bolton.spaws.filter.SubmitterSubmissionsFilter;
import uk.ac.bolton.spaws.model.INode;
import uk.ac.bolton.spaws.model.IRating;
import uk.ac.bolton.spaws.model.IStats;
import uk.ac.bolton.spaws.model.ISubmission;
import uk.ac.bolton.spaws.model.ISubmitter;

public class ParadataManager {
	
	private ISubmitter submitter;
	private INode node;

	public ParadataManager(ISubmitter submitter , INode node) throws Exception{
		
		if (submitter == null){
			throw new Exception("No submitter provided");
		}
		if (node == null){
			throw new Exception("No node provided");
		}
		
		this.submitter = submitter;
		this.node = node;
	}

	/**
	 * Return all paradata for a resource of all types from all submitters for the resource
	 * @param resourceUrl
	 * @return
	 * @throws Exception
	 */
	public List<ISubmission> getSubmissions(String resourceUrl) throws Exception{
		ParadataFetcher fetcher = new ParadataFetcher(node, resourceUrl);
		return fetcher.getSubmissions();
	}
	
	/**
	 * Return all paradata for a resource of all types from other submitters for the resource
	 * @param resourceUrl
	 * @return
	 * @throws Exception
	 */
	public List<ISubmission> getExternalSubmissions(String resourceUrl) throws Exception{
		return new SubmitterSubmissionsFilter().omit(getSubmissions(resourceUrl), submitter);
	}
	
	/**
	 * Return all stats from other submitters for the resource
	 * @param resourceUrl
	 * @return
	 * @throws Exception
	 */
	public List<ISubmission> getExternalStats(String resourceUrl) throws Exception{
		return getExternalSubmissions(resourceUrl, IStats.VERB);
	}
	
	/**
	 * Return all rating submissions from other submitters for the resource
	 * @param resourceUrl
	 * @return
	 * @throws Exception
	 */
	public List<ISubmission> getExternalRatingSubmissions(String resourceUrl) throws Exception{
		return getExternalSubmissions(resourceUrl, IRating.VERB);
	}
	
	/**
	 * Return all submissions using the specified verb from other submitters for the resource
	 * @param resourceUrl
	 * @param verb
	 * @return
	 * @throws Exception
	 */
	public List<ISubmission> getExternalSubmissions(String resourceUrl, String verb) throws Exception{
		return new SubmitterSubmissionsFilter().omit(new NormalizingFilter(verb).filter(getSubmissions(resourceUrl)), submitter);
	}	
	
	/**
	 * Return all submissions using the specified verb from the specified submitter for the resource
	 * @param submitter
	 * @param resourceUrl
	 * @return
	 * @throws Exception
	 */
	public List<ISubmission> getSubmissionsForSubmitter(ISubmitter submitter, String resourceUrl, String verb) throws Exception{
		return new SubmitterSubmissionsFilter().include(new NormalizingFilter(IRating.VERB).filter(getSubmissions(resourceUrl)), submitter);
	}
	
	/**
	 * Publish a collection of submissions; this can be a mix of submission types and be about different resources
	 * @param submissions
	 * @throws Exception
	 */
	public void publishSubmissions(List<ISubmission> submissions) throws Exception{
		ParadataPublisher publisher = new ParadataPublisher(node);
		for (ISubmission submission: submissions){
			publisher.publish(submission);
		}
	}

}
