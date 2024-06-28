package com.cclit.authdemo.exception;

public class UserNotFoundException extends RuntimeException {

	private String message;
	
	public UserNotFoundException() {};
	
	public UserNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
