package org.example.exceptions;

public class InvalidTraineeOperationException extends Exception{

	/**
	 * @serialField
	 */
	private static final long serialVersionUID = 5098282599836207738L;
	public InvalidTraineeOperationException(String message)
	{
		super(message);
	}
}
