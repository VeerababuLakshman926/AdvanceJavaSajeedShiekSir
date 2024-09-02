package com.dl.controller;

import java.sql.SQLException;

import com.dl.dao.UserDao;
import com.dl.dao.UserDaoImpl;
import com.dl.model.User;

public class CreateUserController {
	
	public static void main(String[] args) {
		
		UserDao userDetails = new UserDaoImpl();
		
		User user = new User(5, "Raju", "raju@gmail.com");
		
		try {
			userDetails.insertUser(user);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
