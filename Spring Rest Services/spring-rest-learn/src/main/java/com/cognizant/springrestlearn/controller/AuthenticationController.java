package com.cognizant.springrestlearn.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

	@GetMapping(value="/authenticate")
	public Map<String,String> authenticate(@RequestHeader("Authorization") String authHeader){
		LOGGER.info("Start of authenticate");
		LOGGER.debug("Authentication Header: {}",authHeader);
		String user = getUser(authHeader);
		LOGGER.debug("User: {}",user);
		String token = generateJwt(user);
		LOGGER.debug("Token: {}",token);
		Map<String,String> details = new HashMap<>();
		details.put("token", token);
		LOGGER.info("End of authenticate");
		return details;
	}
	
	private String getUser(String authHeader)
	{
		LOGGER.info("Start of method");
		String decodedAuthToken = new String(Base64.getDecoder().decode(authHeader.substring(6)));
		LOGGER.debug("Decoded token: {}",decodedAuthToken);
		LOGGER.debug(decodedAuthToken.substring(0,4));
		LOGGER.info("End of method");
		return decodedAuthToken.substring(0,4);
	}
	
	private String generateJwt(String user) {
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);
		builder.setIssuedAt(new Date());
		builder.setExpiration(new Date((new Date()).getTime()+1200000));
		builder.signWith(SignatureAlgorithm.HS256,"secretkey");
		String token = builder.compact();
		return token;
	}
}
