package com.dl.constructorinjection.javabased;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Honda honda = context.getBean(Honda.class);
		System.out.println(honda);
		context.close();
	}

}
