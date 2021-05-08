package org.example.exceptions;

public class InvalidTraineeDataException extends Exception{

	/**
	 * @serialField
	 */
	private static final long serialVersionUID = 5582638592227749543L;
	public InvalidTraineeDataException(String message)
	{
		super(message);
	}
}
