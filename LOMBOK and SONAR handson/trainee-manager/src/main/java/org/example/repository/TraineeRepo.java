package org.example.repository;

import java.util.List;

import org.example.model.Trainee;

public interface TraineeRepo {
	public Trainee findByName(String name);
	public List<Trainee> findAll(String cohortCode);
	
}
