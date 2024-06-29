package com.cclit.authdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cclit.authdemo.exception.EventNotFoundException;
import com.cclit.authdemo.exception.InvalidInputException;
import com.cclit.authdemo.exception.UserNotFoundException;
import com.cclit.authdemo.message.ErrorMessage;


/**
 *  Authentication related exception handler class
 *  
 *  @author GalenLin
 */
@ControllerAdvice
public class AuthDemoExceptionHandler {
	
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<ErrorMessage> invalidInputExceptionHandler(InvalidInputException exception){
		
		ErrorMessage errorMsg = new ErrorMessage();
		errorMsg.setMessage(exception.getMessage());
		errorMsg.setErrors(exception.getErrorMessage());
		
		return ResponseEntity.status(422).body(errorMsg);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorMessage> userNotFoundExceptionHandler(UserNotFoundException exception){
		
		ErrorMessage errorMsg = new ErrorMessage();
		errorMsg.setMessage(exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMsg);
	}
	
	
	@ExceptionHandler(EventNotFoundException.class)
	public ResponseEntity<ErrorMessage> eventNotFoundExceptionHandler(EventNotFoundException exception){
		
		ErrorMessage errorMsg = new ErrorMessage();
		errorMsg.setMessage(exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMsg);
	}
	

}
