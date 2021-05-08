package org.example.dao;

import org.example.exceptions.InvalidTraineeDataException;
import org.example.exceptions.InvalidTraineeOperationException;

public interface TraineeDao {
	public void addTraineeToRepository(String email,String name,String cohortCode, String empId)throws InvalidTraineeDataException,InvalidTraineeOperationException;

	public void removeTraineeFromRepository(String empId);
	
}
