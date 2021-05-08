package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.Flight;
import com.cognizant.repository.FlightRepository;

import lombok.Getter;

@Service
@Getter
public class FlightManagementService {
	
	@Autowired
	private FlightRepository flightRepository;
	
	public boolean addFlight(Flight flight)
	{
		return flightRepository.getFlights().add(flight);
	}
}
