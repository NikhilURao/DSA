/*
 * Queue and BFS
Prerequisite: Tree Level-order Traversal

Breadth-first search (BFS) is an algorithm to traverse or search in data structures like a tree or a graph.

As we mentioned, we can use BFS to do level-order traversal in a tree.

We can also use BFS to traverse a graph. For example, we can use BFS to find a path, 
especially the shortest path, from a start node to a target node.

We can use BFS, in even more abstract scenarios, to traverse all the possible statuses. 
In this case, we can regard the statuses as the nodes in the graph while the legal transition paths as 
the edges in the graph.
 
One common application of Breadth-first Search (BFS) is to find the shortest path from the root node to the target
node.


1. What is the processing order of the nodes?

In the first round, we process the root node. In the second round, we process the nodes next to the root node; 
in the third round, we process the nodes which are two steps from the root node; so on and so forth.

Similar to tree's level-order traversal, the nodes closer to the root node will be traversed earlier.

If a node X is added to the queue in the kth round, the length of the shortest path between the root node and X 
is exactly k. That is to say, you are already in the shortest path the first time you find the target node.

2. What is the enqueue and dequeue order of the queue?

As shown in the animation above, we first enqueue the root node. Then in each round, we process the nodes 
which are already in the queue one by one and add all their neighbors to the queue. 
It is worth noting that the newly-added nodes will not be traversed immediately but will be processed in the 
next round.

The processing order of the nodes is the exact same order as how they were added to the queue, 
which is First-in-First-out (FIFO). That's why we use a queue in BFS.
 */
package com.queue.queueAndBFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class QueueAndBFS {
	
	public class Node{
		
	}
	
	
	/**
	 * BFS Template 1 without visited
	 * Return the length of the shortest path between root and target node.
	 * 
	 * 1. As shown in the code, in each round, the nodes in the queue are the nodes which are waiting to be processed.
     * 2. After each outer while loop, we are one step farther from the root node. 
     * 		The variable step indicates the distance from the root node and the current node we are visiting.
	 * 
	 */
	int BFS(Node root, Node target) {
	    Queue<Node> queue = new LinkedList<>();  // store all nodes which are waiting to be processed
	    int step = 0;       // number of steps needed from root to current node
	    // initialize
	    // add root to queue;
	    queue.offer(root);
	    // or
	    queue.add(root);
	    // BFS
	    // queue is not empty
	    while (!queue.isEmpty()) {
	        // iterate the nodes which are already in the queue
	        int size = queue.size();
	        for (int i = 0; i < size; ++i) {
	            Node cur = queue.poll(); // the first node in queue;
	            
	            // if cur is target return step ()
	            if (cur == target)
	            	/*
	            	 * If a node X is added to the queue in the kth round, the length of the shortest path 
	            	 * between the root node and X is exactly k. That is to say, you are already in the 
	            	 * shortest path the first time you find the target node. So we return step knowing that it
	            	 * is the shortest path.
	            	 */
	            	return step;
	            
	            // define the neighbors of cur
	            // if you are allowed to move in up, down, left, right in a matrix then we can use a directions 
	            // array of array
	            int [][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	            // get nls from dirs
	            Node [] nls = new Node[10];
	            for (Node next : nls) {
	                queue.add(next);//add next to queue;
	            }
	            //remove the first node from queue;
	            queue.poll();
	        }
	        step = step + 1;
	    }
	    return -1;          // there is no path from root to target
	}
	
	/**
	 * Return the length of the shortest path between root and target node.
	 * Sometimes, it is important to make sure that we never visit a node twice. 
	 * Otherwise, we might get stuck in an infinite loop, e.g. in graph with cycle. 
	 * If so, we can add a hash set to the code above to solve this problem. 
	 */
	int BFSWithVisited(Node root, Node target) {
	    Queue<Node> queue = new LinkedList<>();  // store all nodes which are waiting to be processed
	    Set<Node> visited = new HashSet<>();  // store all the nodes that we've visited
	    int step = 0;       // number of steps needed from root to current node
	    // initialize
	    // add root to queue;
	    queue.offer(root);
	    // or
	    queue.add(root);
	    // add root to visited;
	    visited.add(root);
	    // BFS
	    while (!queue.isEmpty()) {
	        // iterate the nodes which are already in the queue
	        int size = queue.size();
	        for (int i = 0; i < size; ++i) {
	        	Node cur = queue.poll(); // the first node in queue;
	            
	            // if cur is target return step ()
	            if (cur == target)
	            	/*
	            	 * If a node X is added to the queue in the kth round, the length of the shortest path 
	            	 * between the root node and X is exactly k. That is to say, you are already in the 
	            	 * shortest path the first time you find the target node. So we return step knowing that it
	            	 * is the shortest path.
	            	 */
	            	return step;
	            // define the neighbors of cur
	            // if you are allowed to move in up, down, left, right in a matrix then we can use a directions 
	            // array of array
	            int [][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	            // get nls from dirs
	            Node [] nls = new Node[10];
	            for (Node next : nls) {
	                if (!visited.contains(next)) { // next is not in visited
	    	            for (Node nxt : nls) {
	    	                queue.add(nxt);//add next to queue;
	    	                visited.add(nxt); // add next to set visited
	    	            }
	    	            
	                }
	            }
	            // remove the first node from queue;
	            queue.poll();
	        }
	        step = step + 1;
	    }
	    return -1;          // there is no path from root to target
	}
	
	/*
	 * There are some cases where one does not need keep the visited hash set:
	 * You are absolutely sure there is no cycle, for example, in tree traversal;
	 * You do want to add the node to the queue multiple times.
	 */
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
