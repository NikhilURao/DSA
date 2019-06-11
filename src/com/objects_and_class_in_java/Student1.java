/*
 * There are 3 ways to initialize objects in Java
 * 1.By reference variables
 * 2.By method
 * 3.By constructor
 */
package com.objects_and_class_in_java;

public class Student1 {
	int id;
	String name;
//Creating a method to initialize an object. 
//Setter Method
	public void Insert(int i,String n) {
		id =i;
		name=n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student1 s= new Student1();
		Student1 s1 = new Student1();
//initializing objects in Java by reference variables
		s.id=101;
		s.name = "Niks";
		System.out.println(s.id);
		System.out.println(s.name);
//initializing objects in Java by method
		s1.Insert(103, "Megs");
		System.out.println(s1.id+" "+s1.name);
	}

}
