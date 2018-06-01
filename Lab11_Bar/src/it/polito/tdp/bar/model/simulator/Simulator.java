package it.polito.tdp.bar.model.simulator;

import java.util.List;
import java.util.PriorityQueue;

import it.polito.tdp.bar.model.Table;

public class Simulator {

	//PARAMETRI
	private final int NUM_CUSTOMERS; 
	
	//CODA EVENTI
	private PriorityQueue<Event> events; 
	
	//MONDO
	List<Table> tables;
	List<Customer> customers; 
	
	//RISULTATI
	private int totClients, satisfied, unsatisfied;
	private boolean runned;

	
	
	
	public int getTotClients() {
		return totClients;
	}

	public int getSatisfied() {
		return satisfied;
	}

	public int getUnsatisfied() {
		return unsatisfied;
	}

	public boolean hasRun() {
		return this.runned;
	}

	public void init() {
		// TODO Auto-generated method stub
		
		//RESULTS
		totClients= satisfied = unsatisfied =0;
		this.runned = false;
		
		//EVENTS
		this.events = new PriorityQueue<Event>();
		
	}

	public void run() {
		
		Event event;
		
		while( (event=this.events.poll())!=null)
			this.processEvent(event);
			
		this.runned = true;
	}

	private void processEvent(Event event) {
		
		switch(event.getEventType()) {
			
		
		
		}
		
		
	}
	
	
}
