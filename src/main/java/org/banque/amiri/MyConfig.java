package org.banque.amiri;

import org.banque.amiri.rmi.BanqueRMIRemote;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
public class MyConfig {
	// SOAP
	// mm que spring-beans.xml Sauf ICI avec java

	@Bean
	public SimpleJaxWsServiceExporter getJWS() {
		SimpleJaxWsServiceExporter expoter = new SimpleJaxWsServiceExporter();
		expoter.setBaseAddress("http://localhost:8098/maBanque");
		return expoter;
	}

	// RMI
	@Bean
	public RmiServiceExporter getRmiService(ApplicationContext context) {
		RmiServiceExporter exporter = new RmiServiceExporter();
		exporter.setService(context.getBean("myRmiService"));
		exporter.setRegistryPort(1099);
		exporter.setServiceName("BK");//Publie dans l'annuaire avec le nom BK
		exporter.setServiceInterface(BanqueRMIRemote.class);
		return exporter;
	}
}
