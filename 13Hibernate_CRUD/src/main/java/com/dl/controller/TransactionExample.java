package com.dl.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TransactionExample {

	// Url, username and password strings
	private static final String jdbcUrl = "jdbc:mysql://localhost:3306/advancejava18jdbc";
	private static final String jdbcUserName = "root";
	private static final String jdbcPassword = "Nani123@.";
	
	public static void main(String[] args) {
		
		try {
			
			Connection con = null;
			Statement st =  null;
			 try {
				 
				 Class.forName("com.mysql.cj.jdbc.Driver");
				 con = DriverManager.getConnection(jdbcUrl, jdbcUserName,jdbcPassword);
				 
				 System.out.println("Data Before Transaction");
				 
				 displayAccountData(con);
				 
				 System.out.println("Transaction Begins");
				 con.setAutoCommit(false);
				 updateAccountBalance(st, "sai Kiran", -10000);
				 updateAccountBalance(st, "sai Ram", 10000);
				 
				 System.out.println("Can you confirm this transaction [Yes|No]");
				 Scanner sc = new Scanner(System.in);
				 
				 String userConfirmation = sc.next();
				 
				 if(userConfirmation.equalsIgnoreCase("yes")) {
					 con.commit();
					 System.out.println("Transaction committed");
				 } else {
					 con.rollback();
					 System.out.println("Transaction rolled back");
				 }
				 
				 System.out.println("Data After Transaction");
				 
				 displayAccountData(con);
				
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println(e);
			} finally {
				if(st != null) {
					st.close();
				}
				
				if(con != null) {
					con.close();
				}
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	private static void displayAccountData(Connection con) {
		try(
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from accounts");
				){
			
			while(rs.next()) {
				System.out.println(rs.getString("user_name") + "\t" + rs.getString("user_balance"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void updateAccountBalance(Statement st, String userName, int amount) throws SQLException {
		st.executeUpdate("UPDATE accounts SET user_balance = user_balance + " + amount + " WHERE user_name = '"
				+ userName + "'");
	}

}
