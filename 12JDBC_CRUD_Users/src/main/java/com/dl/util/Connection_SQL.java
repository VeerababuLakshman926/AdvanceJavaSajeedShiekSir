package com.dl.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connection_SQL {
	
	public static Connection createConnection() {
		
		Connection connection = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava18jdbc", "root", "Nani123@.");
			
		} catch (Exception e) {
			System.out.println("Creating Connection error" + e);
		}
		return connection;
	}
	

}
