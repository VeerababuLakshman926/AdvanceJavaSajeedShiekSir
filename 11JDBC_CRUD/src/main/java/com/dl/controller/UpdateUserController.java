package com.dl.controller;

import com.dl.dao.UserDao;
import com.dl.dao.UserDaoImpl;
import com.dl.model.User;

public class UpdateUserController {
	
	public static void main(String[] args) {
		
		UserDao updateUser =  new UserDaoImpl();
		User user = new User();
		user.setId(1);
		user.setUserName("Sai Ram");
		user.setEmail("sairam@gmail.com");
		
		try {
			
			updateUser.updateUser(user);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
