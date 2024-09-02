package com.dl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.dl.model.User;

public class UserDaoImpl implements UserDao {
	
	//Url, username and password strings
	private String jdbcUrl = "jdbc:mysql://localhost:3306/advancejava18jdbc";
	private String jdbcUserName = "root";
	private String jdbcPassword = "Nani123@.";
	
	//Writing sql queries
	private static final String Create_User_Sql_Table = "create table users(id int auto_increment primary key, userName varchar(255), email varchar(255))";
	private static final String Insert_User_Sql = "insert into users(username, email) values (?, ?)";
	private static final String Update_User_Sql = "update users set username = ?, email = ? where id = ?";
	private static final String Select_User_by_Id = "select id, username, email from users where id = ?";
	private static final String Get_All_Users = "select * from users";
	private static final String Delete_User_By_Id = "delete from users where id = ?";
	
	 
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
			prepareStatement = connection.prepareStatement(Create_User_Sql_Table);
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
	public void insertUser(User user) throws SQLException {
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
	
		try{
			connection = createConnection();
			prepareStatement = connection.prepareStatement(Insert_User_Sql);
			prepareStatement.setString(1, user.getUserName());
			prepareStatement.setString(2, user.getEmail());
			prepareStatement.executeUpdate();
			
			System.out.println("User created successfully.");
			
		} catch (Exception e) {
	        System.out.println("Exception is : " + e);
	    } finally {
	        if (prepareStatement != null) {
	            prepareStatement.close();
	        }
	        if (connection != null) {
	            connection.close();
	        }
	    }
		
	}

	@Override
	public User getUserById(int id) throws SQLException {
		
		User user = new User();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			connection = createConnection();
			preparedStatement = connection.prepareStatement(Select_User_by_Id);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				
			}
			
		} catch (Exception e) {
			System.out.println("Exception is  " + e);
		} finally {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(connection != null) {
				connection.close();
			}
		}
		return user;
	}

	@Override
	public List<User> getAllUser() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		List<User> UsersList = new ArrayList<User>();
		
		try {
			
			connection = createConnection();
			preparedStatement = connection.prepareStatement(Get_All_Users);
			ResultSet  rs = preparedStatement.executeQuery();
			
			
			while(rs.next()) {
				
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("userName"));
				user.setEmail(rs.getString("email"));
				UsersList.add(user);
				
			}
			
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		} finally {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(connection != null) {
				connection.close();
			}
		}
		return UsersList;
	}

	@Override
	public void updateUser(User user) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement =  null;
		
		try {
			
			connection = createConnection();
			preparedStatement = connection.prepareStatement(Update_User_Sql);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setInt(3, user.getId());
			preparedStatement.executeUpdate();
			System.out.println("User Updated successfully");
			
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		} finally {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(connection != null) {
				connection.close();
			}
			
		}
		
	}

	@Override
	public void deleteUser(int id) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement =  null;
		
		try {
			connection = createConnection();
			preparedStatement = connection.prepareStatement(Delete_User_By_Id);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("User deleted successfully");
			
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		} finally {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(connection != null) {
				connection.close();
			}
			
		}
		
		
	}


	@Override
	public List<String> getAllUsernames() throws SQLException {
		List<String> userNames = new ArrayList<String>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			connection = createConnection();
			preparedStatement = connection.prepareStatement(Get_All_Users);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String userName = rs.getString("username");
				userNames.add(userName);
			}
			
			
			
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		} finally {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(connection != null) {
				connection.close();
			}
			
		}
		return userNames;
	}


	@Override
	public List<String> getAllEmails() throws SQLException {
		List<String> emails = new ArrayList<String>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			connection = createConnection();
			preparedStatement = connection.prepareStatement(Get_All_Users);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String email = rs.getString("email");
				emails.add(email);
			}
			
			
			
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		} finally {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(connection != null) {
				connection.close();
			}
			
		}
		return emails;
	}


	@Override
	public List<String> getAllSameNames() throws SQLException {
		List<String> userNames = new ArrayList<String>();
		List<String> similarUserNames = new ArrayList<String>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			connection = createConnection();
			preparedStatement = connection.prepareStatement(Get_All_Users);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String username = rs.getString("username");
				userNames.add(username);
			}
			
			Iterator<String> it = userNames.iterator();
			
			while(it.hasNext()) {
				String username = it.next();
				int count = 0;
				for(int i = 0; i < userNames.size(); i++) {
					
					String username2 = userNames.get(i);
					if(username.contentEquals(username2)) {
						count++;
					}
				}
				
				if(count > 1 && !similarUserNames.contains(username)) {
					similarUserNames.add(username);
				}
				
			}
			
			
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		} finally {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(connection != null) {
				connection.close();
			}
			
		}
		
		return similarUserNames;
	}


	@Override
	public List<String> getAllSameEmails() throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		List<String> similarEmails = new ArrayList<String>();
		List<String> emails = new ArrayList<String>();
		
		try {
			
			connection = createConnection();
			preparedStatement = connection.prepareStatement(Get_All_Users);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String email = rs.getString("email");
				emails.add(email);
			}
			
			for(int i = 0; i < emails.size(); i++) {
				String email1 = emails.get(i);
				int count = 0;
				for(int j = 0; j< emails.size(); j++) {
					String email2 = emails.get(j);
					if(email1.contentEquals(email2)) {
						count++;
					}
				}
				
				if(count >1 && !similarEmails.contains(email1)) {
					similarEmails.add(email1);
				}
			}
			
			
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		} finally {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(connection != null) {
				connection.close();
			}
		}
		return similarEmails;
	}


	@Override
	public List<User> searchOnUsername(String search) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement =  null;
		List<User> userList = new ArrayList<User>();
		List<User> filterList = new ArrayList<User>();
		
		try {
			
			connection = createConnection();
			preparedStatement = connection.prepareStatement(Get_All_Users);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				
				userList.add(user);
			}
			
			for(int i = 0; i < userList.size() ; i++) {
				User user = userList.get(i);
				String username = user.getUserName().toLowerCase();
				if(username.contains(search.toLowerCase())) {
					filterList.add(user);
				}
			}
			
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		}
		return filterList;
	}

}
