package com.dl.list;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Client {



	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("com/dl/list/applicationContext.xml");
		Honda honda = context.getBean("honda", Honda.class);
		System.out.println(honda.getSname());
		System.out.println(honda.getModels());
		context.close();
		
	}
}
