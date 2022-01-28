/*
 * Reverse Link List II
 * Problem Description

Reverse a linked list head from position B to C.

NOTE: Do it in-place and in one-pass.



Problem Constraints

1 <= |head| <= 106

1 <= B <= C <= |head|



Input Format

The first argument contains a pointer to the head of the given linked list, head.

The second arugment contains an integer, B.

The third argument contains an integer C.



Output Format

Return a pointer to the head of the modified linked list.



Example Input

Input 1:

 head = 1 -> 2 -> 3 -> 4 -> 5
 B = 2
 C = 4

Input 2:

 head = 1 -> 2 -> 3 -> 4 -> 5
 B = 1
 C = 5


Example Output

Output 1:

 1 -> 4 -> 3 -> 2 -> 5
Output 2:

 5 -> 4 -> 3 -> 2 -> 1


Example Explanation

Explanation 1:

 In the first example, we want to reverse the highlighted part of the given linked list : 1 -> 2 -> 3 -> 4 -> 5 
 Thus, the output is 1 -> 4 -> 3 -> 2 -> 5 
Explanation 2:

 In the second example, we want to reverse the highlighted part of the given linked list : 1 -> 4 -> 3 -> 2 -> 5  
 Thus, the output is 5 -> 4 -> 3 -> 2 -> 1 
 
 
 Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]
 

Constraints:

The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n

 */
package com.linked;

public class ReverseLinkedList2 {
	
	public static Node reverseBetween(Node A, int m, int n) {
        int i;
        Node node = A;
        Node prev = null;
        m--;
        n--;
        for (i = 0; i < m; i++) {
            prev = node;
            node = node.next;
        }
        if (prev != null)
            prev.next = reverseList(node, n - m + 1);
        else
            A = reverseList(node, n - m + 1);
        return A;
    }

    public static Node reverseList(Node A, int count) {
        Node node, prev, temp, last;
        node = A;
        last = A;
        if (node == null)
            return null;
        prev = null;
        while (node != null && count > 0) {
            temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
            count--;
        }
        last.next = node;
        return prev;
    }
	
	public static Node reverseBetweenPos(Node head, int B, int C) {
        if (head!=null && head.next!=null){
            Node temp = head; 
            Node start = null;
            Node start1 = null;
            Node end1 = null;
            Node end = null;
            int n = 1;
            if (B==1) {
            	start = null;
            	start1 = temp;
            }
            while (temp!=null) {
                if (n==B-1) {
                	start = temp;
                	start1 = temp.next;
                }
                if (n==C) {
                	end1 = temp;
                	end = temp.next;
                }
                temp = temp.next;
                n++;
                
            }
            if (n==C) {
            	end1 = temp;
            	end = temp.next;
            }
            Node prev = start1;
            Node cur = prev.next;
            Node nxt = null;
            while (cur!=null && cur!=end) {
            	nxt = cur.next;
            	cur.next = prev;
            	prev = cur;
            	cur = nxt;
            }
            if (start!=null) {
                start.next = prev;
            }
            if (B==1) {
            	head = prev;
            }
            start1.next = cur;
            return head;
            
        }
        else{
            return head;
        }
    }
	
	public static void print(Node head)
	{
		Node temp = head;
		while (temp != null)
		{
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		Node head = new Node (1);
		head.next = new Node (2);
		head.next.next = new Node (3);
		head.next.next.next = new Node (4);
		System.out.println("Original Array");
		print(head);
		System.out.println();
		System.out.println("1st Approach");
		head = reverseBetweenPos(head, 1, 3);
		System.out.println();
		print(head);
		System.out.println();
		System.out.println("2nd Approach");
		head = reverseBetween(head, 1, 3);
		System.out.println();
		print(head);
		
		
		
	}

}
