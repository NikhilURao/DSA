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
		else
		{
			
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
		sl.SortInsert(15);
		sl.print();

	}

}
