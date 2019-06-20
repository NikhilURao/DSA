package com.linked;

public class MainLinkedDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		MyLinkedList_Functions al1=new MyLinkedList_Functions();
//		al1.InsertAtBeginning(10);
//		al1.InsertAtEnd(20);
//		al1.InsertAtBeginning(30);
//		al1.InsertAtBeginning(40);
//		al1.InsertAtEnd(50);
//		al1.InsertAfterkthNode(77, 8);
//		al1.DeleteNode(8);
//		
//		
////		MyLinkedList_Functions al2=new MyLinkedList_Functions();
////		al2.InsertAtEnd(20);
////		al2.InsertAtBeginning(10);
////		al2.InsertAtEnd(300);
//		
//		al1.print();
//		System.out.println();
//		//al2.print();
		
		CircularSinglyLinkedList cl = new CircularSinglyLinkedList();
		cl.Insert(10);
		cl.Insert(11);
		cl.Insert(56);
		cl.Insert(98);
		cl.Insert(45);
		cl.Insert(77);
		cl.print();
		

	}

}
