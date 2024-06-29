package com.cclit.authdemo.dto;

import com.cclit.authdemo.bean.EventEntity;

/**
 *  Single Event - event detail for response
 *  
 *  @author GalenLin
 */
public class EventDetail {
	
	
	private EventEntity event;
	
	private String message;
	
	
	public EventDetail() {};
	
	public EventDetail(String message, EventEntity event) {
		this.message = message;
		this.event = event;
	}
	
	

	public EventEntity getEvent() {
		return event;
	}

	public void setEvent(EventEntity event) {
		this.event = event;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
