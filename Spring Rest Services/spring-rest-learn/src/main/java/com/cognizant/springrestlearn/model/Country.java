package com.cognizant.springrestlearn.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
	@NotNull
	@Size(min=2,max=2,message="Country code should be 2 characters")
	private String code;
	private String name;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);
	public Country()
	{
		LOGGER.debug("Inside Country Constructor");
	}
	public String getCode() {
		LOGGER.debug("Inside getter method of Code");
		return code;
	}
	public void setCode(String code) {
		LOGGER.debug("Inside setter method of Code");
		this.code = code;
	}
	public String getName() {
		LOGGER.debug("Inside getter method of Name");
		return name;
	}
	public void setName(String name) {
		LOGGER.debug("Inside setter method of Name");
		this.name = name;
	}
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	
}
