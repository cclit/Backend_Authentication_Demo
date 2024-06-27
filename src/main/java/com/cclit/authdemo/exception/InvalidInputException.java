package com.cclit.authdemo.exception;

import java.util.Map;

import com.cclit.authdemo.message.ErrorMessage;

public class InvalidInputException extends RuntimeException {
	
	private Map<String, String> errorMessage;
	
	private String message;
	
	public InvalidInputException() {};
	
	public InvalidInputException(String message, Map<String, String> errorMessage) {
		this.errorMessage = errorMessage;
		this.message = message;
	}

	public Map<String, String> getErrorMessage() {
		return errorMessage;
	}

	public String getMessage() {
		return message;
	}


}
