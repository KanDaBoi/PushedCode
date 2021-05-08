package org.example;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class PatientAppointment {
	private String patientName;
	private int age;
	private Date appointmentDate;
}
