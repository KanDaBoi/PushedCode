package org.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.example.exceptions.InvalidTraineeDataException;
import org.example.exceptions.InvalidTraineeOperationException;
import org.example.model.Trainee;

import lombok.Getter;

@Getter
public class TraineeDaoImpl implements TraineeDao {
	public static List<Trainee> trainees = new ArrayList<>();

	@Override
	public void addTraineeToRepository(String email, String name, String cohortCode, String empId)
			throws InvalidTraineeDataException, InvalidTraineeOperationException {
		Pattern p1 = Pattern.compile("[\\d]");
		Matcher m1 = p1.matcher(name);
		Pattern p2 = Pattern.compile("[A-z0-9]+[@]{1}[A-z0-9]+[.]{1}[A-z]+");
		Matcher m2 = p2.matcher(email);
		Pattern p3 = Pattern.compile("[\\d]{6}");
		Matcher m3 = p3.matcher(empId);
		Pattern p4 = Pattern.compile("[A-z]{3}[0-9]{2}[A-z]{2}[0-9]{2}");
		Matcher m4 = p4.matcher(cohortCode);
		if (!m1.matches() && m2.matches() && m3.matches() && m4.matches()) {
			for (Trainee trainee : trainees) {
				if (empId.equalsIgnoreCase(trainee.getEmpId()) && !cohortCode.equalsIgnoreCase(trainee.getCohortCode()))
					throw new InvalidTraineeOperationException("Cannot add same trainee to different cohort");
			}
			Trainee trainee = new Trainee(email, name, cohortCode, empId);
			trainees.add(trainee);
		} else
			throw new InvalidTraineeDataException("Details are not in the correct format.");
	}

	@Override
	public void removeTraineeFromRepository(String empId) {
		trainees.removeIf(trainee -> trainee.getEmpId().equalsIgnoreCase(empId));
	}

}
