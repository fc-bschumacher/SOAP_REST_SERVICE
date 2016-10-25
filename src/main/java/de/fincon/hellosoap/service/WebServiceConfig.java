package de.fincon.hellosoap.service;

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

	
	// the description of the Bean (name = ... ) describes the name of the wsdl file ->  current project: hellosoap.wsdl 
	@Bean(name = "hellosoap")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema spielSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("HelloSoapPort");
		
		// directory where the current wsdl file is lying
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://hellosoap.de");
		wsdl11Definition.setSchema(spielSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema spielSchema() {
		return new SimpleXsdSchema(new ClassPathResource("hellosoap.xsd"));
	}
}
