package com.linked;

public class RecRevPrintLL {
	public Node head;

	public void Print_Rev_Rec(Node head) 
	{
		if (head!=null) 
		{
			Print_Rev_Rec(head.next);
			System.out.print(head.data+" ");
		}
		
	}
	
	public void add(int data) 
	{		
		if (this.head==null)
		{
			System.out.println("111");
			Node n = new Node(data);
			this.head = n; 
		}
		else {
			Node n = new Node(data);
			n.next = this.head;
			this.head = n;
			
		}
	}
	public void print()
	{
		Node temp = this.head;
		while (temp != null)
		{
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}


	public static void main(String[] args) {
		
		RecRevPrintLL pnr = new RecRevPrintLL() ;
		pnr.add(10);
		pnr.add(20);
		pnr.add(30);
		pnr.add(40);
		pnr.print();
		System.out.println();
		pnr.Print_Rev_Rec(pnr.head);
	}

}
