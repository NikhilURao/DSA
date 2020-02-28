package com.trees;

public class Queue 
{
	QNode front;
	QNode rear;
	
	public boolean isEmpty()
	{
		if (this.front == null && this.rear == null)
		{
			return true;
		}
		return false;
	}
	
	public void enqueue(BTNode data)
	{
		if (this.isEmpty())
		{
			this.front = this.rear = new QNode(data);
		}
		else 
		{
			rear.next = new QNode(data);
			rear = rear.next;
		}
	}
	
	public BTNode dequeue()
	{
		if (this.isEmpty())
		{
			return null;
		}
		else if (this.front == this.rear)
		{
			BTNode temp = this.front.data;
			this.front = this.rear = null;
			return temp;
		}
		else 
		{
			BTNode temp = this.front.data;
			this.front = this.front.next;
			return temp;
		}
	}

}
