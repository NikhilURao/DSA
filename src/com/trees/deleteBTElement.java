/*
 * Given the element(data) to be deleted. 
 * Perform deletion operation on the given element.
 * 1. Search and find the given element in the BT by traversing in level order.
 * 2. Find the deepest node(leaf node) in the BT.
 * 3. Replace the data of the deepest node with the node to be deleted.
 * 4. Delete the deepest node
 * 
 */
package com.trees;

public class deleteBTElement
{
	public BTNode searchBT(BTNode root, int key)
	{
		if (root == null)
			return null;
		else
		{
			Queue q = new Queue();
			q.enqueue(root);
			
			while (!q.isEmpty())
			{
				BTNode res = q.dequeue();
				
				if (res.data == key)
				{
					return res;
				}
				else 
				{
					if (res.left!=null)
						q.enqueue(res.left);
					if (res.right!=null)
						q.enqueue(res.right);
				}
			}
			
			return null;
		}
	}
	
	public BTNode getDeepestNode(BTNode root)
	{
		if (root != null)
		{
			Queue q = new Queue();
			q.enqueue(root);
			BTNode res = null;
			
			while (!q.isEmpty())
			{
				BTNode temp = q.dequeue();
				
				if (temp.left != null)
					q.enqueue(temp.left);
				if (temp.right != null)
					q.enqueue(temp.right);
				res = temp;
			}
			
			return res;
		}
		else 
			return null;
	}
	
	public void deleteDeepestNode(BTNode root, int key)
	{
		if (root==null)
			return;
		else
		{	
			if (root.left!=null && root.left.data == key)
				root.left = null;
			else if (root.right!=null && root.right.data == key)
				root.right = null;
			else
			{
				deleteDeepestNode(root.left, key);
				deleteDeepestNode(root.right, key);
			}
		}
	}
	
	public void deleteElement(BTNode root, int key)
	{
		BTNode node_tobe_deleted = searchBT(root, key);
		if (node_tobe_deleted!=null)
		{
			BTNode deepest_node = getDeepestNode(root);
			
			if (node_tobe_deleted != deepest_node)
			{
				int nur = deepest_node.data;
				deleteDeepestNode(root, deepest_node.data);	
				node_tobe_deleted.data = nur;
			}
			else
			{
				deleteDeepestNode(root, deepest_node.data);
			}
				
		}
		else
			System.out.println("Given Element is not present in the tree");
	}
	public static void main(String[] args) 
	{
		BTNode root = new BTNode(8);
		root.left = new BTNode(2);
		root.left.left = new BTNode(10);
		root.right = new BTNode(32);
		root.left.right = new BTNode(40);
		root.left.right.left = new BTNode(3);
		root.right.left = new BTNode(16);
		root.right.left.right = new BTNode(12);
		
		LevelOrderTransversal lot = new LevelOrderTransversal();
		lot.LevelOrderTraverse_Iterative(root);
		deleteBTElement dbt = new deleteBTElement();
		dbt.deleteElement(root, 32);
		System.out.println();
		lot.LevelOrderTraverse_Iterative(root);
		
		
	}

}
