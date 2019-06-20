package com.doublylinked;

public class MainDoublyLinkedList {

	public static void main(String[] args) 
	{
//		MyDoublyLinkedList dl1 = new MyDoublyLinkedList();
//		dl1.InsertAtBeginning(10);
//		dl1.InsertAtBeginning(30);
//		dl1.InsertAtBeginning(23);
//		dl1.InsertAtBeginning(23);
//		dl1.InsertAtBeginning(23);
//		dl1.InsertAtBeginning(23);
//		dl1.print();
//		System.out.println(" ");
//
//		MyDoublyLinkedList dl2 = new MyDoublyLinkedList();
//		dl2.InsertAtEnd(10);
//		dl2.InsertAtEnd(20);
//		dl2.InsertAtEnd(30);
//		dl2.InsertAtEnd(60);
//		dl2.print();
		
		
		CircularDoublyLinkedList cl = new CircularDoublyLinkedList();
		cl.Insert(10);
		cl.Insert(13);
		cl.Insert(17);
		cl.Insert(50);
		cl.Insert(99);
		cl.print();
	}

}
