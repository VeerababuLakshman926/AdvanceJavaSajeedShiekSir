package com.dl.controller;

import com.dl.dao.UserDao;
import com.dl.dao.UserDaoImpl;
import com.dl.model.User;

public class getUserByIdController {
	
	public static void main(String[] args) {
		
		UserDao userById = new UserDaoImpl();
		User user = new User();
		try {
			
			user = userById.getUserById(1);
			System.out.println(user.getId() +"\t" + user.getUserName() +"\t"  + user.getEmail());
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
