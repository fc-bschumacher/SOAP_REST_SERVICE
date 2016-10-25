package de.fincon.bundesliga.service;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

//import org.springframework.boot.autoconfigure.webservices.*;

import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/ws/*");
	}

	
	// die bezeichnung des Bean Namens (name = ... ) bezeichnet später den genauen Namen der wsdl Datei  ->  hier: hallosoap.wsdl 
	@Bean(name = "hallosoap")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema spielSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("BundesligaPort");
		// Verzeichnis in dem die wsdl Datei abgerufen werden kann
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://hallosoap.de");
		wsdl11Definition.setSchema(spielSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema spielSchema() {
		return new SimpleXsdSchema(new ClassPathResource("spiel.xsd"));
	}
}
