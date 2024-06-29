package com.cclit.authdemo.dto;

import java.util.List;

import com.cclit.authdemo.bean.EventEntity;

/**
 *  All events Response content class
 *  
 *  @author GalenLin
 */
public class EventsRes {

	private List<EventEntity> events;

	public List<EventEntity> getEvents() {
		return events;
	}

	public void setEvents(List<EventEntity> events) {
		this.events = events;
	}
	
}
