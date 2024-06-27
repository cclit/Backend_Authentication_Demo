package com.cclit.authdemo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 *  User login and Reqister Request class
 *  
 *  @author GalenLin
 */
public class UserLoginReq {
	
	@NotBlank(message = "Please enter an email address for register.")
	@Email(message = "Invalid email.")
	private String email;
	
//	@NotBlank
//	@Min(value = 6, message = "Invalid password. Must be at least 6 characters long.")
	@Pattern(regexp = ".{6,}", message = "Invalid password. Must be at least 6 characters long.")
	private String password;
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
