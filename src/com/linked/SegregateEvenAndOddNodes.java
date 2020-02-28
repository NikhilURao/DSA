package com.linked;

public class SegregateEvenAndOddNodes {
	Node head;
	
	public Node Segregate() 
	{
		Node ptr_even = null;
		Node ptr_odd = null;
		
		while (this.head.next != null)
		{
			Node temp = this.head;
			head = head.next;
			temp.next = null;
			
			if (temp.data % 2 == 0)
			{
				
				if (ptr_even == null)
				{
					ptr_even = temp;
				}
				else
				{
					Node nur = ptr_even;
					while (nur.next!=null)
					{
						nur=nur.next;
					}
					
					nur.next = temp;
				}
			}
			else
			{
				if (ptr_odd == null)
				{
					ptr_odd = temp;
				}
				else
				{
					Node nur = ptr_odd;
					while (nur.next!=null)
					{
						nur=nur.next;
					}
					
					nur.next = temp;
				}
			}	
	
		}
		
		Node tail_even = ptr_even;
		
		while (tail_even.next != null)
		{
			tail_even = tail_even.next;
		}
		
		tail_even.next = ptr_odd;
		return ptr_even;
	}	
	
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
	
	public void print(Node head)
	{
		Node ptr = head;
		while (ptr!=null)
		{
			System.out.print(ptr.data+ " ");
			ptr = ptr.next;
		}
		
	}
	
	public static void main(String[] args) {
		
		SegregateEvenAndOddNodes s = new SegregateEvenAndOddNodes();
		s.Insert_LL(22);
		s.Insert_LL(3);
		s.Insert_LL(14);
		s.Insert_LL(7);
		s.Insert_LL(6);
		s.Insert_LL(4);
		s.print(s.head);
		System.out.println();
		s.print(s.Segregate());
		
		
		

	}

}
