/*
 * left -> right -> root
 */

package com.trees;

import java.util.ArrayList;
import java.util.List;

public class PostorderTransversal 
{
	public void PostOrderTransverseRec(BTNode root)
	{
		if (root != null)
		{
			PostOrderTransverseRec(root.left);
			PostOrderTransverseRec(root.right);
			System.out.print(root.data+" ");
		}
	}
	
	public List<Integer> PostOrderTraverseIterative(BTNode root)
	{
		List<Integer> ls = new ArrayList<Integer>();
		if (root == null)
			return ls;
		else 
		{
			BTNode temp = root;
			Stack s = new Stack();
			
			while (true)
			{
				while (temp!=null)
				{
					if (temp.right != null)
					{
						s.push(temp.right);
					}
					s.push(temp);
					temp = temp.left;
				}
				
				if (s.isEmpty())
					break;
				
				BTNode ptr = s.pop();
				
				if (ptr.right != s.top())
				{
					ls.add(ptr.data);
					System.out.print(ptr.data+" ");
				}
					
				else 
				{
					
					temp = s.pop();
					s.push(ptr);
				}
				
			}
			return ls;
				
		}

	}

	public static void main(String[] args) 
	{
		BTNode root = new BTNode(1);
		root.left = new BTNode(6);
		root.right = new BTNode(2);
		//root.left.right = new BTNode(4);
		root.left.left = new BTNode(3);
		//root.right.left = new BTNode(16);
		//root.right.left.right = new BTNode(12);
		
		PostorderTransversal pot = new PostorderTransversal();
		pot.PostOrderTransverseRec(root);
		System.out.println();
		pot.PostOrderTraverseIterative(root);
	}

}
