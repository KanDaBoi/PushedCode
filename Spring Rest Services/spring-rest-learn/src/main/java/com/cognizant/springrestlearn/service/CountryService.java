package com.cognizant.springrestlearn.service;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springrestlearn.model.Country;
import com.cognizant.springrestlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	public Country getCountry(String code) throws IOException, CountryNotFoundException
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = (List<Country>)ctx.getBean("countryList");
		Country countryMatched = null;
		for(Country country: countries)
		{
			if(country.getCode().equalsIgnoreCase(code))
			{
				countryMatched = country;
				break;
			}
		}
		((Closeable)ctx).close();
		if(countryMatched!=null)
			return countryMatched;
		else
			throw new CountryNotFoundException();
	}
}
