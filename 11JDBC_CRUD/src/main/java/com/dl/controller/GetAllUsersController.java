package com.dl.controller;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.dl.dao.UserDao;
import com.dl.dao.UserDaoImpl;
import com.dl.model.User;

public class GetAllUsersController {
	
	public static void main(String[] args) {
		
		UserDao User = new UserDaoImpl();
		
		
		List<User> UsersList;
		try {
			UsersList = User.getAllUser();
			Iterator<User> it =  UsersList.iterator();
			
			while(it.hasNext()) {
				User user = it.next();
				//System.out.println(user);
				System.out.println(user.getId() + "\t" + user.getUserName() + "\t" + user.getEmail());
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		
	}

}
