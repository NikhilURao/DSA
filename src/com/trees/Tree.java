/* *
 * 1. Tree is a non-linear DS, in particular it is a hierarchical DS.
 * 
 * 2. Tree Data Structure is used to organize data in hierarchical manner.
 * 
 * 3. A Tree is a non-linear data structure where each node is connected to 
 *    a number of nodes (not necessarily 2) with the help of pointers or 
 *    references.
 *    
 *    Tree Terminologies
 *    
 *    1. Root: The Root is the first node of the tree.
 *    
 *    2. Edge: An Edge is a link connecting any 2 nodes in tree.
 *    
 *    3. Parent and Children node.
 *    
 *    4. Siblings: The children nodes of the same parent are called Siblings.
 *    			   That is, the nodes with same parent are called siblings.
 *    
 *    5. Leaf Node: A node is said to be the leaf node if it has no children. 
 *    
 *    6. Height of a Tree: 
 *    Height of a tree is defined as the total number of levels in the tree or the 
 *    length of the path from the root node to the node present at the last level 
 *    or the farthest leaf node.
 *    
 *    						OR
 *    
 *    Height of a tree is the distance/number of edges from the root to 
 *    farthest leaf.
 *    						OR
 *    
 *    Height of a tree is the number of nodes from the root to the farthest leaf.
 *    
 *    						OR 
 *    Height of tree = max(height of its children node) + 1
 *    
 *    7. Depth of a node: Depth of the node is the distance of that node from the root.
 *    	 Depth of a node is equal to the level of the node.
 *    
 *    8. Depth of a tree = height of a tree.
 *    	 Depth of a tree is the distance between the farthest leaf and the root.
 *  
 *  Why Tree? 
 *  
 *  Unlike Array and Linked List, which are linear data structures, 
 *  tree is hierarchical (or non-linear) data structure. 
 *  
 *  1. One reason to use trees might be because you want to store information 
 *  that naturally forms a hierarchy. For example, the file system on a 
 *  computer.
 *  
 *  2. If we organize keys in form of a tree (with some ordering e.g., BST), 
 *  we can search for a given key in moderate time (quicker than Linked List 
 *  and slower than arrays). Self-balancing search trees like AVL and 
 *  Red-Black trees guarantee an upper bound of O(Logn) for search.
 *  
 *  3. We can insert/delete keys in moderate time (quicker than Arrays and 
 *  slower than Unordered Linked Lists). Self-balancing search trees like AVL 
 *  and Red-Black trees guarantee an upper bound of O(Logn) for insertion/deletion.
 *  
 *  4. Like Linked Lists and unlike Arrays, Pointer implementation of trees 
 *  don’t have an upper limit on number of nodes as nodes are linked using 
 *  pointers.
 *  
 *  Other Applications : 
 *  
 *  1. Store hierarchical data, like folder structure, organization structure, 
 *  XML/HTML data.
 *  
 *  2. Binary Search Tree is a tree that allows fast search, insert, delete
 *  on a sorted data. It also allows finding closest item.
 *  
 *  3. Heap is a tree data structure which is implemented using arrays and 
 *  used to implement priority queues.
 *  
 *  4. B-Tree and B+ Tree : They are used to implement indexing in databases.
 *  
 *  5. Syntax Tree:  Scanning, parsing , generation of code and evaluation of 
 *  arithmetic expressions in Compiler design.
 *  
 *  6. K-D Tree: A space partitioning tree used to organize points in K 
 *  dimensional space.
 *  
 *  7. Trie : Used to implement dictionaries with prefix lookup.
 *  
 *  8. Suffix Tree : For quick pattern searching in a fixed text.
 *  
 *  9. Spanning Trees and shortest path trees are used in routers 
 *  and bridges respectively in computer networks
 *  
 *  10. As a workflow for compositing digital images for visual effects.
 *  
 *  11. Decision trees.
 *  
 *  12. Organization chart of a large organization.
 *  
 *  13. In XML parser.
 *  
 *  14. Machine learning algorithm.
 *  
 *  15. IN server like DNS (Domain Name Server)
 *  
 *  16. In java virtual machine.
 * 
 *  
 * */

package com.trees;

public class Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
