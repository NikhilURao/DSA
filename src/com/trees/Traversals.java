package com.trees;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Traversals 
{

	public void LevelOrderTraversal(BTNode root)
	{
		if (root != null)
		{
			Queue<BTNode> q = new LinkedList<BTNode>();
			q.add(root);
			
			while (!q.isEmpty())
			{
				BTNode temp = q.remove();
				System.out.print(temp.data+" ");
				
				if (temp.left != null)
				{
					q.add(temp.left);
				}
				if (temp.right != null)
				{
					q.add(temp.right);
				}
			}
		}
	}
	
	public void InOrderTraversal(BTNode root)
	{
		if (root != null)
		{
			BTNode temp = root;
			Stack<BTNode> s = new Stack<BTNode>();
			
			while (true)
			{
				while(temp != null)
				{
					s.push(temp);
					temp = temp.left;
				}
				if (s.isEmpty()) break;
				temp = s.pop();
				System.out.print(temp.data+" ");
				temp = temp.right;
			}
		}
		else 
		{
			return;
		}
	}
	
	public void PreOrderTraversal(BTNode root)
	{
		if (root != null)
		{
			BTNode temp = root;
			Stack<BTNode> s= new Stack<BTNode>();
			
			while (true)
			{
				while(temp != null)
				{
					System.out.print(temp.data+" ");
					s.push(temp);
					temp = temp.left;
				}
				
				if (s.isEmpty()) break;
				temp = s.pop();
				temp = temp.right;

			}

		}
		
	}
	
	public void PostOrderTraversal(BTNode root)
	{
		if (root != null)
		{
			BTNode temp = root;
			Stack<BTNode> s = new Stack<BTNode>();
			
			while(true)
			{
				while (temp != null)
				{
					s.push(temp);
					temp = temp.left;
				}
				
				if (s.isEmpty()) break;
				
				if (temp.right != null)
				{
					temp = s.peek();
					temp = temp.right;
				}
				else
				{
					temp = s.pop();
					System.out.print(temp.data+" ");
					temp = s.pop();
				}
			}
		}
		else return;
	}
	
	public static void main(String[] args) 
	{
		BTNode root = new BTNode(7);
		root.left = new BTNode(6);
		root.right = new BTNode(11);
		root.left.left = new BTNode(14);
		root.left.right = new BTNode(5);
		root.right.left = new BTNode(2);
		root.right.right = new BTNode(4);
		
		Traversals tvr = new Traversals();
		tvr.LevelOrderTraversal(root);
		System.out.println();
		tvr.InOrderTraversal(root);
		System.out.println();
		tvr.PreOrderTraversal(root);
	}
}
