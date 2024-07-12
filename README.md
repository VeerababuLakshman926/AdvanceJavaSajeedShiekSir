# AdvanceJavaSajeedShiekSir
Advance Java

# AdvanceJavaSajeedSir

# Road Map

# What is Spring?
* Spring is dependency injection FrameWork.
* Spring is also called as Light Weight FrameWork alternate to J2EE(Servlets and JSP).
* Spring became popular in developing Java Applications.
* Spring was developed by Rod Johnson.

# What is Dependency Injection?
* Dependency Injection is a design pattern.
* It removes dependency from the program.
* This concept says that you dont create objects, but describe them how they should be created.
* You dont directly connect components and services together in code, but describe which services are need by which components in a spring configuration file.
* The spring container is responsible for hooking it up all.
* we have three types of dependency injections: Setter Injection(important), Construction Injection, Filed Injection.
  
**Dependency**
* An object usually requires object of another classes to perform operations. We call these object dependencies.
**Injection**
* The process of providing the required dependencies to an object.

 ```
class Address {
	public void getAddress() {
		System.out.println("Your Address");
	}
}

public class User {
	
	private Address address;
	
	public User() {
		address = new Address();
	}
	
	public void address() {
		address.getAddress();
	}
	
	public static void main(String[] args) {
		new User.address();
	}
}

Here User is dependent class and Address class is dependency for this User class.
Here Injection is nothing but providing the required Address object to the User Class object.
```


# What is Spring configuration file?
* Spring config is an XML file.
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
* Spring IOC Container will create objects, wire them together, configure them and manage their life cycle till destruction.
* The Spring container uses Dependency Injection to manage the components that make up an application.

# What are the types of IOC Containers in Spring?
**Bean Factory Container:**
* BeanFactory interface is part of the org.springframework.beans.factory.package.
* ``` import org.springframework.beans.factory.BeanFactory ```
* Where XmlBeanFactory is the implementation class of BeanFactory.
* It is the root interface of Spring IOC which is supported by BeanFactory interface.
* The BeanFactory is the actual container which instantiaties, configures and manages the number of beans.
* It belongs to org.springframework.beans.factory.BeanFactory interface.
* These beans typically collaborate with one another, and thus have dependencies between themselves.
* The BeanFactory enables you to read bean definition and access them using the bean factory.

**Application Context:**
* BeanFactory is the basic container, where as Application Context is the advanced container.
* Application Context extends the BeanFactory interface.
* The Application context interface is part of the org.springframework.context package in Spring framework.
* ``` import org.springframework.context.ApplicationContext ```
* Application context provides more facilities than BeanFactory such as integration withe Spring AOP, message resource handling for i18n etc..

# What is POJO Class?
* POJO stands for Plain Old Java Object.
* Here class must be public.
* Properties are private.
* Default constructor is mandatory.
* Need to have public setters and getters methods.
* Now, POJO class will not implement serializable interface.

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
* All JavaBeans are POJO's, but not all POJO's are JavaBeans.
* Now, Bean class can implement Serializable Interface.
* Here class must be public.
* Properties are private.
* Default constructor is mandatory.
*  Need to have public setters and getters methods.

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
* POJI stands for Plain Old Java Interface.
* It is a term analogous to POJO, but for interfaces.
* A POJI is an interface that does not extend any special interfaces of framework or a library.
* It is just a regular interface with methods that need to be implemented by any class that implement POJI.
* It is a term less commonly used than POJO, but concept is similar.

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
* To achieve loose coupling, you can introduce an interface called MessageService, which both SMSService and EmailService will implement.
* Here's how you can refactor the code.
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

# 3. Autowiring:

* byName: property name and bean name must be same
* byType: property name and bean name can be different
* constructor: constructor mode inject the dependency by calling the constructor of the class, it calls the constructor having large number of parameters
* no: by default it no, it is not autowired
* autodetect : deprecated in spring 3

# 4. Bean Scopes:
We have 5 types of bean scopes.  
* Singleton : creates only one instance of the bean.
* Prototype : creates new instance for every bean call.
* request : single bean instane per HTTP request.
* Session : single bean instane per HTTP Session.
* Global Session : single bean instane per global HTTP request.

# 5. Inner Beans:
* Inner bean using setter injection.
* Inner bean using constructor injection.
* Inner bean using object reference.

# 6. Annotations:
* @Autowired (setter level, constructor level, field level)
* @Qualifier
* @Component: For annotation configuration we annote with @Component annotation. This annotation allows spring container to auto detect while component scanning. Using Componentscan spring ioc container will basically scan the classes, which are annotated with @Component annotation it will create the instance of that class and manage beans.
* @ComponentScan: Basically, we use @ComponentScan annotation along with @Configuration annotation to specify the class
* @Configuration, @ComponentScan, @Value, @Bean, @Primary, @Scope, @LazyAnnotation.



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
we are providing value as an attribute rather than element.
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
Small changes need to be done in the applicationContext.xml file . 
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
we are providing value as an attribute rather than element.
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

**Example - C namespace**   
Small changes need to be done in the applicationContext.xml file.  
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
package com.dl.ambiguites;

public class Student {
	
	private int rollno;
	private double stipend;
	private String institute;
	
	public Student(int rollno, double stipend, String institute) {
		this.rollno = rollno;
		this.stipend = stipend;
		this.institute = institute;
	}
	
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", stipend=" + stipend + ", institute=" + institute + "]";
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

	<bean class="com.dl.ambiguites.Student" name="student">
		
			<constructor-arg name="stipend" type="double" value="20000.00" index="1"></constructor-arg>
			<constructor-arg name="rollno" type="int" value="101" index="0"></constructor-arg>
			<constructor-arg name="institute" type="String" value="DL" index="2"></constructor-arg> 
			
	</bean>
</beans>
```

```
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

```
# When to use setter injection and When to constructor injection?
* Constructor injection is used when all parameter are mandatory. If we are not unable to provide any parameter it will throw an error.
* Setter injection is used when even if we don't provide the data for some parameter, default values are assigned and The code will run.

# Autowiring:

* byName: property name and bean name must be same.
* byType: property name and bean name can be different.
* constructor: constructor mode inject the dependency by calling the constructor of the class, it calls the constructor having large number of parameters.
* no: by default it no, it is not autowired.
* autodetect : deprecated in spring 3.


**Example - byName**  

```
package com.dl.withByName;

public class Models {
	
	private String models;
	private String type;
	
	public String getModels() {
		return models;
	}
	public void setModels(String models) {
		this.models = models;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Models [models=" + models + ", type=" + type + "]";
	}
	
}

```
```
package com.dl.withByName;

public class Honda {
	
	private Models models_byName;

	public Models getModels_byName() {
		return models_byName;
	}

	public void setModels_byName(Models models_byName) {
		this.models_byName = models_byName;
	}

	@Override
	public String toString() {
		return "Honda [models_byName=" + models_byName + "]";
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
       
	     <bean class="com.dl.withByName.Models" name="models_byName" p:models="Honda City" p:type="Manual" />
		<bean class="com.dl.withByName.Honda" name="honda" autowire="byName" ></bean>
		
		<!-- Property name and bean name must be same-->
</beans>
```

```
package com.dl.withByName;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Client {
	
public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/dl/withByName/applicationContext.xml");
		Honda honda = context.getBean("honda", Honda.class);
		System.out.println(honda);
		context.close();
	}
}	


```

**Example - byType**  

```
package com.dl.withByType;

public class Models {
	
	private String models;
	private String type;
	
	public String getModels() {
		return models;
	}
	public void setModels(String models) {
		this.models = models;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Models [models=" + models + ", type=" + type + "]";
	}
	
}

```
```
package com.dl.withByType;

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
       
	     <bean class="com.dl.withByType.Models" name="model_byType" p:models="Honda City" p:type="Manual" />
		<bean class="com.dl.withByType.Honda" name="honda" autowire="byType" ></bean>
		
		<!-- Property name and bean name can be different-->
</beans>
```

```
package com.dl.withByType;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Client {
	
public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/dl/withByType/applicationContext.xml");
		Honda honda = context.getBean("honda", Honda.class);
		System.out.println(honda);
		context.close();
	}
}	

```

**Example - ContructorType**  

```
package com.dl.ConstructorType;

public class Models {
	
	private String models;
	private String type;
	
	
	public Models(String models, String type) {
		this.models = models;
		this.type = type;
	}


	@Override
	public String toString() {
		return "Models [models=" + models + ", type=" + type + "]";
	}
	
}

```
```
package com.dl.ConstructorType;

public class Honda {
	
	private Models models;
	
	public Honda(Models models) {
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
       
	     <bean class="com.dl.ConstructorType.Models" name="models_constructorType" c:models="Honda City" c:type="Manual" />
		<bean class="com.dl.ConstructorType.Honda" name="honda" autowire="constructor" ></bean>
		
		
</beans>
```

```
package com.dl.ConstructorType;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Client {
	
public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/dl/ConstructorType/applicationContext.xml");
		Honda honda = context.getBean("honda", Honda.class);
		System.out.println(honda);
		context.close();
	}
}	

```

# 4. Bean Scopes:
We have 5 types of bean scopes.  
* Singleton : creates only one instance of the bean i.e., object address reference is same.
* Prototype : creates new instance for every bean call.
* request : single bean instane per HTTP request.
* Session : single bean instane per HTTP Session.
* Global Session : single bean instane per global HTTP request.

**Example - Singleton : creates only one instance of the bean i.e., object address reference is same**  

```
package com.dl.singleton;

public class Honda {
	
	private int vno;
	private String vname;
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
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       https://www.springframework.org/schema/beans/spring-beans-3.0.xsd"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c">

	<bean class="com.dl.singleton.Honda" name="honda" scope="singleton">
		
		<property name="vno" value="101"></property>	
		<property name="vname" value="Honda City"></property>
		
		<!--Create only one instance for every bean call i.e., object address reference is same-->
			
	</bean>
</beans>
```

```
package com.dl.singleton;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Client {
	
public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/dl/singleton/applicationContext.xml");
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

```

```
101
Honda City
class com.dl.singleton.Honda
1776409896 //object address is same in both cases
101
Honda City
class com.dl.singleton.Honda
1776409896  //object address is same in both cases

```

**Example - Prototype : creates new instance for every bean call i.e., new object address reference for every bean call**  

```
package com.dl.prototype;

public class Honda {
	
	private int vno;
	private String vname;
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
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       https://www.springframework.org/schema/beans/spring-beans-3.0.xsd"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c">

	<bean class="com.dl.prototype.Honda" name="honda" scope="prototype">
		
		<property name="vno" value="101"></property>	
		<property name="vname" value="Honda City"></property>
		
		<!--Create new instance for every bean call i.e., new object address reference-->
			
	</bean>
</beans>
```

```
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


```

```
101
Honda City
class com.dl.prototype.Honda
1954471782 //object address is different for both the cases
101
Honda City
class com.dl.prototype.Honda
1025309396 //object address is different for both the cases

```

# 5. Inner Beans:
* Inner bean using setter injection.
* Inner bean using constructor injection.
* Inner bean using object reference.

**Example - Inner bean using setter injection**  

```
package com.dl.innerBeans.setterInjection;

public class HondaCars {
	
	private String carModels;

	public String getCarModels() {
		return carModels;
	}

	public void setCarModels(String carModels) {
		this.carModels = carModels;
	}

	@Override
	public String toString() {
		return "HondaCars [carModels=" + carModels + "]";
	}
	
	
}

```
```
package com.dl.innerBeans.setterInjection;

public class Honda {
	
	private HondaCars hondaCars;

	public HondaCars getHondaCars() {
		return hondaCars;
	}

	public void setHondaCars(HondaCars hondaCars) {
		this.hondaCars = hondaCars;
	}

	@Override
	public String toString() {
		return "Honda [hondaCars=" + hondaCars + "]";
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
       
       
		<bean class="com.dl.innerBeans.setterInjection.Honda" name="honda">
		
			<property name="hondaCars">
				<bean class="com.dl.innerBeans.setterInjection.HondaCars" name="car">
					<property name="carModels" value="Honda City"></property>
				</bean>
			</property>
			
		
		</bean>
		
		
		
</beans>
```

```
package com.dl.innerBeans.setterInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/dl/innerBeans/setterInjection/applicationContext.xml");
		Honda honda = context.getBean("honda", Honda.class);
		System.out.println(honda.getHondaCars());
		context.close();
	}
}

```

**Example - Inner bean using constructor injection**  

```
package com.dl.innerBeans.constructorInjection;

public class HondaCars {
	
	private String carModels;

	
	public HondaCars(String carModels) {
		this.carModels = carModels;
	}

	@Override
	public String toString() {
		return "HondaCars [carModels=" + carModels + "]";
	}
	
	
}

```
```
package com.dl.innerBeans.constructorInjection;

public class Honda {
	
	private HondaCars hondaCars;

	
	public Honda(HondaCars hondaCars) {
		this.hondaCars = hondaCars;
	}


	@Override
	public String toString() {
		return "Honda [hondaCars=" + hondaCars + "]";
	}
	
	
}

```

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans-3.0.xsd"
	xmlns:p="http://www.springframework.org/schema/p">


	<bean class="com.dl.innerBeans.constructorInjection.Honda" name="honda">

		<constructor-arg name="hondaCars">

			<bean class="com.dl.innerBeans.constructorInjection.HondaCars"
				name="car">
				<constructor-arg name="carModels" value="Honda City"></constructor-arg>
			</bean>

		</constructor-arg>


	</bean>


</beans>
```

```
package com.dl.innerBeans.constructorInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/dl/innerBeans/constructorInjection/applicationContext.xml");
		Honda honda = context.getBean("honda", Honda.class);
		System.out.println(honda);
		context.close();
	}
}

```

**Example - Inner bean using object reference**  

```
package com.dl.innerBeans.objectReference;

public class HondaCars {
	
	private String carModels;

	public String getCarModels() {
		return carModels;
	}

	public void setCarModels(String carModels) {
		this.carModels = carModels;
	}

	@Override
	public String toString() {
		return "HondaCars [carModels=" + carModels + "]";
	}
	
	
}


```
```
package com.dl.innerBeans.objectReference;

public class Honda {
	
	private HondaCars hondaCars;

	public HondaCars getHondaCars() {
		return hondaCars;
	}

	public void setHondaCars(HondaCars hondaCars) {
		this.hondaCars = hondaCars;
	}

	@Override
	public String toString() {
		return "Honda [hondaCars=" + hondaCars + "]";
	}
	
	
}
```

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans-3.0.xsd"
	xmlns:p="http://www.springframework.org/schema/p">


	<bean class="com.dl.innerBeans.objectReference.HondaCars" name="car">
		<property name="carModels" value="Honda City"></property>
	</bean>

	<bean class="com.dl.innerBeans.objectReference.Honda" name="honda">

		<property name="hondaCars">
			<ref bean="car" />
		</property>


	</bean>


</beans>
```

```
package com.dl.innerBeans.objectReference;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/dl/innerBeans/objectReference/applicationContext.xml");
		Honda honda = context.getBean("honda", Honda.class);
		System.out.println(honda.getHondaCars());
		context.close();
	}
}
```




# Constructor based DI example using Annotation based configuration
* Constructor injection in Spring is a method of dependency injection in which the dependencies of a class are provided through the class's constructor.
* This is the recommended method of dependency injection in spring as it promotes immutability and makes it clear what dependencies a class has.

**Advantages: Constructor injection has several advantages over field injection in Spring:**
1. **Immutability :** With constructor injection, the injected dependencies can be marked as final, ensuring that they cannot be modified once they are set. This is not possible with field injection, as the fields needs to be non-final to allow injection after the object's construction.
2. **Explicit Dependencies :** Constructor Injection makes the dependencies of a class explicit. By looking at the constructor, you can immediately see what dependencies a class has. With field injection, the dependencies are less obvious, as they scattered throughout the class.
3. **Easier Testion :** Constructor Injection makes unit testing easier. You can simply instantiate the object with mock dependencies in your tests. With field injection, you would need to use reflection to set the fields, which can be more cumbersome.
4. **Avoids Nulls :** With constructor injection, the container ensures that all the dependencies are satisfied before it invokes the class constructor, so there's no risk null pointer exceptions due to unsatisfied dependencies. With field injection, the fields are set after the constructor has run, so there's is a risk of null pointer exceptions if the object is used before the dependencies are set.
5. **Fail Fast :** If a dependency cannot be injected, with constructor injection, the application will fail to start. This is a good thing because you will know about the configuration issue immediately. With field injection, the application can start with null fields, and you might only find out about the problem later when the null field is used.

 **Disavantages	: While Constructor injection is generally recommended in Spring due to its advantages**
 1. **Verbose Code :** If a class has many dependencies, the constructor can become quiet large and unwieldy. This can make the code harder to read and maintain.
 2. **Circular Dependencies :** Constructor injection can lead to problems if you have circular dependencies between your beans. For example, if bean A requires bean B via constructor injection, and bean B requires bean A via constructor injection, spring won't be able to resolve these dependencies. However such circular dependencies are generally a sign of poor design and should be avoided.
 3. **Inflexibility :** Once a dependency is set via the constructor, it cannot be changed. This is generally a good thing as it promotes immutability, but there might be some rare cases where you need to change the dependencies of an object after it has been created.
 4. **Compatability with older code :** If you are working with older code that uses field or setter injections, you might need to refactor the code to use constructor injection. This can be time consuming and might introduce bugs if not done carefully.

# Setter based DI example using Annotation based configuration
* Setter injection in spring is method of dependency injection where the dependencies of a class are provided through setter methods.

**Advantages**
**Flexibility :**
* You can change the dependencies of an object after it has been created.
* This can be useful in some situations, but it can also lead to  problems if the object is used before all of its dependencies have been set.
**Partial Injection :**
* You can choose only inject some of the dependencies of a class.
* This can be useful if some dependencies have sensibel defaults or are optional.

**Disadvantages compared to Constructor Injection**
**Mutability :**
* The dependencies of an object can be changed after it has been created. This can lead to problems if the object is used in a multi-threaded environment.

**Hiddend Dependencies :**
* It's not immediately clear what dependencies a class has.
* You have to look at all of the setter methods to find out.

**More Difficult Testing :**
* You have to remember to call the setter methods when creating an object in your tests.
* If you forget to do this, your test might fail in confusing ways.

# Field Based DI Example using Annotation based configuration
* Field injection in Spring is a way to inject dependencies into your classes.
* This is done by using @Autowired annotation directly on the fields that need to be injected.
* No need to use constructor and setter.

**Advantages:**

**Simplicity:**
* It's is very easy to use.
* You just need to add @Autowired annotation to a field and Spring will take care of the rest.
* However, field injection also has some significant disadvantages compared to constructor injection.

**Hidden Dependencies:**
* It's not immediately clear what dependencies a class has. You have to look at all of the fields to find out.

**Immutability :**
* The dependencies of an object can be changed after it has been created.
* This can lead to problems if the object is used in a multi-threaded environment.

**Testing :**
* It's more difficult to provide mock implementation of the dependencies when testing your class. You have to use reflection to change the fields, which can be cumbersome and error prone.

**Disadvantages :**
* Field injection is generally not recommended. Constructor injection is usually better choice.

# Java Based Configuration Example
* Yes, @Bean is a Spring Framework annotation.
* It is used in Java-Based configuration to indicate that a method produces a bean to be managed by the Spring container.
* In the context of Spring, a bean is an object that is instantiated, assembled and managed by the Spring IOC (Inversion of Control) container.
* These beans are created with the configuration metadata that you supply to the container, via XML, Java annotations or Java code.

# @Scope Annotation
* @Scope annotation is used to define a scope of the bean.
* We use @Scope to define the scope of a @Component class or a @Bean definition.
* Singleton: Only one instance of the bean is created and shared across the entire application (default scope).
* Prototype: a new instance of the bean is created every time it is requested.

# @Lazy Annotation:
* In Spring Framework, the @Lazy annotation is used to indicate that a bean should be lazily initaited.
* This means that the bean will be created and initialized only when it is first requested for use.
* In this example, LazyBean is a Spring bean that is marked with the @Lazy annotation.
* This means that the LazyBean will not be created and initialzed at startup.











