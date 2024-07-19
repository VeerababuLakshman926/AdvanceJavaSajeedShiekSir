package com.dl.controller;

import java.sql.SQLException;

import com.dl.dao.UserDao;
import com.dl.dao.UserDaoImpl;

public class DeleteUserController {
	
	public static void main(String[] args) {
		
		UserDao deleteUserById = new UserDaoImpl();
		try {
			deleteUserById.deleteUser(6);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
