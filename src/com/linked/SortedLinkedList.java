package com.linked;

public class SortedLinkedList 
{
	private Node head;
	
	public void SortInsert(int data)
	{
		if (this.head == null)
		{
			this.head = new Node(data);
		}
		else if(this.head.data > data)
 		{
				Node temp = new Node(data);
				temp.next = this.head;
				this.head = temp;
		}
		else 
		{
			Node temp = this.head;
			
			while (temp.next != null && temp.next.data < data )
			{
				temp = temp.next;
			}
			
			Node n = new Node(data);
			n.next = temp.next;
			temp.next = n;
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

	public static void main(String[] args) 
	{
		SortedLinkedList sl = new SortedLinkedList();
		sl.SortInsert(10);
		sl.SortInsert(5);
		sl.SortInsert(4);
		sl.SortInsert(3);
		sl.SortInsert(2);
		sl.SortInsert(5);
		sl.SortInsert(7);
		sl.print();

	}

}
