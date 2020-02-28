package com.trees;

public class BinaryTree {
	BTNode root;
	
	public void Insert(int data)
	{
		if (this.root == null)
		{
			this.root = new BTNode(data);
		}
		else 
		{
			Queue q = new Queue();
			q.enqueue(this.root);
			
			while (!q.isEmpty())
			{
				BTNode temp = q.dequeue();
				System.out.println(temp.data);
				
				if (temp.left == null)
				{
					temp.left = new BTNode (data);
					return;
				}
				else
				{
					q.enqueue(temp.left);
				}
				
				if (temp.right == null)
				{
					temp.right = new BTNode (data);
					return;
				}
				else
				{
					q.enqueue(temp.right);
				}
			}
		}
	}
	
	public void print()
	{
		if (this.root != null)
		{
			Queue q = new Queue();
			q.enqueue(this.root);
			
			while (!q.isEmpty())
			{
				BTNode temp = q.dequeue(); 
				System.out.println(temp.data+" ");
				
				if (temp.left != null)
				{
					q.enqueue(temp.left);
				}
				
				if (temp.right != null)
				{
					q.enqueue(temp.right);
				}
			}
		}
	}

	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();
		bt.Insert(10);
		bt.Insert(20);
		bt.Insert(40);
		bt.Insert(56);
		bt.Insert(13);
		
		bt.print();
		
	}

}
