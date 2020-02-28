/*
 * There are two singly linked lists in a system. By some programming error, 
 * the end node of one of the linked list got linked to the second list,
 *  forming an inverted Y shaped list
 */
package com.linked;

import java.util.*;

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
	
	public int getIntersectionPointUsingDiffNode()
	{
		Node temp1 = this.head1;
		Node temp2 = this.head2;
		int intersection_pt = 0;
		int count1=0;
		int count2=0;
		int dif=0;
		
		while (temp1!=null)
		{
			temp1 = temp1.next;
			count1++;
		}
		while (temp2!=null)
		{
			temp2 = temp2.next;
			count2++;
		}
		
		temp1 = this.head1;
		temp2 = this.head2;
		
		if (count1 > count2)
		{
			 dif = count1-count2;
			 int i=0;
			 while (temp1!=null && i<dif)
			 {
				 temp1 = temp1.next;
				 i++;
			 }
		}
		else
		{
			dif = count2-count1;
			int i=0;
			while (temp2!=null && i<dif)
			{
				temp2 = temp2.next;
				i++;
			}
		}
		
		while (temp1 != null && temp2 != null)
		{
			if (temp1.next == temp2.next)
			{
				intersection_pt = temp1.next.data;
				break;
			}
			
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		
		return intersection_pt;
		
	}
	
	public int getIntersectionUsingHashSet()
	{
		HashSet<Node> hs = new HashSet<Node>();
		Node temp1 = this.head1;
		Node temp2 = this.head2;
		int res = 0;
		
		while (temp2!=null)
		{
			hs.add(temp2);
			temp2 = temp2.next;
		}
		
		while (temp1.next!=null)
		{
			if (hs.contains(temp1))
			{
				res = temp1.data;
			}
			
			temp1 = temp1.next;
		}
		
		return res;
	}
	
	
	public static void main(String [] args) {
		
		IntersectionPoint ip = new IntersectionPoint();
		/*
		ip.createIntersectedLinkedList(10, 0);
		ip.createIntersectedLinkedList(20, 0);
		ip.createIntersectedLinkedList(15, 0);
		ip.createIntersectedLinkedList(40, 0);
		ip.createIntersectedLinkedList(35, 15);
		*/
		
		ip.head1 = new Node (10);
		ip.head1.next = new Node (6);
		ip.head1.next.next = new Node (13);
		ip.head1.next.next.next= new Node (34);
		ip.head1.next.next.next.next = new Node (50);
		ip.head2 = new Node(21);
		ip.head2.next = new Node(32);
		ip.head2.next.next = ip.head1.next.next.next;
		
		
		ip.print1();
		System.out.println();
		ip.print2();
		System.out.println();
		System.out.println(ip.getIntersectionPointUsingDiffNode());
		System.out.println(ip.getIntersectionUsingHashSet());
		

	}
}
