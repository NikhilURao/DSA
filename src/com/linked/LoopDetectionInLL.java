package com.linked;

import java.util.HashSet;

public class LoopDetectionInLL {
	
	Node head;
	
	public void Insert_LL(int data) 
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
	
	// Detect Loop or Cycle using Hash Table
	public boolean detectLoopWithHashTable()
	{
		HashSet<Node> hs = new HashSet<Node>();
		Node temp = this.head;
		
		while (temp.next != null)
		{
			if(hs.contains(temp))
			{
				return true;
			}
			else 
			{
				hs.add(temp);
			}
			
			temp = temp.next;
		}
		
		return false;
		
	}
	// Detect Loop and Loop starting Node 
	//using Floyd’s Cycle-Finding Algorithm (Hare and Tortoise)
	
	public boolean detectLoop()
	{
		Node temp1 = this.head;
		Node temp2 = this.head;
		while (temp1 != null && temp2 != null && temp2.next != null)
		{
			temp1 = temp1.next;
			temp2 = temp2.next.next;
			
			if (temp1 == temp2)
			{
				return true;
			}
		}
		
		return false;
		
	}

	
	public int detectLoopStartingNode()
	{
		Node temp1 = this.head;
		Node temp2 = this.head;
		Node ptr1 = this.head;
		Node ptr2 = null;
		while (temp1 != null && temp2 != null && temp2.next != null)
		{
			temp1 = temp1.next;
			temp2 = temp2.next.next;
			
			if (temp1 == temp2)
			{
				ptr2 = temp1;
				break;
			}	
		}
		
		while (ptr1 != ptr2)
		{
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;	
		}
		
		return ptr1.data;
		
	}
	public static void main(String[] args) {
		LoopDetectionInLL lpd = new LoopDetectionInLL();
		lpd.Insert_LL(1);
		lpd.Insert_LL(11);
		lpd.Insert_LL(22);
		lpd.Insert_LL(2);
		lpd.Insert_LL(23);
		lpd.Insert_LL(45);
		lpd.Insert_LL(8);
		
		//System.out.println(lpd.detectLoopWithHashTable());
		System.out.println(lpd.detectLoop());
		
		lpd.head = new Node(33);
		lpd.head.next = new Node (4);
		lpd.head.next.next = new Node(7);
		lpd.head.next.next.next = new Node(11);
		lpd.head.next.next.next = lpd.head.next;		
		
		//System.out.println(lpd.detectLoopWithHashTable());
		System.out.println(lpd.detectLoop());
		System.out.println(lpd.detectLoopStartingNode());
		
		
		

	}

}
