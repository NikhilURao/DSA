package com.trees;
// Height of a BT is equal to the maximum of the height of left sub-tree and the height of the right sub-tree.
// TC: O(N) where N is the number of nodes in BT
// SC: O(N) worst case

public class HeightOfBT 
{
	public int getHeight(BTNode root)
	{
		if (root == null)
		{
			return 0;
		}
		else
		{
			int lh = getHeight(root.left);
			int rh = getHeight(root.right);
			
			// return Math.max(lh, rh) + 1; 
			
			return (lh > rh) ? lh+1 : rh+1;
			
		}
	}
	public static void main(String[] args) {
		
		BTNode root = new BTNode(8);
		root.left = new BTNode(32);
		root.right = new BTNode(9);
		root.left.right = new BTNode(4);
		root.left.right.left = new BTNode(3);
		root.right.left = new BTNode(16);
		root.right.left.right = new BTNode(12);
		root.right.left.right.right = new BTNode(21);
		root.right.left.right.right.left = new BTNode(43);
		
		HeightOfBT hbt = new HeightOfBT();
		System.out.println(hbt.getHeight(root));
		

	}

}
