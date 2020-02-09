package com.linked;

public class RemoveDuplicates 
{
	Node head;
	
	public void Insert_LL(int data) 
	{
		
		if(this.head == null) 
		{
			this.head=new Node(data);
			
		}
		else 
		{
			Node temp = new Node(data);
			temp.next = this.head;
			this.head = temp;
		}
	}
	
	public void Sorted() {
		Node temp = null;
		while (this.head!=null) {
			Node ptr = this.head;
			this.head = this.head.next;
			ptr.next =null;
			
			if (temp == null) {
				temp = ptr;
			}
			else if(temp.data > ptr.data) {
				ptr.next = temp;
				temp = ptr;
			}
			else {
				Node temp2= temp;
				while(temp2.next != null && temp2.next.data < ptr.data) {
					temp2 = temp2.next;
				}
				ptr.next =temp2.next;
				temp2.next = ptr;
			}
			
		}
		this.head = temp;
		
	}
	
	public void RemoveDupsSorted()
	{
		Node temp = this.head;
		while (temp!=null && temp.next != null)	
		{
			if (temp.data == temp.next.data)
			{
				Node ptr = temp.next;
				temp.next = ptr.next;
				ptr.next = null;
			}
			else 
			{
				temp = temp.next;
			}
		}
	}
	
	public void RemoveDupsUnsorted()
	{
		Node temp = this.head;
		while (temp != null)
		{
			Node ptr = temp;
			while (ptr.next != null)
			{
				if (ptr.next.data == temp.data)
				{
					Node temp2 = ptr.next;
					ptr.next = temp2.next;
					temp2.next = null;
				}
				else
				{
					ptr = ptr.next;
				}
			}
			temp = temp.next;
		}
		
	}
	
	public void print() {
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}		
		
	}
	public static void main(String[] args) {
		RemoveDuplicates obj = new RemoveDuplicates();
		obj.Insert_LL(8);
		obj.Insert_LL(2);
		obj.Insert_LL(8);
		obj.Insert_LL(6);
		obj.Insert_LL(6);
		obj.Insert_LL(6);
		obj.Insert_LL(2);
		obj.print();
		System.out.println();
		obj.Sorted();
		System.out.println();
		obj.print();
		System.out.println();
		//obj.RemoveDupsUnsorted();
		obj.RemoveDupsSorted();
		obj.print();
		

	}

}
