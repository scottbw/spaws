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
package uk.ac.bolton.spaws.integration;

import static org.junit.Assert.assertEquals;

import java.net.URL;

import org.junit.BeforeClass;
import org.junit.Test;

import uk.ac.bolton.spaws.ParadataManager;
import uk.ac.bolton.spaws.model.INode;
import uk.ac.bolton.spaws.model.IStats;
import uk.ac.bolton.spaws.model.ISubmission;
import uk.ac.bolton.spaws.model.impl.Node;
import uk.ac.bolton.spaws.model.impl.Submitter;

public class StatsTest {
	
	private static final String MIMAS_TEST_NODE_URL = "http://alpha.mimas.ac.uk";
	private static final String WIDGET_URI = "http://wookie.apache.org/widgets/butterfly";
	private static INode node;
	
	@BeforeClass
	public static void setup() throws Exception{
		
		node = new Node(new URL(MIMAS_TEST_NODE_URL), "fred", "flintstone");
	
//		ParadataManager manager = new ParadataManager(new Submitter(), node);
//
//		List<ISubmission> submissions = new ArrayList<ISubmission>();
//		
//		Submitter site1 = new Submitter();
//		site1.setSubmitter("SPAWS-TEST-SITE-1");
//		Stats site1stats = new Stats();
//		site1stats.setDownloads(11);
//		site1stats.setEmbeds(1);
//		site1stats.setLikes(1);
//		site1stats.setViews(111);
//		
//		Submitter site2 = new Submitter();
//		site2.setSubmitter("SPAWS-TEST-SITE-2");
//		Stats site2stats = new Stats();
//		site2stats.setDownloads(22);
//		site2stats.setViews(222);
//		
//		
//		submissions.add(new Submission(site1, null, site1stats, WIDGET_URI));
//		submissions.add(new Submission(site2, null, site2stats, WIDGET_URI));
//		
//		manager.publishSubmissions(submissions);
	}
	
	@Test
	public void test() throws Exception{
		
		ParadataManager manager = new ParadataManager(new Submitter(), node);
		int downloads = 0;
		int views = 0;
		int embeds = 0;
		int likes = 0;
		
		for (ISubmission submission: manager.getExternalStats(WIDGET_URI)){
			IStats stats = (IStats)submission.getAction();
			downloads += stats.getDownloads();
			views += stats.getViews();
			embeds += stats.getEmbeds();
			likes += stats.getLikes();
		}
		
		assertEquals(33, downloads);
		assertEquals(333, views);
		assertEquals(1, embeds);
		assertEquals(1, likes);
	}

}
