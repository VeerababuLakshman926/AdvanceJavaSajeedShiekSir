package com.dl.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.dl.model.User;
import com.dl.util.Connection_SQL;

public class UserDAOImpl implements UserDAO {

	static Connection connection = Connection_SQL.createConnection();

	@Override
	public void createTableUser() throws SQLException {
		
		Statement statement = null;
				
		try {
			statement = connection.createStatement();
			String query = "create table usersTable(id int auto_increment primary key, userName varchar(255), email varchar(255))";
			statement.execute(query);
		} catch (SQLException e) {
			System.out.println("Exception in creating table : " + e );
		} finally {
			
			if(statement != null) {
				statement.close();
			}
			
			if(connection != null) {
				connection.close();
			}
			
			
		}
		
		
	}

	@Override
	public void createUser(User user) throws SQLException{
		
		PreparedStatement preparedStatement = null;
				
		try {
			
			String query = "insert into usersTable(username, email) values (?, ?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Exception in creating user : " + e );
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
	public List<User> getAllUser() throws SQLException {
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
