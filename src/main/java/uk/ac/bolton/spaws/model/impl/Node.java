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
package uk.ac.bolton.spaws.model.impl;

import java.net.URL;

import uk.ac.bolton.spaws.model.INode;

public class Node implements INode{
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param scheme the scheme to set
	 */
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	private String scheme;
	private String host;
	private String username; 
	private String password;
	
	public Node(String scheme, String host){
		this.scheme = scheme;
		this.host = host;
	}
	
	public Node(URL nodeUrl){
		this.scheme = nodeUrl.getProtocol();
		this.host = nodeUrl.getHost();
	}
	
	public Node(URL nodeUrl, String username, String password){
		this.scheme = nodeUrl.getProtocol();
		this.host = nodeUrl.getHost();
		this.username = username;
		this.password = password;
	}

	public String getScheme() {
		return scheme;
	}

	public String getHost() {
		return host;
	}
	
	

}
