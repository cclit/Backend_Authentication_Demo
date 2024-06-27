package com.cclit.authdemo.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/**
 *  Event Entity
 *  
 *  @author GalenLin
 */
@Entity
@Table(name = "EVENT")
public class EventEntity {
	
	/*
	 * Event Id : stored as UUID type
	 * 
	 * */
	@Id
	@Column(name = "ID", length = 40)
	private String id;
	
	@Column(name = "TITLE", length = 30)
	private String title;
	
	@Column(name = "IMAGE", length = 1000)
	private String image;
	
	
	/*
	 * create date : stored as pattern : yyyy-mm-dd
	 * 
	 * */
	@Column(name = "DATE", length = 20)
	private String date;
	
	@Column(name = "DESCRIPTION", length = 400)
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}