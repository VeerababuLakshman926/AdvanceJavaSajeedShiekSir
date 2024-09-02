package com.dl.isa;

//IS A : Inheritance
class Parent {
	
	public void m1(int a, int b) {
		System.out.println(a);
		System.out.println(b);
	}
}

class Child extends Parent{
	
	public void m2(int a, int b) {
		System.out.println(a);
		System.out.println(b);
	}
}

public class Test {
	
	public static void main(String[] args) {
		Child child = new Child();
		child.m1(1, 2);
		child.m2(4, 5);
	}
}
