/*
 * Merge Two Sorted Lists
 * 
 * Problem Description

Merge two sorted linked lists A and B and return it as a new list.

The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.



Problem Constraints

0 <= |A|, |B| <= 105



Input Format

The first argument of input contains a pointer to the head of linked list A.

The second argument of input contains a pointer to the head of linked list B.



Output Format

Return a pointer to the head of the merged linked list.



Example Input

Input 1:

 A = 5 -> 8 -> 20
 B = 4 -> 11 -> 15
Input 2:

 A = 1 -> 2 -> 3
 B = Null


Example Output

Output 1:

 4 -> 5 -> 8 -> 11 -> 15 -> 20
Output 2:

 1 -> 2 -> 3


Example Explanation

Explanation 1:

 Merging A and B will result in 4 -> 5 -> 8 -> 11 -> 15 -> 20 
Explanation 2:

 We don't need to merge as B is empty. 
 */
package com.linked;

public class Merge2SortedLL {
	
	/* 
	 * There are 2 approaches of solving this problem.
	 * 1st Approach: In place. Keep head1 intact. Take each node of LL2, 
	 * compare and insert at the correct position in LL1. This is in place i.e. SC: O(1) constant space
	 */
	
	public static Node mergeSortedInPlace(Node head1, Node head2) {
		if (head1==null && head2!=null) {
			return head2;
		}
		else if (head2==null && head1!=null) {
			return head2;
		}
		else {
			while (head2!=null) {
				Node ptr = head2;
				head2 = head2.next;
				ptr.next = null;
				
				if (ptr.data < head1.data) {
					ptr.next = head1;
					head1 = ptr;
				}
				else {
					Node temp = head1;
					while (temp.next!=null && ptr.data > temp.next.data) {
						temp = temp.next;
					}
					ptr.next = temp.next;
					temp.next = ptr;
					}	
			}
			
			return head1;

		}
	}
	/*
	 * 2nd Approach: Create a new Linked List by creating a dummy head node. 
	 * Compare the 2 heads i.e. head1.data and head2.data.
	 * Whichever is the smaller, add to the end of new Linked List.
	 * Do so until one/both of the LL is empty, copy the nodes of the other linked list as is at the end of the new linked list.
	 * TC => O(M+N) if M and N are the lengths of LL1 and LL2 respectively.
	 * SC => O(M+N) Non-inplace
	 */
	
	public static Node mergeSortedIntoNewLL(Node head1, Node head2) {
		if (head1==null && head2!=null) {
			return head2;
		}
		else if (head2==null && head1!=null) {
			return head2;
		}
		else if(head1==null && head2==null) {
			return null;
		}
		else {
			Node dummyHead = new Node(-1);
			Node dummyTail = dummyHead;
			Node ptr;
			while (head1!=null && head2!=null) {
				if (head1.data < head2.data) {
					ptr = head1;
					head1 = head1.next;
					ptr.next = null;
				}
				else {
					ptr = head2;
					head2 = head2.next;
					ptr.next = null;
				}
				dummyTail.next = ptr;
				dummyTail = dummyTail.next;
				
			}
			if (head1!=null)
			{
				while (head1!= null) {
					dummyTail.next =head1;
					dummyTail = dummyTail.next;
					head1 = head1.next;
				}

			}
			if (head2!=null)
			{
				while (head2!= null) {
					dummyTail.next =head2;
					dummyTail = dummyTail.next;
					head2 = head2.next;
				}

			}
			return dummyHead.next;
		}
	}
	
	public static void printLL(Node head) {
		if (head!=null) {
			Node ptr = head;
			while (ptr!=null) {	
				System.out.print(ptr.data+" ");
				ptr = ptr.next;
			}
		}	
	}
	

	public static void main(String[] args) {
		Node head1 = new Node(1);head1.next = new Node(2);head1.next.next = new Node(3);
		Node head2 = new Node(4); head2.next = new Node(5);head2.next.next = new Node(6);//head2.next.next.next = new Node(15);
		System.out.println("Sorted LL1");
		printLL(head1);
		System.out.println();
		System.out.println("Sorted LL2");
		printLL(head2);
		System.out.println();
		System.out.println("Merge Sorted LL");
		//head1 = mergeSortedInPlace(head1, head2);
		head1 = mergeSortedIntoNewLL(head1, head2);
		printLL(head1);

	}

}
