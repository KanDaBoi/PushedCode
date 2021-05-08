package com.cognizant.queryormlearn.service.exception;

public class CountryNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9081365968567081483L;

	public CountryNotFoundException(String message) {
		super(message);
	}
}
