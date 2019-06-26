/*
 * Queue is FIFO (First In First Out)
 */
package com.linked;

public class LinkedQueue 
{
	Node front;
	Node rear;
	
	public void enqueue(int data)
	{
		if (this.front == null)
		{
			Node temp = new Node(data);
			this.front = temp;
			this.rear = temp;
		}
		else
		{
			this.rear.next = new Node(data);
			this.rear = this.rear.next;
		}
	}
	
	public int dequeue()
	{
		if (this.front == null)
		{
			return 0;
		}
		else
		{
			Node temp = this.front;
			this.front = temp.next;
			temp.next = null;
			return temp.data;
		}
	}
	
	public void print()
	{
	Node temp = this.front;
	while (temp != null)
	{
		System.out.print(temp.data +" ");
		temp = temp.next;
	}
	}

	public static void main(String[] args) 
	{
		LinkedQueue lq = new LinkedQueue();
		lq.enqueue(10);
		lq.enqueue(20);
		lq.enqueue(33);
		lq.enqueue(56);
		lq.print();
		System.out.println();
		System.out.println(lq.dequeue());
		lq.print();
		System.out.println();
		System.out.println(lq.dequeue());
		lq.print();
		System.out.println();
		System.out.println(lq.dequeue());
		lq.print();
		System.out.println();
		System.out.println(lq.dequeue());
		lq.print();
		System.out.println();
		System.out.println(lq.dequeue());
		lq.print();
		

	}

}
