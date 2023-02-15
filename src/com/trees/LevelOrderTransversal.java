package com.trees;

import java.util.*;

import java.util.Queue;



public class LevelOrderTransversal {
	
	// prints the BT nodes level by level
	public void LevelOrderTraverse_Iterative(BTNode root)
	{
		if (root != null)
		{
			Queue<BTNode> q = new LinkedList<>();
			q.add(root);
			
			while (!q.isEmpty())
			{
				BTNode temp = q.poll();
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
	
	// return list of lists
	public ArrayList<ArrayList> LevelOrderTraversal(BTNode root){
		
		ArrayList<ArrayList> resLevel = new ArrayList<ArrayList>();
		
		if (root == null) return resLevel;
		
		else {
			Queue<BTNode> queue = new LinkedList<BTNode>();
			queue.add(root);
			
			while (!queue.isEmpty()) {
				ArrayList<Integer> curLevelNodes = new ArrayList<>();
				int size = queue.size();
				
				for (int i=0; i<size; i++) {
					BTNode temp = queue.poll();
					if(temp.left!=null) 
						queue.add(temp.left);
					if(temp.right!=null) 
						queue.add(temp.right);
					curLevelNodes.add(temp.data);
				}
				resLevel.add(curLevelNodes);
			}
			
			return resLevel;
		}
		
	}
	
	public ArrayList<ArrayList<Integer>> levelOrder(BTNode A) {

	       Queue<BTNode> q = new LinkedList();
	        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(); // final return ArrayList
	        q.add(A);  // adding root BTNode to q
	        while(q.size() > 0){
	            int N = q.size();
	            ArrayList<Integer> temp = new ArrayList<>();  // creating a new ArrayList for every level
	            for(int i=0; i<N; i++){  // iterating for each level
	                BTNode t = q.peek();
	                temp.add(t.data);
	                q.remove();
	                if(t.left != null) q.add(t.left);
	                if(t.right != null) q.add(t.right);
	                
	            }
	            ans.add(temp);  // adding temp ArrayList to ans ArrayList
	        }
	        return ans;
	}
    
	

	public static void main(String[] args) {
		
		BTNode root = new BTNode (6);// Level 0 Root
		root.left = new BTNode(11);// Level 1 left
		root.right = new BTNode(15);// Level 1 right
		root.left.left = new  BTNode(13); 
		root.left.right = new BTNode(4);
		root.left.right.left = new BTNode(14);
		root.left.right.left.right = new BTNode(3);
		root.right.left = new BTNode(5);
		root.right.right = new BTNode(9);
		root.right.left.left = new BTNode(1);
		root.right.left.right = new BTNode(2);
		root.right.left.right.left = new BTNode(12);
		
		LevelOrderTransversal lot = new LevelOrderTransversal();
		lot.LevelOrderTraverse_Iterative(root);
		System.out.println();
		ArrayList<ArrayList> out = lot.LevelOrderTraversal(root);
		
		for (int i=0; i<out.size(); i++) {
			for (int j=0; j<out.get(i).size(); j++) {
				System.out.print(out.get(i).get(j) + " ");
			}
			System.out.print(" | ");
		}
		System.out.println();
		ArrayList<ArrayList<Integer>> outls = lot.levelOrder(root);
		
		for (int i=0; i<out.size(); i++) {
			for (int j=0; j<outls.get(i).size(); j++) {
				System.out.print(outls.get(i).get(j) + " ");
			}
			System.out.print(" | ");
		}
		
		/*
		LinkedList<Integer> q = new LinkedList<Integer>();
		ArrayDeque<Integer> qa = new ArrayDeque<Integer>();
		ArrayList<ArrayList<Integer>> nodes = new ArrayList<ArrayList<Integer>>();
		ArrayList <Integer> ls = new ArrayList<Integer>();
		ls.add(1);
		ls.add(2);
		System.out.println(ls);
		
		nodes.add(ls);
		System.out.println(nodes);
		*/
		
		
	}

}
