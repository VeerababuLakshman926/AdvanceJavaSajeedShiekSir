package com.dl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.dl.model.User;

public class UserDaoImpl implements UserDao {
	
	//Url, username and password strings
	private String jdbcUrl = "jdbc:mysql://localhost:3306/advancejava18jdbc";
	private String jdbcUserName = "root";
	private String jdbcPassword = "Nani123@.";
	
	//Writing sql queries
	private static final String createTable = "create table users(id int auto_increment primary key, userName varchar(255), email varchar(255))";
	
	 
	protected Connection createConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcUrl, jdbcUserName,jdbcPassword);
		} catch (Exception e) {
			System.out.println("Exception in connection is" + e);
		}
		
		return connection;
	}
	

	@Override
	public void createTable() throws SQLException {
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
	
		try{
			connection = createConnection();
			prepareStatement = connection.prepareStatement(createTable);
			prepareStatement.execute();
			System.out.println("Table 'users' created successfully.");
			
		} catch (SQLException e) {
			System.out.println("Error code : " + e.getErrorCode());
	        if (e.getErrorCode() == 1050) {
	            // Error code 1050: Table already exists
	        	System.out.println("SQL Exception in if block: " + e.getMessage());
	        } else {
	            System.out.println("SQL Exception in else block: " + e.getMessage());
	        }
	    } 
	        catch (Exception e) {
	        System.out.println("Exception is : " + e);
	    } finally {
	        if (prepareStatement != null) {
	            prepareStatement.close();
	        }
	        if (connection != null) {
	            connection.close();
	        }
	    }
		
//		or you can write the above code like below same output. In the below code final block is not used because the resources are closed automatically at the end of try block.
		
		
//		try ( Connection connection = createConnection();
//			  PreparedStatement prepareStatement = connection.prepareStatement(createTable);){
//				
//				prepareStatement.execute();
//				System.out.println("Table 'users' created successfully.");
//				
//			} catch (SQLException e) {
//				System.out.println("Error code : " + e.getErrorCode());
//		        if (e.getErrorCode() == 1050) {
//		            // Error code 1050: Table already exists
//		        	System.out.println("SQL Exception in if block: " + e.getMessage());
//		        } else {
//		            System.out.println("SQL Exception in else block: " + e.getMessage());
//		        }
//		    } 
//		        catch (Exception e) {
//		        System.out.println("Exception is : " + e);
//		    }
		
		
	}

	@Override
	public void insertUser() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
