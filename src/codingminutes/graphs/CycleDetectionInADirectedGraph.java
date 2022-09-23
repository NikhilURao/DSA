/*
 * 
 * 
 * 
 */
package codingminutes.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import codingminutes.graphs.graphrepresentation.Graph;

public class CycleDetectionInADirectedGraph {
	
	public boolean isCycleDetected(int V, int [][] edges, int src) {
		Graph g = new Graph(V);
		
		for (int [] edge: edges) {
			g.addEdge(edge[0], edge[1], false);
		}
		
		Set<Integer> visited = new HashSet<>();
		Set<Integer> visitedInCurCallStack = new HashSet<>();
		
		for (int i=0; i<V; i++) {
			if (!visited.contains(i)) {
				if (DFS(i, visited, visitedInCurCallStack, g.getAdjacencyList())) {
					return true;
				}
			}
		}
		return false;
		
	}
	
	public boolean DFS(int node, Set<Integer> visited , Set<Integer> visitedInCurCallStack, ArrayList<Integer>[] ls) {
		// arrive at a node
		visited.add(node);
		visitedInCurCallStack.add(node);
		
		// return true if back edge is present
		for (int nbr: ls[node]) {
			if (visitedInCurCallStack.contains(nbr))
				return true;
			
			else if (!visited.contains(nbr)) {
				boolean nbrContainsCycle = DFS(nbr, visited, visitedInCurCallStack, ls);
				
				if (nbrContainsCycle) {
					return true;
				}
			}
			
		}
		
		visitedInCurCallStack.remove(node);
		return false;
		
		
	}

	public static void main(String[] args) {
		int [][] edges = {{0,1}, {1,2}, {0,4}, {4,3}, {3,5}, {4,5}};
		// int [][] edges = {{0,1}, {1,2}, {0,4}, {4,3}, {3,5}, {5,4}};
		System.out.println("Directed Graph");
		CycleDetectionInADirectedGraph cycDetectDirectedGraph = new CycleDetectionInADirectedGraph();
		System.out.println(cycDetectDirectedGraph.isCycleDetected(6, edges, 0));
		System.out.println("UnDirected Graph");
		CycleDetectionInAnUndirectedGraph cycDetectUndirectedGraph = new CycleDetectionInAnUndirectedGraph();
		System.out.println(cycDetectUndirectedGraph.isCycleDetected(6, edges, 0));

	}

}
