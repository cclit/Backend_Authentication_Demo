package com.cclit.authdemo.bean;

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
@Table(name = "USER")
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
	
	@Column(name = "PASSWORD")
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

	public String getPwd() {
		return password;
	}

	public void setPwd(String password) {
		this.password = password;
	}
	
	
	
}
