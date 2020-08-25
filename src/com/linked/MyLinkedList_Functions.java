package com.linked;

public class MyLinkedList_Functions {
	private Node head;
	
	// PushFront
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
	
	// TopFront - Return front item
	public Node TopFront()
	{
		if (this.head != null)
		{
			return this.head;
		}
		else
		{
			System.out.println("Empty Linked List. No Front item to return");
			return null;
		}
	}
	
	// PopFront - remove front item
	public void PopFront()
	{
		if (this.head != null)
		{
			this.head = this.head.next;
		}
		else
		{
			System.out.println("Empty Linked List. No Front item to remove");
		}
	}
	
	// PushBack
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
	
	// TopBack - return back item
	public Node TopBack()
	{
		if (this.head != null)
		{
			Node temp = this.head;
			
			while (temp.next != null)
			{
				temp = temp.next;
			}
			
			return temp;
		}
		else 
		{
			System.out.println("Empty Liked List. No back item to return");
			return null;
		}
	}
	
	// PopBack - remove back item
	public void PopBack()
	{
		if (this.head != null)
		{
			Node temp = this.head;
			
			while (temp.next.next != null)
			{
				temp = temp.next;
			}
			
			temp.next = null;
		}
		
		else
		{
			System.out.println("Empty Linked List. No back item to pop");
		}
		
	}
	
	//Find - is key in list
	public boolean find(int data)
	{
		if (this.head != null)
		{
			Node temp = this.head;
			
			while (temp.next != null)
			{
				if (temp.data == data)
				{
					return true;
				}
			}
			
			return false;
		}
		else return false;

	}
	
	// IsEmpty
	public boolean IsEmpty()
	{
		if (this.head == null) return true;
		else return false;
	}
	
	public void InsertAfterkthNode(int data,int k)
	{
		if (k > getLength()) return;
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
	// Pop
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
		int i = 1;
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
	
	public int getLength()
	{
		Node temp = this.head;
		int count = 0;
		while (temp != null)
		{
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	public static void main(String[] args) {
		MyLinkedList_Functions ll_func_api = new MyLinkedList_Functions();
		ll_func_api.InsertAtBeginning(10);
		ll_func_api.InsertAtBeginning(15);
		ll_func_api.InsertAtEnd(12);
		ll_func_api.InsertAfterkthNode(7, 2);
		ll_func_api.InsertAfterkthNode(30, 0);
		ll_func_api.InsertAfterkthNode(13, 3);
		ll_func_api.PopBack();
		ll_func_api.PopFront();
		ll_func_api.DeleteNode(2);
		
		
		ll_func_api.print();
		System.out.println();
		System.out.println(ll_func_api.TopBack().data);
		System.out.println(ll_func_api.TopFront().data);
		
	}

}


