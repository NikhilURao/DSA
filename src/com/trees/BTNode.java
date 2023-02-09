/*
 * Representation of Binary Tree is a BTNode.
 * 
 * Each node in the tree contains the following:
 * 1. Data
 * 2. Pointer to the left child
 * 3. Pointer to the right child
 */
package com.trees;

public class BTNode {
	
	public int data;
	public BTNode left;
	public BTNode right;

	public BTNode(int data) {
		
		this.data = data;
		left = right = null;
		
	} 

}
