/*
 * Swap nodes in a linked list without swapping data
 * Given a linked list and two keys in it, swap nodes for two given keys. 
 * Nodes should be swapped by changing links.
 */
package com.linked;

public class SwappingNodes {
	Node head;
	
	public void swapNodes(int k1,int k2)
	{
		Node prev = null;
		Node present = this.head;
		
		while(present != null && present.data != k1)
		{
			prev = present;
			present = present.next;
		}
		
		Node prev1 = null;
		Node present1 = this.head;
		
		if (k1==k2)
		{
			return;
		}
		
		while(present1 != null && present1.data != k2)
		{
			prev1 = present1;
			present1 = present1.next;
		}
		if (prev == null)
		{
			this.head = present1;
		}
		else
		{
			prev.next = present1;
		}
		if (prev1 == null)
		{
			this.head = present;
		}
		else
		{
			prev1.next = present;
		}
		
		if (present == null || present1 == null)
		{
			return;
		}

		Node temp = present.next;
		present.next = present1.next;
		present1.next = temp;
		
		
	}
	
	public void InsertintoLL(int data)
	{
		if (this.head == null)
		{
			this.head = new Node(data);
		}
		else
		{
			Node n = new Node(data);
			n.next = this.head;
			this.head = n;
		}
	}
	
	public void printLL()
	{
		Node temp = this.head;
		while (temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		
		SwappingNodes sn = new SwappingNodes();
		sn.InsertintoLL(10);
		sn.InsertintoLL(11);
		sn.InsertintoLL(6);
		sn.InsertintoLL(22);
		sn.InsertintoLL(30);
		sn.InsertintoLL(2);
		sn.printLL();
		System.out.println();
		sn.swapNodes(2, 22);
		sn.printLL();
		
		

	}

}
