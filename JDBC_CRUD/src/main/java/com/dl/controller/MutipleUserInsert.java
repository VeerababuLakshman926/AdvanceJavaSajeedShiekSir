package com.dl.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.dl.dao.UserDao;
import com.dl.dao.UserDaoImpl;
import com.dl.model.User;

public class MutipleUserInsert {
	
	public static void main(String[] args) {
		
		UserDao Insert = new UserDaoImpl();
		User user1 = new User(5, "Raju", "raju@gmail.com");
		User user2 = new User(6, "Kiran", "kiran@gmail.com");
		List<User> entryList = new ArrayList<User>();
		entryList.add(user1);
		entryList.add(user2);
		
		Iterator<User> it = entryList.iterator();
		
		while(it.hasNext()){
			User user = it.next();
			try {
				Insert.insertUser(user);
			} catch (SQLException e) {
				System.out.println(e);
			}
			
		}
		
		
	}

}
