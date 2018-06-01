package it.polito.tdp.bar.model;

import java.util.List;

import it.polito.tdp.bar.model.exception.IncompatibleTablesException;
import it.polito.tdp.bar.model.exception.NotEnoughSeatsException;
import it.polito.tdp.bar.model.exception.UnavailableTableException;

public class Table {
	
	private final int id;
	private int totSeats;
	private TableState state;
	private int freeSeats;
	private List<Client> client;
	
	public Table(int id, int totSeats) {
		super();
		this.id = id;
		this.totSeats = totSeats;
	}
	
	public void addSeats(int numSeats) {
		this.totSeats += numSeats;
		this.freeSeats += numSeats;
	}
	/**
	 * Serves the client at this table. The number of free seats of the table and its state are updated
	 * @param client
	 * @return true if the client was successfully assigned the table;
	 * 			false if the table was FULL or if it was UNUSABLE or if it 
	 * 			did not have enough seats or if it already contained the client;
	 * @throws UnavailableTableException if the table is not usable
	 * @throws NotEnoughSeatsException if the number of seats is not sufficient
	 */
	public boolean serveClient(Client client) throws UnavailableTableException, NotEnoughSeatsException {
		
		if(this.client.contains(client) && client.getTable().equals(this))
			return false;
		
		try {
			if(this.state == TableState.FULL)
				return false;
			if(this.state ==  TableState.CLEANING || this.state == TableState.UNAVAILABLE) 
				throw new UnavailableTableException();
			
			if(this.client.contains(client) && !client.getTable().equals(this))
				throw new IncompatibleTablesException();
			
			if(this.totSeats < client.getNumPeople() || this.freeSeats<client.getNumPeople())
				throw new NotEnoughSeatsException();
			
			this.freeSeats = this.freeSeats-client.getNumPeople();
			this.client.add(client);
			
			if(this.freeSeats == 0)
				this.state = TableState.FULL;
			else
				this.state = TableState.TAKEN;
			
			return true;
			
		} catch (UnavailableTableException ute) {
			ute.printStackTrace();
			return false;
		}catch(NotEnoughSeatsException nese) {
			nese.printStackTrace();
			System.out.format("Number of people: %d Tot Number of seats: %d Numeber available: %d", client.getNumPeople(), this.totSeats, this.freeSeats);;
			return false;
		} catch (IncompatibleTablesException e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * Removes the given client from the table and updates the required values (free seats and table state).
	 * @param client
	 * @return true if the table contained the client; 
	 * 			false if the table did not host the given client.
	 */
	public boolean freeFromClient(Client client) {
		
		if(this.client.remove(client)) {
			
			this.freeSeats += client.getNumPeople();
			
			if(this.client.isEmpty())
				this.state = TableState.FREE;
			else
				this.state = TableState.TAKEN;
			
			return true;
		}else
			return false;	
	}
	
	/**
	 * If the table is usable it is freed of all customers. Its number of free seats is reset default.
	 * @return true if the operation was successful false if the table was not usable (state = UNAVAILABLE or CLEANING)
	 */
	public boolean freeAllSeats() {
		if(this.state == TableState.FREE)
			return true;
		if(this.state == TableState.TAKEN || this.state == TableState.FULL) {
			this.client = null;
			
			this.state = TableState.FREE;
			this.freeSeats = this.totSeats;
			
			return true;
		}else
			return false;
	}
	
	public List<Client> getClient() {
		return client;
	}
	public void setClient(List<Client> client) {
		this.client = client;
	}
	public int getTotSeats() {
		return totSeats;
	}
	public TableState getState() {
		return state;
	}
	public void setState(TableState state) {
		this.state = state;
	}
	public int getFreeSeats() {
		return freeSeats;
	}
	public void setFreeSeats(int freeSeats) {
		this.freeSeats = freeSeats;
	}
	public int getId() {
		return id;
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
		Table other = (Table) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
