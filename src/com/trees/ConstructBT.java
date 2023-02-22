package com.trees;

public class ConstructBT 
{
	int root_index=0;
	int root_index_1=14;
	
	public BTNode constructBTUsingInPreOrder(int[]in,int[]pre,int start,int end)
	{
		if (start<=end)
		{
			BTNode root = new BTNode(pre[root_index]);
			root_index++;
			int ptr=0;
			for(int i=0;i<in.length;i++)
			{
				if (in[i]==pre[root_index-1])
				{
					ptr = i;
					break;
				}
			}
			root.left = constructBTUsingInPreOrder(in, pre, start, ptr-1);
			root.right = constructBTUsingInPreOrder(in, pre, ptr+1, end);
			
			return root;
			
		}
		else
			return null;
	}
	
	public BTNode constructBTUsingInPostOrder(int[]in,int[]post,int start,int end)
	{
		if (start<=end)
		{
			BTNode root = new BTNode(post[root_index_1]);
			root_index_1 --;
			int ptr=0;
			
			for (int i=0;i<in.length;i++)
			{
				if (in[i]==post[root_index_1+1])
				{
					ptr = i;
					break;
				}
			}
			
			root.right = constructBTUsingInPostOrder(in, post, ptr+1, end);
			root.left = constructBTUsingInPostOrder(in, post, start, ptr-1);
			
			return root;
		}
		else
			return null;
	}
	
	
	// Function for in-order, pre-order and post-order traversal 
	public void levelorderTraverse(BTNode root)
	{
		if (root!=null)
		{
			Queue q = new Queue();
			q.enqueue(root);
			
			while (!q.isEmpty())
			{
				BTNode temp = q.dequeue();
				System.out.print(temp.data+" ");
				if (temp.left!=null)
					q.enqueue(temp.left);
				if (temp.right!=null)
					q.enqueue(temp.right);
			}
		}
		else 
			return;
	}
	
	public void inorderTraverse(BTNode root)
	{
		if (root!=null)
		{
			Stack s = new Stack();
			BTNode temp = root;
			
			while (true)
			{
				while (temp!=null)
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
		else
			return;
	}
	
	public void preorderTraverse(BTNode root)
	{
		if (root!=null)
		{
			Stack s = new Stack();
			BTNode temp = root;
			
			while (true)
			{
				while (temp!=null)
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
		else
			return;
	}
	
	public void postorderTraverse(BTNode root)
	{
		if (root!=null)
		{
			Stack s = new Stack();
			BTNode temp = root;
			
			while (true)
			{
				while(temp!=null)
				{
					if (temp.right!=null)
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
					System.out.print(ptr.data+" ");
				}
				else
				{
					temp = s.pop();
					s.push(ptr);
				}
					
			}
		}
		else
			return;
	}

	public static void main(String[] args) 
	{
		/*
		BTNode root = new BTNode(8);
		root.left = new BTNode(3);
		root.right = new BTNode(11);
		root.left.left = new BTNode(4);
		root.left.right = new BTNode(9);
		root.right.left = new BTNode(6);
		root.right.right = new BTNode(13);
		root.left.left.left = new BTNode(21);
		root.left.left.right = new BTNode(12);
		root.left.right.left = new BTNode(7);
		root.right.left.left = new BTNode(15);
		root.right.left.right = new BTNode(10);
		root.right.right.right = new BTNode(2);
		root.left.left.right.left = new BTNode(1);
		root.right.right.right.right = new BTNode(5);
		
		ConstructBT cbt = new ConstructBT();
		cbt.inorderTraverse(root);//21 4 1 12 3 7 9 8 15 6 10 11 13 2 5 
		System.out.println();
		cbt.preorderTraverse(root);//8 3 4 21 12 1 9 7 11 6 15 10 13 2 5
		*/
		int[] in = {21,4,1,12,3,7,9,8,15,6,10,11,13,2,5};
		int[] pre = {8,3,4,21,12,1,9,7,11,6,15,10,13,2,5};
		int[] post = {21,1,12,4,7,9,3,15,10,6,5,2,13,11,8};
		
		ConstructBT cbt = new ConstructBT();
		BTNode root_inpre=cbt.constructBTUsingInPreOrder(in, pre, 0, in.length-1);
		BTNode root_inpost = cbt.constructBTUsingInPostOrder(in, post, 0, post.length-1);
		System.out.println("BT constructed using in-order and pre-order traversal");
		cbt.inorderTraverse(root_inpre);//21 4 1 12 3 7 9 8 15 6 10 11 13 2 5
		System.out.println();
		cbt.preorderTraverse(root_inpre);//8 3 4 21 12 1 9 7 11 6 15 10 13 2 5
		System.out.println();
		cbt.postorderTraverse(root_inpre);//21 1 12 4 7 9 3 15 10 6 5 2 13 11 8
		System.out.println();
		System.out.println("BT constructed using in-order and post-order traversal");
		cbt.inorderTraverse(root_inpost);//21 4 1 12 3 7 9 8 15 6 10 11 13 2 5
		System.out.println();
		cbt.preorderTraverse(root_inpost);//8 3 4 21 12 1 9 7 11 6 15 10 13 2 5
		System.out.println();
		cbt.postorderTraverse(root_inpost);//21 1 12 4 7 9 3 15 10 6 5 2 13 11 8
		
		
		
		
	}

}