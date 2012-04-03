package uk.ac.bolton.spaws.model;

import com.navnorth.learningregistry.LRActivity;

public interface IParadata {
	
	public abstract String getVerb();
	
	public abstract void addMeasure(LRActivity activity);

}
