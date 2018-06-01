package it.polito.tdp.bar.model;


/**
 * Assumption: the client is first served, then pays.
 */
public enum ClientState {
	

	/**
	 *The client has just arrived. It is waiting for the bar staff to assign a table or to be sent to the counter.
	 */
	ARRIVED,
	/**
	 * The client has been assigned a table and is seated.
	 */
	SEATED,
	/**
	 * The client has been directed to the counter and has accepted.
	 */
	COUNTER,
	/**
	 * The client exits the bar. If he was seated at a table, this needs to be freed.
	 */
	OUT,
	/**
	 * The client is waiting for a table to be freed. (For further implementation).
	 */
	WAITING,
	/**
	 * The client has ordered and is waiting to be served. (For further implementation).
	 */
	ORDERED,
	/**
	 * The client has received what he ordered, is satisfied, BUT HAS TO PAY. (For further implementation).
	 */
	SERVED,
	/**
	 * The client has paid. He may leave the bar. (For further implementation).
	 */
	PAID;
	
}
