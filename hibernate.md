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

**There are four ways to use Second level Cache**  

**read-only :** caching will work for read only operation.  
**nonstrict-read-writer :** caching wil work for read and write but one at a time.  
**read-write :** caching will work for read and write, can be uses simultaneously.  
**transactional :** caching will work for transaction.  
    **->** The cache-usage property can be applied to class or collection level in hbm.xml file.  
    **->** The example to define cache usage is given as  
    ```
     <cache usage="read-only"/> 
    ```
 

# Printing Hibernate Queries in Console: 
* Hibernate has build-in a function to enable the **Logging** of all the generated SQL statements to the console.
* You can enable it by add a  **"show_sql" property** in the Hibernate configuration file **"hibernate.cfg.xml"**.
* This function is good for basic troubleshooting.
* Enable the logging of all the generated SQL statements to the console
```
<!--hibernate.cfg.xml-->
<property name="show_sql">true</property>
```
* Format the generated SQL statement to make it more readable, but takes up more screen space.
```
<!--hibernate.cfg.xml-->
<property name="format_sql">true</property>
```

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

* Instances may exist in one of the following three states at a given point of time.
* **transient :** A new instance of a persistent class which is not associated with a Session and has no representation in the database and no identifier value is considered transient by hibernate.
* **persistent :** You can make a transient instance persistent by associating it with a Session. A persistent instance has a representation in the database, an identifier value and is associated with a Session.
* **detaches :** Once we close the Hibernate Session, the persistent instance will become a detached instance.

# What is the purpose of Session.beginTransaction() method?

* **Session.beginTransaction()** begins a unit of work and returns the associated Transaction object.

# Which method is used to add a Criteria to a query?

* **Session.criteria()** creates a new Criteria instance, for the given entity class or a superclass of an entity class.

# Which method is used to a HQL query SQL query?

* **Session.createQuery** creates a new instance of Query for the given HQL query string.
* **Session.createSQLQuery** creates a new instance of SQLQuery for the given SQL query string.

# Which method is used to remove a persistent instance from the datastore?

* **Session.delete** removes a persistent instance from the datastore.

# Which method is used to get a persistent instance from the datastore?

* **Session.get** returns the persistent instance of the given **names entity** with the given **identifier** or **null** if there is no such persistance instance.

# Which method is used to re-read the state of the given instance from the underlying database?

* **Session.refresh** re-reads the state of the given instance from the underlying database.

# Which method is used to save the state of the given instance from the underlying database?

* **Session.save** saves the state of the given instance from the underlying database.

# Which method is used to update the state of the given instance from the underlying database?

* **Session.update** updates the state of the given instance from the underlying database.

# Which method is used to save or update the state of the given instance from the underlying database?

* **Session.saveOrUpdate** updates the state of the given instance from the underlying database.

# What are persistent classes in hibernate?

* Java classes whose objects or instances will be stored in database tables are called persistent classes in Hibernate.

# What are the best practices  that Hibernate recommends for persistent classes?

There are following main rules of persistent classes, however, none of these rules are hard requirements.
* All Java classes that will be persisted than a default constructor.
* All the classes should contain **ID** in order to allow easy **indentification** of your **objects** witnin Hibernate and the database.
* This property maps to the **primary key column** of a database table.
* All attributes that will be persisted should be declared **private** and have **getters** and **setters** methods defined in the **JavaBean** style.
* A central feature of Hibernate, **proxies**, depends upon on the **persistent class** being either **non-final**, or the implementation of an **interface** that declares all **public methods**.
*  All the classes that do not **extend or implement** some specialized **classes and interfaces** required by the EJB framework.

# Where Object/relational mappings are defined in hibernate?

* An **Object/relational mappings** are usually defined in an **XML document**.
* This Mapping file instructs Hibernate how to map the defined class or classes to the database tables.
* We should save the Mapping document in a file with the format below
```
<classname>.hbm.xml
```
# What is root node of hbm.xml?

* The mapping document is an XML document having the **```<hibernate-mapping>```** as the root element which contains all the **```<class>```** elements.

# Which elements of hbm.xml defines a specific mappings from a Java classes to the database tables?

* The **```<class>```** elements are used to define specific mapping from a **Java Classes** to the **Database tables**
* The **Java class name** is specified using the **name attribute** of the **class element** and the **database table name** is specified using the **table attribute**.

# Which elements of hbm.xml defines maps the unique ID attribute in class to the primary key of the database tables?

* The **```<id>```** element maps the unique ID attribute in class to the primary key of the database table.
* The name attribute of the id element refers to the property in the class and the column attribute refers to the column in the database table.
* The type attribute holds the hibernate mapping type, this mapping types will convert from Java to SQL data type.

# Which element of hbm.xml is used to automatically generate the primary key values?

* The **```<generator>```** element within the id element is used to automatically generate the primary key values.
* Set the class attribute of the generator element is set to native to let hibernate pick up either identity, sequence or hilo alogorithm to create primary key depending upon the capabilities of the underlying database.

# Which element of hbm.xml is used to map a java class property to a column in the database table?

* The **```<property>```**  element is used to map a Java Class property to a column in the database table.
* The name attribute of the element refers to the property in the class and the column attribute refers to the column in the database table.
* The type attribute holds the hibernate mapping type, this mapping types will convert Java to SQL data type.

# Which element of hbm.xml is used to map a java.util.Set property in hibernate?

* This is mapped with a **```<set>```** element and initailized with **```java.util.HashSet```**.

# Which element of hbm.xml is used to map a java.util.SortedSet property in hibernate?

* This is mapped with a **```<set>```** element and initailized with **```java.util.TreeSet```**.
* The sort attribute can be set to either a comparator or natural ordering.

# Which element of hbm.xml is used to map a java.util.List property in hibernate?

* This is mapped with a **```<list>```** element and initailized with **```java.util.ArrayList```**.

# Which element of hbm.xml is used to map a java.util.Collection property in hibernate?

* This is mapped with a **```<bag>```** or **```<ibag>```** element and initailized with **```java.util.ArrayList```**.

# Which element of hbm.xml is used to map a java.util.Map property in hibernate?

* This is mapped with a **```<map>```** element and initailized with **```java.util.HashMap```**.

# Which element of hbm.xml is used to map a java.util.SortedMap property in hibernate?

* This is mapped with a **```<map>```** element and initailized with **```java.util.TreeMap```**.
* The sort attribute can be set to either a comparator or natural ordering.

# What is the difference between save() and persist() methods of session object?

* session.save saves the object and returns the id of the instance whereas  persist do  not return anything after saving the instance.

# What is lazy loading?

* Lazy loading is a technique in which objects are loaded on demand basis.
* Since Hibernate 3, lazy loading is by default enabled so that child objects are not loaded when parent parent is loaded.

# HQL

* HQL is a query language which looks like sql but the difference is HQL Query(commands) are database independent.
* HQL queries are database independent and sql queries are DB dependent.
* HQL query looks similar to sql query.
* In HQL query, in place of table name we put pojo class name and in place of column name we put varialbe names of pojo class.
* Because of pojo class name and variables are used in HQL.
* Query HQL is called an object oriented form of sql.
* Internally hibernate translates HQL query into SQL query with respect to database, using "Dialect.class".

# Projection is used for 2 ways. They are

1. To read the **partial entity** from the DB using **Criteria**
2. To perform **aggregate function** using **Criteria**

ProjectionList is a optional when we used single property(single projection).   
**```Projection p Projections.property("employeeSalary");```**  
**```crit.setProjection(p)```**  

When we want to read a partial entity with a single property then we don't require a ProjectionList.  
We can directly sent Projection object to Criteria.

```
Criteria crit = session.createCriteria("Employee.class");
Projection p = Projections.property("employeeSalary");
crit.setProjection(p);
List list = crit.list();
Iterator it = list.iterator();
while(it.hasNext()){
Integer i = (Integer) it.next();
--
--
}
```

While working with Criteria object, if we want to read a result by executing some aggregate functions then also we need to take the support of Projections.  

```
Criteria crit = session.createCriteria("Employee.class");
Projection p1 = Projections.property("employeeSalary");
Projection p2 = Projections.property("employeeSalary");
Projection p3 = Projections.property("employeeSalary");
ProjectionList plist = Projections.projectionList();
plist.add(p1);
plist.add(p2);
plist.add(p3);
crit.setProjection(plist);
List list = crit.list();
```

# Difference between Merge and Update methods in hibernate?

* Both **update()** and **merger()** methods in hibernate are used to convert the object which is in **detached state into persistent state**.
* But there is a little difference. Actually update and merge methods will come into picture when ever we **loaded the same object again and again** into database.

# Transaction Management

* A **transaction** simply represents a unit of work.
* In such case, if one step fails, the whole transaction fails (which termed as atomicity).
* A transaction can be described by **ACID** properties **(Atomicity, Consistency, Isolation and Durability)**.

**Transaction Interface in Hibernate**  

* In hibernate framework, we have **Transaction interface** that defines the unit of work.
* It maintains abstraction from the transaction implementation **(JTA,JDBC)**.
* A transaction is associated with Session instantiated by calling **session.beginTransaction();**

**The methods of Transaction interface are as follows :**  

* **void begin()** starts a new transaction.
* **void commit()** ends the unit of work unless we are in FlushMode.NEVER.
* **void rollback()** forces this transaction to rollback.
* **void setTimeout(int seconds)** it sets a transaction timeout for any transaction started by a subsequent call to begin on this instance.
* **boolean IsAlive()** checks if the transaction is still alive.
* **void registerSynchronization(Synchronization s)** registers a user synchronization callback for this transaction.
* **boolean wasCommitted()** checks if the transaction is committed successfully.
* **boolean wasRolledBack()** checks if the transaction is rolledbacked successfully.

**Hibernate Configuration file**  

* Hibernate configuration file contains database specific configurations and used to intialize SessionFactory.
* We provide database credentials or JNDI resource information in the hibernate configuration xml file.
* Some other important parts of hibernate configuration file is **Dialect** information, so that hibernate knows the database type and mapping file or class details.

# What is Right Join?

* Right Join is a key word in SQL.
* Which returns all the data from right hand side (table 2) and matched records from left hand side table (table 1).
* We can see the NULL values from the left side if there is no match.

# Hibernate Right Join

* We can apply the Joins in Hibernate by using the **hql query or native sql query**.
* To make a join between the two tables, those two tables must be in a logical relationship.
* We can meet the relationship between two tables by applying the parents table's primary key as childs table's foreign key.

# What is Left Join?

* Left Join is a key word in SQL.
* Which returns all the data from left hand side and matched records from right hand side table.
* We can see the NULL values from the right side if there is no match.

# Hibernate Left Join

* We can apply the Joins in Hibernate by using the **hql query or native sql query**.
* To make a join between the two tables, those two tables must be in a logical relationship.
* We can meet the relationship between two tables by applying the parents table's primary key as childs table's foreign key.


# Hibernate proxy?

* A mapping of classes can be made into a proxy instead of using the table.
* This will be used to return the load and often called as a session.
* It can also contain an actual method to load the data and proxy is created by default by Hibernate, for mapping a class to a file.

# Hibernate Session and how to get it?

* Hibernate Session is the interface Java application layer and Hibernate.
* This is the core interface used to perform database operations.
* Lifecycle of a session is bound by the beginning and end of transaction.
* Session provide methods to perform create, read, update and delete operations for a persistent object.
* We can execut HQL queries, SQL native queries and create criteria using Session object.

# Hibernate Generator Classes

* **Generators** are one of the most key concept in hibernate.
* Hibernate provides different types of  predefined generator classes, to represent a primary key in database.
* A generator class is used to generate an Id for an object, which is going to be insert in database as a primary key.

**Predefined Generator Classes**  
Hibernate has given some predefined generator classes listed below :  
* **assigned**
* **increment**
* **sequence**
* **hilo**
* **identity**
* **native**
* **foreign**
* **uuid**

# Custom generator class in hibernate:

* If we want to generate  a primary key with our own format, then we can go this custom generator i.e., If we want to generate id as numeric then we can go with any generator except assigned.
* Or If we want to make the id as String type we can go with assigned.
* To achieve this, we can go with custome generator in hibernate.
* In order to create a user defined generator class in hibernate (custom generators) our class should implement Identifier Generator interface.
* Not only our custom generator class, all the pre-defined generator classes were implemented by the Identifier Generator Interface.
* The Identifier Generator Interface has a single abstract method called generate().
* So we need to override generate() method and define our own logic to generate custom Id in that.

# What are collection types in Hibernate?
There are five collection types in hibernate used for **one-to-many relationship mappings**  
* **Bag**
* **Set**
* **List**
* **Array**
* **Map**

# Why we should not make Entity Class final?
* Hibernate use **proxy classes for lazy loading of data**, only when it's needed.
* This is done **by extending the entity bean**, if the entity bean will be final then lazy loading will not be possible, hence low performance.

# Hibernate Session is thread safe?
* Hibernate Session object **is not thread safe**, every thread should get it's own session instance and close it after it's work is finished.

# Difference between openSession() and getCurrentSession()?

* Hibernate **SessionFactory.getCurrentSession() method** returns the session bound to the context.
* But for this to work, we need to configure it in **hibernate configuration file**.
* Since this session object belongs to the hibernate context, we don't need to close it.
* Once the **SessionFactory is closed**, this **Session** objects gets closed.
* **```<property name="hibernate.current_session_context_class">thread</property>```**
* Hibernate SessionFactory **openSession()** method always opens a new session.
* We should **close this session object** once we are done with all the database operations.
* We should open a new session for each request in multi-thread environment.











