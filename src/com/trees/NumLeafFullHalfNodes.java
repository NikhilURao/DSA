/*
 * Leaf Nodes || Full Nodes || Half Nodes
 */
package com.trees;

public class NumLeafFullHalfNodes 
{
	public int getNumLeafNodes(BTNode root)
	{
		if (root == null)
			return 0;
		else
		{
			int count=0;
			Queue q = new Queue();
			q.enqueue(root);
			
			while (!q.isEmpty())
			{
				BTNode temp = q.dequeue();
				
				if (temp.left == null && temp.right == null)
				{
					count++;
					System.out.print(temp.data+" ");
				}
				if (temp.left != null)
					q.enqueue(temp.left);
				if (temp.right != null)
					q.enqueue(temp.right);
			}
			
			return count;
		}
	}
	
	public int getNumFullNodes(BTNode root)
	{
		if (root == null)
			return 0;
		else
		{
			int count=0;
			Queue q = new Queue();
			q.enqueue(root);
			
			while (!q.isEmpty())
			{
				BTNode temp = q.dequeue();
				
				if (temp.left != null && temp.right != null)
				{
					count++;
					System.out.print(temp.data+" ");
				}
				if (temp.left != null)
					q.enqueue(temp.left);
				if (temp.right != null)
					q.enqueue(temp.right);
			}
			
			return count;
		}
	}
	
	public int getNumHalfNodes(BTNode root)
	{
		if (root == null)
			return 0;
		else
		{
			int count=0;
			Queue q = new Queue();
			q.enqueue(root);
			
			while (!q.isEmpty())
			{
				BTNode temp = q.dequeue();
				
				if ((temp.left!=null&&temp.right==null)||(temp.left == null && temp.right != null))
				{
					count++;
					System.out.print(temp.data+" ");
				}
				if (temp.left != null)
					q.enqueue(temp.left);
				if (temp.right != null)
					q.enqueue(temp.right);
			}
			
			return count;
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
		
		NumLeafFullHalfNodes nln = new NumLeafFullHalfNodes();
		System.out.println(nln.getNumLeafNodes(root));
		System.out.println(nln.getNumFullNodes(root));
		System.out.println(nln.getNumHalfNodes(root));

	}

}
