package org.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.example.dao.TraineeDaoImpl;
import org.example.model.Trainee;

public class TraineeRepoImpl implements TraineeRepo {

	@Override
	public Trainee findByName(String name) {
		Trainee trainee = null;
		for(Trainee presentTrainee : TraineeDaoImpl.trainees)
		{
			if (presentTrainee.getName().equalsIgnoreCase(name))
				trainee = presentTrainee;
		}
		return trainee;
	}

	@Override
	public List<Trainee> findAll(String cohortCode) {
		List<Trainee> traineesOfACohort = new ArrayList<>();
		for(Trainee trainee : TraineeDaoImpl.trainees)
		{
			if(trainee.getCohortCode().equalsIgnoreCase(cohortCode))
				traineesOfACohort.add(trainee);
		}
		return traineesOfACohort;
	}

}
