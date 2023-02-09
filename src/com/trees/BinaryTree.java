/* *
 * 
 *  A Tree is said to be a Binary Tree if all of its nodes have at-most or max
 *  2 children. That is, all of its node can have either no child, 1 child, or 2 child nodes.
 *     
 *   Properties of a Binary Tree:
 *   1. The maximum number of nodes at level 'l' of a binary tree is (2l - 1). 
 *   Level of root is 1. This can be proved by induction. For root, l = 1, 
 *   number of nodes = 21-1 = 1 Assume that the maximum number of nodes on 
 *   level l is 2l-1. Since in Binary tree every node has at most 2 children,
 *    next level would have twice nodes, i.e. 2 * 2l-1.
 *    
 *   2. Maximum number of nodes in a binary tree of height 'h' is (2h – 1). 
 *   Here height of a tree is the maximum number of nodes on the root to 
 *   leaf path. The height of a tree with a single node is considered as 1. 
 *   This result can be derived from point 2 above. A tree has maximum nodes
 *    if all levels have maximum nodes. So maximum number of nodes in a 
 *    binary tree of height h is 1 + 2 + 4 + .. + 2h-1. This is a simple 
 *    geometric series with h terms and sum of this series is 2h – 1. 
 *    In some books, the height of the root is considered as 0. In that 
 *    convention, the above formula becomes 2h+1 – 1.
 *    
 *   3. In a Binary Tree with N nodes, the minimum possible height or 
 *   the minimum number of levels is Log2(N+1). This can be directly 
 *   derived from point 2 above. If we consider the convention where 
 *   the height of a leaf node is considered 0, then above formula for 
 *   minimum possible height becomes Log2(N+1) – 1.
 *   
 *   4. A Binary Tree with L leaves has at least (Log2L + 1) levels. 
 *   A Binary tree has maximum number of leaves (and minimum number of 
 *   levels) when all levels are fully filled. Let all leaves be at level l, 
 *   then below is true for number of leaves L.
 *   
 *   5. In a Binary tree in which every node has 0 or 2 children, the number
 *   of leaf nodes is always one more than the nodes with two children.
 *   
 *   Types of Binary Trees: 
 *   Based on the structure and number of parents and children nodes, 
 *   a Binary Tree is classified into the following common types:
 *   
 *   1. Full Binary Tree: A Binary Tree is full if every node has either 
 *   0 or 2 children. The following are examples of a full binary tree.
 *   We can also say that a full binary tree is a binary tree in which 
 *    all nodes except leave nodes have two children.
 *    
 *   2. Complete Binary Tree: A Binary Tree is a complete Binary Tree if all 
 *   levels are completely filled except possibly the last level and the last
 *   level has all keys as left as possible.
 *   
 *   3. Perfect Binary Tree: A Binary tree is a Perfect Binary Tree when all
 *   internal nodes have two children and all the leave nodes are at the same 
 *   level.
 *  
 * */

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
