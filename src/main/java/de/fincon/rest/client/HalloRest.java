package de.fincon.rest.client;

import org.springframework.web.client.RestTemplate;

// REST Client
public class HalloRest {

	final String uri = "http://localhost:8082/greeting";
	
	// Methode um den String zurück zu liefern (JSON)
	public String getGreeting() {
		RestTemplate rest = new RestTemplate();
		String result = rest.getForObject(uri, String.class);
		return result;
	}

}