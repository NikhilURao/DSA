package com.doublylinked;

public class CircularDoublyLinkedList 
{
private Node head;

public void Insert(int data)
{
	if (this.head == null)
	{
		Node temp = new Node(data);
		this.head = temp;
		temp.prev = temp;
		temp.next = temp;
	}
	else 
	{
		Node temp = this.head;
		while (temp.next != this.head)
		{
			temp = temp.next;
		}
		Node node = new Node(data);
		temp.next = node;
		node.prev = temp;
		node.next = this.head;
		this.head.prev = node;
	}
}

public void print()
{
Node temp = this.head;
while (temp.next != this.head)
{
	System.out.print(temp.data+" ");
	temp = temp.next;
}
System.out.print(temp.data);
}
}
