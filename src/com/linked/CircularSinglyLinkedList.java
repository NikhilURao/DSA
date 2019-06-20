package com.linked;

public class CircularSinglyLinkedList 
{

	private Node head;
	
	public void Insert(int data)
	{
		if (this.head == null)
		{
			Node FirstNode = new Node(data);
			this.head = FirstNode;
			FirstNode.next = FirstNode;
			
		}
		else 
		{
			Node temp = this.head;
			while (temp.next != head )
			{
				temp = temp.next;
			}
			Node node = new Node(data);
			temp.next = node;
			node.next = this.head;
			
		}
	}
	public void print()
	{
		Node temp = this.head;
		while (temp.next != head)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.print(temp.data);
	}
	
}
