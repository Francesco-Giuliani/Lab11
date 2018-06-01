package it.polito.tdp.bar.model;

import it.polito.tdp.bar.model.simulator.Simulator;

public class Model {

	private Simulator simulator;
	private Statistics statistics;
	
	public Model() {
	
		this.simulator = new Simulator();
		this.statistics = new Statistics(simulator);		
	}
	
	public void startSimulation() {
		this.simulator.init();
		this.simulator.run();
		
		this.statistics.getResults();
	}
	
	public String printStatistics() {
		String res;
		
		if(this.simulator.hasRun())
			this.statistics.getResults();
		else {
			res = "Attenzione! Non è ancora stata avviata la simulazione. Avviarla con Model.startSimulation().\n";
			return res;
		}
		res = "Numero totale clienti: "+this.statistics.getTotalClients()+
				"\nNumero clienti soddisfatti: "+this.statistics.getTotalSatisfied()+
				"\nNumero clienti insoddisfatti: "+this.statistics.getTotalUnsatisfied();
		
		return res;
	}
	
	
	
}
