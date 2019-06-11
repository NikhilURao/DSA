package com.objects_and_class_in_java;
// Java program to illustrate how to define a class and fields
//Defining a student class
public class Student {
//defining fields
	int id;//fields or data member or instance variable
	String name;
//creating main method inside the student class
	public static void main(String[] args) {
//Creating an object or instance s1 that uses class student as a template
		Student s1 = new Student();
// /Printing values of the object  
		System.out.println(s1.id);//accessing member through reference variable	
		System.out.println(s1.name);
	}

}
