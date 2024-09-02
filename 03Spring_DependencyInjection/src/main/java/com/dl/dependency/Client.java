package com.dl.dependency;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("com/dl/dependency/applicationContext.xml");
		Brand b1 = context.getBean("cars", Brand.class);
		Brand b2 = context.getBean("bikes", Brand.class);
		
		System.out.println(b1.honda());
		System.out.println(b2.honda());
		
		context.close();
	}
}
