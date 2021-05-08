package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;

@Getter
public class ClinicCalendar {

	private List<PatientAppointment> appointments = new ArrayList<>();
	
	public boolean addAppointment(String name,int age,String dateText) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm a");
		Date date = sdf.parse(dateText);
		PatientAppointment patientAppointment = new PatientAppointment(name,age,date);
		return appointments.add(patientAppointment);
	}
}
