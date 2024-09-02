package com.dl.innerBeans.objectReference;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/dl/innerBeans/objectReference/applicationContext.xml");
		Honda honda = context.getBean("honda", Honda.class);
		System.out.println(honda.getHondaCars());
		context.close();
	}
}