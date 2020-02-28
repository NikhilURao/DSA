// Java program to implement Queue using  
// two stacks with costly enQueue()  
package com.stack;

import java.util.EmptyStackException;

public class QueueUsingStack 
	{
		Node head1;// For Stack1

		Node head2;// For Stack2
		
		//Implementing Stack1 (LIFO) using Linked List 
		public void push_S1(int data)
		{
			if (this.head1 == null)
			{
				head1 = new Node(data);
			}
			else 
			{
				Node temp = new Node(data);
				temp.next = this.head1;
				this.head1 = temp;
				
			}
		}
		
		public int pop_S1() throws EmptyStackException
		{
			if (this.head1 == null)
			{
				System.out.println("Stack Empty");
				throw new EmptyStackException();
			}
			else
			{
				Node temp = this.head1;
				this.head1 = this.head1.next;
				temp.next = null;
				return temp.data;
			}
		}
		
		public int peek_s1() throws EmptyStackException
		{
			if (this.head1!=null)
			{
				return this.head1.data;
			}
			else
				throw new EmptyStackException();
		}
		
		public boolean isEmpty_S1()
		{
			if (this.head1 == null)
				return true;
			return false;
		}
		
		//Implementing Stack2 (LIFO) using Linked List 
		public void push_S2(int data)
		{
			if (this.head2 == null)
			{
				head2 = new Node(data);
			}
			else 
			{
				Node temp = new Node(data);
				temp.next = this.head2;
				this.head2 = temp;
				
			}
		}
		
		public int pop_S2() throws EmptyStackException
		{
			if (this.head2 == null)
			{
				System.out.println("Stack Empty");
				throw new EmptyStackException();
			}
			else
			{
				Node temp = this.head2;
				this.head2 = this.head2.next;
				temp.next = null;
				return temp.data;
			}
		}
		
		public int peek_s2() throws EmptyStackException
		{
			if (this.head2!=null)
			{
				return this.head2.data;
			}
			else
				throw new EmptyStackException();
		}
		
		public boolean isEmpty_S2()
		{
			if (this.head2 == null)
				return true;
			return false;
		}
		
		// Implementation Queue using 2 Stacks S1 and S2
		
		public void Enqueue(int data)
		{
			while (!isEmpty_S1())
			{
				push_S2(pop_S1());
			}
			
			push_S1(data);
			
			while (!isEmpty_S2())
			{
				push_S1(pop_S2());
			}
			
		}
		
		public int Dequeue() throws NullPointerException
		{
			if (isEmpty_S1())
			{
				System.out.println("Empty Queue");
				throw new NullPointerException();
			}
			
			else
			{
				int temp = peek_s1();
				pop_S1();
				return temp;
			}
		}
		
		public void printQueue()
		{
			
		}
		
		
		
	public static void main(String[] args) {
		QueueUsingStack qus = new QueueUsingStack();
		

	}

}
