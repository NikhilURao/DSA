package com.core;
/*
 * this keyword in java
 * There can be a lot of usage of java this keyword. In java, 
 * this is a reference variable that refers to the current object.
 * 
 * Usage of java this keyword
 * Here is given the 6 usage of java this keyword.
 * this can be used to refer current class instance variable.
 * this can be used to invoke current class method (implicitly)
 * this() can be used to invoke current class constructor.
 * this can be passed as an argument in the method call.
 * this can be passed as argument in the constructor call.
 * this can be used to return the current class instance from the method.
*/
/**
 * 1) this: to refer current class instance variable
The this keyword can be used to refer current class instance variable. 
If there is ambiguity between the instance variables and parameters, 
this keyword resolves the problem of ambiguity.
 */
class StudentEg{
//instance variables of the class student	
	int id;
	String name;
	String city;
//Constructor method with the parameters same as the instance variables
StudentEg(int id,String name,String city){
	this.id = id;
	this.name = name;
	this.city = city;
	}
void display() {
	System.out.println("Student info :");
}
}


public class this_keyword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
