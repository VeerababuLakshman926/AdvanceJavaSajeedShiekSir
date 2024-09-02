package com.dl.controller;

import com.dl.dao.EmployeeDao;
import com.dl.dao.EmployeeDaoImpl;
import com.dl.model.Employee;

public class FindById {
	
	public static void main(String[] args) {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		try {
			Employee employee = employeeDao.findById(5L);
			System.out.println("Name : "+employee.getName() + "\t" + "Email : " + employee.getEmail());
		
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
