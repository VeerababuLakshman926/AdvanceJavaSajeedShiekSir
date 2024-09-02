package com.dl.setterinjection.ml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/dl/setterinjection/ml/applicationContext.xml");
		Honda honda = context.getBean("honda", Honda.class);
		System.out.println(honda.getModels());
		context.close();
		
	}
}
