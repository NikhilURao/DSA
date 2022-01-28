package com.linked;

public class DeleteMiddleNode {
	
	public static Node deleteMiddleNode(Node head) {
		// Return head = null for empty LL. Return head = null for LL with just one node, as that node is deleted.
		if (head==null || head.next == null) {
			return null;
		}
		else {
			Node prev = null;
			Node cur = head;
			Node twoXCur = head;
			
			while (twoXCur!=null && twoXCur.next!=null && twoXCur.next.next!=null) {
				prev = cur;
				cur = cur.next;
				twoXCur = twoXCur.next.next;
			}
			prev.next = cur.next;
			
			return head;
		}
	}
	
	// Aux Functions
	public static Node add(int data, Node head)
	{
		if (head == null)
		{
			head = new Node(data);
		}
		else 
		{
			Node temp = head;
			while (temp.next != null)
			{
				temp = temp.next;
			}
		Node n = new Node(data);
		temp.next = n;
		}
		return head;
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
		Node head = null;
		head = add(10, head);
		head = add(20, head);
		head = add(30, head);
		print(head);
		head = deleteMiddleNode(head);
		System.out.println();
		print(head);

	}

}
