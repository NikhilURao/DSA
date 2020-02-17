package com.linked;

public class IntersectionSortedLL {
	
	Node head1;
	Node head2;
	
	public void getIntersection()
	{
		Node temp1 = this.head1;
		Node temp2 = this.head2;
		Node ptr = null;
		
		while (temp1 != null)
		{
			while(temp2 != null && temp2.data == temp1.data)
			{
				if (ptr == null)
				{
					ptr = new Node(temp1.data);
				}
				else
				{
					Node ntr = ptr;
					Node last = new Node(temp1.data);
					while (ntr.next != null)
					{
						ntr = ntr.next;
					}
					ntr.next = last;
				}
				temp2 = temp2.next;
			}
			temp1 = temp1.next;
		}
		
		Node temp = ptr;
		
		while(temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	public void pushintoLL1(int data)
	{
		if (this.head1 == null)
		{
			this.head1 = new Node(data);
		}
		else
		{
			Node t1 = this.head1;
			while (t1.next != null)
			{
				t1 = t1.next;
			}
			t1.next = new Node(data);
		}
	}
	
	public void print1()
	{
		Node t1 = this.head1;
		
		while(t1 != null)
		{
			System.out.print(t1.data+" ");
			t1 = t1.next;
		}
	}
	
	public void pushintoLL2(int data)
	{
		if (this.head2 == null)
		{
			this.head2 = new Node(data);
		}
		else
		{
			Node t2 = this.head2;
			while (t2.next != null)
			{
				t2 = t2.next;
			}
			t2.next = new Node(data);
		}
	}
	
	public void print2()
	{
		Node t2 = this.head2;
		
		while(t2 != null)
		{
			System.out.print(t2.data+" ");
			t2 = t2.next;
		}
	}
	

	public static void main(String[] args) {
		
		IntersectionSortedLL isl = new IntersectionSortedLL();
		isl.pushintoLL1(1);
		isl.pushintoLL1(2);
		isl.pushintoLL1(3);
		isl.pushintoLL1(4);
		isl.pushintoLL1(6);
		isl.pushintoLL2(2);
		isl.pushintoLL2(4);
		isl.pushintoLL2(6);
		isl.pushintoLL2(8);
		isl.print1();
		System.out.println();
		isl.print2();
		System.out.println();
		isl.getIntersection();
		
		
		
	}

}
