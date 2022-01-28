package com.linked;

import java.util.LinkedList;

public class MiddleNodeSLL 
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
		Node n = new Node(data);
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
	public void findMiddleNode()
	{
		Node temp1 = this.head;
		Node temp2 = this.head;
		int count = 0;
		while (temp2 != null && temp2.next != null)
		{
			temp1 = temp1.next;
			temp2 = temp2.next.next;
			count++;
		}
		System.out.println("middle node is "+count+"\n"+"Data in middle node is "+temp1.data);
	}
	/*
	 * Middle element of linked list
Problem Description

Given a linked list of integers. Find and return the middle element of the linked list.

NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.



Problem Constraints
1 <= length of the linked list <= 100000

1 <= Node value <= 109



Input Format
The only argument given head pointer of linked list.



Output Format
Return the middle element of the linked list.



Example Input
Input 1:

 1 -> 2 -> 3 -> 4 -> 5
Input 2:

 1 -> 5 -> 6 -> 2 -> 3 -> 4


Example Output
Output 1:

 3
Output 2:

 2


Example Explanation
Explanation 1:

 The middle element is 3.
Explanation 2:

 The middle element in even length linked list of length N is ((N/2) + 1)th element which is 2.
	 */
	public int findMiddleNode2() {
		if (this.head!=null) {
			int len = 0;
			Node temp1 = this.head;
			// calculating the length. 0 based index for len
			while (temp1.next != null) {
				temp1 = temp1.next;
				len++;
			}
			//System.out.println("length: "+len);
			// temp2 to iterate once
			Node temp2 = this.head;
			/*
			 * // temp3 travels twice as faster than temp2 (hare and tortoise approach). 
			 * while temp3 travels the entire LL, temp2 will be reaching exactly the middle of the LL
			 */
			Node temp3 = this.head;
			while (temp3!=null && temp3.next!=null && temp3.next.next!=null) {
				temp2 = temp2.next;
				temp3 = temp3.next.next;
			}
			// for even len -> middle is (len/2)+1 th index
			if ((len+1)%2 == 0) {
				return temp2.next.data;
			}
			// for odd len -> middle is (len/2) th index
			else {
				return temp2.data;
			}
			
		}
		else {
			return -1;
		}

		
	}

	public static void main(String [ ] ar)
	{
		MiddleNodeSLL sl = new MiddleNodeSLL();
		sl.add(14);
		sl.add(42);
		sl.add(98);
		sl.add(26);
		sl.add(36);
		sl.add(28);
		sl.add(57);
		sl.add(93);
		sl.add(33);
		sl.add(22);
		sl.add(55);
		sl.add(99);
		sl.print();
		sl.findMiddleNode();
		System.out.println(sl.findMiddleNode2());
	}
}
