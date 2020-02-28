/*
 * root -> left -> right
 */

package com.trees;

public class PreorderTransversal 
{
	
	public void PreorderTransverseRec(BTNode root)
	{
		if (root != null)
		{
			System.out.print(root.data+" ");
			PreorderTransverseRec(root.left);
			PreorderTransverseRec(root.right);
		}	
			
	}
	
	public void PreorderTransverseIterative(BTNode root)
	{
		Stack s = new Stack();
		
		BTNode temp = root;
		
		while (true)
		{
			while (temp != null)
			{
				System.out.print(temp.data+" ");
				s.push(temp);
				temp = temp.left;
			}
			
			if (s.isEmpty())
				break;
			
			temp = s.pop();
			temp = temp.right;
			
		}
	}

	public static void main(String[] args) 
	{
		BTNode root = new BTNode(8);
		root.left = new BTNode(6);
		root.right = new BTNode(9);
		root.left.right = new BTNode(4);
		root.left.right.left = new BTNode(3);
		root.right.left = new BTNode(16);
		root.right.left.right = new BTNode(12);
		
		PreorderTransversal pot = new PreorderTransversal();
		pot.PreorderTransverseRec(root);
		System.out.println();
		pot.PreorderTransverseIterative(root);

	}

}
