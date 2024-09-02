package com.dl.set;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Client {



	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("com/dl/set/applicationContext.xml");
		Honda honda = context.getBean("honda", Honda.class);
		System.out.println(honda.getSname());
		System.out.println(honda.getModels());
		context.close();
		
	}
}
