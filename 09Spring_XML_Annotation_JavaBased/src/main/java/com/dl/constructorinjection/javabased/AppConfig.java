package com.dl.constructorinjection.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.dl.constructorinjection.javabased")
public class AppConfig {
	
	@Bean
	public Models models() {
		
		Models models = new Models("Honda City, Honda Civic", "Automatic");
		
		return models;
	}
	
}
