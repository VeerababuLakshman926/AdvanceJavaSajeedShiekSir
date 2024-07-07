package com.dl.ValueAsElement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Client {

	public static void main(String[] args) {
		
//		ApplicationContext context =  new ClassPathXmlApplicationContext("com/dl/ValueAsElement/applicationContext.xml");
//		//Honda honda = (Honda) context.getBean("honda"); 
//		//the above and below both commands are same but it is adivisable to use below one. 
//		// the above will give ClassCastException if the retrieved bean is not honda class type
//		// the below one will give BeanNotOfRequiredTypeException if the retrieved bean is not honda class type
//		Honda honda = context.getBean("honda", Honda.class);
//		System.out.println("Vehicle Name is " + honda.getVname());
//		System.out.println("Vehicle No is " + honda.getVno());
//		//context.close();
		
		
		Resource resource = new ClassPathResource("com/dl/ValueAsElement/applicationContext.xml");
		
	}
}
