package com.dl.controller;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.dl.dao.UserDao;
import com.dl.dao.UserDaoImpl;
import com.dl.model.User;

public class SearchBasedOnUsernameController {
	
	public static void main(String[] args) {
		
		UserDao userSearch = new UserDaoImpl();
		try {
			List <User> filterList = userSearch.searchOnUsername("kiran");
			
			Iterator<User> it = filterList.iterator();
			
			while(it.hasNext()) {
				User user = it.next();
				System.out.println(user.getId() + "\t" + user.getUserName() + "\t" + user.getEmail());
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
