package eu.fincon.hellosoap.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {

	@Value("${restUrl}")
	public String restUrl;
	
}
