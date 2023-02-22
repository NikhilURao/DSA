package BST;

import com.trees.BTNode;

public class BSTNodeInRange {
	
	/**
	* Approach: As this is binary tree, whenever we get a value equal to B(lower limit) we don't have to check its left nodes.
	* Similarly, whenever we get a value equal to C(upper limit) we don't have to check its right nodes.
	* If we get a value which is within B & C, we check both left and right nodes and to include itself, we add 1 to ans.
	* If we get a value which is not within B & C, we check both left and right node but dont add itself.

	* Steps:
	* Check if the current node is null. If so, return 0, since there are no nodes to count.
	* Check if the value of the current node is between B and C. If so, count this node, and continue recursively checking its left and right subtrees.
	* If the value of the current node is equal to B, count this node, and continue recursively checking only its right subtree.
	* If the value of the current node is equal to C, count this node, and continue recursively checking only its left subtree.
	* If the value of the current node is not between B and C, do not count this node, and continue recursively checking its left and right subtrees.
	* Add up all the nodes that were counted in the above steps and return the total count.

	**/

	public int solve(BTNode A, int B, int C) {
		if(A == null) return 0;
	    if(A.data > B && A.data < C) return solve(A.left, B, C) + 1 + solve (A.right, B, C);
	    else if(A.data == B) return solve(A.right, B, C) + 1;
	    else if(A.data == C) return solve(A.left, B, C) + 1;
	    else return solve(A.left, B, C) + solve(A.right, B, C);
	    }
	

	public static void main(String[] args) {
		BTNode root = new BTNode(7);
		root.left = new BTNode(6);
		root.right = new BTNode(11);
		root.left.left = new BTNode(14);
		root.left.right = new BTNode(5);
		root.right.left = new BTNode(2);
		root.right.right = new BTNode(4);
		BSTNodeInRange bstnir = new BSTNodeInRange();
		System.out.println(bstnir.solve(root, 5, 10));

	}

}
