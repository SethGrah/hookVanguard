package com.skillstorm.hook.models;

public class LoginResponse {

	private String username;
	private String auth;
	
	
	
	
	public LoginResponse() {
		super();
	}
	public LoginResponse(String username, String auth) {
		this.username = username;
		this.auth = auth;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	@Override
	public String toString() {
		return "LoginResponse [username=" + username + ", auth=" + auth + "]";
	}
	
}
