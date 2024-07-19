package com.dl.controller;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.dl.dao.UserDao;
import com.dl.dao.UserDaoImpl;

public class GetAllSameEmails {
	
	public static void main(String[] args) {
		
		UserDao emails = new UserDaoImpl();
		
		try {
			List<String> emailList = emails.getAllSameEmails();
			Iterator<String> it = emailList.iterator();
			
			while(it.hasNext()) {
				System.out.println(it.next());
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		
	}

}
