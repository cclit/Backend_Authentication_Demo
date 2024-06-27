package com.cclit.authdemo.message;

import java.util.Map;

/**
 *  Error Message for response
 *  
 *  @author GalenLin
 */
public class ErrorMessage {

	private String message;
	
	private Map<String, String> errors;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	
	
	
}
