package com.linked;

public class MyLinkedList_Functions {
	private Node head;
	
	public void InsertAtBeginning(int data) 
	{
		
		if(this.head == null) 
		{
			this.head=new Node(data);
			
		}
		else 
		{
			Node temp = new Node(data);
			temp.next = this.head;
			this.head = temp;
		}
	}
	
	
	
	public void InsertAtEnd(int data)
	{ 
		if(this.head == null)
		{
			this.head = new Node(data);
		}
		else 
		{
		Node lastnode = this.head;
		
		while(lastnode.next != null)
		{
			lastnode = lastnode.next; 
		}
		lastnode.next = new Node(data);
		}
	}
	
	
	public void InsertAfterkthNode(int data,int k)
	{
		if (this.head == null || k==0)
		{
			Node temp = new Node(data);
			temp.next = this.head;
			this.head = temp;
		}
		else 
		{
			Node current = this.head;
			Node previous = null;
			int i=0;
			while(i < k && current.next != null )
			{
				previous = current;
				current = current.next;
				if (current == null)
				{
					break;
				}
				i++;
			}
			
			Node temp = new Node(data);
			temp.next = current;
			previous.next=temp;
		
		}
}
	
	public void DeleteNode(int pos)
	{
		if (this.head == null)
		{
			System.out.println("Cannot perform delete operation. No nodes present to delete");
		}
		else 
		{
		if (pos == 0)
		{
			this.head = head.next;
		}
		else 
		{ 			
		int i = 0;
		Node present=this.head;
		Node previous = null;
		//Node next = this.head.next;
			while (i < pos)
			{
				previous = present;
				present = present.next;
				if (present == null || present.next == null) 
				{
					break;
				}
				//System.out.println(present.data+","+previous.data);
				i++;
			}
			previous.next = present.next; 
		}
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
	
	public static void main(String[] args) {
		MyLinkedList_Functions ll_func = new MyLinkedList_Functions();
		ll_func.InsertAtEnd(10);
		ll_func.InsertAtEnd(20);
		ll_func.InsertAtEnd(30);
		ll_func.InsertAtEnd(40);
		ll_func.InsertAtEnd(50);
		ll_func.print();
	}

}


