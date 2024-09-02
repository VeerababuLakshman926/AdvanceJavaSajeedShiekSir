package com.dl.dao;

import com.dl.model.Employee;

public interface EmployeeDao {
	
	Employee findById(Long id);
	
	void save(Employee employee);
	
	void update(Employee employee);
	
	void delete(Long id);
	
	//Insert Multiple records
	//get same names records
	// select using letter

}
