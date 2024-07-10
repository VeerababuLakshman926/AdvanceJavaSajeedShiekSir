package com.dl.ambiguites;

public class Student {
	
	private int rollno;
	private double stipend;
	private String institute;
	
	public Student(int rollno, double stipend, String institute) {
		this.rollno = rollno;
		this.stipend = stipend;
		this.institute = institute;
	}
	
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", stipend=" + stipend + ", institute=" + institute + "]";
	}
	
	
}
