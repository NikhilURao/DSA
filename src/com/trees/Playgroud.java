package com.trees;

public class Playgroud 
	{
		public int getHeight(BTNode root)
		{
			if (root == null)
				return -1;// 0 if root node is considered as Height=1 else -1 if root considered as Height=0
			else
			{
				int lh = getHeight(root.left);
				int rh = getHeight(root.right);
				
				return (lh>rh)? lh + 1 : rh + 1;
			}
		}
		
		public int getMax(BTNode root)
		{
			if (root==null)
				return Integer.MIN_VALUE;
			else
			{
				int lmax = getMax(root.left);
				//System.out.println(lmax);
				int rmax = getMax(root.right);
				//System.out.println(rmax);
				
				if (lmax > rmax && lmax > root.data)
					return lmax;
					
				else if (rmax >= lmax && rmax >= root.data)
					return rmax;
				else
					return root.data;
			}
		}
		
		public int getMaxIt(BTNode root)
		{
			int max = Integer.MIN_VALUE;
			
			if (root == null)
				return max;
			else
			{
				Queue q = new Queue();
				q.enqueue(root);
				
				while (!q.isEmpty())
				{
					BTNode temp = q.dequeue();
					
					if (temp.data > max)
						max = temp.data;
					
					if (temp.left!=null)
						q.enqueue(temp.left);
					if (temp.right!=null)
						q.enqueue(temp.right);
				}
				
				return max;
			}
		}
		
		public boolean searchBT(BTNode root, int key)
		{
			if (root == null)
				return false;
			else
			{
				if (root.data == key || searchBT(root.left, key)|| searchBT(root.right, key))
					return true;
				else
					return false;
			}
		}
		
		public void insertIntoBT(BTNode root, int data)
		{
			if (root != null)
			{
				Queue q = new Queue();
				q.enqueue(root);
				while(!q.isEmpty())
				{
					BTNode temp = q.dequeue();
					
					if (temp.left == null)
					{
						temp.left = new BTNode(data);
						break;
					}	
					else
						q.enqueue(temp.left);
					if (temp.right == null)
					{
						temp.right = new BTNode(data);
						break;
					}
					else
						q.enqueue(temp.right);
				}
			}
			else
				return;
		}
		
		public int sizeOfBT(BTNode root)
		{
			if (root == null)
				return 0;
			else
			{
				int lcount = sizeOfBT(root.left);
				int rcount = sizeOfBT(root.right);
				return lcount + rcount + 1;
			}
		}
		
		public void reverseLevelOrderTransversal(BTNode root)
		{
			if (root != null)
			{
				Queue q = new Queue();
				Stack s = new Stack();
				q.enqueue(root);
				
				while (!q.isEmpty())
				{
					BTNode temp = q.dequeue();
					s.push(temp);
					if (temp.left != null)
						q.enqueue(temp.left);
					if (temp.right != null)
						q.enqueue(temp.right);
				}
				
				while(!s.isEmpty())
				{
					BTNode ptr_data = s.pop();
					System.out.print(ptr_data.data+" ");
				}
			}
			else 
				return;
		}
		
		public int getHeightIterative(BTNode root)
		{
			if (root != null)
			{
				Queue q = new Queue();
				q.enqueue(root);
				q.enqueue(null);
				int count = 1;
				
				while (!q.isEmpty())
				{
					BTNode temp = q.dequeue();
					
					if (temp!=null)
					{
						if (temp.left == null && temp.right == null)
							return count;
						else if (temp.left!=null)
							q.enqueue(temp.left);
						else if (temp.right!=null)
							q.enqueue(temp.right);
					}
					else
					{
						if (!q.isEmpty())
						{
						count++;
						q.enqueue(null);
						}
					}
					
				}
				return count;
			}
			else 
				return 0;	
		}
		
		public int getminDepth(BTNode root)
		{
			if (root == null)
				return 0;
			else
			{
				int lc = getminDepth(root.left);
				int rc = getminDepth(root.right);
				
				return (lc<rc)? lc+1 : rc+1;
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
		
		Playgroud p = new Playgroud();
		System.out.println("Height of the BT using rec is: "+p.getHeight(root));
		System.out.println("Height of the BT using iterative is:"+p.getHeightIterative(root));
		System.out.println("Minimum Depth of BT is:"+p.getminDepth(root));
		System.out.println("Number of Elements/ Count of Elements in BT/ Size of BT:"+p.sizeOfBT(root));
		System.out.println("Maximum Element in the BT is: rec: "+p.getMax(root));
		System.out.println("Maximum Element in the BT is: iterative: "+p.getMaxIt(root));
		System.out.println(p.searchBT(root, 8));
		LevelOrderTransversal lot = new LevelOrderTransversal();
		lot.LevelOrderTraverse_Iterative(root);
		p.insertIntoBT(root, 21);
		System.out.println();
		lot.LevelOrderTraverse_Iterative(root);
		System.out.println();
		p.reverseLevelOrderTransversal(root);

	}

}
