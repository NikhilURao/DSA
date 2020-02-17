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
	
	public void InsertAtkthPosition(int data, int k)
	{
		Node temp = this.head;
		int i = 1;
		
		while (temp != null && i < k)
		{
			i++;
			temp = temp.next;
		}
		//System.out.println(temp.data);
		
		Node newNode = new Node(data);
		newNode.next = temp;
		temp.prev.next = newNode;
		newNode.prev = temp.prev;
		temp.prev = null;
		
		
	}
	
	public void deleteFirstNode()
	{
		Node temp = this.head;
		this.head = this.head.next;
		this.head.prev = null;
		temp.next = null;
	}
	
	public void deleteLastNode()
	{
		Node temp = this.head;
		
		while (temp.next != null)
		{
			temp = temp.next;
		}
		System.out.println(this.head.data);
		System.out.println();
		System.out.println(temp.prev.data);
		 
	}
	public void print()
	{
		Node temp = this.head;
		while (temp!= null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println(this.head.next);
		System.out.println(this.head.next.next.prev);

	}
	
public static void main(String [] args)
{
	MyDoublyLinkedList dll = new MyDoublyLinkedList();
	dll.InsertAtBeginning(10);
	dll.InsertAtBeginning(20);
	dll.InsertAtEnd(45);
	dll.InsertAtkthPosition(25, 2);
	//dll.deleteFirstNode();
	//dll.deleteLastNode();
	dll.print();
}

}
