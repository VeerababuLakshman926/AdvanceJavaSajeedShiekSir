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
