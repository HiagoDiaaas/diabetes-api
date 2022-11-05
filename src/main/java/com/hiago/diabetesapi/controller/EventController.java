package com.hiago.diabetesapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiago.diabetesapi.entity.Event;
import com.hiago.diabetesapi.service.EventService;


@RestController
public class EventController {
	
	@Autowired
	private EventService service;
	
	@PostMapping("/addEvent")
	public Event addProduct(@RequestBody Event event) {
		return service.saveEvent(event);
	}
	
	@PostMapping("/addEvents")
	public List<Event> addProduct(@RequestBody List<Event> events) {
		return service.saveEvents(events);
	}
	
	@GetMapping("/events")
	public List<Event> findAllEvents() {
		return service.getEvents();
	}
	
	@GetMapping("/eventById/{id}")
	public Event findEventtById(@PathVariable int id) {
		return service.getEventById(id);
	}
	
	@PutMapping("/update")
	public Event updateEvent(@RequestBody Event event) {
		return service.updateEvent(event);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEvent(@PathVariable int id) {
		return service.deleteEvent(id);
	}
	
	
	

}
