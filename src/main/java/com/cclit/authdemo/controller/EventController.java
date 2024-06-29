package com.cclit.authdemo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cclit.authdemo.bean.EventEntity;
import com.cclit.authdemo.dto.EventDetail;
import com.cclit.authdemo.dto.EventReqForm;
import com.cclit.authdemo.dto.EventsRes;
import com.cclit.authdemo.exception.InvalidInputException;
import com.cclit.authdemo.service.EventService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(value = "http://localhost:3000")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@GetMapping("/events")
	public ResponseEntity<EventsRes> getAllEvents(){
		
		EventsRes eventRes = new EventsRes();
		
		List<EventEntity> list = eventService.findAllEvents();
		
		eventRes.setEvents(list);
		
		return ResponseEntity.ok(eventRes);
	}
	
	@GetMapping("/events/{id}")
	public ResponseEntity<EventDetail> getEventDetail(@PathVariable String id){
		
		EventDetail eventDetail = new EventDetail();
		
		EventEntity event = eventService.findEventById(id);
		
		eventDetail.setEvent(event);
		
		return ResponseEntity.ok(eventDetail);
	}
	
	@PostMapping("/events")
	public ResponseEntity<EventDetail> addEvent(@RequestBody @Valid EventReqForm event, BindingResult result){
		
		inputTimeCheck(event.getDate(), result);
		
		inputInfoValidationCheck(result);
		
		EventEntity eventSaved = eventService.save(event);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(new EventDetail("Event saved.", eventSaved));
	}
	
	
	@PatchMapping("/events/{id}")
	public ResponseEntity<EventDetail> updateEvent(@RequestBody @Valid EventReqForm event, BindingResult result,
												   @PathVariable String id){
		
		inputTimeCheck(event.getDate(), result);
		
		inputInfoValidationCheck(result);
	
		EventEntity eventUpdated = eventService.updateById(event, id);
		
		return ResponseEntity.status(HttpStatus.OK).body(new EventDetail("Event saved.", eventUpdated));
	}
	
	@DeleteMapping("/events/{id}")
	public ResponseEntity<EventDetail> deleteEvent(@PathVariable String id){
		
		eventService.deleteById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(new EventDetail("Event deleted.", null));
	}
	
	
	private void inputInfoValidationCheck(BindingResult result) {
		
		if(result.hasErrors()) {
			List<FieldError> fieldErrors = result.getFieldErrors();
			Map<String, String> errorMsgMap = new HashMap<>();
			
			fieldErrors.forEach(item ->
				errorMsgMap.put(item.getField(), item.getDefaultMessage()));
			throw new InvalidInputException("Adding the event failed due to validation errors.", errorMsgMap);
		}
		
	}
	
	
	private void inputTimeCheck(String timeString, BindingResult result) {
		
		if(timeString == null) {
			result.rejectValue("date", null, "Invalid date.");
			return;
		}
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
			LocalDate date = LocalDate.parse(timeString, formatter);
		} catch (DateTimeParseException e) {
			result.rejectValue("date", null, "Invalid date.");
		}
		
	}
	

}
