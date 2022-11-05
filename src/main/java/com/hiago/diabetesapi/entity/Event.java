package com.hiago.diabetesapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "EVENT_TBL")
public class Event {
	
	
	@Id
	@GeneratedValue
	private int id;
	private String value;
	private String type;
	private String dateAndTime;
	private String sfSymbolIdentifier;
	
	
	public Event() {
		
	}


	public Event(int id, String value, String type, String dateAndTime, String sfSymbolIdentifier) {
		super();
		this.id = id;
		this.value = value;
		this.type = type;
		this.dateAndTime = dateAndTime;
		this.sfSymbolIdentifier = sfSymbolIdentifier;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getDateAndTime() {
		return dateAndTime;
	}


	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}


	public String getSfSymbolIdentifier() {
		return sfSymbolIdentifier;
	}


	public void setSfSymbolIdentifier(String sfSymbolIdentifier) {
		this.sfSymbolIdentifier = sfSymbolIdentifier;
	}
	
	
	
	
	
	

}
