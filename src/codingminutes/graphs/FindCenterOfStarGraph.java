/*
 * Find Center of Star Graph

There is an undirected star graph consisting of n nodes labeled from 1 to n. A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node.

You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the nodes ui and vi. Return the center of the given star graph.

 

Example 1:


Input: edges = [[1,2],[2,3],[4,2]]
Output: 2
Explanation: As shown in the figure above, node 2 is connected to every other node, so 2 is the center.
Example 2:

Input: edges = [[1,2],[5,1],[1,3],[1,4]]
Output: 1
 

Constraints:

3 <= n <= 105
edges.length == n - 1
edges[i].length == 2
1 <= ui, vi <= n
ui != vi
The given edges represent a valid star graph.
 * 
 * 
 * 
 * 
 */
package codingminutes.graphs;

public class FindCenterOfStarGraph {
	
	/*
	Solve using degree concept in Graph
	Create a frequency array of edges.length + 2 and iterate through the edges and count the occurrences 
	of edges[i][0] and edges[i][1]. Later check which freq array and return the index which has freq == num of nodes
	Time Complexity: O(n)
	Space Complexity:O(n) -> For degree array extra space.
	*/
	    public static int findCenter1(int[][] edges) {
	    int n=edges.length;
	    int degree[]=new int[edges.length+2];
	    for(int a[]:edges){
	    degree[a[0]]++;
	    degree[a[1]]++;
	    }
	        for(int i=1;i<degree.length;i++){
	            if(degree[i]==n){
	                return i;
	            }
	        }
	        return 0;
	    }

	/*
	 * If all the nodes in the graph are connected to a certain node (central node), we are a 100% sure that the node's value is going to appear in every pair of edges[ ].

As a result, we just need to compare the first two pairs in edges[ ], if the first value at edges[0] is equal to any value at edges[1] (which means is the central node) we return the the first value at edges[0] which is the same as edges[0][0].

Nevertheless, if edges[0][0] is not in edges[1], the only possible solution is to return edges[0][1].
	 */
	
	/*
	rather than looking for a vertex that exists in every pair, we check for first two pairs.
	Time Complexity: O(1)
	Space Complexity:O(1) 
	*/

	    public static int findCenter2(int[][] edges) {
	        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1])
	            return edges[0][0];
	        
	        else 
	            return edges[0][1];
	    }
	public static void main(String[] args) {
		int [][] edges = {{1,2},{5,1},{1,3},{1,4}};
		System.out.println(findCenter1(edges));
		System.out.println(findCenter2(edges));

	}

}
