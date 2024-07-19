package com.dl.controller;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.dl.dao.UserDao;
import com.dl.dao.UserDaoImpl;

public class GetAllUserNamesController {

	public static void main(String[] args) {
		
		UserDao userNames = new UserDaoImpl();
		 
		try {
			List<String> userNamesList = userNames.getAllUsernames();
			Iterator<String> it = userNamesList.iterator();
			
			while(it.hasNext()) {
				System.out.println(it.next());
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		
	}
}
