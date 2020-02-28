/*
 * 5 Methods to Reverse a Linked List 
 */
package com.linked;

public class ReverseLinkedList 
{
	public Node head;
	
	public void RevLL1()
	{
		Node temp = this.head;
		while (temp.next != null) 
		{
			temp = temp.next;
		}
		while(this.head != temp) 
		{
			Node ptr = this.head;
			this.head = this.head.next;
			ptr.next = temp.next;
			temp.next = ptr;
		}
	}
	
	public void RevLL2()
	{
		Node temp = null;
		while(this.head != null)
		{
			Node ptr = this.head;
			this.head = this.head.next;
			ptr.next = null;	
			
			if (temp == null)
			{
				temp = ptr;
			}
			else
			{
				ptr.next = temp;
				temp = ptr;
			}
		}
		this.head = temp;
			
	}
	
	public void RevLL3()
	{
		Node prev = null;
		Node current = this.head;
		Node next = null;
		
		while (current != null)
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		this.head = prev;
	}
	
	public Node RevLL4(Node head)
	{
		if (head == null || head.next == null)
		{
			return head;
		}
		else
		{	//System.out.println("111");
			Node last = RevLL4(head.next);
			head.next.next = head;
			
			if (this.head == head)
			{
				this.head.next = null;
			}
			
			return last;
		}
	}
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
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	
	

	public static void main(String[] args) {
		ReverseLinkedList ll = new ReverseLinkedList();
		ll.add(10);
		ll.add(27);
		ll.add(26);
		ll.add(45);
		ll.print();
		/*
		System.out.println();
		ll.RevLL1();
		System.out.println();
		ll.print();
		System.out.println();
		ll.RevLL2();
		System.out.println();
		ll.print();
		System.out.println();
		ll.RevLL3();
		System.out.println();
		ll.print();
		System.out.println();
		*/
		ll.head = ll.RevLL4(ll.head);
		System.out.println();
		ll.print();

	}

}
