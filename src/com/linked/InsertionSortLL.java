package com.linked;

public class InsertionSortLL {
	public Node insertionSortLL(Node head)
	{
		if (head == null )
		{
			return head;
		}
		else
		{
			Node temp = head;
			Node newHead = null;
			while (temp != null)
			{
				if (newHead == null || temp.data <= newHead.data)
				{
					temp.next = newHead;
					newHead = temp;
				}
				else 
				{
					Node cur = newHead;
					Node prev = null;
					while (cur != null && cur.data < temp.data)
					{
						prev = cur;
						cur = cur.next;
					}
					
					temp.next = prev.next;
					prev.next = temp;	
				}
				
				temp = temp.next;
			}
			return newHead;
		}
	}
	
	public void print(Node head)
	{
		Node ptr = head;
		
		while (ptr != null)
		{
			System.out.print(ptr.data+" ");
			ptr = ptr.next;
		}
	}
	

	public static void main(String[] args) {
		
		Node n = new Node (2);
		n.next = new Node(5);
		n.next.next = new Node(7);
		
		InsertionSortLL ins = new InsertionSortLL();
		System.out.println("LL Before Insertion Sort");
		ins.print(n);
		System.out.println();
		System.out.println("LL Before Insertion Sort");
		ins.print(ins.insertionSortLL(n));
		

	}

}
