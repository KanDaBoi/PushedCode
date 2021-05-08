package com.cognizant.exception;

public class InvalidFlightOperation extends Exception{

	/**
	 * @serialField
	 */
	private static final long serialVersionUID = 5098282599836207738L;
	public InvalidFlightOperation(String message)
	{
		super(message);
	}
}
