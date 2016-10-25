package de.fincon.rest.client;

import org.springframework.web.client.RestTemplate;

// REST Client
public class HelloRest {

	final String uri = "http://localhost:8082/greeting";
	
	/*
	 * 	method to return the JSON String 
	 */
	public String getGreeting() {
		RestTemplate rest = new RestTemplate();
		String result = rest.getForObject(uri, String.class);
		return result;
	}

}