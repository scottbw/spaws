package uk.ac.bolton.spaws.model.impl;

import uk.ac.bolton.spaws.model.IActor;

public class Actor implements IActor {
	
	public Actor(){
		
	}
	
	public Actor(String name){
		this.name = name;
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
