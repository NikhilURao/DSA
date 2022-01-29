package com.linked;

import java.util.HashSet;

public class LoopDetectionInLL {
	
	// Detect Loop or Cycle using Hash Table
	public boolean detectLoopWithHashTable(Node head)
	{
		HashSet<Node> hs = new HashSet<Node>();
		Node temp = head;
		
		while (temp.next != null)
		{
			if(hs.contains(temp))
			{
				return true;
			}
			else 
			{
				hs.add(temp);
			}
			
			temp = temp.next;
		}
		
		return false;
		
	}

	// Detect Loop and Loop starting Node 
	//using Floyd's Cycle-Finding Algorithm (Hare and Tortoise)
	
	public boolean detectLoop(Node head)
	{
		Node temp1 = head;
		Node temp2 = head;
		while (temp1 != null && temp2 != null && temp2.next != null)
		{
			temp1 = temp1.next;
			temp2 = temp2.next.next;
			
			if (temp1 == temp2)
			{
				return true;
			}
		}
		
		return false;
		
	}

	/*
	 * List Cycle - Loop Starting Node
	 * 
Problem Description

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Try solving it using constant additional space.

Example:

Input: 

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3. 
	 */	
	public Node detectLoopStartingNode(Node head)
	{
		Node tortoise = head;
		Node hare = head;
		Node loopStartingPoint = head;
		Node meetingPoint = null;
		while (hare.next != null && hare.next.next != null)
		{
			tortoise = tortoise.next;
			hare = hare.next.next;
			
			if (tortoise == hare)
			{
				meetingPoint = tortoise;
				break;
			}	
		}
		
		if (meetingPoint == null) {
			// No loop in LL
			return null;
		}
		else {
			while (loopStartingPoint != meetingPoint)
			{
				loopStartingPoint = loopStartingPoint.next;
				meetingPoint = meetingPoint.next;	
			}
			
			return loopStartingPoint;
		}
		
	}
	
	/*
	 * Remove Loop from Linked List
	 * 
Problem Description

Given a linked list which contains some loop.

You need to find the node, which creates a loop, and break it by making the node point to NULL.



Problem Constraints

1 <= number of nodes <= 1000



Input Format

Only argument is the head of the linked list.



Output Format

return the head of the updated linked list.



Example Input

Input 1:

 
1 -> 2
^    |
| - - 
Input 2:

3 -> 2 -> 4 -> 5 -> 6
          ^         |
          |         |    
          - - - - - -


Example Output

Output 1:

 1 -> 2 -> NULL
Output 2:

 3 -> 2 -> 4 -> 5 -> 6 -> NULL


Example Explanation

Explanation 1:

 Chain of 1->2 is broken.
Explanation 2:

 Chain of 4->6 is broken.
 
	 */
	public Node breakLoopInLL(Node head) {
		Node tortoise = head;
		Node hare = head;
		Node loopStartingPoint = head;
		Node meetingPoint = null;
		while (hare.next != null && hare.next.next != null)
		{
			tortoise = tortoise.next;
			hare = hare.next.next;
			
			if (tortoise == hare)
			{
				meetingPoint = tortoise;
				break;
			}	
		}
		
		if (meetingPoint == null) {
			// No loop in LL
			return null;
		}
		else {
			while (meetingPoint.next != loopStartingPoint.next)
			{
				loopStartingPoint = loopStartingPoint.next;
				meetingPoint = meetingPoint.next;	
			}
			
			meetingPoint.next = null;
			return head;
		}
	}
	
	public static void printLL(Node head) {
		if (head!=null) {
			Node ptr = head;
			while (ptr!=null) {	
				System.out.print(ptr.data+" ");
				ptr = ptr.next;
			}
		}	
	}
	
	public static void main(String[] args) {
		LoopDetectionInLL lpd = new LoopDetectionInLL();
		
		Node head = new Node(33);
		head.next = new Node (4);
		head.next.next = new Node(7);
		head.next.next.next = new Node(11);
		head.next.next.next.next = new Node (44);
		head.next.next.next.next.next = head.next.next;
		
		/*
		 *  33 -> 4 -> 7 -> 11 -> 44
		 *             |          |
		 *             |          |
		 *              ----------           
		 *  
		 */
		
		//System.out.println(lpd.detectLoopWithHashTable());
		System.out.println("Loop present in the LL? : "+ lpd.detectLoop(head));
		Node loopStartNode = lpd.detectLoopStartingNode(head);
		System.out.println("Loop starting point is Node: "+loopStartNode+
				" with data "+loopStartNode.data);
		head = lpd.breakLoopInLL(head);
		System.out.println("Loop chain broken. LL after breaking the loop is: ");
		printLL(head);
		
		
		

	}

}
