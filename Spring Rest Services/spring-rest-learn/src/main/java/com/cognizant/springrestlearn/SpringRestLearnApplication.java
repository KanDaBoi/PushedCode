package com.cognizant.springrestlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springrestlearn.model.Country;

@SpringBootApplication
public class SpringRestLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringRestLearnApplication.class);
	public static void main(String[] args) throws ParseException {
		LOGGER.info("Inside main method of Application class.");
		LOGGER.info("Main working just fine.");
		SpringApplication.run(SpringRestLearnApplication.class, args);
		LOGGER.info("Running display date method");
		displayDate();
		LOGGER.info("Running display country method");
		displayCountry();
		LOGGER.info("Running display countries method");
		displayCountries();
		LOGGER.info("Ending main now...");
	}
	
	private static void displayDate() throws ParseException
	{
		LOGGER.info("START");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat sdf = ctx.getBean("dateFormat",SimpleDateFormat.class);
		Date date = sdf.parse("31/12/2018");
		LOGGER.debug("Date: {}",date);
		LOGGER.debug("END");
	}
	
	private static void displayCountry()
	{
		LOGGER.info("START");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("country.xml");
		Country country = ctx.getBean("in",Country.class);
		Country anotherCountry = ctx.getBean("in",Country.class);
		LOGGER.debug("Country: {}",country);
		LOGGER.debug("Another country: {}",anotherCountry);
		LOGGER.debug("Hash: {}",country.hashCode());
		LOGGER.debug("Hash: {}",anotherCountry.hashCode());
		LOGGER.info("END");
	}
	
	private static void displayCountries()
	{
		LOGGER.info("START");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = (List<Country>)ctx.getBean("countryList");
		for(Country country : countries)
			LOGGER.debug("Country: {}",country);
		LOGGER.info("END");
	}

}
