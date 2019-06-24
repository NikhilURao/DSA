package com.linked;

public class PrintRevLL 
{
	private Node head;
	
	public void add(int data)
	{
		if (this.head == null)
		{
			this.head = new Node(data);
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
	
	public void print()
	{
		Node temp = this.head;
		
		while (temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	public int getNodeCount()
	{
		Node temp = this.head;
		int i=0;
		
		if (this.head == null)
		{
			return 0;
		}
		
		while (temp != null)
		{
			temp = temp.next;
			i++;
		}
		
		return i;
	}
	
	public void printkthNodeData(int k)
	{
		int i=1;
		Node temp = this.head;
		
		while (i < k)
		{
			temp = temp.next;
			i++;
		}
		System.out.print(temp.data+" ");
		
	}
	
	public void printReverseLL()
	{
		int countofnodes = getNodeCount();
		for (int i = countofnodes ; i > 0 ; i--)
		{
			printkthNodeData(i);
		}
	}
	
	public void revrec(Node temp)
	{
		if (temp != null)
		{
			revrec(temp.next);
			System.out.print(temp.data+" ");
		}
	}
	
	public void revrec()
	{
		 revrec(this.head);
		
	}
	
	public static void main(String[] args) 
	{
		PrintRevLL ll = new PrintRevLL();
		ll.add(10);
		ll.add(27);
		ll.add(26);
		ll.add(45);
		ll.print();
		System.out.println("");
//		System.out.println(ll.getNodeCount());
//		ll.printkthNodeData(2);
//		System.out.println("");
//		ll.printReverseLL();
		ll.revrec();
		

	}
}
