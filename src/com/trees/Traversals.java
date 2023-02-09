/* *
 * 
 * Inorder (Left, Root, Right)
 * Preorder (Root, Left, Right)
 * Postorder (Left, Right, Root)
 * 
 * TC: O(N) where N is the number of nodes in BT
 * SC: If we don’t consider the size of the stack for function calls then O(1)
 * otherwise O(h) where h is the height of the tree. 
 * The height of the skewed tree is n (no. of elements) so the worst space 
 * complexity is O(N) and the height is (Log N) for the balanced tree so 
 * the best space complexity is O(Log N).
 * 
 * */

package com.trees;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Traversals 
{

	public void LevelOrderTraversal(BTNode root)
	{
		if (root != null)
		{
			Queue<BTNode> q = new LinkedList<BTNode>();
			q.add(root);
			
			while (!q.isEmpty())
			{
				BTNode temp = q.remove();
				System.out.print(temp.data+" ");
				
				if (temp.left != null)
				{
					q.add(temp.left);
				}
				if (temp.right != null)
				{
					q.add(temp.right);
				}
			}
		}
	}
	
	/*
	 * Inorder (Left, Root, Right)
	 * TC: O(N) N: number of nodes in BT.
	 * SC: O(N) recursive stack space when the BT is skewed (worst case).
	 */
	
	public void InOrderTraversalRec(BTNode root) {
		if (root!=null) {
			InOrderTraversal(root.left);
			System.out.println(root.data);
			InOrderTraversal(root.right);
		}
	}
	
	public void InOrderTraversal(BTNode root)
	{
		if (root != null)
		{
			BTNode temp = root;
			Stack<BTNode> s = new Stack<BTNode>();
			
			while (true)
			{
				while(temp != null)
				{
					s.push(temp);
					temp = temp.left;
				}
				if (s.isEmpty()) break;
				temp = s.pop();
				System.out.print(temp.data+" ");
				temp = temp.right;
			}
		}
		else 
		{
			return;
		}
	}
	
	/*
	 * Preorder (Root, Left, Right)
	 * TC: O(N) N: number of nodes in BT.
	 * SC: O(N) recursive stack space when the BT is skewed (worst case).
	 */
	
	public void PreOrderTraversalRec(BTNode root) {
		if (root!=null) {
			System.out.println(root.data);
			PreOrderTraversalRec(root.left);
			PreOrderTraversalRec(root.right);
		}
	}
	
	public void PreOrderTraversal(BTNode root)
	{
		if (root != null)
		{
			BTNode temp = root;
			Stack<BTNode> s= new Stack<BTNode>();
			
			while (true)
			{
				while(temp != null)
				{
					System.out.print(temp.data+" ");
					s.push(temp);
					temp = temp.left;
				}
				
				if (s.isEmpty()) break;
				temp = s.pop();
				temp = temp.right;

			}

		}
		
	}
	
	/*
	 * Postorder (Left, Right, Root)
	 * TC: O(N) N: number of nodes in BT.
	 * SC: O(N) recursive stack space when the BT is skewed (worst case).
	 */
	
	public void PostOrderTraversalRec(BTNode root) {
		if (root!=null) {
			PostOrderTraversalRec(root.left);
			PostOrderTraversalRec(root.right);
			System.out.println(root.data);
		}
	}
	
	public void PostOrderTraversal(BTNode root)
	{
		if (root != null)
		{
			BTNode temp = root;
			Stack<BTNode> s = new Stack<BTNode>();
			
			while(true)
			{
				while (temp != null)
				{
					s.push(temp);
					temp = temp.left;
				}
				
				if (s.isEmpty()) break;
				
				if (temp.right != null)
				{
					temp = s.peek();
					temp = temp.right;
				}
				else
				{
					temp = s.pop();
					System.out.print(temp.data+" ");
					temp = s.pop();
				}
			}
		}
		else return;
	}
	
	public static void main(String[] args) 
	{
		BTNode root = new BTNode(7);
		root.left = new BTNode(6);
		root.right = new BTNode(11);
		root.left.left = new BTNode(14);
		root.left.right = new BTNode(5);
		root.right.left = new BTNode(2);
		root.right.right = new BTNode(4);
		
		Traversals tvr = new Traversals();
		tvr.LevelOrderTraversal(root);
		System.out.println();
		tvr.InOrderTraversal(root);
		System.out.println();
		tvr.PreOrderTraversal(root);
		System.out.println();
		tvr.PostOrderTraversal(root);
	}
}
