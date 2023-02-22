/*
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
 

Example 1:


Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

Example 2:

Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.
Example 3:

Input: root = [], key = 0
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-105 <= Node.val <= 105
Each node has a unique value.
root is a valid binary search tree.
-105 <= key <= 105
 * 
 * 
 */

package BST;

import com.trees.BTNode;
import com.trees.Traversals;

public class DeleteNodeInBST {
	
    public BTNode deleteNode(BTNode root, int key) {
    	
    	if (root == null) {
    		System.out.println("Root Node is null");
    		return null;
    	}
    	
    	Boolean keyFound = false;
    	BTNode prev = null;
    	BTNode next = root;
    	BTNode cur = root;
    	BTNode keyNode = null;
    	
    	// search for the node with value/ data = key
    	while (cur!=null) {
    		if (cur.data == key) {
    			keyFound = true;
    			keyNode = cur;
    			break;
    		}
    		else if (key>cur.data) {
    			prev = cur;
    			cur = cur.right;
    		}
    		else {
    			prev = cur;
    			cur = cur.left;
    		}
    	}
    	
    	if (!keyFound) {
    		System.out.println("Key Node not found in the BST");
    		return root;
    	}
    	
    	/* case 1: when the node is a leaf node. 
    	 * cur.left == null && cur.right == null
    	 * */
    	if (keyNode.left == null && keyNode.right == null) {
    		if (prev==null) return null;
    		deleteLeafNode(keyNode, prev);
    	}
    	
    	/* case 2: when the node has just one child node, 
    	 * either left or right.
    	 * */
    	else if ((keyNode.left == null && keyNode.right != null)
    			|| (keyNode.right == null && keyNode.left != null)) {
    		if (prev==null) return null;
    		deleteNodeWithOneChild(keyNode, prev);
    	}
    	
    	/* case 3: when the node has both left and right children.
    	 * In that case we need to replace the data of the root node with 
    	 * either the max of value from its left subtree or the min of 
    	 * value from its right subtree. 
    	 * */
    	else {
    		/* find minimum of the right sub-tree or 
    		the maximum of the left sub-tree.
    		minRightBST and maxLeftBST will either be a node with single 
    		child or will be a leaf node.
    		*/
    		BTNode minRightBST = minOfBST(keyNode.right);
    		// Or BTNode maxLeftBST = maxOfBST(keyNode.left);
    		
    		// delete minRightBST
    		root = deleteNode(root, minRightBST.data);
    		
    		// replace root.data with minRightBST.data
    		keyNode.data = minRightBST.data;
 
    	}
        
    	return root;

    }
    
    public void deleteLeafNode(BTNode keyNode, BTNode prev) {
    	if (keyNode.left == null && keyNode.right == null) {
    		if (prev.left!=null && prev.left.data == keyNode.data) {
    			prev.left = null;
    		}
    		else {
    			prev.right = null;
    		}
    	}
    	else {
    		System.out.println("Key Node not a leaf node");
    		return;
    	}
    		
    }
    
    public void deleteNodeWithOneChild(BTNode keyNode, BTNode prev) {
    	if (keyNode.left == null && keyNode.right != null) {
    		if (prev.left.data == keyNode.data) {
    			prev.left = keyNode.right;
    			keyNode.right = null;
    		}
    		else {
    			prev.right = keyNode.right;
    			keyNode.right = null;
    		}
    	}
    	
    	else if (keyNode.right == null && keyNode.left != null) {
    		if (prev.left.data == keyNode.data) {
    			prev.left = keyNode.left;
    			keyNode.left = null;
    		}
    		else {
    			prev.right = keyNode.left;
    			keyNode.left = null;
    		}
    	}
    	
    	else {
    		System.out.println("Key Node not a node with 1 child");
    		return;
    	}
    }
    
    
    
    public BTNode minOfBST(BTNode root) {
    	if (root == null) return null;
    	
    	BTNode temp = root;
    	
    	while (temp.left != null) {
    		temp = temp.left;
    	}
    	
    	return temp;
    }
    
    public BTNode maxOfBST(BTNode root) {
    	if (root == null) return null;
    	
    	BTNode temp = root;
    	
    	while (temp.right != null) {
    		temp = temp.right;
    	}
    	
    	return temp;
    }

	public static void main(String[] args) {
//		BTNode root = new BTNode(5);
//		root.left = new BTNode(3);
//		root.right = new BTNode(6);
//		root.left.left = new BTNode(2);
//		root.left.right = new BTNode(4);
//		root.right.left = null;
//		root.right.right = new BTNode(7);
		
		BTNode root = new BTNode(5);

		DeleteNodeInBST delete = new DeleteNodeInBST();
		BTNode new_root = delete.deleteNode(root, 5);
		Traversals traversal = new Traversals();
		traversal.LevelOrderTraversal(new_root);
	}

}
