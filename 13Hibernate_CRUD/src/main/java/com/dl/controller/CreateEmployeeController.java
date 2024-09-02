package com.dl.controller;

import com.dl.dao.EmployeeDao;
import com.dl.dao.EmployeeDaoImpl;
import com.dl.model.Employee;

public class CreateEmployeeController {
	
	public static void main(String[] args) {
		
		Employee employee = new Employee();
		employee.setName("Chandu");
		employee.setEmail("chandu@gmail.com");
		
		EmployeeDao insert = new EmployeeDaoImpl();
		insert.save(employee);
		System.out.println("Employee Created Successfully");
	}

}
