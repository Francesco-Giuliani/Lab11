package it.polito.tdp.bar.model;

import it.polito.tdp.bar.model.exception.NotEnoughSeatsException;
import it.polito.tdp.bar.model.exception.TableNotValidException;
import it.polito.tdp.bar.model.exception.UnavailableTableException;

public class Client {
	
	private int id;
	private int numPeople;
	private int stayTime;
	private double tolerance;
	private ClientState state;
	private Table table;
	
	public Client(int id, int numPeople, int stayTime, double tolerance) {
		super();
		this.id = id;
		this.numPeople = numPeople;
		this.stayTime = stayTime;
		this.tolerance = tolerance;
		this.state = ClientState.ARRIVED;
		this.table = null;
	}
	/**
	 * Assigns a table to the given client and adds this client to the clients at the table. If it is successufully added
	 * @param table
	 * @return true if successfully added both table to client and client to table.
	 * 			false otherwise.
	 */
	
	public boolean assignTable(Table table) {
		
		if(this.state == ClientState.ARRIVED ||this.state == ClientState.WAITING) {
		
			if(table == null) {
				try {
					throw new TableNotValidException();
				} catch (TableNotValidException e) {
					e.printStackTrace();
					return false;
				}
			}
			this.table = table;
			
			this.state = ClientState.SEATED;
			
			try {
				return table.serveClient(this);
			} catch (UnavailableTableException | NotEnoughSeatsException e) {
				e.printStackTrace();
				return false;
			}
		}else
			return false;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumPeople() {
		return numPeople;
	}
	public void setNumPeople(int numPeople) {
		this.numPeople = numPeople;
	}
	public int getStayTime() {
		return stayTime;
	}
	public void setStayTime(int stayTime) {
		this.stayTime = stayTime;
	}
	public double getTolerance() {
		return tolerance;
	}
	public void setTolerance(double tolerance) {
		this.tolerance = tolerance;
	}
	public ClientState getState() {
		return state;
	}
	public void setState(ClientState state) {
		this.state = state;
	}
	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	

}
