package com.hiago.diabetesapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hiago.diabetesapi.entity.Event;
import com.hiago.diabetesapi.repository.EventRepository;


@Service
public class EventService {
	
	@Autowired
	private EventRepository repository;
	
	public Event saveEvent(Event event) {
		return repository.save(event);
	}
	
	public List<Event> saveEvents(List<Event> events) {
		return repository.saveAll(events);
	}
	
	public List<Event> getEvents() {
		return repository.findAll();
	}
	
	
	public void deleteAllEvents() {
		repository.deleteAll();
		
	}
	
	
	public Event getEventById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public String deleteEvent(int id) {
		repository.deleteById(id);
		return "event removed" + " " + id;
	}
	
	public Event updateEvent(Event event) {
		Event existingEvent = repository.findById(event.getId()).orElse(null);
		existingEvent.setValue(event.getValue());
		existingEvent.setType(event.getType());
		existingEvent.setDateAndTime(event.getDateAndTime());
		existingEvent.setSfSymbolIdentifier(event.getSfSymbolIdentifier());
		return repository.save(existingEvent);
		
		
	}
	
	

}
