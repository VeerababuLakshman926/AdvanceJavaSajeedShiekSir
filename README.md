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
* ``` import org.springframework.context.ApplicationContext ```
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

# Types of injection:
# 1.Setter Injection:

* Value as element, Value as attribute, pname Space
* List, Set, Map, Properties
* object reference, dcheck(variable required check)

# 2. Constructor Injection:

* Value as element, Value as attribute, pc name Space
* List, Set, Map, Properties
* object reference, ambiguity

# 3. Inner Beans:

* setter injection and constructor injection and inner bean ref tag

# 4. Autowiring:

* byName: property name and bean name must be same
* byType: property name and bean name can be different
* cons: constructor mode inject the dependency by calling the constructor of the class, it calls the constructor having large number of parameters
* no: by default it no, it is not autowired
* autodetect : deprecated in spring 3

# 5. Bean Scopes:


# Setter Injection 
* Can be categorized into three types.
# 1. Injection Primitive types: 
* Value as element
* Value as attribute
* pname Space

# 2. Injection Collection Types:
* List
* Set
* Map
* Properties

# 3. Object Reference:
* object reference
* dcheck

# 1. Injection Primitive types:

**Example - Value as a type**
* POM.xml
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.dl</groupId>
  <artifactId>Spring_setterInjection</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <name>Spring_setterInjection</name>
  <description>Spring_setterInjection</description>
  
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
* applicationContext.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       https://www.springframework.org/schema/beans/spring-beans-3.0.xsd">
       
	     <bean class="com.dl.ValueAsElement.Honda" name="honda">
	     	<property name="vno"><value>8765</value></property>
	     	<property name="vname"><value>Honda City</value></property>
	     </bean>

</beans>
```

```
package com.dl.ValueAsElement;

//Pojo class
public class Honda {

	private int vno;
	private String vname;
	
	public Honda() {
		// TODO Auto-generated constructor stub
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
```

package com.dl.ValueAsElement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class Client {



	public static void main(String[] args) {
		
		ApplicationContext context =  new ClassPathXmlApplicationContext("com/dl/ValueAsElement/applicationContext.xml");
		//Honda honda = (Honda) context.getBean("honda"); 
		//the above and below both commands are same but it is adivisable to use below one. 
		// the above will give ClassCastException if the retrieved bean is not honda class type
		// the below one will give BeanNotOfRequiredTypeException if the retrieved bean is not honda class type
		Honda honda = context.getBean("honda", Honda.class);
		System.out.println("Vehicle Name is " + honda.getVname());
		System.out.println("Vehicle No is " + honda.getVno());
//		context.close();
		
		//Relative path
//		Resource resource = new ClassPathResource("com/dl/ValueAsElement/applicationContext.xml");
//		BeanFactory factory = new XmlBeanFactory(resource);
//		Honda honda = factory.getBean("honda", Honda.class);
//		System.out.println("Vehicle Name is " + honda.getVname());
//		System.out.println("Vehicle No is " + honda.getVno());
		
		//absolute path
//		FileSystemResource resource = new FileSystemResource("D:\\coding\\4.advanceJava\\advanceJava Sajeed/applicationContext.xml");
//		BeanFactory factory = new XmlBeanFactory(resource);
//		Honda honda = factory.getBean("honda", Honda.class);
//		System.out.println("Vehicle Name is " + honda.getVname());
//		System.out.println("Vehicle No is " + honda.getVno());
//		
	}
}


```

**Example - Value as an attribute**  
Small changes need to be done in the applicationContext.xml file.  
we are providing value as an attribute rather than element
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       https://www.springframework.org/schema/beans/spring-beans-3.0.xsd">
       
	     <bean class="com.dl.ValueAsAttribute.Honda" name="honda">
	     	<property name="vno" value="8765"></property>
	     	<property name="vname" value="Honda City"></property>
	     </bean>

</beans>
```

**Example - P namespace**   
Small changes need to be done in the applicationContext.xml file  
we are providing value as a pname rather than element.
we also add the pname space in the name spaces ``` xmlns:p="http://www.springframework.org/schema/p ```
```
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       https://www.springframework.org/schema/beans/spring-beans-3.0.xsd"
       xmlns:p="http://www.springframework.org/schema/p">
       
	     <bean class="com.dl.ValueAsPnameSpace.Honda" name="honda" p:vno="9876" p:vname="Honda City"/>

</beans>
```

# 2. Injection Collection Types:

**Example - List**

```
package com.dl.list;

import java.util.List;

//Pojo class
public class Honda {

	private String sname;
	private List<String> models;
	
	public Honda() {
		// TODO Auto-generated constructor stub
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public List<String> getModels() {
		return models;
	}

	public void setModels(List<String> models) {
		this.models = models;
	}
}

```

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       https://www.springframework.org/schema/beans/spring-beans-3.0.xsd"
       >
       
	     <bean class="com.dl.list.Honda" name="honda" >
	     	<property name="sname">
	     		<value>Fortune Honda</value>
	     	</property>
	     	<property name="models">
	     		<list>
	     			<value>Honda City</value>
	     			<value>Honda Accord</value>
	     			<value>Honda Civic</value>
	     			<value>Honda City</value>
	     		</list>
	     	</property>
	     </bean>

</beans>
```

```
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

```

**Example - Set**

```
package com.dl.list;

import java.util.List;

//Pojo class
public class Honda {

	private String sname;
	private List<String> models;
	
	public Honda() {
		// TODO Auto-generated constructor stub
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public List<String> getModels() {
		return models;
	}

	public void setModels(List<String> models) {
		this.models = models;
	}	
	
}

```

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       https://www.springframework.org/schema/beans/spring-beans-3.0.xsd"
       >
       
	     <bean class="com.dl.set.Honda" name="honda" >
	     	<property name="sname">
	     		<value>Fortune Honda</value>
	     	</property>
	     	<property name="models">
	     		<list>
	     			<value>Honda City</value>
	     			<value>Honda Accord</value>
	     			<value>Honda Civic</value>
	     			<value>Honda Civic</value>
	     		</list>
	     	</property>
	     </bean>

</beans>
```

```
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


```

**Example - Map**

```
package com.dl.map;

import java.util.Map;


//Pojo class
public class Honda {

	private int vno;
	private Map<Integer, String> models;
	
	public Honda() {
		// TODO Auto-generated constructor stub
	}

	public int getVno() {
		return vno;
	}

	public void setVno(int vno) {
		this.vno = vno;
	}

	public Map<Integer, String> getModels() {
		return models;
	}

	public void setModels(Map<Integer, String> models) {
		this.models = models;
	}

	@Override
	public String toString() {
		return "Honda [vno=" + vno + ", models=" + models + "]";
	}
	
}


```

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       https://www.springframework.org/schema/beans/spring-beans-3.0.xsd"
       >
       
	     <bean class="com.dl.map.Honda" name="honda" >
	     	<property name="vno">
	     		<value>9876</value>
	     	</property>
	     	<property name="models">
	     		<map>
	     			<entry key="1" value="Honda City"></entry>
	     			<entry>
	     				<key><value>2</value></key>
	     				<value>Honda Civic</value>
	     			</entry>
	     			<entry>
	     				<key><value>3</value></key>
	     				<value>Honda Accord</value>
	     			</entry>
	     		</map>
	     	</property>
	     </bean>

</beans>
```

```
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

```

**Example - Properties**  

```
package com.dl.properties.util;

import java.util.Properties;

public class Honda {
	
	private Properties models;

	public Properties getModels() {
		return models;
	}

	public void setModels(Properties models) {
		this.models = models;
	}
	

}

```

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       https://www.springframework.org/schema/beans/spring-beans-3.0.xsd"
       xmlns:p="http://www.springframework.org/schema/p">
       
	     <bean class="com.dl.properties.util.Honda" name="honda" >
	     	
	     	<property name="models">
	     		 <props>
	     		 	<prop key="A">Honda City</prop>
	     		 	<prop key="B">Honda Civic</prop>
	     		 	<prop key="C">Honda City</prop>
	     		 </props>
	     	</property>
	     </bean>

</beans>
```

```

package com.dl.properties.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Client {



	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("com/dl/properties/util/applicationContext.xml");
		
		Honda honda = context.getBean("honda", Honda.class);
		System.out.println(honda.getModels());
		context.close();
		
	}
}
```

# 3. Object Reference:

**Example - Objective Reference**  

```
package com.dl.objectReference;

public class Models {
	
	private String carName;
	private Double cost;
	private String generation;
	private String type;
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public String getGeneration() {
		return generation;
	}
	public void setGeneration(String generation) {
		this.generation = generation;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Models [carName=" + carName + ", cost=" + cost + ", generation=" + generation + ", type=" + type + "]";
	}
	
	
	
	
}


```
```
package com.dl.objectReference;



public class Honda {
	
	private Models models;

	public Models getModels() {
		return models;
	}

	public void setModels(Models models) {
		this.models = models;
	}

	@Override
	public String toString() {
		return "Honda [models=" + models + "]";
	}

	

}

```

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       https://www.springframework.org/schema/beans/spring-beans-3.0.xsd"
       xmlns:p="http://www.springframework.org/schema/p">
       
	     <bean class="com.dl.objectReference.Models" name="models" p:carName="Honda City" p:cost="900000" p:generation="G6" p:type="Manual" />
		<bean class="com.dl.objectReference.Honda" name="honda" p:models-ref="models" ></bean>
</beans>
```

```
package com.dl.objectReference;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Client {



	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("com/dl/objectReference/applicationContext.xml");
		Honda honda = context.getBean("honda", Honda.class);
		System.out.println(honda.getModels());
		System.out.println(honda);
		context.close();
		
	}
}

```

**Example - dCheck**  

```
package com.dl.dcheck;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

public class Honda {
	
	private int vno;
	private List<String> models;
	public int getVno() {
		return vno;
	}
	
	@Required
	public void setVno(int vno) {
		this.vno = vno;
	}
	public List<String> getModels() {
		return models;
	}
	
	@Required
	public void setModels(List<String> models) {
		this.models = models;
	}
	@Override
	public String toString() {
		return "Honda [vno=" + vno + ", models=" + models + "]";
	}
	
	
}


```

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context = "http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       https://www.springframework.org/schema/beans/spring-beans-3.0.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context-3.0.xsd"
       xmlns:p="http://www.springframework.org/schema/p">
       
       <context:annotation-config></context:annotation-config>
		<bean class="com.dl.dcheck.Honda" name="honda">
			
			<property name="vno" value="1234"></property>
			<property name="models" >
				<list>
					<value>Honda City</value>
					<value>Honda Civic</value>
				</list>  
			</property>
		
		</bean>
		<bean class="org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor" />
		
		
</beans>
```

```

package com.dl.dcheck;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Client {



	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("com/dl/dcheck/applicationContext.xml");
		Honda honda = context.getBean("honda", Honda.class);
		System.out.println(honda);
		context.close();
		
	}
}

```

# Constructor Injection 
* Can be categorized into three types.
# 1. Injection Primitive types: 
* Value as element
* Value as attribute
* c nameSpace

# 2. Injection Collection Types:
* List
* Set
* Map
* Properties

# 3. Object Reference:
* object reference
* ambiguity

# 1. Injection Primitive types:

**Example - Value as a type**
* POM.xml
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.dl</groupId>
  <artifactId>Spring_ConstructorInjection</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <name>Spring_ConstructorInjection</name>
  <description>Spring_ConstructorInjection</description>
  
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
* applicationContext.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       https://www.springframework.org/schema/beans/spring-beans-3.0.xsd"
       xmlns:p="http://www.springframework.org/schema/p">
       
      
		<bean class="com.dl.ValueAsAElement.Honda" name="honda">
			
			<constructor-arg name="vno">
				<value>8795</value>
			</constructor-arg>
			<constructor-arg name="vname">
				<value>Honda City</value>
			</constructor-arg>
		
		</bean>
		
		
		
</beans>
```

```
package com.dl.ValueAsAElement;

public class Honda {

	private int vno;
	private String vname;
	
	public Honda(int vno, String vname) {
		this.vno = vno;
		this.vname = vname;
	}

	@Override
	public String toString() {
		return "Honda [vno=" + vno + ", vname=" + vname + "]";
	}
	
	
	
	
}


```
```

package com.dl.ValueAsAElement;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/dl/ValueAsAElement/applicationContext.xml");
		Honda honda = context.getBean("honda", Honda.class);
		System.out.println(honda);
		context.close();
	}
}

```

**Example - Value as an attribute**  
Small changes need to be done in the applicationContext.xml file.  
we are providing value as an attribute rather than element
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       https://www.springframework.org/schema/beans/spring-beans-3.0.xsd"
       xmlns:p="http://www.springframework.org/schema/p">
       
      
		<bean class="com.dl.ValueAsAttribute.Honda" name="honda">
			
			<constructor-arg name="vno" value="8795" />
			<constructor-arg name="vname" value="Honda City" />
			
		
		</bean>
		
		
</beans>
```

**Example - Pname space**   
Small changes need to be done in the applicationContext.xml file  
we are providing value as a cname rather than element.
we also add the cname space in the name spaces ``` xmlns:c="http://www.springframework.org/schema/c ```
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       https://www.springframework.org/schema/beans/spring-beans-3.0.xsd"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c">
       
      
		<bean class="com.dl.PCnameSpace.Honda" name="honda" c:vno="8795" c:vname="Honda City" />
		
		
		
</beans>
```

# 2. Injection Collection Types:

**Example - List**

```
package com.dl.collection.list;

import java.util.List;

public class Honda {
	
	private String sname;
	private List<String> models;
	public Honda(String sname, List<String> models) {
		super();
		this.sname = sname;
		this.models = models;
	}
	@Override
	public String toString() {
		return "Honda [sname=" + sname + ", models=" + models + "]";
	}
	

}


```

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       https://www.springframework.org/schema/beans/spring-beans-3.0.xsd"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c">

	<bean class="com.dl.collection.list.Honda" name="honda">
		
			<constructor-arg name="sname" value="Fortune Honda"></constructor-arg>
			<constructor-arg name="models"> 
				<list>
					<value>Honda City</value>
					<value>Honda Accord</value>
					<value>Honda Civic</value>
					<value>Honda City</value>
				</list>
			</constructor-arg>
	</bean>
</beans>
```

```
package com.dl.collection.list;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/dl/collection/list/applicationContext.xml");
		Honda honda = context.getBean("honda", Honda.class);
		System.out.println(honda);
		context.close();
	}

}	

```

**Example - Set**

```
package com.dl.collection.set;


import java.util.Set;

public class Honda {
	
	private String sname;
	private Set<String> models;
	public Honda(String sname, Set<String> models) {
		super();
		this.sname = sname;
		this.models = models;
	}
	@Override
	public String toString() {
		return "Honda [sname=" + sname + ", models=" + models + "]";
	}
	
	
	

}


```

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       https://www.springframework.org/schema/beans/spring-beans-3.0.xsd"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c">

	<bean class="com.dl.collection.set.Honda" name="honda">
		
			<constructor-arg name="sname" value="Fortune Honda"></constructor-arg>
			<constructor-arg name="models"> 
				<set>
					<value>Honda City</value>
					<value>Honda Accord</value>
					<value>Honda Civic</value>
					<value>Honda City</value>
				</set>
			</constructor-arg>
	</bean>
</beans>
```

```
package com.dl.collection.set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/dl/collection/set/applicationContext.xml");
		Honda honda = context.getBean("honda", Honda.class);
		System.out.println(honda);
		context.close();
	}

}	

```

**Example - Map**

```
package com.dl.collection.map;

import java.util.Map;

public class Honda {
	private Map<Integer, String> models;
	private String sname;
	
	public Honda(String sname, Map<Integer, String> models) {
		super();
		this.sname = sname;
		this.models = models;
	}
	@Override
	public String toString() {
		return "Honda [sname=" + sname + ", models=" + models + "]";
	}

}

```

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       https://www.springframework.org/schema/beans/spring-beans-3.0.xsd"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c">

	<bean class="com.dl.collection.map.Honda" name="honda">
			
			
			<constructor-arg name="sname" value="Fortune Honda"></constructor-arg>
			<constructor-arg name="models">
				<map>
					<entry key="1"><value>Honda City</value></entry>
					<entry key="2"><value>Honda Accors</value></entry>
					<entry key="3"><value>Honda Civic</value></entry>
					<entry key="4"><value>Honda City</value></entry>
					
				</map>
			</constructor-arg>
			
	</bean>
</beans>
```

```
package com.dl.collection.map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/dl/collection/map/applicationContext.xml");
		Honda honda = context.getBean("honda", Honda.class);
		System.out.println(honda);
		context.close();
	}

}	

```

**Example - Properties**  

```
package com.dl.properties.util;

import java.util.Properties;

public class Honda {

	
	private Properties models;

	public Honda(Properties models) {
		this.models = models;
	}

	@Override
	public String toString() {
		return "Honda [models=" + models + "]";
	}
	
	
	
	
	
	
}


```

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       https://www.springframework.org/schema/beans/spring-beans-3.0.xsd"
       xmlns:p="http://www.springframework.org/schema/p">
       
      
		<bean class="com.dl.properties.util.Honda" name="honda" >
	     	<constructor-arg>
	     		 <props>
	     		 	<prop key="A">Honda City</prop>
	     		 	<prop key="B">Honda Civic</prop>
	     		 	<prop key="C">Honda City</prop>
	     		 </props>
	     	</constructor-arg>
	     	
	     </bean>
		
		
</beans>
```

```

package com.dl.properties.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/dl/properties/util/applicationContext.xml");
		Honda honda = context.getBean("honda",Honda.class);
		System.out.println(honda);
		context.close();
	}
}

```

# 3. Object Reference:

**Example - Objective Reference**  

```
package com.dl.objectReference;

public class Models {
	
	private String carName;
	private Double cost;
	private String generation;
	private String type;
	public Models(String carName, Double cost, String generation, String type) {
		super();
		this.carName = carName;
		this.cost = cost;
		this.generation = generation;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Models [carName=" + carName + ", cost=" + cost + ", generation=" + generation + ", type=" + type + "]";
	}
	
	
}


```
```
package com.dl.objectReference;

public class Honda {
	
	private Models models;

	public Honda(Models models) {
		super();
		this.models = models;
	}

	@Override
	public String toString() {
		return "Honda [models=" + models + "]";
	}
	
	
}

```

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       https://www.springframework.org/schema/beans/spring-beans-3.0.xsd"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c">

	<bean class="com.dl.objectReference.Models" name="models" c:cost="90000" c:carName="Honda City" c:generation="G6" c:type="Manual" />
	<bean class="com.dl.objectReference.Honda" name="honda"  c:models-ref="models"></bean>
</beans>
```

```
package com.dl.objectReference;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	
public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/dl/objectReference/applicationContext.xml");
		Honda honda = context.getBean("honda", Honda.class);
		System.out.println(honda);
		context.close();
	}

}

```

**Example - Ambiguity**  

```
package com.dl.dcheck;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

public class Honda {
	
	private int vno;
	private List<String> models;
	public int getVno() {
		return vno;
	}
	
	@Required
	public void setVno(int vno) {
		this.vno = vno;
	}
	public List<String> getModels() {
		return models;
	}
	
	@Required
	public void setModels(List<String> models) {
		this.models = models;
	}
	@Override
	public String toString() {
		return "Honda [vno=" + vno + ", models=" + models + "]";
	}
	
	
}


```

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context = "http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       https://www.springframework.org/schema/beans/spring-beans-3.0.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context-3.0.xsd"
       xmlns:p="http://www.springframework.org/schema/p">
       
       <context:annotation-config></context:annotation-config>
		<bean class="com.dl.dcheck.Honda" name="honda">
			
			<property name="vno" value="1234"></property>
			<property name="models" >
				<list>
					<value>Honda City</value>
					<value>Honda Civic</value>
				</list>  
			</property>
		
		</bean>
		<bean class="org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor" />
		
		
</beans>
```

```

package com.dl.dcheck;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Client {



	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("com/dl/dcheck/applicationContext.xml");
		Honda honda = context.getBean("honda", Honda.class);
		System.out.println(honda);
		context.close();
		
	}
}

```










