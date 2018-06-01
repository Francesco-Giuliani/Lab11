package it.polito.tdp.bar.model;

public enum TableState {

	/**
	 * The table is completely free: all seats are available
	 */
	FREE,
	/**
	 *The table is completely full: no seats available
	 */
	FULL,
	/**
	 * The table is partially taken: there are some seats available. (For further implementation of the model).
	 */
	TAKEN,
	/**
	 * The table is not available. Impossible tu use it for a longer time. (For further implementation of the model).
	 */
	UNAVAILABLE,
	/**
	 * The table is being cleaned. Unavailable for a short time. (For further implementation of the model).
	 */
	CLEANING;
}
