/*
 * Constructor :  constructor is a block of codes similar to the method. 
 * It is called when an instance of the class is created. 
 * At the time of calling constructor, memory for the object is allocated in the memory.
 * The default constructor is used to provide the default values to the object 
 * like 0, null, etc., depending on the type.
 * A constructor is used to initialize the state of an object.
 * A constructor must not have a return type.
 * The Java compiler provides a default constructor 
 * if you don't have any constructor in a class.
 * The constructor name must be same as the class name.
 * 
 */
package com.core;

class Product {
	int prid;
	String prname;
//A default Constructor which does not have any parameters.
//It prints as soon as the object of class Product is created
	Product(){
		System.out.println("Product has been created");
	}
//A parameterized Constructor has specific parameters
//The parameterized constructor is used to provide 
//different values to distinct objects. However, you can provide the same values also.	
	Product(int prid,String prname){
		this.prid = prid;
		this.prname = prname;
	}

}


public class ConstructorMain {

	public static void main(String[] args) {
		Product p = new Product();
		Product p1 = new Product(47761, "iPhone X 128MB");
		System.out.println(p1.prname);
	
		
		
	}

}
