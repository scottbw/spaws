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
package uk.ac.bolton.spaws.model.util;

import java.util.ArrayList;
import java.util.List;

import uk.ac.bolton.spaws.model.ISubmission;
import uk.ac.bolton.spaws.model.ISubmitter;

/**
 * Filters for submissions based on submitter information
 */
public class SubmitterSubmissionsFilter {
	
	/**
	 * Filter a set of submissions removing any from the supplied submitter
	 * @param submissions the list of submissions to filter
	 * @param submitter the submitter whose submissions should be omitted from the results
	 * @return the filtered list of submissions
	 */
	public List<ISubmission> omit(List<ISubmission> submissions, ISubmitter submitter){
		
		ArrayList<ISubmission> filteredSubmissions = new ArrayList<ISubmission>();
		
		for (ISubmission submission: submissions){
			if (!submission.getSubmitter().equals(submitter)){
				filteredSubmissions.add(submission);
			}
		}
		
		return filteredSubmissions;
	}

}
