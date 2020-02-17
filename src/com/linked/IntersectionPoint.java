/*
 * There are two singly linked lists in a system. By some programming error, 
 * the end node of one of the linked list got linked to the second list,
 *  forming an inverted Y shaped list
 */
package com.linked;

public class IntersectionPoint {
	Node head1;
	Node head2;

	public void createIntersectedLinkedList(int data1, int data2)
	{
		if (this.head1 == null)
		{
			this.head1 = new Node(data1);
		}
		else
		{
			Node temp = this.head1;
			while (temp.next != null)
			{
				temp = temp.next;
			}
			temp.next = new Node (data1);
		}
		
		if (data2 != 0)
		{
			this.head2 = new Node(data2);
			head2.next = head1.next.next.next;
		}
	}
	
	public void print1 ()
	{
		Node temp = this.head1;
		
		while (temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	public void print2 ()
	{
		Node temp = this.head2;
		
		while (temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	public Node getIntersectionPoint()
	{
		Node temp1 = this.head1;
		Node temp2 = this.head2;
		
		while (temp1 != null)
		{
			while (temp2 != null)
			{
				if (temp1.next == temp2.next)
				{
					return temp1.next;
				}
				temp2 = temp2.next;
			}
			temp1 = temp1.next;
		}
		return null;
	}
	public static void main(String [] args) {
		
		IntersectionPoint ip = new IntersectionPoint();
		ip.createIntersectedLinkedList(10, 0);
		ip.createIntersectedLinkedList(20, 0);
		ip.createIntersectedLinkedList(30, 0);
		ip.createIntersectedLinkedList(40, 0);
		ip.createIntersectedLinkedList(50, 15);
		
		ip.print1();
		System.out.println();
		ip.print2();
		
		ip.getIntersectionPoint();
		

	}
}
