package uk.ac.bolton.spaws.model.impl;

import uk.ac.bolton.spaws.model.IParadata;

public abstract class Paradata implements IParadata{
	
	private String content;
	private String contextUrl;

	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.IParadata#getContent()
	 */
	public String getContent() {
		//
		// We have to use empty string rather than null,
		// as otherwise this causes problems for signing a LR document
		//
		if (content == null) return "";
		
		return content;
	}
	
	public void setContent(String content){
		this.content = content;
	}

	/* (non-Javadoc)
	 * @see uk.ac.bolton.spaws.model.IParadata#getContextUrl()
	 */
	public String getContextUrl() {
		return contextUrl;
	}
	
	public void setContextUrl(String contextUrl){
		this.contextUrl = contextUrl;
	}
	
	

}
