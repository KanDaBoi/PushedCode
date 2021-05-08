package com.cognizant.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.model.Flight;

import lombok.Getter;

@Repository
@Getter
public class FlightRepository {
	private List<Flight> flights = new ArrayList<>();
}
