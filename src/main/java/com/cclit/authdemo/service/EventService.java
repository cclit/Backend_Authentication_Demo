package com.cclit.authdemo.service;

import java.util.List;

import com.cclit.authdemo.bean.EventEntity;
import com.cclit.authdemo.dto.EventReqForm;

/**
 *  Event service interface
 *  
 *  @author GalenLin
 */
public interface EventService {
	
	
	public List<EventEntity> findAllEvents();
	
	public EventEntity findEventById(String id);
	
	public EventEntity save(EventReqForm eventReqForm);
	
	public EventEntity updateById(EventReqForm eventReqForm, String id);
	
	public void deleteById(String id);

}
