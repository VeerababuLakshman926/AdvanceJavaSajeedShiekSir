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
