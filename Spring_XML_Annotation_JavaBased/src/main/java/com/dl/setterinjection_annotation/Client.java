package com.dl.setterinjection_annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dl.setterinjection.javabased.AppConfig;
import com.dl.setterinjection.javabased.Honda;

public class Client {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Honda honda = context.getBean(Honda.class);
		System.out.println(honda.getModels());
		context.close();
	}
}
