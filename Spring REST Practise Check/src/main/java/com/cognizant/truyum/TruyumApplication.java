package com.cognizant.truyum;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@ComponentScan(basePackages =  {"com.cognizant.truyum.controller","com.cognizant.truyum.service","com.cognizant.truyum.model","com.cognizant.truyum.dao"})
public class TruyumApplication {
	

	public static void main(String[] args){
		
		SpringApplication.run(TruyumApplication.class, args);

	}
}
