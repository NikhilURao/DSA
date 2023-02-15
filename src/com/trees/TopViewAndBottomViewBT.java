/*
 * 
 *   Input:         1
                  /    \ 
                2       3
               / \    /   \
             4    5  6     7
                          /  \ 
                         8    9 

Top view Output: 
4
2
1 
3 
7
9

Bottom View Output:
4
2
6
8
7
9

*/

package com.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.AbstractMap.SimpleEntry;

public class TopViewAndBottomViewBT {
	
	public ArrayList<Integer> showTopView(BTNode root){
		ArrayList<Integer> topViewRes = new ArrayList<Integer>();
    	// vertical order traversal variant
    	if (root == null) return topViewRes;
    	
    	else {
    		Queue<SimpleEntry<Integer, BTNode>> queue = new LinkedList<SimpleEntry<Integer, BTNode>>();
    		SimpleEntry<Integer, BTNode> rootPair = new SimpleEntry<Integer, BTNode>(0, root);
    		queue.add(rootPair);
    		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
    		int maxLevel = Integer.MIN_VALUE; int minLevel = Integer.MAX_VALUE;
    		
    		while (!queue.isEmpty()) {
    			
    			int size = queue.size();
    			
    			ArrayList<Integer> ls = new ArrayList<>();
    			
    			for (int i=0; i<size; i++) {
    				SimpleEntry<Integer, BTNode> curLvlPair = queue.peek();
    				queue.remove();
    				int curDistanceFromRoot = curLvlPair.getKey();
    				BTNode temp = curLvlPair.getValue();
    				
    				if (curDistanceFromRoot > maxLevel) maxLevel = curDistanceFromRoot;
    				if (curDistanceFromRoot < minLevel) minLevel = curDistanceFromRoot;
    				
    				if (temp.left!=null) {
    					SimpleEntry<Integer, BTNode> curLvlPairLeft = new SimpleEntry<Integer, BTNode>(curDistanceFromRoot-1, temp.left);
    		    		queue.add(curLvlPairLeft);
    				}
    				if (temp.right!=null) {
    					SimpleEntry<Integer, BTNode> curLvlPairRight = new SimpleEntry<Integer, BTNode>(curDistanceFromRoot+1, temp.right);
    		    		queue.add(curLvlPairRight);
    				}
    				if (map.containsKey(curDistanceFromRoot)) {
    					ArrayList<Integer> curLvlLs = map.get(curDistanceFromRoot);
    					curLvlLs.add(temp.data);
    					map.put(curDistanceFromRoot, curLvlLs);
    				}
    				else {
    					ArrayList<Integer> curLvlLs = map.getOrDefault(curDistanceFromRoot, new ArrayList<Integer>());
    					curLvlLs.add(temp.data);
    					map.put(curDistanceFromRoot, curLvlLs);
    				}
    				}
    		}
    		
    		for (int i=minLevel; i<=maxLevel; i++) {
    			topViewRes.add(map.get(i).get(0));
    		}
    		
    		return topViewRes;
	}
}
	
	public ArrayList<Integer> showBottomView(BTNode root){
		ArrayList<Integer> bottomViewRes = new ArrayList<Integer>();
    	// vertical order traversal variant
    	if (root == null) return bottomViewRes;
    	
    	else {
    		Queue<SimpleEntry<Integer, BTNode>> queue = new LinkedList<SimpleEntry<Integer, BTNode>>();
    		SimpleEntry<Integer, BTNode> rootPair = new SimpleEntry<Integer, BTNode>(0, root);
    		queue.add(rootPair);
    		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
    		int maxLevel = Integer.MIN_VALUE; int minLevel = Integer.MAX_VALUE;
    		
    		while (!queue.isEmpty()) {
    			
    			int size = queue.size();
    			
    			ArrayList<Integer> ls = new ArrayList<>();
    			
    			for (int i=0; i<size; i++) {
    				SimpleEntry<Integer, BTNode> curLvlPair = queue.peek();
    				queue.remove();
    				int curDistanceFromRoot = curLvlPair.getKey();
    				BTNode temp = curLvlPair.getValue();
    				
    				if (curDistanceFromRoot > maxLevel) maxLevel = curDistanceFromRoot;
    				if (curDistanceFromRoot < minLevel) minLevel = curDistanceFromRoot;
    				
    				if (temp.left!=null) {
    					SimpleEntry<Integer, BTNode> curLvlPairLeft = new SimpleEntry<Integer, BTNode>(curDistanceFromRoot-1, temp.left);
    		    		queue.add(curLvlPairLeft);
    				}
    				if (temp.right!=null) {
    					SimpleEntry<Integer, BTNode> curLvlPairRight = new SimpleEntry<Integer, BTNode>(curDistanceFromRoot+1, temp.right);
    		    		queue.add(curLvlPairRight);
    				}
    				if (map.containsKey(curDistanceFromRoot)) {
    					ArrayList<Integer> curLvlLs = map.get(curDistanceFromRoot);
    					curLvlLs.add(temp.data);
    					map.put(curDistanceFromRoot, curLvlLs);
    				}
    				else {
    					ArrayList<Integer> curLvlLs = map.getOrDefault(curDistanceFromRoot, new ArrayList<Integer>());
    					curLvlLs.add(temp.data);
    					map.put(curDistanceFromRoot, curLvlLs);
    				}
    				}
    		}
    		
    		for (int i=minLevel; i<=maxLevel; i++) {
    			ArrayList<Integer> tls = map.get(i);
    			bottomViewRes.add(tls.get(tls.size()-1));
    		}
    		
    		return bottomViewRes;
	}
}

	public static void main(String[] args) {
		BTNode root = new BTNode (1);// Level 0 Root
		root.left = new BTNode(2);// Level 1 left
		root.right = new BTNode(3);// Level 1 right
		root.left.left = new  BTNode(4); 
		root.left.right = new BTNode(5);
		root.right.left = new BTNode(6);
		root.right.right = new BTNode(7);
		root.right.right.left = new BTNode(8);
		root.right.right.right = new BTNode(9);
		
		TopViewAndBottomViewBT tbv = new TopViewAndBottomViewBT();
		ArrayList<Integer> outTV = tbv.showTopView(root);
		ArrayList<Integer> outBV = tbv.showBottomView(root);
		System.out.print("TV ");
		for (int i=0; i<outTV.size(); i++) {
			System.out.print(outTV.get(i)+" ");
		}
		System.out.println("");
		System.out.print("BV ");
		for (int i=0; i<outBV.size(); i++) {
			System.out.print(outBV.get(i)+" ");
		}

	}

}
