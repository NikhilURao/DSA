package com.linked;

public class NthNodeFromTail {
	Node head;
	
	public void add(int data)
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
	
	public int returnnthfromtail(int postionfromtail)
	{
		Node tail = null;
		
		while (this.head != null)
		{
			Node ptr = this.head;
			this.head = this.head.next;
			ptr.next = null;
			
			if (tail == null)
			{
				tail = ptr;
			}
			else
			{
				ptr.next = tail;
				tail = ptr;
			}	
		}
			Node temp = tail;
			int i=0;
			while (temp.next != null && i< postionfromtail)
			{
				temp = temp.next;
				i++;
			}
			
			
			return temp.data;
	}
	
	public void print(Node head)
	{
		Node nur = head;
		while (nur != null)
		{
			System.out.print(nur.data+" ");
			nur = nur.next;
		}
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NthNodeFromTail nft = new NthNodeFromTail();
		nft.add(10);
		nft.add(20);
		nft.add(30);
		nft.add(40);
		nft.add(50);
		nft.print(nft.head);
		System.out.println();
		System.out.println(nft.returnnthfromtail(2));
		
		
		

	}

}
