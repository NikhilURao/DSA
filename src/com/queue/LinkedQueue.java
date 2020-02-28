package com.queue;


public class LinkedQueue {
	
	public Node head;
	
	public void enqueue(int data)
	{
		if (this.head == null)
		{
			this.head = new Node (data);
		}
		else
		{
			Node temp = this.head;
			
			while (temp.next != null)
			{
				temp = temp.next;
			}
			
			temp.next = new Node(data);
		}
	}
	
	public int dequeue()
	{
		if (this.head == null)
		{
			System.out.println("Queue Empty");
			return -1;
		}
		else
		{
			Node temp = this.head;
			head = head.next;
			temp.next = null;
			return temp.data;
		}
	}
	
	public int front()
	{
		return this.head.data;
	}
	
	public void printQueue()
	{
		Node temp =  this.head;
		while (temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		
		LinkedQueue lq = new LinkedQueue();
		lq.enqueue(10);
		lq.enqueue(20);
		lq.enqueue(30);
		lq.enqueue(40);
		lq.printQueue();
		System.out.println();
		System.out.println(lq.dequeue());
		lq.printQueue();
		

	}

}
