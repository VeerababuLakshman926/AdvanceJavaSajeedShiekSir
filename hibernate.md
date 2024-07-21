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


# Hibernate
* **Hibernate** is a popular framework of java which allows us efficient **Object Relational Mapping** using configuration files in **XML format.**  
* After Java objects mapping to database tables, database is used and handled using Java Objects without writing complex database queries.
* It was started in 2001 by Gavin King as an alternative to EJB2 style entity bean.

# Differences between Session vs SessionFactory - Hibernate?
* **SessionFactory objects** are one per **Application**.
* **Session Objects** are one per **Client**.
* **SessionFactory** is to **create** and **Manage sessions**.
* **Session** is to provide **CRUD interface** for **Mapped classes**, and also access to the more versatile **Criteria API**.
* **SessionFactory** is **Thread safe**.
* **Session** is **not thread safe**.

# Hibernate Caching

* **First level Cache**
* **Second level Cache**
* **Query level Cache**

**First level Cache**

* **Hibernate First level Cache** is the **session cache**.
* **Hibernate First level Cache** is associated with the **Session object**.
* The **Session cache** caches objects with in the **current session**.
* **Hibernate First level Cache** is enabled by **default** and there is no way to **disable it**.
* The **Session object** keeps an **Object under its own power** before **committing** it to the **Database**.
* **Hibernate provides Methods**, through which we can **Delete selected objects** from the **Cache**.
* If any object **cached** in a **Session**, then it will not be visible to other **Session** and when the **Session** is closed, then all the **cached objects** will be **lost**.


**Second Level Cache**

* **Second level cache** was introduced in **Hibernate 3.0**.
* The **Second Level Cache** is responsible for caching objects across Sessions.
* Whenever we are loading any object from the **Database**, then Hibernate verify whether that **object** is available in the **Local cache Memory** of that particular **Session**. --> **[means first level cache]**
* If not available then Hibernate verify whether the **Object** is available in **Global Cache or Factory Cache**. --> **[means Second level cache]**
* If not available then Hibernate will hit the **Database** and **Loads the object** from there and then first stores in the **Local Cache of the Session |first level|** then in the **Global Cache | Second level cache|**.
* When another **Session** need to **Load the same object** from the **Database**, then Hibernate copies that object from **Global cache [second level cache]** into **Local Cache** of this new session.

* **EhCache** is the best choice for utilizing **hibernate second level cache**.
* Add Hibernate **ehcache dependency** in your **Maven project**.
* Add the **EhCache** provider in **Hibernate configuration file**.
* **Annotate** the entity beans with **@Cache annotation**.

**Query Cache**

* **Query Cache** is used to cache the results of a query.
* Hibernate also implements a **Cache** for **Query resultsets** that integrates closely with the **second-level cache**.
* This is an optional feature.
* It requires two additional physical **cache regions** that **hold the cached query results** and **the Timestamps** when a table **was last updated**.
* This is only useful for **Queries** that are run frequently with **same parameters**.

# Concurrency Strategies

* A Concurrency Strategy is a **Mediator**, which is responsible for storing items of data in the cache and retrieving them from the cache.
* If you are going to enable **second level cache**, you have to decide, for each persistence class and collection. Which concurrency strategy to use.

**There are four ways to use Second level Cache**.

**read-only :** caching will work for read only operation.  
**nonstrict-read-writer :** caching wil work for read and write but one at a time.  
**read-write :** caching will work for read and write, can be uses simultaneously.  
**transactional :** caching will work for transaction.
    * The cache-usage property can be applied to class or collection level in hbm.xml file.
    * The example to define cache usage is given below:
      **<cache usage="read-only" />**

# Printing Hibernate Queries in Console: 
* Hibernate has build-in a function to enable the **Logging** of all the generated SQL statements to the console.
* You can enable it by add a  **"show_sql" property** in the Hibernate configuration file **"hibernate.cfg.xml"**.
* This function is good for basic troubleshooting.
* Enable the logging of all the generated SQL statements to the console
**<!--hibernate.cfg.xml-->**  
**<property name="show_sql">true</property>**  
* Format the generated SQL statement to make it more readable, but takes up more screen space.
**<!--hibernate.cfg.xml-->**  
**<property name="format_sql">true</property>**  

# Cascade Attributes

* Cascade attribute is mandatory, whenever we apply relationship between objects, casacade attribute transfers operations done on one object onto its related child objects.
* If we write **cascade = "all"** then changes at parent class object will be effected to child class object too.
* If we write **cascade = "all"** then all operations like insert, delete, update at parent object will be effected to child object also.
* **None :** No Cascading, it's not a type but when we don't define any cascading then no operations in parent affects the child.
* **ALL :** Cascades save, delete, update, evict, lock, replicate, merge, persist. Basically everything.
* **SAVE_UPDATE :**  Cascades save and update, available only in hibernate.
* **DELETE :** Corresponds to the Hibernate native DELETE action, only in hibernate.
* **DETACH, MERGE, PERSIST, REFRESH and REMOVE** for similar operations.
* **LOCK :** Corresponds to the Hibernate native LOCK action.
* **REPLICATE :** Corresponds to the Hibernate native REPLICATE action.

# Difference between load() and get() method

**Load() method:**
* Only use the load() method if you are sure that object exists.
* load() method will throw an exception if the unique id is not found in the database.
* load() just runs a proxy by default and database won't be hit until the proxy is first invoked.

**get() method**
* If you are not sure that the object exists, then use one of the get() methods.
* get() method will return null if the unique id is not found in the database.
* get() will hit the database immediately.

# Key Components/Objects of Hibernate

* **Configuration :** Represents a configuration or properties file required by the Hibernate.
* **SessionFactory :** Configure Hibernate for the application using the supplies configuration file and allows for a Session object to be instaniated.
* **Session :** Used to get a physical connection with a database.
* **Transaction :** Represents a unit of work with the database and most of the **RDBMS** supports transaction functionality.
* **Query :** Use SQL or Hibernate Query Language(HQL) string to retrieve data from the data base and create objects.
* **Criteria :** Used to create and execute object oriented criteria queries to retrieve objects.

# Configuration object provides two key components

* **Database connection :** This is handled through one or more configuration files supported by Hibernate. These files are **hibernate.properties** and **hibernate.cfg.xml**.

* **Class Mapping Setup :** This component creates the connection between the java classes and database tables.

# What is Configuration object in hibernate?

* The **Configuration object** is the first Hibernate object you create in any Hibernate application and usually created only once during application initialization.
* It represents a configuration or properties file required by the Hibernate.

# What is Query in hibernate?

* **Query objects** use SQL or Hibernate Query Language(HQL) string to retrieve data from the database and create objects.
* A Query instance is used to bind query parameters, limit the number of results returned by the query and finally to execute the query.

# What is Criteria in hibernate?

* Criteria object are used to create and excute object oriented criteria queries to retrieve objects.

**To perform bulk select operations we need this criteria api**  
* **Criteria API** means, we used **Criteria interface** and we called methods of Criteria Interface for reading entities from the DB.
* **Criteria API** can be used only for selected operations. We can't perform non-select operation using criteria.
* Internally hibernate creates a **tunned sql command** and then executes in DB.
* If we use HQL, then Hibernate translates **HQL command** into its equivalent **sql command** but it does not apply for **query tunning**.
* So in HQL programmer is responsible for **query tunning**.
* In Criteria, there will be less burden on the programmer because **query tunning** will be taken care by hibernate only.
* **Criteria criteria = session.createCriteria(Employee.class);**

# Properties and Description

* **hibernate.dialect** This property makes Hibernate generate the appropriate SQL for the chosen database.
* **hibernate.connection.driver_class** The JDBC driver class.
* **hibernate.connection.url** The JDBC URL to the database interface.
* **hibernate.connection.username** The database username.
* **hibernate.connection.password** The database password.
* **hibernate.connection.pool_size** Limits the number of connections waiting in the Hibernate database connection pool.
* **hibernate.connection.autocommit** Allows auto commit made to be used for the JDBC connection.

# What are the three states of a persistent entity at a given point in time?


















