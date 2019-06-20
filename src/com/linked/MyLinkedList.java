package com.linked;

public class MyLinkedList {
	
	private Node head;
	
	public void add(int data)
	{
		if(this.head==null)
		{
			this.head=new Node(data);
		}
		else
		{
			/*
			 * Node temp=new Node(data); temp.next=this.head; this.head=temp;
			 */
			
			Node temp=this.head;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			
			temp.next=new Node(data);
		}
	}
	
	
	public void print()
	{
		Node temp=this.head;
		
		while(temp!=null)
		{
			System.out.print(temp.data+"  ");
			temp=temp.next;
		}
		
	}
	
	

}
