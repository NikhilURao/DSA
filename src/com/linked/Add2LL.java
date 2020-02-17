package com.linked;

public class Add2LL {
	Node head1;
	Node head2;
	
	public void add2LinkedList()
	{
		Node head= null;
		
		int a;
		int b;
		int carry=0;
		int sum=0;
		int res1=0;
		
		while (head1!=null || head2!=null)
		{
			
			
			a = (head1!=null) ? head1.data : 0;
			b = (head2!=null) ? head2.data : 0;
			
			sum = a+b+carry;
			carry = sum/10;
			res1 = sum%10;
			System.out.println(a+" "+b+" "+sum+" "+carry+" "+res1);
			if (head==null)
			{
				head = new Node(res1);
			}
			else
			{
				Node temp = new Node(res1);
				temp.next = head;
				head= temp;
			}

			head1= (head1!=null)?head1.next:null;
			head2= (head2!=null)?head2.next:null;
		
						
		}
		
		if (carry!= 0)
		{
			Node temp = new Node(carry);
			temp.next = head;
			head = temp;
		}
		
		while(head!=null)
		{
			System.out.print(head.data+" ");
			head = head.next;
		}
	}
	
	public void add2LinkedListRec()
	{
		
	}
	
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
	
	
	public void print1() {
		Node temp = this.head1;
		while (temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}		
		
	}
	
	
	public void print2() {
		Node temp = this.head2;
		while (temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}		
		
	}

	public static void main(String[] args) {
		
		Add2LL a = new Add2LL();
		a.Insert_LL1(1);
		a.Insert_LL1(0);
		a.Insert_LL1(0);
		a.Insert_LL1(0);
		
		a.print1();
		System.out.println();
		
		a.Insert_LL2(9);
		a.Insert_LL2(9);
		a.Insert_LL2(9);
		//a.Insert_LL2(9);
		
		a.print2();
		System.out.println();
		
		a.add2LinkedList();
		
		

	}

}
