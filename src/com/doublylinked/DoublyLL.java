package com.doublylinked;

public class DoublyLL 
{
	Node head;
	Node tail;
	
	public void addToFront(int key)
    {
    	if (head != null)
    	{
    		Node temp = new Node(key);
    		head.prev = temp;
    		temp.next = head;
    		head = temp;
    	}
    	else 
    	{
    		head = new Node(key);
    		tail = head;
    	}
    }
	
	public int removeFromTail()
	{
		if (tail != null)
		{
			Node temp = tail;
			tail = tail.prev;
			tail.next.prev = null;
			tail.next = null;
			return temp.data;
		}
		else return -1;
	}
	
	public void print()
	{
		Node temp = this.head;
		while (temp!=null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) 
	{
		DoublyLL dll = new DoublyLL();
		dll.addToFront(10);
		dll.addToFront(15);
		dll.addToFront(29);
		System.out.println(dll.removeFromTail());
		dll.print();
		System.out.println();
		System.out.println(dll.head.data);
		System.out.println(dll.tail.data);
	}

}
