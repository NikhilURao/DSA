package codingminutes.graphs;

import java.util.*;

import codingminutes.graphs.graphrepresentation.Graph;

public class TopologicalSorting {
	
	// Topological Sorting using BFS or Kahn's Algorithm
	
	public void topologicalSortBFS(int V, int[][] edges) {
		Graph g = new Graph(V);
		
		for (int [] edge: edges) {
			g.addEdge(edge[0], edge[1], false);
		}
		List<Integer>[] adjLS = g.getAdjacencyList();
		
		// calculate the in-degree for each node in the graph.
		// in-degree array is the count of in-coming vertices/edges for a particular node in the graph 
		int [] inDegree = new int [V];
		
		for (int i=0; i<V; i++) {
			for (int nbr: adjLS[i]) {
				inDegree[nbr]++;
				}
		}
		Queue<Integer> q = new LinkedList<>();
		// PriorityQueue<Integer> q = new PriorityQueue<>();
		// If you want to sort it by natural ordering -> ascending order or aplhabetical order
		// then use a PriorityQueue. 
		// push all nodes whose in-degree is 0 into the queue
		for (int i=0; i<V; i++) {
			if(inDegree[i] == 0)
				q.add(i);
		}
		
		// BFS
		while (!q.isEmpty()) {
			int node = q.poll();
			System.out.print(node+" ");
			for (int nbr: adjLS[node]) {
				inDegree[nbr]--;
				if (inDegree[nbr] == 0) {
					q.add(nbr);
				}
			}
		}
	}
	
	// Topological Sorting using DFS  0 1 4 2 3 5 
	
	public void topologicalSortDFS(int V, int[][] edges) {
		Graph g = new Graph(V);
		for (int [] edge: edges) {
			g.addEdge(edge[0], edge[1], false);
		}
		ArrayList<Integer>[] adjLs = g.getAdjacencyList();
		
		boolean [] visited = new boolean[V];
		LinkedList<Integer> ordering = new LinkedList<>();
		
		for (int i=0; i<V; i++) {
			if (!visited[i]) {
				DFS(i, visited, adjLs, ordering);
			}
		}
		
		for (int i=0; i<ordering.size(); i++) {
			System.out.print(ordering.get(i)+" ");
		}
	}
	
	public void DFS(int node, boolean [] visited, ArrayList<Integer>[] adjacencyList,
			LinkedList<Integer> ordering) {
		// mark as visited
		visited[node] = true;
		
		for (int nbr: adjacencyList[node]) {
			if (!visited[nbr]) {
				DFS(nbr, visited, adjacencyList, ordering);
			}
		}
		
		ordering.addFirst(node);
		return;
	}

	public static void main(String[] args) {
		int [][] edges = {{1,4}, {0,2},{1,2},{2,3},{4,5},{3,5}};
		int numNodes = 6;
		TopologicalSorting ts = new TopologicalSorting();
		System.out.println("Topological Sorting using BFS");
		ts.topologicalSortBFS(numNodes, edges);
		System.out.println();
		System.out.println("Topological Sorting using DFS");
		ts.topologicalSortDFS(numNodes, edges);

	}

}
