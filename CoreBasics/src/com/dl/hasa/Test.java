//package com.dl.hasa;
//
//// HAS A : Using class as a data member
//class Address{
//	
//	public String address;
//
//	public Address(String address) {
//		this.address = address;
//	}
//
//	@Override
//	public String toString() {
//		return address;
//	}
//	
//	
//	
//}
//
//class Employee{
//	public Address address;
//	
//	
//	public Employee(Address address) {
//		this.address = address;
//	}
//
//
//	public void EmployeeDetails(String empName, String empDepartment) {
//		System.out.println(empName);
//		System.out.println(empDepartment);
//		System.out.println(this.address);
//		
//	}
//	
//}
//
//public class Test {
//	
//	public static void main(String[] args) {
//		Address address1 = new Address("Hitech City");
//		Employee employee = new Employee(address1);
//		employee.EmployeeDetails("Raju", "Developer");
//		
//		
//	}
//
//}
