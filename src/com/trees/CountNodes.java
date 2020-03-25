package com.trees;

public class CountNodes 
{
	public int getCountsRec(BTNode root)
	{
		if (root == null)
			return 0;
		else
		{
			int lc = getCountsRec(root.left);
			int rc= getCountsRec(root.right);
			
			return lc+1+rc;
		}
	}
		
	public static void main(String[] args) {
		
		BTNode root = new BTNode(8);
		root.left = new BTNode(6);
		root.right = new BTNode(9);
		root.left.right = new BTNode(4);
		root.left.right.left = new BTNode(3);
		root.right.left = new BTNode(16);
		root.right.left.right = new BTNode(12);
		
		CountNodes cn = new CountNodes();
		System.out.println(cn.getCountsRec(root));

	}

}
