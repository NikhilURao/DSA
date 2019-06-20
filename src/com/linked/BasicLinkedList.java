package com.linked;
//Creating Node class 
class Nodes
{
	int data;//variable to store data
	Nodes next;//reference variable next of type Nodes to store the reference of the next node
	
	Nodes(int data)//constructor to assign the value to the node
	{
		this.data = data;//this keyword to refer current class instance variable
	}
	
}

public class BasicLinkedList {
	
	public static void main(String [] args) 
	{
	Nodes n1 = new Nodes(10);// creating an object of type Nodes and assigning the value 10
	Nodes n2 = new Nodes(20);
	Nodes n3 = new Nodes(30);
	Nodes n4 = new Nodes(40);
	n1.next = n2;
	n2.next = n3;
	n3.next = n4;

		/*
		 * System.out.println(n1.data);//printing the data of node n1
		 * System.out.println(n1.next.data);//printing the data of node n2
		 * System.out.println(n1.next.next.data);//data of n3
		 * System.out.println(n1.next.next.next.data);//data of n4
		 */		 
	Nodes temp = n1;
	while (temp!=null)
	{
		System.out.println(temp.data);
		temp = temp.next;
	}
	
	}	
	
}
