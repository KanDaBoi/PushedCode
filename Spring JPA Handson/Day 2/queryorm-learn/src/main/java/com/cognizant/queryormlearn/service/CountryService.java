package com.cognizant.queryormlearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.queryormlearn.model.Country;
import com.cognizant.queryormlearn.repository.CountryRepository;
import com.cognizant.queryormlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException
	{
		Optional<Country> result = countryRepository.findById(countryCode);
		if(!(result.isPresent()))
			throw new CountryNotFoundException("Country not found");
		else
			return result.get();
	}
	
	@Transactional
	public void updateCountry(String code,String name)
	{
		Country country = countryRepository.findById(code).get();
		country.setName(name);
		countryRepository.save(country);
	}
	
	@Transactional
	public void addCountry(Country country)
	{
		countryRepository.save(country);
	}
	
	@Transactional
	public void deleteCountry(String code)
	{
		countryRepository.deleteById(code);
	}
	
	public List<Country> showAllPredictedCountries(String partName)
	{
		return countryRepository.findByNameContaining(partName);
	}
	
	public List<Country> showSortedPredictedCountries(String partName)
	{
		return countryRepository.findByNameContainingOrderByNameAsc(partName);
	}
	
	public List<Country> alphabetIndexing(String alphabetIndex)
	{
		return countryRepository.findByNameStartingWith(alphabetIndex);
	}
}