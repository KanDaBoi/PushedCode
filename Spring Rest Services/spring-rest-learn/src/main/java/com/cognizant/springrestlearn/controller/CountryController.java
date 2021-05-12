package com.cognizant.springrestlearn.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springrestlearn.model.Country;
import com.cognizant.springrestlearn.service.CountryService;
import com.cognizant.springrestlearn.service.exception.CountryNotFoundException;

@RestController
@RequestMapping("/countries")
public class CountryController {

	@Autowired
	private CountryService countryService;

	private static final ApplicationContext ctx = new ClassPathXmlApplicationContext("country.xml");
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

	public CountryController() {
		LOGGER.debug("Inside constructor");
	}

	@RequestMapping(value = "/in", method = RequestMethod.GET)
	public Country getCountryIndia() throws IOException {
		LOGGER.debug("Start of get country india");

		Country india = ctx.getBean("in", Country.class);
		LOGGER.debug("End of get country india");
		return india;
	}

	@GetMapping
	public List<Country> getAllCountries() {
		List<Country> countries = (List<Country>) ctx.getBean("countryList");
		return countries;
	}

	@GetMapping(value = "/{code}")
	public Country getCountry(@PathVariable("code") String code) throws IOException, CountryNotFoundException {
		return countryService.getCountry(code);
	}

	@PostMapping
	public Country addCountry(@RequestBody @Valid Country country) {
		LOGGER.debug("start");
		return country;
	}
}
