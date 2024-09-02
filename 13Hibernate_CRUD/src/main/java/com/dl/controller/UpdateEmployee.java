package com.dl.controller;

import com.dl.dao.EmployeeDao;
import com.dl.dao.EmployeeDaoImpl;
import com.dl.model.Employee;

public class UpdateEmployee {
	
public static void main(String[] args) {
		
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setName("Sai");
		employee.setEmail("sai@gmail.com");
		
		EmployeeDao update = new EmployeeDaoImpl();
		update.update(employee);
		System.out.println("Employee Updated Successfully");
	}
}
