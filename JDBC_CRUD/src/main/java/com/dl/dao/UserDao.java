package com.dl.dao;

import java.sql.SQLException;
import java.util.List;

import com.dl.model.User;

public interface UserDao {
	
	public void createTable() throws SQLException;
	public void insertUser() throws SQLException;
	public User getUserById(int id) throws SQLException;
	public List<User> getAllUser();
	public void updateUser(User user) throws SQLException;
	public void deleteUser(int id) throws SQLException;
	
	

}
