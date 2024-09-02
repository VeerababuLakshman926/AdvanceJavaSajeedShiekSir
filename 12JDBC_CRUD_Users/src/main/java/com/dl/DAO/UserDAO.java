package com.dl.DAO;

import java.sql.SQLException;
import java.util.List;

import com.dl.model.User;

public interface UserDAO {
	
	public void createTableUser() throws SQLException;
	public void createUser(User user) throws SQLException;
	public List<User> getAllUser() throws SQLException;
	public void updateUser(User user) throws SQLException;
	public void deleteUser(int id) throws SQLException;

}
