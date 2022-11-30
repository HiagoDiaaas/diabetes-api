package com.hiago.diabetesapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.hiago.diabetesapi.entity.Event;
import com.hiago.diabetesapi.repository.EventRepository;
import com.hiago.diabetesapi.service.EventService;


@RestController
public class EventController {
	
	@Autowired
	private EventService service;
	
	@Autowired
	private EventRepository repository;
	
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
	

	
	@PutMapping("/update/{id}")
    public ResponseEntity<Event> save(@PathVariable int id, @RequestBody Event event){
        Optional<Event> object = repository.findById(id);
        if(object.isPresent()) {
        	 event.setId(id);
            this.repository.save(event);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
	

	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<Event> delete(@PathVariable int id){
        Optional<Event> object = repository.findById(id);
        if(object.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
	
	
//	@DeleteMapping("/deleteAll")
//    public void deleteAll(){
//        service.deleteAllEvents();
//    }
	
	

	@DeleteMapping("/deleteAll")
    public ResponseEntity<Event> deleteAll(){
            repository.deleteAll();
            return ResponseEntity.noContent().build();
        
    }
	
	
	

}
