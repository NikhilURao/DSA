/*
 * Left -> Root -> Right
 */

package com.trees;

import java.util.ArrayList;

public class InorderTraversal {
	
	public void InorderTraverseRec(BTNode root)
	{
		if (root != null)
		{
			InorderTraverseRec(root.left);
			System.out.print(root.data+" ");
			InorderTraverseRec(root.right);
		}
	} 
	
	public void InorderTraverseIterative(BTNode root)
	{
		if (root == null)
			return;
		
		else
		{
			Stack s = new Stack();
			
			BTNode temp = root;
			
			while (temp!=null || !s.isEmpty())
			{
				while (temp != null)
				{
					s.push(temp);
					temp = temp.left;
				}
				
				if (s.isEmpty())
					break;
				
				temp = s.pop();
				System.out.print(temp.data+" ");
				temp = temp.right;
				
			}
		}
		
	}

	public static void main(String[] args) {
		
		BTNode root = new BTNode(1);
		root.left = new BTNode(6);
		root.right = new BTNode(2);
		//root.left.right = new BTNode(4);
		root.left.left = new BTNode(3);
		//root.right.left = new BTNode(16);
		//root.right.left.right = new BTNode(12);
		
		InorderTraversal iot = new InorderTraversal();
		iot.InorderTraverseRec(root);
		System.out.println();
		iot.InorderTraverseIterative(root);
		
		ArrayList<Integer> ls = new ArrayList<>();
		
		


	}

}
