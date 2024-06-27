package com.cclit.authdemo.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cclit.authdemo.exception.InvalidInputException;
import com.cclit.authdemo.message.ErrorMessage;


/**
 *  Authentication related exception handler class
 *  
 *  @author GalenLin
 */
@ControllerAdvice
public class AuthExceptionController {
	
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<ErrorMessage> invalidInputExceptionHandler(InvalidInputException exception){
		
		ErrorMessage errorMsg = new ErrorMessage();
		errorMsg.setMessage(exception.getMessage());
		errorMsg.setErrors(exception.getErrorMessage());
		
		return ResponseEntity.status(422).body(errorMsg);
	}

}
