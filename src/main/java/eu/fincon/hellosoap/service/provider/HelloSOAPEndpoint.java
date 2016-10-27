package eu.fincon.hellosoap.service.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import eu.fincon.hellosoap.service.ApplicationProperties;
import eu.fincon.hellosoap.service.model.RestResponse;
import io.spring.guides.gs_producing_web_service.GetHelloSOAPRequest;
import io.spring.guides.gs_producing_web_service.GetHelloSOAPResponse;
import io.spring.guides.gs_producing_web_service.HelloSOAPPort;

@Endpoint()
public class HelloSOAPEndpoint implements HelloSOAPPort {
	
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
	
	@Autowired
	private ApplicationProperties properties;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHelloSOAPRequest")
	@ResponsePayload
	@Override
	public GetHelloSOAPResponse getHelloSOAP(@RequestPayload GetHelloSOAPRequest getHelloSOAPRequest) {
		GetHelloSOAPResponse response = new GetHelloSOAPResponse();
		response.setAnswer(getGreeting(getHelloSOAPRequest.getName()));
		return response;
	}

	private String getGreeting(String name) {
		String uri = properties.restUrl;
		if (name != null) {
			uri = uri + "?name=" + name;
		}
		
		RestTemplate rest = new RestTemplate();
		RestResponse result = rest.getForObject(uri, RestResponse.class);
		return result.getContent();
}


}
