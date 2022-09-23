package codingminutes.graphs;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import codingminutes.graphs.graphrepresentation.Graph;


public class CycleDetectionInAnUndirectedGraph {
	
	public boolean DFS(int node, Set<Integer> visited, int parent, ArrayList<Integer>[] ls) {
		// mark node as visited
		visited.add(node);
		
		for (int nbr: ls[node]) {
			if (!visited.contains(nbr)) {
				boolean containsCycle = DFS(node, visited, nbr, ls);
				if (containsCycle)
					return true;
			}
			else if(parent != nbr)
				return true;
		}
		
		return false;
	}
	
	public boolean isCycleDetected(int V,int [][] edges, int src) {
		
		// graph creation and adding edges
		Graph g = new Graph(V);
		
		for (int[] edge: edges) {
			g.addEdge(edge[0], edge[1], true);
			
		}
		
		ArrayList<Integer>[] adjacencyList = g.getAdjacencyList();
		
		Set<Integer> visited = new HashSet<>();
		return DFS(src, visited, -1, adjacencyList);
	}

	public static void main(String[] args) {
		int [][] edges = {{0,1}, {2,1}, {0,4}, {3,4}, {3,5}};
		CycleDetectionInAnUndirectedGraph cycDetect = new CycleDetectionInAnUndirectedGraph();
		System.out.println(cycDetect.isCycleDetected(6, edges, 0));

	}

}
