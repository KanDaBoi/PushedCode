package com.cognizant.springlearn.service.exception;

public class CountryNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3017329714056727723L;

	public CountryNotFoundException(String message) {
		super(message);
	}
}
