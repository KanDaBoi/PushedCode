package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.exception.InvalidFlightOperation;
import com.cognizant.model.Flight;
import com.cognizant.model.Passenger;
import com.cognizant.service.FlightManagementService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@SuppressWarnings("unchecked")
public class FlightManagementController {

	private static final String BUSINESS = "business";
	private static final String ECONOMY = "economy";
	private static final String ERROR_MESSAGE = "errorMessage";
	private static final String ERROR = "error";
	private static final String FLIGHTS = "flights";
	@Autowired
	private FlightManagementService flightManagementService;

	@GetMapping(value = "/flights")
	public String getIndexForm(ModelMap map) {
		return "flight";
	}

	@GetMapping(value = "/economyAdd")
	public String redirectToEconomyAdd(@ModelAttribute("passenger") Passenger passenger) {
		return ECONOMY;
	}

	@GetMapping(value = "/businessAdd")
	public String redirectToBusinessAdd(@ModelAttribute("passenger") Passenger passenger) {
		return BUSINESS;
	}

	@PostMapping(value = "/flights/economy")
	public String addPassengerToEconomy(@ModelAttribute("passenger") Passenger passenger, ModelMap map) {
		List<Flight> flights = (List<Flight>) map.getAttribute(FLIGHTS);
		Flight economyFlight = new Flight();
		for (Flight flight : flights) {
			if (flight.getFlightType().equalsIgnoreCase(ECONOMY)) {
				economyFlight = flight;
				break;
			}
		}
		try {
			economyFlight.addPassenger(passenger);
			map.addAttribute("name", passenger.getName());
			map.addAttribute("id", economyFlight.getId());
			return "result";
		} catch (InvalidFlightOperation ifo) {
			log.error(ifo.getMessage());
			String stackTrace = "";
			for (StackTraceElement stack : ifo.getStackTrace()) {
				stackTrace += stack + "\n";
			}
			log.error(stackTrace);
			map.addAttribute(ERROR_MESSAGE, ifo.getMessage());
			return ERROR;
		} catch (NullPointerException npe) {
			log.error(npe.getMessage());
			return ERROR;
		}
	}

	@PostMapping(value = "/flights/business")
	public String addPassengerToBusiness(@ModelAttribute("passenger") Passenger passenger, ModelMap map) {
		List<Flight> flights = (List<Flight>) map.getAttribute(FLIGHTS);
		Flight businessFlight = new Flight();
		for (Flight flight : flights) {
			if (flight.getFlightType().equalsIgnoreCase(BUSINESS)) {
				businessFlight = flight;
				break;
			}
		}
		try {
			businessFlight.addPassenger(passenger);
			map.addAttribute("name", passenger.getName());
			map.addAttribute("id", businessFlight.getId());
			return "result";
		} catch (InvalidFlightOperation ifo) {
			exceptionHandling(ifo);
			map.addAttribute(ERROR_MESSAGE, ifo.getMessage());
			return ERROR;
		} catch (NullPointerException npe) {
			log.error(npe.getMessage());
			return ERROR;
		}
	}

	@GetMapping(value = "/flights/economy")
	public String deletePassengerFromEconomy(@RequestParam("param2") String vipStatus,
			@RequestParam("param1") String name, ModelMap map) {
		List<Flight> flights = (List<Flight>) map.getAttribute(FLIGHTS);
		Flight economyFlight = new Flight();
		for (Flight flight : flights) {
			if (flight.getFlightType().equalsIgnoreCase(ECONOMY)) {
				economyFlight = flight;
				break;
			}
		}
		try {
			for (Passenger passenger : economyFlight.getPassengers()) {
				if (passenger.getName().equalsIgnoreCase(name)
						&& passenger.isVip() == (boolean) Boolean.valueOf(vipStatus)) {
					economyFlight.removePassenger(passenger);
					break;
				}
			}
			return "successDeletion";
//			economyFlight.getPassengers().removeIf(passenger -> passenger.equals(exPassenger));
		} catch (InvalidFlightOperation ifo) {
			exceptionHandling(ifo);
			map.addAttribute(ERROR_MESSAGE, ifo.getMessage());
			return ERROR;
		}
	}

	@GetMapping(value = "/flights/business")
	public String deletePassengerFromBusiness(@RequestParam("param2") String vipStatus,
			@RequestParam("param1") String name, ModelMap map) {
		List<Flight> flights = (List<Flight>) map.getAttribute(FLIGHTS);
		Flight businessFlight = new Flight();
		for (Flight flight : flights) {
			if (flight.getFlightType().equalsIgnoreCase(BUSINESS)) {
				businessFlight = flight;
				break;
			}
		}
		try {
			for (Passenger passenger : businessFlight.getPassengers()) {
				if (passenger.getName().equalsIgnoreCase(name)
						&& passenger.isVip() == (boolean) Boolean.valueOf(vipStatus)) {
					businessFlight.removePassenger(passenger);
					break;
				}
			}
			return "successDeletion";
//			economyFlight.getPassengers().removeIf(passenger -> passenger.equals(exPassenger));
		} catch (InvalidFlightOperation ifo) {
			exceptionHandling(ifo);
			map.addAttribute(ERROR_MESSAGE, ifo.getMessage());
			return ERROR;
		}
	}

	@GetMapping(value = "/seeAllFlights")
	public String seeAllFlights(ModelMap map) {
		return "allFlights";
	}

	@ModelAttribute(FLIGHTS)
	public List<Flight> addFlights() {
		Flight businessFlight = new Flight();
		businessFlight.setFlightType(BUSINESS);
		businessFlight.setId("2");
		Flight economyFlight = new Flight();
		economyFlight.setFlightType(ECONOMY);
		economyFlight.setId("1");
		flightManagementService.addFlight(economyFlight);
		flightManagementService.addFlight(businessFlight);
		return flightManagementService.getFlightRepository().getFlights();
	}

	private static void exceptionHandling(InvalidFlightOperation ifo) {
		log.error(ifo.getMessage());
		String stackTrace = "";
		for (StackTraceElement stack : ifo.getStackTrace()) {
			stackTrace += stack + "\n";
		}
		log.error(stackTrace);
	}
}