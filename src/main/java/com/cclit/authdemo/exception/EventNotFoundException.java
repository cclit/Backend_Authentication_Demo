package com.cclit.authdemo.exception;

public class EventNotFoundException extends RuntimeException {

	private String message;
	
	public EventNotFoundException() {};
	
	public EventNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
