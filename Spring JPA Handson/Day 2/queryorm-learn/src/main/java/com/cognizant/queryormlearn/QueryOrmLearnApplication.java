package com.cognizant.queryormlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.queryormlearn.model.Country;
import com.cognizant.queryormlearn.service.CountryService;
import com.cognizant.queryormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class QueryOrmLearnApplication {
	private static CountryService countryService;
	private static final Logger LOGGER = LoggerFactory.getLogger(QueryOrmLearnApplication.class);

	public static void main(String[] args) throws CountryNotFoundException {
		LOGGER.info("Inside main");
		ApplicationContext ctx = SpringApplication.run(QueryOrmLearnApplication.class, args);
		countryService = ctx.getBean(CountryService.class);
		findByPartNameTest();
		findByPartNameSortedTest();
		findByAlphabetIndexTest();
		LOGGER.info("Exiting testing");
	}

	public static void findByPartNameTest() {
		LOGGER.debug("Predicting by part name");
		for (Country country : countryService.showAllPredictedCountries("ou")) {
			LOGGER.info(country.toString());
		}
		LOGGER.debug("Done predicting");
	}

	public static void findByPartNameSortedTest() {
		LOGGER.debug("Starting sort test");
		for (Country country : countryService.showSortedPredictedCountries("ou"))
			LOGGER.info(country.toString());
		LOGGER.debug("Done sorting test");
	}

	public static void findByAlphabetIndexTest() {
		LOGGER.debug("Starting index test");
		for (Country country : countryService.alphabetIndexing("Z"))
			LOGGER.info(country.toString());
		LOGGER.debug("Done index test");
	}
}