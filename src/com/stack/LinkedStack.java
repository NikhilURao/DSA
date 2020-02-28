/*
 * Stack is LIFO (Last In First Out) or FILO (First In Last Out)
 * terminology : push -> add data ; pop -> delete 
 */

package com.stack;

public class LinkedStack 
{
	private Node head;
	
	public void push(int data)
	{
		if (this.head == null)
		{
			this.head = new Node(data);
		}
		else
		{
			Node n = new Node(data);
			n.next = this.head;
			this.head = n;
		}
	}
	
	public int pop()
	{
		
		if (this.head == null)
		{
			System.out.println("Linked List Empty or Stack Underflow Exception");
			return 0;
		}
		else
		{
			Node temp = this.head;
			this.head = this.head.next;
			temp.next = null;
			return temp.data;
			
		}
	}
	
	public int top()
	{
		if (this.head == null)
		{
			System.out.println("Empty Linked List");
		}
		
			return this.head.data;

	}
	
	public int getLen()
	{
		int len = 0;
		Node ptr  = this.head;
		
		if (this.head == null)
		{
			return 0;
		}
		
		while (ptr.next != null)
		{
			ptr = ptr.next;
			len++;
		}
		
		return len+1;
	}
	
	public void print()
	{
		Node temp = this.head;
		while (temp != null)
		{
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) 
	{
		LinkedStack ls = new LinkedStack();
		ls.push(10);
		ls.push(67);
		ls.push(44);
		ls.push(98);
		ls.print();
		System.out.println();
		System.out.println(ls.top());
		System.out.println(ls.getLen());
		System.out.println(ls.pop());
		ls.print();
		System.out.println();
		System.out.println(ls.top());
		System.out.println(ls.pop());
		ls.print();
		System.out.println();
		System.out.println(ls.getLen());
		System.out.println(ls.pop());
		ls.print();
		System.out.println();
		System.out.println(ls.getLen());
		System.out.println(ls.pop());
		ls.print();
		System.out.println(ls.getLen());
		System.out.println(ls.pop());
		System.out.println(ls.getLen());
		

		


	}

}
