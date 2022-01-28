/*
 * Given 2 Linked Lists (head pointers head1 and head2). Merge the 2 linked list alternatively.
 * Given length(LL1) > length(LL2)
 * 
 * Eg: LL1 5 -> 9 -> 4 -> 6 -> 15
 * 	   LL2 12 -> 8 -> 3 -> 16
 * O/P : 5 -> 12 -> 9 -> 8 -> 4 -> 3 -> 6 -> 16 -> 15 
 * 
 * Note: Do it in O(1) space. Not allowed to create a new LL.
 */

package com.linked;

public class MergeLL {
	
	public static Node mergeLL(Node head1, Node head2) {
		if (head2 == null) {
			return head1;
		}
		else {
			Node temp1 = head1;
			Node temp2 = head2;
			
			while (temp1.next!=null && head2!=null) {
				temp2 = head2;
				head2 = head2.next;
				temp2.next = temp1.next;
				temp1.next = temp2;
				temp1 = temp1.next.next;
			}
			
			return head1;
		}
	}
	
	public static void print(Node head)
	{
		Node temp = head;
		while (temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		Node head1 = new Node(5);head1.next = new Node(9);head1.next.next = new Node(4);head1.next.next.next = new Node(6);head1.next.next.next.next = new Node(15);
		Node head2 = new Node(12);head2.next = new Node(8);head2.next.next = new Node(3);head2.next.next.next = new Node(16);
		System.out.println("LL1:");
		print(head1);
		System.out.println();
		System.out.println("LL2:");
		print(head2); 
		System.out.println();
		System.out.println();
		head1 = mergeLL(head1, head2);
		System.out.println();
		System.out.println("Merge LL1 and LL2:");
		System.out.println();
		print(head1);
		System.out.println();


	}

}
