package com.dl.controller;

import com.dl.dao.EmployeeDao;
import com.dl.dao.EmployeeDaoImpl;

public class DeleteEmployeeById {
	
	public static void main(String[] args) {
		
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		employeeDao.delete(5L);
	}

}
