package com.dl.ambiguites;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/dl/ambiguites/applicationContext.xml");
		Student student = context.getBean("student", Student.class);
		System.out.println(student);
		context.close();
	}

}	
