package org.example;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;

import org.junit.jupiter.api.Test;

class ClinicCalendarTest {

	@Test
	void calendarTest() throws ParseException {
		ClinicCalendar cc = new ClinicCalendar();
		String name="Kanishk Jha";
		int age = 21;
		String dateText = "04-5-2021 07:01 AM";
		assertTrue(cc.addAppointment(name, age, dateText));
		assertThrows(ParseException.class,()->{cc.addAppointment(name, age, "04/05/2021 07:01:56");});
	}

}
