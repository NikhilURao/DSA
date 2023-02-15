// Left view of a BT

package com.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftView {
	
	public ArrayList<Integer> showLeftView(BTNode root){
		
		if (root == null) return new ArrayList<Integer>();
		
		else {
			// do level order traversal of BT and store the nodes at each level in a list of lists
			ArrayList<ArrayList<Integer>> ls = new ArrayList<ArrayList<Integer>>();
			Queue<BTNode> queue = new LinkedList<BTNode>();
			queue.add(root);
			
			while (!queue.isEmpty()) {
				int size = queue.size();
				ArrayList<Integer> lvl = new ArrayList<>();
				
				for (int i=0; i<size; i++) {
					BTNode temp = queue.poll();
					if(temp.left!=null) 
						queue.add(temp.left);
					if(temp.right!=null)
						queue.add(temp.right);
					lvl.add(temp.data);
				}
				
				ls.add(lvl);

			}
			
			// only take the first element in each list. 1st element in the list of level order traversal represents the left view of BT
			ArrayList<Integer> out = new ArrayList<>();
			for (int i=0; i<ls.size(); i++) {
				out.add(ls.get(i).get(0));
			}
			
			return out;
		}
		
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
		
		LeftView lv = new LeftView();
		ArrayList<Integer> out = lv.showLeftView(root);
		for (int i=0; i<out.size(); i++) {
			System.out.print(out.get(i)+" ");;
		}

		// 6  | 11 15  | 13 4 5 9  | 14 1 2  | 3 12  | 
	}

}
