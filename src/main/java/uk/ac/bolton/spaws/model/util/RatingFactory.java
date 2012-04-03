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

import uk.ac.bolton.spaws.model.IRating;
import uk.ac.bolton.spaws.model.impl.Rating;

public class RatingFactory {

	public static IRating createRating(JSONObject document) throws JSONException{
		if (document.has("resource_data")){
			if (document.getJSONObject("resource_data").has("activity")){
				JSONObject activity = document.getJSONObject("resource_data").getJSONObject("activity");
				if (activity.has("verb")){
					if (activity.getJSONObject("verb").has("action")){
						if (activity.getJSONObject("verb").get("action").equals("rated")){
							return createRatingFromActivity(activity.getJSONObject("verb"));
						}
					}
				}
			}
		}
		return null;
	}
	
	private static IRating createRatingFromActivity(JSONObject verb) throws JSONException{
		Rating rating = new Rating();
		
		JSONObject measure = verb.getJSONObject("measure");
		if (measure == null) return null;
		rating.setMin(measure.getInt("scaleMin"));
		rating.setMax(measure.getInt("scaleMax"));
		rating.setRating(measure.getInt("value"));
		rating.setSample(measure.getInt("sampleSize"));
		
		return rating;
	}

}
