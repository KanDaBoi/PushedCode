package com.cognizant.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.cognizant.exception.InvalidFlightOperation;
import com.cognizant.service.FlightManagementService;

class FlightUnitTest {

	@Test
	void addFlightTest() throws InvalidFlightOperation {
		FlightManagementService fms = new FlightManagementService();
		Passenger passenger = new Passenger();
		Flight flight = new Flight();
		assertThrows(NullPointerException.class,() -> {fms.addFlight(flight);});
		passenger.setName("Kanishk Jha");
		passenger.setVip(true);
		flight.setFlightType("business");
		flight.setId("1");
		assertTrue(flight.addPassenger(passenger));
		 assertThrows(InvalidFlightOperation.class,() ->
		 {flight.removePassenger(passenger);});
		flight.setFlightType("economy");
		assertTrue(flight.addPassenger(passenger));
		 assertThrows(InvalidFlightOperation.class,() ->
		 {flight.removePassenger(passenger);});
		passenger.setVip(false);
		assertTrue(flight.addPassenger(passenger));
		assertTrue(flight.removePassenger(passenger));
		flight.setFlightType("business");
		 assertThrows(InvalidFlightOperation.class,() ->
		 {flight.addPassenger(passenger);});
		 assertThrows(InvalidFlightOperation.class,() ->
		 {flight.removePassenger(passenger);});
	}
}