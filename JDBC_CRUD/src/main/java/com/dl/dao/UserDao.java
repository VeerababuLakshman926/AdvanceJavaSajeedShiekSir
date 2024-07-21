package com.dl.dao;

import java.sql.SQLException;
import java.util.List;

import com.dl.model.User;

public interface UserDao {
	
	public void createTable() throws SQLException;
	public void insertUser(User user) throws SQLException;
	public User getUserById(int id) throws SQLException;
	public List<User> getAllUser() throws SQLException;
	public void updateUser(User user) throws SQLException;
	public void deleteUser(int id) throws SQLException;
	public List<String> getAllUsernames() throws SQLException;
	public List<String> getAllEmails() throws SQLException;
	public List<String> getAllSameNames() throws SQLException;
	public List<String> getAllSameEmails() throws SQLException;
	public List<User> searchOnUsername(String search) throws SQLException;
	
	
	//get all user
	//deleteUser
	//insert multiple users at same time
	// getall username
	//get all emailids
	// get all same names
	//get all same email id
	//Search based on name
	//Understanding rollback and transaction
	
	

}
