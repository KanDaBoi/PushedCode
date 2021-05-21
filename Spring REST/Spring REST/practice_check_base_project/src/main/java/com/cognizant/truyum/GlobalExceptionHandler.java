package com.cognizant.truyum;

public class GlobalExceptionHandler extends Exception{

	private static final long serialVersionUID = 1L;

	public GlobalExceptionHandler(String msg) {
		super(msg);
	}
}
