# AdvanceJavaSajeedShiekSir
Advance Java

# AdvanceJavaSajeedSir

# Road Map

# What is Spring?
* Spring is dependency injection FrameWork
* Spring is also called as Light Weight FrameWork alternate to J2EE(Servlets and JSP)
* Spring became popular in developing Java Applications
* Spring was developed by Rod Johnson

# What is Dependency Injection?
* Dependency Injection is a design pattern
* It removes dependency from the program
* This concept says that you dont create objects, but describe them how they should be created
* You dont directly connect components and services together in code, but describe which services are need by which components in a spring config file
* The spring container is responsible for hooking it up all
* we have three types of dependency injections: Setter Injection(important), Construction Injection, Filed Injection.

# What is Spring config file?
* Spring config is an XML file
* This file contains class information and describes how these classes are configured and introduced to each other.
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       https://www.springframework.org/schema/beans/spring-beans-3.0.xsd"> 
   
   <bean class="com.dl.dependency.Car" id="cars"></bean>
   <bean class="com.dl.dependency.Bike" id="bikes"></bean>
   
</beans>

```
# What is Spring IOC Container?
* Spring IOC Container will create objects, wire them together, configure them and manage their life cycle till destruction
* The Spring container uses Dependency Injection to manage the components that make up an application

# What are the types of IOC Containers in Spring?
**Bean Factory Container:**
* BeanFactory interface is part of the org.springframework.beans.factory.package
* ``` import org.springframework.beans.factory.BeanFactory ```
* Where XmlBeanFactory is the implementation class of BeanFactory
* It is the root interface of Spring IOC which is supported by BeanFactory interface.
* The BeanFactory is the actual container which instantiaties, configures and manages the number of beans.
* It belongs to org.springframework.beans.factory.BeanFactory interface
* These beans typically collaborate with one another, and thus have dependencies between themselves
* The BeanFactory enables you to read bean definition and access them using the bean factory

**Application Context:**
* BeanFactory is the basic container, where as Application Context is the advanced container
* Application Context extends the BeanFactory interface
* The Application context interface is part of the org.springframework.context package in Spring framework
* import org.springframework.context.ApplicationContext
* Application context provides more facilities than BeanFactory such as integration withe Spring AOP, message resource handling for i18n etc..

# What is POJO Class?
* POJO stands for Plain Old Java Object
* Here class must be public
* Properties are private
* Default constructor is mandatory
* Need to have setters and getters
* Now POJO class will not implement serializable interface

```
//Pojo class and it is not implementing serializabe interface
public class Honda {
	//Properties are private
	private int vno;
	private String vname;

	//Default constructor
	public Honda() {
		// TODO Auto-generated constructor stub
	}

	//Having setter and getters
	public int getVno() {
		return vno;
	}

	public void setVno(int vno) {
		this.vno = vno;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}
	
	
}

```

# What is Bean Class?
* All JavaBeans are POJO's, but not all POJO's are JavaBeans
* Now, Bean class can implement Serializable Interface
* Here class must be public
* Properties are private
* Default constructor is mandatory
* Need to have setters and getters

```
//Bean Class it is implementing Serlizable interface
public class Honda implements java.io.Serializable {
	//Properties are private
	private static final long serialVersionUID = 1L;
	private int vno;
	private String vname;

	//Default constructor
	public Honda() {
		// TODO Auto-generated constructor stub
	}

	//Having setter and getters
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getVno() {
		return vno;
	}

	public void setVno(int vno) {
		this.vno = vno;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}
	
	
}
```

# What is POJI class?
* POJI stands for Plain Old Java Interface
* It is a term analogous to POJO but for interfaces
* A POJI is an interface that does not extend any special interfaces of framework or a library
* It is just a regular interface with methods that need to be implemented by any class
* It is a term less commonly used than POJO, but concept is similar

```
public interface Vehicle{
 void get();
 void buy();
}
```

# What is IS A and HAS A relationship?
# IS A : Inheritance
```
package com.dl.isa;

//IS A : Inheritance
class Parent {
	
	public void m1(int a, int b) {
		System.out.println(a);
		System.out.println(b);
	}
}

class Child extends Parent{
	
	public void m2(int a, int b) {
		System.out.println(a);
		System.out.println(b);
	}
}

public class Test {
	
	public static void main(String[] args) {
		Child child = new Child();
		child.m1(1, 2);
		child.m2(4, 5);
	}
}

```
# HAS A  : Using class as a data member

# Example-1
```
package com.dl.hasa;

// HAS A : Using class as a data member
class Address{
	
	String address;

	public Address(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return address;
	}
	
	
	
}

class Employee{
	Address address;
	
	
	public Employee(Address address) {
		this.address = address; // aggregation
	}


	public void EmployeeDetails(String empName, String empDepartment) {
		System.out.println(empName);
		System.out.println(empDepartment);
		System.out.println(this.address);
		
	}
	
}

public class Test {
	
	public static void main(String[] args) {
		Address address1 = new Address("Hitech City");
		Employee employee = new Employee(address1);
		employee.EmployeeDetails("Raju", "Developer");
		
		//if employee = null; then contained object address is not destroyed. 
	}

}
```

# Example-2
```
package com.dl.hasa;

public class Address {
	
	String city;
	String state; 
	String country;
	public Address(String city, String state, String country) {
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
	

}

package com.dl.hasa;

public class Employee {
	
	int id;
	String name;
	Address address; //data member
	
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
		this.address = new Address("HYD", "TG", "INDIA"); //composition 
	}
	
	public void display() {
		System.out.println(id + " " + name + " " + address.city + " " + address.state + " " + address.country);
	}
	
	public static void main(String[] args) {
		
		
		Employee employee = new Employee(101, "Raju");
		employee.display();
		
		//if employee = null; then contained object address is also destroyed. 
	}
}

```
# What is Tight coupling and Loose Coupling?

# Tight coupling : too much dependency between the class objects
```

package com.dl.tightcoupling;

public class SMSService {
	
	public void sendMessage(String message) {
		System.out.println("SMS " + message);
	}

}


package com.dl.tightcoupling;

public class EmailService {

	public void sendMessage(String message) {
		System.out.println("Email " + message);
	}
	
}


package com.dl.tightcoupling;

public class MessageSender {
	
	// we are creating 2 instances here
	private SMSService smsService = new SMSService();
	private EmailService emailService = new EmailService();
	
	public void sendSMS(String message) {
		this.smsService.sendMessage(message);
	}
	
	public void sendEmail(String message) {
		this.emailService.sendMessage(message);
	}
	
	
}


package com.dl.tightcoupling;

public class Client {

	public static void main(String[] args) {
		
		MessageSender messageSender = new MessageSender();
		messageSender.sendSMS("Hello sms");
		messageSender.sendEmail("hello Email");
	}
}

```
* Yes, the provided code exhibits tight coupling between the MessageSender class and SMSService class and EmailService class.
* Tight coupling refers to a situation where one class is directly dependent on the implementation details of another class.
* In this case, MessageSender directly creates instance of SMSService and EmailService with in its own implementation.
* This means that if you ever want to change the way messages are sent via SMS or email, you would need to modify the MessageSender class, which violates the principle of seperation of concerns and makes the code less flexible and harder to maintain.

# Loose Coupling : minimal dependency between class objects
* To achieve loose coupling, you can introduce an interface called MessageService, which both SMSService and EmailService will implement
* Here's how you can refactor the code
```
package com.dl.looseCoupling;

public interface MessageService {
	void sendMessage(String message);
}

package com.dl.looseCoupling;

public class SMSService implements MessageService {

	@Override
	public void sendMessage(String message) {
		System.out.println("SMS " + message);
	}

}

package com.dl.looseCoupling;

public class EmailService implements MessageService {

	@Override
	public void sendMessage(String message) {
		System.out.println("Email " + message);

	}

}

package com.dl.looseCoupling;

public class MessageSender {
	
	//Interface as Datamember
	private MessageService messageService;

	//constructor using fields
	public MessageSender(MessageService messageService) {
		this.messageService = messageService;
	}
	
	public void sendMessage(String message) {
		this.messageService.sendMessage(message);
	}
}


package com.dl.looseCoupling;

public class Client {

	public static void main(String[] args) {
		
		MessageSender messageSender1 = new MessageSender(new SMSService());
		MessageSender messageSender2 = new MessageSender(new EmailService());
		
		messageSender1.sendMessage("Sms hello");
		messageSender2.sendMessage("Email Hello");
	}
}

```
* With this refactoring, MessageSender no longer directly creates instances of SMSService and EmailService.
* Instead, it depends on the MessageService interface.
* This allows you to easily swap implementation by passing different implementations of MessageService to MessageSender, promoting flexibility and maintainability.

# Program with no dependency Injection

```
package com.dl.noInjection;

public interface Brand {

	public void honda();
}

package com.dl.noInjection;

public class Car implements Brand {

	@Override
	public void honda() {
		System.out.println("Honda car");
		
	}

	

}

package com.dl.noInjection;

public class Bike implements Brand {

	@Override
	public void honda() {
		System.out.println("Honda Bike");

	}

}


package com.dl.noInjection;

public class Client {
	
	public static void main(String[] args) {
		
		Brand b = new Car();
		b.honda();
		
		b = new Bike();
		b.honda();
	}

}


```

# Program with dependency injection

# POM.xml file 
* spring-core and spring-context dependencies are added into the xml file
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.dl</groupId>
  <artifactId>Spring_DependencyInjection</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <name>Spring_DependencyInjection</name>
  <description>Spring_DependencyInjection</description>
  
  <dependencies>
  	<!-- https://mvnrepository.com/artifact/org.springframework/spring-core -->
	<dependency>
	    <groupId>org.springframework</groupId>
	    <artifactId>spring-core</artifactId>
	    <version>5.3.34</version>
	</dependency>
	
	<!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
	<dependency>
	    <groupId>org.springframework</groupId>
	    <artifactId>spring-context</artifactId>
	    <version>5.3.34</version>
	</dependency>
  
  </dependencies>
</project>
```
```
package com.dl.dependency;

public interface Brand {
	public String honda();
}
```
```
package com.dl.dependency;

public class Car implements Brand {

	@Override
	public String honda() {
		
		return "Honda Car";
	}

}

```
```
package com.dl.dependency;

public class Bike implements Brand {

	@Override
	public String honda() {
		return "Honda bike";
	}

}

```
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       https://www.springframework.org/schema/beans/spring-beans-3.0.xsd"> 
   
   <bean class="com.dl.dependency.Car" id="cars"></bean>
   <bean class="com.dl.dependency.Bike" id="bikes"></bean>
   
</beans>
```

```
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

```
# Explanation
1. Bean Definition: The applicationContext.xml file defines two beans (cars, bikes) of type com.dl.dependency.Car, com.dl.dependency.Bike.

2. Spring Context Initialization: The ClassPathXmlApplicationContext class (from spring-context) is used to load the applicationContext.xml file. This class reads the XML file and initializes the Spring context.

3. Bean Creation: During the context initialization, the core container (from spring-core) creates and manages the cars, bikes beans according to the definitions provided in the XML file.

4. Dependency Injection: The spring-core module injects the object Car, Bike into the cars, bikes beans respectively.

5. Bean Retrieval: The ClassPathXmlApplicationContext (from spring-context) allows the application to retrieve the cars, bikes beans and use it.

# Setter Injection 
* Can be categorized into three types.
# 1. Injection Primitive types: 
* Value as element
* Value as attribute
* P schema P Name Space

# 2. Injection Collection Types:
* List
* Set
* Map
* Properties

# 3. Object Reference:
* <Reference>









