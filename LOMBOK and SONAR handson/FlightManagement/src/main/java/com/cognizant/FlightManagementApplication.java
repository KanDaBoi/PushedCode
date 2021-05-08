package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@ComponentScan("com.cognizant.*")
public class FlightManagementApplication {

	public static void main(String[] args) {
		log.info("Start");
		SpringApplication.run(FlightManagementApplication.class, args);
		log.info("End");
	}

}
