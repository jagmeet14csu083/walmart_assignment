package io.jagmeet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@SpringBootApplication
@EnableScheduling
public class WalmartAssignmentApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(WalmartAssignmentApplication.class, args);
		
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	@Bean
	public XmlMapper getXmlMapper() {
		return new XmlMapper();
	}

}
