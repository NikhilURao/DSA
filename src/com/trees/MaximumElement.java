package com.trees;

public class MaximumElement 
{
	int max = Integer.MIN_VALUE;
	
	public void getMax(BTNode root)
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
	public static void main(String[] args) 
	{
		
		BTNode root = new BTNode(8);
		root.left = new BTNode(32);
		root.right = new BTNode(9);
		root.left.right = new BTNode(4);
		root.left.right.left = new BTNode(3);
		root.right.left = new BTNode(16);
		root.right.left.right = new BTNode(12);
		
		MaximumElement el = new MaximumElement();
		el.getMax(root);
		System.out.println(el.max);
		
		System.out.println(el.getMaxRec(root));
	}

}
