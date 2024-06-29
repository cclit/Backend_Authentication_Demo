package com.cclit.authdemo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cclit.authdemo.bean.EventEntity;
import com.cclit.authdemo.dao.EventDao;
import com.cclit.authdemo.dto.EventReqForm;
import com.cclit.authdemo.exception.EventNotFoundException;
import com.cclit.authdemo.service.EventService;


/**
 *  Event service interface implementation class
 *  
 *  @author GalenLin
 */
@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
	private EventDao eventDao;

	@Override
	public List<EventEntity> findAllEvents() {
		
		return eventDao.findAll();
	}

	@Override
	public EventEntity findEventById(String id) {
		
		Optional<EventEntity> eventOp = eventDao.findById(id);
		
		if(eventOp.isEmpty()) {
			throw new EventNotFoundException("Invalid event id.");
		}
		
		return eventOp.get();
	}

	@Override
	public EventEntity save(EventReqForm eventReqForm) {
		
		EventEntity event = new EventEntity();
		
		event.setId(UUID.randomUUID().toString());
		event.setTitle(eventReqForm.getTitle());
		event.setImage(eventReqForm.getImage());
		event.setDate(eventReqForm.getDate());
		event.setDescription(eventReqForm.getDescription());
		
		EventEntity savedEvent = eventDao.save(event);
		
		return savedEvent;
	}

	@Override
	public EventEntity updateById(EventReqForm eventReqForm, String id) {
		
		EventEntity event = findEventById(id);
		
		event.setTitle(eventReqForm.getTitle());
		event.setImage(eventReqForm.getImage());
		event.setDate(eventReqForm.getDate());
		event.setDescription(eventReqForm.getDescription());
		
		return eventDao.save(event);
	}

	@Override
	public void deleteById(String id) {
		
		EventEntity event = findEventById(id);
		
		eventDao.delete(event);
		
	}

}
