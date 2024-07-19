# Contents
1. Hibernate
2. Spring MVC

3. SpringBoot Test Connections
4. SpringBoot with JDBC Template
5. SpringBoot with Hibernate Template
6. SpringBoot with JPA

7. SpringBoot Project Lead Module MicroService
8. SpringBoot Project Home Module MicroService
9. SpringBoot Security
10. SpringBoot ExceptionalHandling and Validations
11. SpringBoot Monitoring and Logging
  
12. SpringBoot Webflux

# SelfLearning

1. SpringBoot with TM
2. SpringBoot with Docker
3. SpringBoot with JPQL
4. SpringBoot with Kafka
5. SpringBoot with Kuber
6. SpringBoot with Oauth JWT

7. Hibernate Mappings

# Hibernate

# What is Hibernate?
1. Hibernate is an open-source Objetc-Relational Mapping (ORM) framework for Java applications.
2. It simplifies the development of Java applications to interact with relational databases by mapping java objects to database tables and handling the underlying SQL queries and transactions.

# What is Session in Hibernate?
1. In Hibernate, a **Session is a primary interface** for interacting with the database.
2. It is an integral part of Hibernate architecture, providing a connection to the database.

# What is SessionFactory?
1. In Hibernate, the **SessionFactory is an interface** responsible for creating and managing session objects.
2. The primary role of **SessionFactory** is to create Session instances.
3. A Session is a lightweight object that represents a single unit of work with the database.

# What is new Configuration().buildSessionFactory(); ?
The Statement **new Configuration().buildSessionFactory();** is used in Hibernate to create a SessionFactory object.  

**new Configuration()**  
This creates a **new instance** of the Configuration class, which is used to configure Hibernate.  

**.configure()**  
This method **loads the Hibernate Configuration file (hibernate.cfg.xml)** to read the database connection and Hibernate properties.  

**.buildSessionFactory();**  
This builds the SessionFactory based on the configuration settings.  
The SessionFactory is a factory for Session instances.  
















