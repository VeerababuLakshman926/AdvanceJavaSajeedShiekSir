# JDBC

# JDBC: JDBC API
* **Java Database Connectivity(JDBC)** is an Application programming Interface(API) for the **Java Programming Language.**  
* It is a part of **Java Standard Edition** platform from **Oracle Corporation.**
* It allows Java programs to access and manipulate the data stored in a database.
* It provides a set of classes and interfaces that enable Java code to interact with databases in a uniform and database-independent manner.
* **JDBC API --> Java Application --> JDBC Driver --> Database**


# What are the steps to connect JDBC application?
1. Load the Driver
2. Create connections
3. Create statement
4. Executing query
5. Closing Connection and  Statement

**1. Load the Driver**  
Driver helps to make a connection to the database. Hence driver must be loaded once in the program. This can be done by two methods:

* Class.forName() is a method in Java that loads the JDBC driver class for a particular database.
* There is no need to create a new object.
* It is used to dynamically load the driver at runtime.
* For example: **Class.forName("com.mysql.cj.jdbc.Driver")**

* DriverManager.registerDriver().
* DriverManager is a java class where the register is its static method(), this method accepts the new Driver object.
* This method is typically called once at the beginning of the program to load the driver into memory and make it available for use throughout the program.
* For example: **DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver)**

**2. Creating Connections** 

* After the driver is loaded, the connection is setup.
* The connection object uses **username, password and URL** to setup the connection.
* URL has a predefined format which contains **database name, the driver used, IP address** where the database is stored. **Port number** and the **Service provider**.
* The connection can be setup by using the command: **Connection connection = DriverManager.getConnection(URL, userName, password)**
* **connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava18jdbc", "root", "admin");**

**3. Creating Statement**

* After creating connection, the Statement object is created.
* **Statement statement = connection.createStatement()**

**4. Executing Query**

* After creating statement, the database query is executed.
* **String query = "create table emp(e_id int, e_name varchar(40), e_address varchar(255), e_salary double)";**
* **statement.execute(query);**

**5. Closing the open resources**

* After completion of interaction with the database the resources should be closed and it is good coding practice.
* **statement.close();**
* **connection.close();**

**Demo for Loading the DriverClass**

```
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.dl</groupId>
	<artifactId>JDBC</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>JDBC</name>
	<description>JDBC</description>

	<dependencies>

		<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.33</version>
		</dependency>


	</dependencies>
</project>
```
```
package com.dl.testConnection;

import java.sql.DriverManager;

public class TestConnection {
	
	public static void main(String[] args) {
		
		try {
			//Load the driver
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// above and below statements can be used to load the driver
			
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			System.out.println("Driver Class is loaded");
		} catch (Exception e) {
			System.out.println("The Exception is" + e);
		}
	}

}

```

# What are the types of Statements?
1. Statement : It is for executing basic SQL queries without parameters.
2. PreparedStatement : It is for parameterised queries to improve performance and security.
3. Callable Statement : It is for calling stored procedures with input and output parameters.

# What are the Types of Packages? 
* JDBC API is maing divided into two packages **java.sql** and **javax.sql**
* This package include classes and interface to perform almost all JDBC operations such as creating and executing SQL Queries.

**java.sql package**  
* This package include classes and interfaces to perform almost all JDBC operations such as creating and executing SQL Queries.

```
java.sql.Statement
java.sql.PreparedStatement
java.sql.CallableStatment

java.sql.Driver
java.sql.SQLException
java.sql.ResultSet
java.sql.CLOB
java.sql.Date
java.sql.Connection
java.sql.BLOB
java.sql.Savepoint

```

**javax.sql package**  
* This package also known as JDBC extension API. It provides classes and interface to access server-side data.

```
javax.sql.DataSource
javax.sql.PooledConnection
javax.sql.ConnectionEventListner
javax.sql.ConnectionEvent
```

# What are the types of Drivers we have in JDBC
* Type-1: Driver or JDBC-ODBC Bridge.
* Type-2: Driver or Native API Party Java Driver.
* Type-3: Driver or Network Protocol Driver
* Type-4: Thin Driver
* Above driver is also called pure Java driver because they directly interact with the database.
* It neither requires any native library nor middleware server.
* Thin Driver is fast compart to other drivers. No any software is required at client side or server side.

# What is ResultSet?

**java.sql.ResultSet**  
* ResultSet is an interface present in the java.sql package and it is used to hold the values which are coming from data base.
* We are able to access the data from the ResultSet Object by using cursor. It is not a database cursor.
* This cursor is pointer that points to one row of data in ResultSet, initially the cursor is positioned before the first row.
* The default ResultSet object is CONCUR_READ_ONLY and TYPE_FORWARD_ONLY.

# What is ResultSet concurrency?
* Based on the ResultSet concurrency the ResultSet object is divided into two types.
* CONCUR_READ_ONLY(it is possible to just read the data)
* CONCUR_UPDATABLE(it is possible to read the data and also possible to update the data)

# What is ResultSet sensitivity?
* Based on ResultSet sensitivity the ResultSet object is divided into two types.
* ResultSet.TYPE_FORWARD_ONLY (it is possible to read the data only in forward direction)
* SCROLL( it is possible to read the data in both forward and backward direction)
```
ResultSet.TYPE_SCROLL_SENSITIVE
ResultSet.TYPE_SCROLLINSENSITIVE
```
**ResultSet.TYPE_SCROLL_SENSITIVE**  
* The cursor can scroll forward and backwards, and the ResultSet is sensitive to changes made by others to the Database, that occurs after the ResultSet was created.

**ResultSet.TYPE_SCROLL_INSENSITIVE**  
* The cursor can move forward and backwards, and the ResultSet is not sensitive to changes made by others to the Database, that occurs after the ResultSet was created.

# What is Batch Execution?
* A batch is a group of queries.
* Batch execution is process of sending multiple queries to the database server at a time in the form of batch and then executing them in the database server.

**Methods of batch execution**  
```
void addBatch(String query);
Int[] executeBatch();
void clearBatch();
```
* void addBatch(String query); is used to place the specified query into the batch.
* Int[] executeBatch(); is used for executing all queries available in the batch.
* void clearBatch(); is used to remove all the queries available in the batch.

# Differentiate between execute(), executeQuery() and executeUpdate() methods of Statement interface.
* All three methods (execute(), executeQuery() and executeUpdate()) are used to execute SQL statements in JDBC but they differ in their functionality and return types.
**execute(String query);**
  * Use this method for statments that might produce different results like DDL statements (CREATE, ALTER, DROP) or procedures that may return data or perform actions without returning data.
  * It returns a boolean value indicating whether the SQL statement produced a ResultSet object (true) or not (false).
**executeQuery(String query);**
  * This method is specifially designed to execute SELECT statements that retrieve data from the database.
  * It returns a ResultSet object containing the results of the query.
  * Use this method when you expect to retrieve data and iterate through the rows in the result set.
**executeUpdate(String query);**
  * This method is used to execute INSERT, UPDATE or DELETE statements that modify data in the database.
  * It returns an integer representing the number of rows affected by the statement.
  * Use this method, when you want to perform data manipulation operations and potentially track how many rows were inserted, updated or deleted.





**Example of JDBC interaction with mysql**

```
package com.dl.createTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	
	public static void main(String[] args) {
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			
			//Step-1: Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Step-2: Create connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava18jdbc", "root", "Nani123@.");
			
			//Step-3: Create Statement
			statement = connection.createStatement();
			
			//Step-4: Create Query
			String query = "create table emp(e_id int, e_name varchar(40), e_address varchar(255), e_salary double)";
			
			//Step-5: Executing Statement
			statement.execute(query);
			
			System.out.println("Table is created");
			
			
		} catch (Exception e) {
			System.out.println("Exception is" + e);
		} finally {
			
			try {
				statement.close();
				System.out.println("Statement is closed");
			} catch (SQLException e) {
				System.out.println("Statement close exception is " + e);
			}
			try {
				connection.close();
				System.out.println("Connection is closed");
			} catch (SQLException e) {
				System.out.println("Connection close exception is " + e);
			}
			
		}
	}

}
```
