package com.trees;

public class LowestCommonAncestor 
{

	public BTNode getLCA(BTNode root, int n1, int n2)
	{
		if (root == null)
			return null;
		if (root.data == n1 || root.data == n2)
			return root;
		else
		{
			BTNode left = getLCA(root.left, n1, n2);
			BTNode right = getLCA(root.right, n1, n2);
			
			if (left!=null && right!=null)
				return root;
			else
				return (left!=null) ? left : right;
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
		
		LowestCommonAncestor lca = new LowestCommonAncestor();
		BTNode temp = lca.getLCA(root, 40, 3); 
		if (temp!=null)
		{
			System.out.println(temp.data);
		}
	}

}
