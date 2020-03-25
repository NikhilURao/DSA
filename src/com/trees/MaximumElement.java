package com.trees;

import java.util.LinkedList;

public class MaximumElement 
{
	int max = Integer.MIN_VALUE;
	
	public void getMaxNaive(BTNode root)
	{
		if (root != null)
		{
			if (root.data > max)
				max = root.data;
			
			getMax(root.left);
			getMax(root.right);
		}
	}
	
	public int getMaxRec(BTNode root)
	{
		if (root != null)
		{
		int leftMax = getMaxRec(root.left);
		int rightMax = getMaxRec(root.right);
		
		if (leftMax > rightMax && leftMax > root.data)
			return leftMax;
		else if (leftMax < rightMax && rightMax > root.data)
			return rightMax;
		else 
			return root.data;
		}
		
		return Integer.MIN_VALUE;
	}
	
	public int getMax(BTNode root)
	{
		if (root!=null)
		{
			Queue q =  new Queue();
			int max = Integer.MIN_VALUE;
			q.enqueue(root);
			
			while (!q.isEmpty())
			{
				BTNode temp = q.dequeue();
				
				
				if (temp.data > max)
				{
					max = temp.data;
				}
				
				if (temp.left!=null)
				{
					q.enqueue(temp.left);
				}
				
				if (temp.right!=null)
				{
					q.enqueue(temp.right);
				}
			}
			return max;
		}
		else 
			return 0;
	}
	public static void main(String[] args) 
	{
		
		BTNode root = new BTNode(8);
		root.left = new BTNode(2);
		root.right = new BTNode(32);
		root.left.right = new BTNode(40);
		root.left.right.left = new BTNode(3);
		root.right.left = new BTNode(16);
		root.right.left.right = new BTNode(12);
		
		MaximumElement el = new MaximumElement();
		//el.getMax(root);
		//System.out.println(el.max);
		//System.out.println(el.getMaxNaive(root));
		System.out.println(el.getMaxRec(root));
		System.out.println(el.getMax(root));
		
		
		
	}

}
