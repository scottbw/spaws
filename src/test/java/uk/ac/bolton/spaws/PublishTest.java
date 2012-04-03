package uk.ac.bolton.spaws;

import java.security.KeyStoreException;

import org.junit.BeforeClass;
import org.junit.Test;

import uk.ac.bolton.spaws.model.ISubmission;
import uk.ac.bolton.spaws.model.impl.Actor;
import uk.ac.bolton.spaws.model.impl.Rating;
import uk.ac.bolton.spaws.model.impl.Submission;

import com.navnorth.learningregistry.*;

public class PublishTest {
	
	private static final String MIMAS_TEST_NODE_URL = "alpha.mimas.ac.uk";
	private static final String WIDGET_URI = "http://wookie.apache.org/widgets/youtube";
	
	private static ParadataPublisher publisher;
	
	@BeforeClass
	public static void setup(){
		publisher = new ParadataPublisher(MIMAS_TEST_NODE_URL);
		publisher.setUsername("fred");
		publisher.setPassword("flintstone");
	}

	@Test
	public void publish1() throws KeyStoreException, LRException{
		Rating rating = new Rating(4);
		Actor actor = new Actor("Bill");
		ISubmission submission = new Submission(actor, rating, WIDGET_URI);
		publisher.publish(submission);
	}

	@Test
	public void publish2() throws KeyStoreException, LRException{
		Rating rating = new Rating(2);
		Actor actor = new Actor("Amy");
		ISubmission submission = new Submission(actor, rating, WIDGET_URI);
		publisher.publish(submission);
	}

	@Test
	public void publish3() throws KeyStoreException, LRException{
		Rating rating = new Rating(3);
		Actor actor = new Actor("Chloe");
		ISubmission submission = new Submission(actor, rating, WIDGET_URI);
		publisher.publish(submission);
	}	
	
}