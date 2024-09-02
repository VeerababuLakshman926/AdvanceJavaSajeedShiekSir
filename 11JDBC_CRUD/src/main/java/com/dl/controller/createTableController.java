package com.dl.controller;

import java.sql.SQLException;

import com.dl.dao.UserDao;
import com.dl.dao.UserDaoImpl;

public class createTableController {
	
	public static void main(String[] args) {
		
		UserDao userTable = new UserDaoImpl();
		
		try {
			userTable.createTable();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
