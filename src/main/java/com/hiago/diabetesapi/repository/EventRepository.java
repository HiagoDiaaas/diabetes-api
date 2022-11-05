package com.hiago.diabetesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiago.diabetesapi.entity.Event;



public interface EventRepository extends JpaRepository<Event, Integer> {

}
