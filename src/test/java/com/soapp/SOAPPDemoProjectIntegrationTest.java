package com.soapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.util.ClassUtils;
import org.springframework.ws.client.core.WebServiceTemplate;

import localhost._8081.ws.ObtenerPaisRequest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SOAPPDemoProjectIntegrationTest {
	
	@LocalServerPort
	private int port = 0;
	
	private String baseUrl = "http://localhost:";
	
	private Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
	
	@BeforeEach
	private void init() throws Exception {
		marshaller.setPackagesToScan(ClassUtils.getPackageName(ObtenerPaisRequest.class));
		marshaller.afterPropertiesSet();
	}
	
	@Test
	public void testSendAndReceive() {
		WebServiceTemplate ws = new WebServiceTemplate(marshaller);
		ObtenerPaisRequest request = new ObtenerPaisRequest();
		request.setName("argentina");
		
		assertThat(ws.marshalSendAndReceive(baseUrl+port+"/ws", request)!= null);
	}
}
