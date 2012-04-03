package uk.ac.bolton.spaws.model;

public interface IRating extends IParadata {
	
	public abstract int getRating();
	public abstract void setRating(int rating);
	
	public abstract int getMin();
	public abstract void setMin(int min);
	
	public abstract int getMax();
	public abstract void setMax(int max);
	
	public abstract int getSample();
	public abstract void setSample(int sample);
	

}
