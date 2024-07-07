package com.dl.noInjection;

public class Client {
	
	public static void main(String[] args) {
		
		Brand b = new Car();
		b.honda();
		
		b = new Bike();
		b.honda();
	}

}
