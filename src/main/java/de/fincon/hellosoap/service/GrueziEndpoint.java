package de.fincon.hellosoap.service;

import java.io.IOException;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.fincon.dom.Message;
import de.fincon.rest.client.HelloRest;
import de.hellosoap.GetGrueziRequest;
import de.hellosoap.GetGrueziResponse;
import de.hellosoap.Gruezi;

@Endpoint
public class GrueziEndpoint {
	
	/*
	 * 	static definition for the namespace
	 */
	private static final String NAMESPACE_URI = "http://hellosoap.de";
	
	/*
	 * 	SOAP method getGreeting
	 */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getGrueziRequest")
	@ResponsePayload
	public GetGrueziResponse getGruss(@RequestPayload GetGrueziRequest request) {

		// creating two instances of the Gruezi.class
		Gruezi gruss = new Gruezi();
		gruss.setGruss("Pauli");
		
		Gruezi error = new Gruezi();
		error.setGruss("Error");
		
		// connection to the REST Service
		String restresponse = "";
		HelloRest rest = new HelloRest();
		restresponse = rest.getGreeting();
		
		// handling the REST response(JSON String) with the aid of Jackson
		ObjectMapper mapper = new ObjectMapper();
		Message msg = new Message();
		
		try {
			msg = mapper.readValue(restresponse, Message.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// creating the response object
		GetGrueziResponse response = new GetGrueziResponse();
		
		if (msg.getText().equals("Hello, World!")){
			
			response.setGruezi(gruss);
		} else {
			response.setGruezi(error);
		}
	
		return response;
	}
}
