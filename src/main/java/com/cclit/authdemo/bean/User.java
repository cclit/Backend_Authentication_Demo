package com.cclit.authdemo.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *  user entity
 *  
 *  @author GalenLin
 */
@Entity
@Table(name = "USERS")
public class User {

	/*
	 * User Id : stored as UUID type
	 * 
	 * */
	@Id
	@Column(name = "ID", length = 40)
	private String id;
	
	@Column(name = "EMAIL", length = 200)
	private String email;
	
	@Column(name = "PASSWORD", length = 30)
	@JsonIgnore
	private String password;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
