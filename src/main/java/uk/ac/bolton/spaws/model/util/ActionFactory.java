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

import uk.ac.bolton.spaws.model.IParadata;
import uk.ac.bolton.spaws.model.IRating;
import uk.ac.bolton.spaws.model.IRatings;
import uk.ac.bolton.spaws.model.IReview;
import uk.ac.bolton.spaws.model.impl.Rating;
import uk.ac.bolton.spaws.model.impl.Ratings;
import uk.ac.bolton.spaws.model.impl.Review;

public class ActionFactory {

	public static IParadata parse(JSONObject document) throws JSONException{
		
		JSONObject activity;
		
		try {
			activity = document.getJSONObject("resource_data").getJSONObject("activity");
		} catch (Exception e) {
			// Document doesn't have JSON paradata activity data
			return null;
		}	
		
		if (activity.has("verb")){
			if (activity.getJSONObject("verb").has("action")){
				String verb = activity.getJSONObject("verb").getString("action");
				if (verb.equals(IRating.VERB)){
					return createRatingFromActivity(activity.getJSONObject("verb"));
				}
				else if (verb.equals(IReview.VERB)){
					return createReviewFromActivity(activity);								
				}
				else if (verb.equals(IRatings.VERB)){
					return createRatingsFromActivity(activity);								
				}
			}
		}
		
		return null;
	}

	/**
	 * Create a rating object
	 * @param verb
	 * @return
	 * @throws JSONException
	 */
	private static IRating createRatingFromActivity(JSONObject verb) throws JSONException{
		Rating rating = new Rating();
		
		JSONObject measure = verb.getJSONObject("measure");
		if (measure == null) return null;
		rating.setMin(measure.getInt("scaleMin"));
		rating.setMax(measure.getInt("scaleMax"));
		rating.setRating(measure.getInt("value"));
		
		return rating;
	}
	
	/**
	 * Create a composite ratings object
	 * @param verb
	 * @return
	 * @throws JSONException
	 */
	private static IRatings createRatingsFromActivity(JSONObject verb) throws JSONException{
		Ratings ratings = new Ratings();
		
		JSONObject measure = verb.getJSONObject("measure");
		if (measure == null) return null;
		ratings.setMin(measure.getInt("scaleMin"));
		ratings.setMax(measure.getInt("scaleMax"));
		ratings.setAverage(measure.getDouble("value"));
		ratings.setSample(measure.getInt("sampleSize"));
		
		return ratings;
	}
	
	/**
	 * Create a review object
	 * @param activity
	 * @return
	 * @throws JSONException
	 */
	private static IReview createReviewFromActivity(JSONObject activity) throws JSONException{
		Review review = new Review();
		review.setComment(activity.getString("content"));
		return review;
	}

}
