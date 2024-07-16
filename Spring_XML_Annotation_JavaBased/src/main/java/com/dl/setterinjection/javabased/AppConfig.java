package com.dl.setterinjection.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.dl.setterinjection.javabased")
public class AppConfig {
	
	@Bean
	public Models models() {
		
		Models models = new Models();
		models.setModels("Honda City, Honda Civic");
		models.setType("Automatic");
		
		return models;
	}
	
}
