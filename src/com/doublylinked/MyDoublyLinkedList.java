package com.doublylinked;

public class MyDoublyLinkedList {
	
	private Node head;
	
	public void InsertAtBeginning(int data)
	{
		if (this.head == null) 
		{
			this.head = new Node(data);
		}
		else 
		{
			Node temp = new Node(data);
			this.head.prev = temp;
			temp.next = this.head;
			this.head = temp;
		}
	}
	
	public void InsertAtEnd(int data)
	{
		if (this.head == null)
		{
			this.head = new Node(data);
		}
		else
		{
			Node temp = this.head;
			while (temp.next != null)
			{
				temp = temp.next;
			}
			Node lastnode = new Node(data);
			temp.next = lastnode;
			lastnode.prev = temp;
		}
	}
	public void print()
	{
		Node temp = this.head;
		while (temp!= null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
}
