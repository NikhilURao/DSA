/*
 * Diameter of a Binary Tree
The diameter of a tree (sometimes called the width) is the number of nodes 
on the longest path between two end nodes.
The diameter of a tree T is the largest of the following quantities:
1. the diameter of T’s left subtree
2. the diameter of T’s right subtree
3. the longest path between leaves that goes through the root of T 
(this can be computed from the heights of the subtrees of T)
 */
package com.trees;

public class DiameterOfBT 
{
	public int getHeight(BTNode root)
	{
		if (root == null)
			return 0;
		else
		{
			int lh = getHeight(root.left);
			int rh = getHeight(root.right);
			
			return (lh>rh)? lh+1 : rh+1;
		}
	}
	
	public int getDiameter(BTNode root)
	{
		if (root == null)
			return 0;
		else
		{
			int lheight = getHeight(root.left);
			int rheight = getHeight(root.right);
			
			int ldiameter = getDiameter(root.left);
			int rdiameter = getDiameter(root.right);
			
			return Math.max(lheight+rheight+1, Math.max(ldiameter, rdiameter));
		}
	}

	public static void main(String[] args) {
		BTNode root = new BTNode(8);
		root.left = new BTNode(2);
		root.left.left = new BTNode(10);
		root.right = new BTNode(32);
		root.left.right = new BTNode(40);
		root.left.right.left = new BTNode(3);
		root.right.left = new BTNode(16);
		root.right.left.right = new BTNode(12);
		
		DiameterOfBT dbt = new DiameterOfBT();
		System.out.println(dbt.getDiameter(root));
		
		Integer a = 10;
		
		

	}

}
