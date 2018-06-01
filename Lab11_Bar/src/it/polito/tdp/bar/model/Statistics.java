package it.polito.tdp.bar.model;

import it.polito.tdp.bar.model.simulator.Simulator;

public class Statistics {

	private int totalClients, totalSatisfied, totalUnsatisfied;
	private Simulator simulator;
	
	public Statistics(Simulator simulator) {
		
		this.simulator = simulator;
		
		this.totalClients =0;
		this.totalSatisfied =0;
		this.totalUnsatisfied =0;
	}

	public int getTotalClients() {
		return totalClients;
	}

	public int getTotalSatisfied() {
		return totalSatisfied;
	}

	public int getTotalUnsatisfied() {
		return totalUnsatisfied;
	}

	public Simulator getSimulator() {
		return simulator;
	}

	public void getResults() {
		this.totalClients = this.simulator.getTotClients();
		this.totalSatisfied = this.simulator.getSatisfied();
		this.totalUnsatisfied = this.simulator.getUnsatisfied();		
	}
		
	
}
