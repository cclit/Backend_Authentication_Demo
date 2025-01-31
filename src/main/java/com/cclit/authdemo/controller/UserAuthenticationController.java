package com.cclit.authdemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cclit.authdemo.bean.User;
import com.cclit.authdemo.dto.UserLoginReq;
import com.cclit.authdemo.dto.UserLoginRes;
import com.cclit.authdemo.exception.InvalidInputException;
import com.cclit.authdemo.service.UserService;
import com.cclit.authdemo.util.JwtUtil;

import jakarta.validation.Valid;

/**
 *  User register and login controller
 *  
 *  @author GalenLin
 */
@RestController
public class UserAuthenticationController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtil jwtGenerator;
	
	
	@PostMapping("/signup")
	public ResponseEntity<UserLoginRes> register(@RequestBody @Valid UserLoginReq userLoginReq, BindingResult result){

		// customize response of status 422 and error message
		inputInfoValidationCheck(result);
		
		User user = userService.register(userLoginReq);
		
		UserLoginRes userLoginRes = getLoginRes("Resister Suscess!", user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userLoginRes);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<UserLoginRes> login(@RequestBody @Valid UserLoginReq userLoginReq, BindingResult result){
		
		inputInfoValidationCheck(result);
		
		User user = userService.login(userLoginReq);
		
		UserLoginRes userLoginRes = getLoginRes("Login Suscess!", user);
				
		return ResponseEntity.status(HttpStatus.OK).body(userLoginRes);
	}
	
	
	
	private void inputInfoValidationCheck(BindingResult result) {
		
		if(result.hasErrors()) {
			
			List<FieldError> fieldErrors = result.getFieldErrors();
			Map<String, String> errorMsgMap = new HashMap<>();
			
			for(FieldError error : fieldErrors) {
//				System.out.println(error.getField() + " : " + error.getDefaultMessage());
				errorMsgMap.put(error.getField(), error.getDefaultMessage());
			}
			
			throw new InvalidInputException("User signup failed due to validation errors.", errorMsgMap);
		}
		
	}
	
	
	private UserLoginRes getLoginRes(String message, User user) {
		
		UserLoginRes userLoginRes = new UserLoginRes();
		
		userLoginRes.setMessage(message);
		userLoginRes.setUser(user);
		userLoginRes.setToken(jwtGenerator.generateJwtToken(user));
		
		return userLoginRes;
	}
	

}
