package com.trees;

public class SearchBT 
{ 
	public boolean search(BTNode root, int key)
	{
		if (root!=null)
		{
			if (root.data == key)
			{
				return true;
			}
			else
			{
				boolean lf = search(root.left, key);
				
				if (!lf)
				{
					boolean rf = search(root.right, key);
					return rf;
				}
				else 
				{
					return lf;
				}	
			}
		}
		else
		{
			return false;
		}
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
		root.right.left.right.right = new BTNode(21);
		root.right.left.right.right.left = new BTNode(43);
		
		SearchBT sbt = new SearchBT();
		System.out.println(sbt.search(root, 21));

	}

}
