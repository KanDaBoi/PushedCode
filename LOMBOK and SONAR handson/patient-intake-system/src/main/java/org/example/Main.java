package org.example;

import java.text.ParseException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
	private static final Logger LOGGER = LoggerFactory.getLogger("success");
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ClinicCalendar cc = new ClinicCalendar();
		int choice;
		try {
			do {
				System.out.println(
						"****APPOINTMENT MENU****\nPlease pick an option:- \n1.)Add a patient appointment\n2.)View all appointments\n3.)Exit\n");
				choice = sc.nextInt();
				sc.nextLine();
				if (choice == 1) {
					System.out.println("Enter a name");
					String name = sc.nextLine();
					System.out.println("Enter an age");
					int age = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter a date");
					String dateText = sc.nextLine();
					cc.addAppointment(name,age,dateText);
					LOGGER.debug("Date format is correct");
					LOGGER.debug("Patient added successfully");
				}
				else if(choice == 2)
				{
					for(PatientAppointment patientAppointment : cc.getAppointments())
						System.out.println(patientAppointment);
					
					LOGGER.debug("View successful");
				}
				else if(choice == 3)
				{
					System.out.println("Thank you for accessing the system. Bye...");
				}
				else
					System.out.println("Invalid input.Please try again.");
			} while (choice != 3);
		} catch (ParseException pe) {
			log.error("Date format invalid.");
			String stackTrace = "";
			for (StackTraceElement stack : pe.getStackTrace()) {
				stackTrace += stack + "\n";
			}
			log.error(stackTrace);
		}
		sc.close();
	}
}


//6820b87a86dcf15cc3fa09b7b1222ae0325d1a5f
//mvn sonar:sonar -Dsonar.projectKey=org.example:PatientIntake -Dsonar.host.url=http://localhost:9000 -Dsonar.login=6820b87a86dcf15cc3fa09b7b1222ae0325d1a5f