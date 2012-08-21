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

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import uk.ac.bolton.spaws.model.ISubmission;
import uk.ac.bolton.spaws.model.ISubmitter;
import uk.ac.bolton.spaws.model.impl.Submission;
import uk.ac.bolton.spaws.model.impl.Submitter;

public class SubmitterSubmissionsFilterTest {
	
	private static ISubmitter badSite;
	private static ISubmitter badSite2;
	private static ISubmitter goodSite;
	
	
	@BeforeClass
	public static void setup(){
		badSite = new Submitter();
		badSite.setSubmitter("badSite");
		badSite2 = new Submitter();
		badSite2.setSubmitter("badSite2");
		goodSite = new Submitter();
		goodSite.setSubmitter("goodSite");		
	}
	
	@Test
	public void multipleSubmitterTest(){
		ISubmission submission1 = new Submission();
		submission1.setSubmitter(goodSite);
		submission1.setResourceURL("http://test1");
		ISubmission submission2 = new Submission();
		submission2.setSubmitter(goodSite);
		submission2.setResourceURL("http://test2");
		ISubmission submission3 = new Submission();
		submission3.setSubmitter(badSite);
		submission3.setResourceURL("http://test3");
		
		List<ISubmission> submissions = new ArrayList<ISubmission>();
		submissions.add(submission1);
		submissions.add(submission2);
		submissions.add(submission3);
		
		List<String> omitList = new ArrayList<String>();
		omitList.add(badSite.getSubmitter());
		
		assertEquals(2, new SubmitterSubmissionsFilter().omit(submissions, omitList).size());
	}
	
	@Test
	public void multipleSubmitterTest2(){
		ISubmission submission1 = new Submission();
		submission1.setSubmitter(goodSite);
		submission1.setResourceURL("http://test1");
		ISubmission submission2 = new Submission();
		submission2.setSubmitter(goodSite);
		submission2.setResourceURL("http://test2");
		ISubmission submission3 = new Submission();
		submission3.setSubmitter(badSite);
		submission3.setResourceURL("http://test3");
		
		List<ISubmission> submissions = new ArrayList<ISubmission>();
		submissions.add(submission1);
		submissions.add(submission2);
		submissions.add(submission3);
		
		List<String> omitList = new ArrayList<String>();
		omitList.add(goodSite.getSubmitter());
		
		assertEquals(1, new SubmitterSubmissionsFilter().omit(submissions, omitList).size());
		assertEquals("http://test3", new SubmitterSubmissionsFilter().omit(submissions, omitList).get(0).getResourceURL());
	}
	
	@Test
	public void multipleSubmitterTest3(){
		ISubmission submission1 = new Submission();
		submission1.setSubmitter(goodSite);
		submission1.setResourceURL("http://test1");
		ISubmission submission2 = new Submission();
		submission2.setSubmitter(badSite);
		submission2.setResourceURL("http://test2");
		ISubmission submission3 = new Submission();
		submission3.setSubmitter(badSite2);
		submission3.setResourceURL("http://test3");
		
		List<ISubmission> submissions = new ArrayList<ISubmission>();
		submissions.add(submission1);
		submissions.add(submission2);
		submissions.add(submission3);
		
		List<String> omitList = new ArrayList<String>();
		omitList.add(badSite.getSubmitter());
		omitList.add(badSite2.getSubmitter());
		
		assertEquals(1, new SubmitterSubmissionsFilter().omit(submissions, omitList).size());
		assertEquals("http://test1", new SubmitterSubmissionsFilter().omit(submissions, omitList).get(0).getResourceURL());
	}

}
