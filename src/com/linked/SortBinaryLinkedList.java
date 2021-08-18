/*
 * Problem Description

Given a Linked List A consisting of N nodes.

The Linked List is binary i.e data values in the linked list nodes consist of only 0's and 1's.

You need to sort the linked list and return the new linked list.

Input: 1 -> 0 -> 0 -> 1
Output: 0 -> 0 -> 1 -> 1
 */
package com.linked;

public class SortBinaryLinkedList {
	// brute force
	public Node sort(Node head)
	{
		int c0 = 0;
		int c1 = 0;
		Node temp = head;
		
		while (temp != null)
		{
			if (temp.data == 1)
				c1++;
			else 
				c0++;
			temp = temp.next;
		}

		Node newhead = null;
		
		while (c0 != 0)
		{
			if (newhead == null)
			{
				newhead = new Node(0);
			}
			else
			{
				Node n = new Node(0);
				n.next = newhead;
				newhead = n;
			}
			
			c0--;
		}

		while (c1 != 0)
		{
			if (newhead == null)
			{
				newhead = new Node(1);
			}
			else
			{
				Node ptr = newhead;
				while (ptr.next != null)
				{
					ptr = ptr.next;
				}
				ptr.next = new Node(1);
			}
			c1--;
		}
		
		return newhead;
	}
	
	public Node sort0s1s(Node head)
	{
		int count[] = {0,0};
		Node ptr = head;
		
		while (ptr != null)
		{
			count[ptr.data]++;
			ptr = ptr.next;
		}
		
		int i=0;
		ptr = head;
		
		while(ptr != null)
		{
			if (count[i] == 0)
				i++;
			else
			{
				ptr.data = i;
				--count[i];
				ptr = ptr.next;
			}
		}
			
		
		return head;
	}
	
	public Node sort01(Node head)
	{
		Node zeron = new Node(0);
		Node onen = new Node(0);
		Node zero = zeron;
		Node one = onen;
		Node ptr = head;
		
		while (ptr != null)
		{
			if (ptr.data == 0)
			{
				
			}
		}
		
		
		
		return head;
	}
	

	public static void main(String[] args) {
		Node node1 = new Node(0);
		Node node2 = new Node(1);
		node1.next = node2;
		Node head = node1;
		
		System.out.println("Before Sorting Binary Likned List of 0s and 1s");
		Node ptr = head;
		while (ptr!=null)
		{
			System.out.print(ptr.data+" ");
			ptr = ptr.next;
		}
		System.out.println();
		SortBinaryLinkedList sbll = new SortBinaryLinkedList();
		//Node head1 = sbll.sort(head);
		Node head1 = sbll.sort0s1s(head);
		System.out.println("After Sorting Binary Likned List of 0s and 1s");
		Node ptr1 = head1;
		while (ptr1!=null)
		{
			System.out.print(ptr1.data+" ");
			ptr1 = ptr1.next;
		}

	}

}
