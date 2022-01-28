/*
 * Reorder List

 * Problem Description

Given a singly linked list A

 A: A0 → A1 → … → An-1 → An 
reorder it to:

 A0 → An → A1 → An-1 → A2 → An-2 → … 
You must do this in-place without altering the nodes' values.



Problem Constraints

1 <= |A| <= 106



Input Format

The first and the only argument of input contains a pointer to the head of the linked list A.



Output Format

Return a pointer to the head of the modified linked list.



Example Input

Input 1:

 A = [1, 2, 3, 4, 5] 
Input 2:

 A = [1, 2, 3, 4] 


Example Output

Output 1:

 [1, 5, 2, 4, 3] 
Output 2:

 [1, 4, 2, 3] 


Example Explanation

Explanation 1:

 The array will be arranged to [A0, An, A1, An-1, A2].
Explanation 2:

 The array will be arranged to [A0, An, A1, An-1, A2].
 */
package com.linked;

public class ReorderLL {
	
	public static Node reorder(Node head) {
		if (head==null || head.next == null) {
			return head;
		}
		else {
			// find the middle node in the Linked List
			Node mid = findMiddle(head);
			// break the LL into 2 linked lists around the mid. 1st LL -> 0 to mid | 2nd LL -> mid+1 to end 
			Node secondHead = mid.next;
			mid.next = null;
			// reverse the second LL
			secondHead = reverseLL(secondHead);
			// merge first LL and reverse of second LL pointed by secondHead
			head = mergeLL(head, secondHead);
			
			return head;
			
		}
	}
	
	public static Node findMiddle(Node head) {
		if (head==null) 
			return null;
		else {
			Node tortoise = head;
			Node hare = head;
			
			while (hare!=null && hare.next!=null && hare.next.next!=null) {
				tortoise = tortoise.next;
				hare = hare.next.next;
			}
			
			return tortoise;
		}
	}
	
	public static Node reverseLL(Node head) {
		if (head==null || head.next==null) {
			return head;
		}
		else {
			Node prev = null;
			Node cur = head;
			Node nxt = null;
			
			while (cur!=null) {
				nxt = cur.next;
				cur.next = prev;
				prev = cur;
				cur = nxt;
			}
			
			head = prev;
			return head;
		}
	}
	
	public static Node mergeLL (Node head1, Node head2) {
		
		if (head2==null) {
			return head1;
		}
		else {
			Node temp1 = head1;
			Node temp2 = head2;
			
			while (head2!=null) {
				temp2 = head2;
				head2 = head2.next;
				temp2.next = temp1.next;
				temp1.next = temp2;
				temp1 = temp1.next.next;
			}
			
			return head1;
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
		Node head1 = new Node(5);head1.next = new Node(9);head1.next.next = new Node(4);head1.next.next.next = new Node(6);head1.next.next.next.next = new Node(15);
		System.out.println("Input LL: ");
		printLL(head1);
		System.out.println();
		head1 = reorder(head1);
		System.out.println("reordered LL: ");
		printLL(head1);
	}

}
