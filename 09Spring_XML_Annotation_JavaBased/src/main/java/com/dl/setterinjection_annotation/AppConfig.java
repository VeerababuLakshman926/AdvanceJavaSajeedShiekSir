package com.dl.setterinjection_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "com.dl.setterinjection_annotation")
public class AppConfig {
	
	@Bean
	public Models models() {
		
		return new Models();
	}
	
}
