package it.polito.tdp.bar.model.simulator;

import java.time.LocalDateTime;

import it.polito.tdp.bar.model.Client;

public class Event {

	private EventType type;
	private LocalDateTime time;
	private Client client;
	
	public Event(EventType eventType, LocalDateTime eventTime) {
		super();
		this.type = eventType;
		this.time = eventTime;
	}

	public EventType getEventType() {
		return type;
	}

	public LocalDateTime getEventTime() {
		return time;
	}

	public void setEventType(EventType eventType) {
		this.type = eventType;
	}

	public void setEventTime(LocalDateTime eventTime) {
		this.time = eventTime;
	}
	
	
}
