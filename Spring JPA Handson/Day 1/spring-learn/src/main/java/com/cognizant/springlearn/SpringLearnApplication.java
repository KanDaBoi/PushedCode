package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class SpringLearnApplication {
	private static CountryService countryService;
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) throws CountryNotFoundException {
		LOGGER.info("Inside main");
		ApplicationContext ctx = SpringApplication.run(SpringLearnApplication.class, args);
		countryService = ctx.getBean(CountryService.class);
		getAllCountriesTest();
		addCountryTest();
		updateCountryTest();
		try {
			deleteCountryTest();
		}catch(CountryNotFoundException cnfe) {
			LOGGER.debug(cnfe.getMessage());
		}
	}

	private static void getAllCountriesTest() {

		LOGGER.info("Start");
		try {
			Country country = countryService.findCountryByCode("IN");
			LOGGER.debug("Country:{}", country);
			LOGGER.info("End");
		}catch(CountryNotFoundException cnfe)
		{
			System.err.println(cnfe.getMessage());
			LOGGER.error("Exception found related to invalid country");
		}

	}
	
	private static void addCountryTest() throws CountryNotFoundException {
		LOGGER.info("Adding new country");
		Country country = new Country();
		country.setCode("XY");
		country.setName("Xylophobia");
		countryService.addCountry(country);
		LOGGER.debug(countryService.findCountryByCode("XY").toString());
	}
	
	private static void updateCountryTest() {
		LOGGER.info("Start update");
		countryService.updateCountry("IN", "Bharat");
		LOGGER.info("End update");
	}
	
	private static void deleteCountryTest() throws CountryNotFoundException {
		LOGGER.info("Starting Delete");
		countryService.deleteCountry("XY");
		LOGGER.info("Country deleted. Searching for deleted country");
		countryService.findCountryByCode("XY");
		LOGGER.info("Delete test complete");
	}
}