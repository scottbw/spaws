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

import uk.ac.bolton.spaws.model.impl.Actor;

public class ActorFactory {

	public static Actor createActor(JSONObject document) throws JSONException{
		
		if (document.has("resource_data")){
			if (document.getJSONObject("resource_data").has("activity")){
				JSONObject activity = document.getJSONObject("resource_data").getJSONObject("activity");
				if (activity.has("actor")){
					Actor actor = new Actor();
					actor.setName(activity.getJSONObject("actor").getString("displayName"));
					return actor;
				}
			}
		}
		return null;
		
	}
	
}
