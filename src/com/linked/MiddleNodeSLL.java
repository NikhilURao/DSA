package com.linked;

import java.util.LinkedList;

public class MiddleNodeSLL 
{
	private Node head;
	
	public void add(int data)
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
		Node n = new Node(data);
		temp.next = n;
		}
	}
	
	public void print()
	{
		Node temp = this.head;
		while (temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	public void findMiddleNode()
	{
		Node temp1 = this.head;
		Node temp2 = this.head;
		int count = 0;
		while (temp2 != null && temp2.next != null)
		{
			temp1 = temp1.next;
			temp2 = temp2.next.next;
			count++;
		}
		System.out.println("middle node is "+count+"\n"+"Data in middle node is "+temp1.data);
	}

	public static void main(String [ ] ar)
	{
		MiddleNodeSLL sl = new MiddleNodeSLL();
		sl.add(10);
		sl.add(15);
		sl.add(21);
		sl.add(22);
		sl.print();
		sl.findMiddleNode();
	}
}
