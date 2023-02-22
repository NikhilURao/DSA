/*
 * Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).

Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.



Problem Constraints
1 <= length of array <= 100000



Input Format
First argument is an integer array A.



Output Format
Return a root node of the Binary Search Tree.



Example Input
Input 1:

 A : [1, 2, 3]
Input 2:

 A : [1, 2, 3, 5, 10]


Example Output
Output 1:

      2
    /   \
   1     3
Output 2:

      3
    /   \
   2     5
  /       \
 1         10
 
 
       3
     /   \
    1     5
     \     \
      2     10


Example Explanation
Explanation 1:

 You need to return the root node of the Binary Tree.
 
 TC: O(n)
 SC: O(n) for creating BST + O(log n) for recursion/ height of tree = recursive stack size
 */

package BST;

import java.util.ArrayList;

import com.trees.BTNode;

import com.trees.LevelOrderTransversal;

public class SortedArrayToBST {
	
    public BTNode createBBST(int[] A, int start, int end){
        if(start > end) return null;

        int mid = (start + end)/2;
        BTNode root = new BTNode(A[mid]);
        root.left = createBBST(A, start, mid-1);
        root.right = createBBST(A, mid+1, end);
        return root;
    }
    public BTNode sortedArrayToBST(final int[] A) {
        return createBBST(A, 0, A.length-1);
    }

	public static void main(String[] args) {
		int [] arr = {1, 2, 3, 5, 10};
		SortedArrayToBST sabst = new SortedArrayToBST();
		
		BTNode root = sabst.sortedArrayToBST(arr);
		
		LevelOrderTransversal lot = new LevelOrderTransversal();
		
		ArrayList<ArrayList<Integer>> outls = lot.levelOrder(root);
		
		for (int i=0; i<outls.size(); i++) {
			for (int j=0; j<outls.get(i).size(); j++) {
				System.out.print(outls.get(i).get(j) + " ");
			}
			System.out.print(" | ");
		}

	}

}
