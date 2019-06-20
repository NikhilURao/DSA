package com.core;

class Node
{
	int data;
	Node next;
	
	Node(int data)
	{
		this.data=data;
	}
}

public class MtLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node n1=new Node(10);
		Node n2=new Node(20);
		n1.next=n2;
		Node n3=new Node(30);
		n2.next=n3;
		Node n4=new Node(40);
		n3.next=n4;
		
		
		/*
		 * System.out.println(n1.data); System.out.println(n1.next.data);
		 * System.out.println(n1.next.next.data);
		 * System.out.println(n1.next.next.next.data);
		 */
		
		Node temp=n1;
		
		while(temp!=null)
		{
			System.out.println(temp.data);
			temp=temp.next;
		}
		
		
		

	}

}
