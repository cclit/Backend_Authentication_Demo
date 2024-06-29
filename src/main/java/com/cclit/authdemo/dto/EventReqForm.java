package com.cclit.authdemo.dto;

//import java.util.Date;

import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

/**
 *  Event request form - for new event addition or event detail update
 *  
 *  @author GalenLin
 */
public class EventReqForm {
	
	@NotBlank(message = "Invalid title.")
	private String title;
	
	@Pattern(regexp = "^http.*", message = "Invalid image url. Please enter an image url.")
	private String image;
	
//	@PastOrPresent(message = "Invalid date.")
	private String date;
	
	@NotBlank(message = "Invalid description.")
	private String description;

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
