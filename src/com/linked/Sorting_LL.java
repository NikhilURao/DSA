package com.linked;

import java.util.*;

public class Sorting_LL {
	
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
	
	public void reverse() {
		Node temp = null;
		
		
		
	}
	
	public void print() {
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}		
		
	}

	public static void main(String[] args) {
		Sorting_LL obj = new Sorting_LL();
		obj.Insert_LL(8);
		obj.Insert_LL(2);
		obj.Insert_LL(6);
		obj.Insert_LL(1);
Helper oh= new Helper();
		
		oh.print(obj.head);
		
		
	}

}

class Helper
{
	public void print(Node head)
	{
		while(head!=null)
		{
			System.out.print(head.data+"  ");
			head=head.next;
		}
		
	}
}
