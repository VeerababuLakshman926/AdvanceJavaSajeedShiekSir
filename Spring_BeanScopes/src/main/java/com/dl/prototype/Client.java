package com.dl.prototype;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Client {
	
public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/dl/prototype/applicationContext.xml");
		Honda honda = context.getBean("honda", Honda.class);
		System.out.println(honda.getVno());
		System.out.println(honda.getVname());
		System.out.println(honda.getClass());
		System.out.println(honda.hashCode());
		
		Honda honda2 = context.getBean("honda", Honda.class);
		System.out.println(honda2.getVno());
		System.out.println(honda2.getVname());
		System.out.println(honda2.getClass());
		System.out.println(honda2.hashCode());
		
		context.close();
	}
}
