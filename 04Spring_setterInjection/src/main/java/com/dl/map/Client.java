package com.dl.map;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Client {



	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("com/dl/map/applicationContext.xml");
		Honda honda = context.getBean("honda", Honda.class);
		System.out.println(honda.getVno());
		System.out.println(honda.getModels());
		context.close();
		
	}
}
