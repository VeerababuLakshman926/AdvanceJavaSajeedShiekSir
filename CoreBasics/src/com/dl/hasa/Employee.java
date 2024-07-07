package com.dl.hasa;

public class Employee {
	
	int id;
	String name;
	Address address; //data member
	
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
		this.address = new Address("HYD", "TG", "INDIA"); //composition 
	}
	
	public void display() {
		System.out.println(id + " " + name + " " + address.city + " " + address.state + " " + address.country);
	}
	
	public static void main(String[] args) {
		
		
		Employee employee = new Employee(101, "Raju");
		employee.display();
		
		//if employee = null; then contained object address is also destroyed.
	}
}
