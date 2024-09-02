package com.dl.ValueAsPnameSpace;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Client {



	public static void main(String[] args) {
		
		ApplicationContext context =  new ClassPathXmlApplicationContext("com/dl/ValueAsPnameSpace/applicationContext.xml");
		
		Honda honda = context.getBean("honda", Honda.class);
		System.out.println("Vehicle Name is " + honda.getVname());
		System.out.println("Vehicle No is " + honda.getVno());
//		context.close();
		
	}
}
