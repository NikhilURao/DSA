package com.trees;

import java.util.EmptyStackException;

public class Stack
{
	StackNode head;
	
	public void push(BTNode data)
	{
		if (this.head == null)
		{
			this.head = new StackNode(data);
		}
		else
		{
			StackNode temp = new StackNode(data);
			temp.next = this.head;
			this.head = temp;
		}
	}
	
	public BTNode pop() throws EmptyStackException
	{
		if (this.head == null)
			throw new EmptyStackException();
		
		else
		{
			StackNode temp = this.head;
			this.head = this.head.next;
			temp.next = null;
			return temp.data;
		}
	}
	
	public boolean isEmpty()
	{
		if (this.head == null)
			return true;
		return false;
	}
	
	public BTNode top() throws EmptyStackException
	{
		if (this.head == null)
			return null;
			
		return this.head.data;
	}
}
