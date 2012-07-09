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
package uk.ac.bolton.spaws.filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import uk.ac.bolton.spaws.model.ISubmission;

/**
 * Abstract base class for a filter for normalizing a set of submissions
 */
public class NormalizingFilter{
	
	/**
	 * The verb to filter
	 */
	private String verb;
	
	public NormalizingFilter(String verb){
		this.verb = verb;
	}
	
	/**
	 * Given a list of submissions, return only the submissions that
	 * are unique for a given set of resources and actors, taking the most recent
	 * as being the definitive.
	 * @param submissions
	 * @return a list of filtered submissions
	 */
	public List<ISubmission> filter(List<ISubmission> submissions){
		
		//
		// Make a copy of the submissions
		//
		List<ISubmission> sortedSubmissions = new ArrayList<ISubmission>();
		sortedSubmissions.addAll(submissions);
		
		//
		// Sort newest-first
		//
		Collections.sort(sortedSubmissions, new SubmissionComparator());
		
		//
		// Create the output array
		//
		List<ISubmission> filteredSubmissions = new ArrayList<ISubmission>();
		
		//
		// Iterate and add 
		//
		for (ISubmission submission:sortedSubmissions){
			if (submission.getAction() != null){
				if (submission.getAction().getVerb() != null){
					if (submission.getAction().getVerb().equals(verb)){
						if (!filteredSubmissions.contains(submission)){
							filteredSubmissions.add(submission);
						}
					}
				}
			}
		}
		
		return filteredSubmissions;
	}
	
	
	/**
	 * Sort comparator for submissions; orders most recent updates first
	 */
	public class SubmissionComparator implements Comparator<ISubmission> {	
		
	    /* (non-Javadoc)
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		public int compare(ISubmission o1, ISubmission o2) {
	        return o2.getUpdated().compareTo(o1.getUpdated());
		}
	}


}
