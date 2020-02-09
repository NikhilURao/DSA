package com.linked;

public class MergingLinkedListSorted {
	Node head1;
	Node head2;
	
	public void Insert_LL1(int data) 
	{
		
		if(this.head1 == null) 
		{
			this.head1=new Node(data);
			
		}
		else 
		{
			Node temp = new Node(data);
			temp.next = this.head1;
			this.head1 = temp;
		}
	}
	
	public void Insert_LL2(int data) 
	{
		
		if(this.head2 == null) 
		{
			this.head2=new Node(data);
			
		}
		else 
		{
			Node temp = new Node(data);
			temp.next = this.head2;
			this.head2 = temp;
		}
	}
	
	public void mergeLL()
	{
		while (head2 != null)
		{
			Node ptr = head2;
			head2 = head2.next;
			ptr.next = null;
			
			if (ptr.data < head1.data)
			{
				ptr.next = head1;
				head1 = ptr;
			}
			else 
			{
				Node temp = head1;
				while (temp.next != null && temp.next.data < ptr.data )
				{
					temp = temp.next;
				}
				
				ptr.next = temp.next;
				temp.next = ptr;
			}
		
		
		}
	}
	
	public void mergeLLFast()
	{
		Node l3 = new Node(0);
		Node temp = l3;
		while (head1!=null && head2!=null)
		{
			if (head1.data < head2.data)
			{
				temp.next = head1;
				head1 = head1.next;
			}
			else 
			{
				temp.next = head2;
				head2 = head2.next;
			}
		}
		if (head1!=null)
		{
			temp.next =head1;
		}
		if (head2!=null)
		{
			temp.next=head2;
		}
	}
	
	
	public void print_LL1() {
		Node temp = this.head1;
		while (temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}		
		
	}
	
	public void print_LL2() {
		Node temp = this.head2;
		while (temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}		
		
	}

	public static void main(String[] args) {
		
		MergingLinkedListSorted obj = new MergingLinkedListSorted();
		obj.Insert_LL1(43);
		obj.Insert_LL1(26);
		obj.Insert_LL1(12);
		obj.Insert_LL1(10);
		obj.print_LL1();
		System.out.println();
		obj.Insert_LL2(64);
		obj.Insert_LL2(55);
		obj.Insert_LL2(16);
		obj.Insert_LL2(11);
		obj.print_LL2();
		//obj.mergeLL();
		//obj.mergeLLFast();
		System.out.println();
		obj.print_LL1();
		
		
		
		
		
		

	}

}
