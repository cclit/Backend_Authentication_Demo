package com.cclit.authdemo.dto;

import com.cclit.authdemo.bean.User;

/**
 *  User Login Response class
 *  
 *  @author GalenLin
 */
public class UserLoginRes {
	
	private User user;
	
	private String message;
	
	private String token;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	

}
