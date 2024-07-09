package com.dl.properties.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/dl/properties/util/applicationContext.xml");
		Honda honda = context.getBean("honda",Honda.class);
		System.out.println(honda);
		context.close();
	}
}
