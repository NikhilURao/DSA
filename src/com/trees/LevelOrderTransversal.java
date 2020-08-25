package com.trees;

import java.util.*;


public class LevelOrderTransversal {
	
	public void LevelOrderTraverse_Iterative(BTNode root)
	{
		if (root != null)
		{
			Queue q = new Queue();
			q.enqueue(root);
			
			while (!q.isEmpty())
			{
				BTNode temp = q.dequeue();
				System.out.print(temp.data+" ");
				
				if (temp.left != null)
				{
					q.enqueue(temp.left);
				}
				
				if (temp.right != null)
				{
					q.enqueue(temp.right);
				}
			}
		}
	}
	

	public static void main(String[] args) {
		
		BTNode root = new BTNode (6);// Level 0 Root
		root.left = new BTNode(11);// Level 1 left
		root.right = new BTNode(15);// Level 1 right
		root.left.left = new  BTNode(13); 
		root.left.right = new BTNode(4);
		root.left.right.left = new BTNode(14);
		root.left.right.left.right = new BTNode(3);
		root.right.left = new BTNode(5);
		root.right.right = new BTNode(9);
		root.right.left.left = new BTNode(1);
		root.right.left.right = new BTNode(2);
		root.right.left.right.left = new BTNode(12);
		
		LevelOrderTransversal lot = new LevelOrderTransversal();
		lot.LevelOrderTraverse_Iterative(root);
		
		/*
		LinkedList<Integer> q = new LinkedList<Integer>();
		ArrayDeque<Integer> qa = new ArrayDeque<Integer>();
		ArrayList<ArrayList<Integer>> nodes = new ArrayList<ArrayList<Integer>>();
		ArrayList <Integer> ls = new ArrayList<Integer>();
		ls.add(1);
		ls.add(2);
		System.out.println(ls);
		
		nodes.add(ls);
		System.out.println(nodes);
		*/
		
		
	}

}
