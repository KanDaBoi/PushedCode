package org.example;

import java.util.List;
import java.util.Scanner;

import org.example.dao.TraineeDao;
import org.example.dao.TraineeDaoImpl;
import org.example.exceptions.InvalidTraineeDataException;
import org.example.exceptions.InvalidTraineeOperationException;
import org.example.model.Trainee;
import org.example.repository.TraineeRepo;
import org.example.repository.TraineeRepoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {

	private final static Logger LOGGER = LoggerFactory.getLogger("errors");

	public static void main(String[] args) {
		log.info("Inside main");
		Scanner sc = new Scanner(System.in);
		TraineeDao daoOperations = new TraineeDaoImpl();
		TraineeRepo repoOperations = new TraineeRepoImpl();
		int choice;
		String name,email,empId,cohortCode;
		boolean breaker = false;
		try {
			while(!breaker) {
				System.out.println(
						"****MENU****\nPlease pick an option:- \n1.)Register Trainee\n2.)Remove Trainee\n3.)Find by name\n4.)Find all\n5)Exit");
				choice = sc.nextInt();
				sc.nextLine();
				switch(choice) {
					case 1:
					System.out.println("Enter a name");
					name = sc.nextLine();
					System.out.println("Enter an email");
					email = sc.nextLine();
					System.out.println("Enter an employee ID");
					empId = sc.nextLine();
					System.out.println("Enter the cohort code");
					cohortCode = sc.nextLine();
					log.info("Adding trainee to repo");
					daoOperations.addTraineeToRepository(email, name, cohortCode, empId);
					log.info("Add done");
					break;
					case 2: 
					log.info("Removing trainee from repo");
					System.out.println("Enter employee id of the employee you wish to remove");
					empId = sc.nextLine();
					daoOperations.removeTraineeFromRepository(empId);
					log.info("Delete successful");
					break;
					case 3:
					System.out.println("Enter name of employee you wish to find.");
					name = sc.nextLine();
					log.info("Searching by name");
					Trainee trainee = repoOperations.findByName(name);
					System.out.println(trainee);
					log.info("Trainee: {}", trainee);
					break;
					case 4:
					System.out.println("Enter the cohort code.");
					cohortCode = sc.nextLine();
					List<Trainee> trainees = repoOperations.findAll(cohortCode);
					log.info("List of employees : {}", trainees);
					for (Trainee presentTrainee : trainees)
						System.out.println(presentTrainee);
					break;
					case 5:
					System.out.println("Thank you for accessing the system. Bye...");
					log.info("Exiting main");
					breaker = true;
					break;
				 default:
					System.out.println("Invalid input.Please try again.");}
			}
		} catch (InvalidTraineeDataException itde) {
			LOGGER.error(itde.getMessage());
			String stackTrace = "";
			for (StackTraceElement stack : itde.getStackTrace()) {
				stackTrace += stack + "\n";
			}
			LOGGER.error(stackTrace);
		} catch (InvalidTraineeOperationException itoe) {
			LOGGER.error(itoe.getMessage());
			String stackTrace = "";
			for (StackTraceElement stack : itoe.getStackTrace()) {
				stackTrace += stack + "\n";
			}
			LOGGER.error(stackTrace);
		}
		sc.close();

	}

}


//1f2922a5b1a3d2d978943e74a2315134b80cb690
//mvn sonar:sonar -Dsonar.projectKey=org.example:TraineeManager -Dsonar.host.url=http://localhost:9000 -Dsonar.login=1f2922a5b1a3d2d978943e74a2315134b80cb690
