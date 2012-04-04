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

import org.json.JSONException;
import org.json.JSONObject;

import uk.ac.bolton.spaws.Submitter;

public class SubmitterFactory {
	
	public static Submitter createSubmitter(JSONObject object) throws JSONException{
		Submitter submitter = new Submitter();
		if (object.has("identity")){
			submitter.setSigner(object.getJSONObject("identity").getString("signer"));
			submitter.setSubmitter(object.getJSONObject("identity").getString("submitter"));
			submitter.setSubmitterType(object.getJSONObject("identity").getString("submitter_type"));
		}
		if (object.has("TOS")){
			submitter.setSubmissionTOS(object.getJSONObject("TOS").getString("submission_TOS"));
			submitter.setSubmissionAttribution(object.getJSONObject("TOS").getString("submission_attribution"));
		}
		return submitter;
	}

}
