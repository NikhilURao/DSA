package com.linked;

public class PairwiseSwapping {
	Node head;
	public void PairwiseSwap()
	{
		Node temp = this.head;
		while (temp != null)
		{
			int k = temp.data;
			temp.data = temp.next.data;
			temp.next.data = k;
			temp = temp.next.next;
		}
	}
	
	public void pushintoLL(int data)
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
			temp.next = new Node(data);
		}
	}
	
	public void print()
	{
		Node temp = this.head;
		
		while(temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	public static void main(String[] args) {
		PairwiseSwapping pwl = new PairwiseSwapping();
		pwl.pushintoLL(10);
		pwl.pushintoLL(12);
		pwl.pushintoLL(7);
		pwl.pushintoLL(21);
		pwl.pushintoLL(19);
		pwl.print();
		System.out.println();
		pwl.PairwiseSwap();
		pwl.print();
		System.out.println();

	}

}
