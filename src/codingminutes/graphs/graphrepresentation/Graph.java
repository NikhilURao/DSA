package codingminutes.graphs.graphrepresentation;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Graph {
	
	int V; // number of nodes in the graph
	ArrayList<Integer>[] ls; // Array of Lists to maintain adjacency list for each node in the graph.
	/* 
	 * [[1, 4], [0, 2], [1, 3], [4, 2, 5], [0, 3, 5], [4, 3]]
	 * Adjacency list for node 0 -> [1, 4] i.e Node 1 & 4 are neighbors of Node 0
	 */
	
	// constructor to initialize the number of nodes.
	public Graph(int V) {
		this.V = V;
		this.ls = new ArrayList[V];
		
        for(int i = 0; i < V; i++){
            ls[i] = new ArrayList<>();
        }
	}
	
	// add an edge between the nodes i and j
	public void addEdge(int i, int j, boolean undirected) {
		// add edge from Node i to Node j
		ls[i].add(j);
		// if the graph/edge is undirected/ non directional, then vice versa is also true add an edge from j to i
		if(undirected) {
			ls[j].add(i);
		}
	}
	
	// print the adjacency list
	public void printAdjLs() {
		System.out.println("Adjacency List");
		for (int i=0; i<ls.length; i++) {
			System.out.print(i+"--->");
			for (int j: ls[i]) {
				System.out.print(j+" ");
			}
			System.out.println("");
		}
	}
	
	public ArrayList<Integer>[] getAdjacencyList(){
		return ls;
	}
	
	public void BFS(int src) {
		Queue<Integer> q = new LinkedList<>();
		boolean [] visited = new boolean[V];
		Arrays.fill(visited, false);
		System.out.println("BFS graph traversal");
		// push src into the queue and mark it as visited
		q.add(src);
		visited[src] = true;
		
		while (!q.isEmpty()) {
			int node = q.remove();
			System.out.println(node);
			
			for (int adjacentNode : ls[node]) {
				if (!visited[adjacentNode]) {
					q.add(adjacentNode);
					visited[adjacentNode] = true;
				}
			}
			
		}
		
	}
	
	// We can use BFS to find the shortest path from a src node to a dest node in a undirected  graph aka
	// single source shortest path for an undirected graph.
	
	public void printShortestPathAndDistanceUsingBFS(int src, int dest) {
		
		Queue<Integer> q = new LinkedList<>();
		boolean [] visited = new boolean [V];
		Arrays.fill(visited, false);
		// array to store the shortest distance from src to each node in the graph 
		int [] shortestDistance = new int [V];
		Arrays.fill(shortestDistance, 0);
		// array to store the reference of the previous node visited before the current node
		int [] sortestPath = new int [V];
		Arrays.fill(shortestDistance, -1);
		
		q.add(src);
		visited[src] = true;
		shortestDistance[src] = 0;
		sortestPath[src] = src;
		
		// BFS
		while (!q.isEmpty()) {
			int f = q.remove();
			
			for(int neighbors: ls[f]) {
				if (!visited[neighbors]) {
					q.add(neighbors);
					
					shortestDistance[neighbors] = shortestDistance[f] + 1;
					sortestPath[neighbors] = f;
					
					visited[neighbors] = true;
				}
			}
		}
		
		
		// print shortest path
		System.out.println("Sortest path between "+ src +" and "+ dest +" is ");
		int t = dest;
		while (t!=src) {
			System.out.print(t+" -- ");
			t = sortestPath[t];
			
		}
		System.out.print(src);
		
		// print shortest distance
		System.out.println();
		System.out.println("Sortest distance between "+ src +" and "+ dest +" is "+ shortestDistance[dest]);
	}
	
	public int minCostBFS(int srcNode, int desNode) {
		Queue<Integer> q = new LinkedList<>();
		boolean [] visited = new boolean [V];
		Arrays.fill(visited, false);
		// array to store the shortest distance from src to each node in the graph 
		int [] shortestDistance = new int [V];
		Arrays.fill(shortestDistance, 0);
		// array to store the reference of the previous node visited before the current node
		int [] sortestPath = new int [V];
		Arrays.fill(shortestDistance, -1);
		
		q.add(srcNode);
		visited[srcNode] = true;
		shortestDistance[srcNode] = 0;
		sortestPath[srcNode] = srcNode;
		
		// BFS
		while (!q.isEmpty()) {
			int f = q.remove();
			
			for(int neighbors: ls[f]) {
				if (!visited[neighbors]) {
					q.add(neighbors);
					
					shortestDistance[neighbors] = shortestDistance[f] + 1;
					sortestPath[neighbors] = f;
					
					visited[neighbors] = true;
				}
			}
		}
		
		// print shortest path
		System.out.println("Sortest path between "+ srcNode +" and "+ desNode +" is ");
		int t = desNode;
		while (t!=srcNode) {
			System.out.print(t+" -- ");
			t = sortestPath[t];
			
		}
		System.out.print(srcNode);
		
		return shortestDistance[desNode];
		
	}
	
	public void DFS(int src) {
		System.out.println("DFS graph traveral: ");
		boolean [] visited = new boolean[V];
		Arrays.fill(visited, false);
		DFSHelper(src, visited);

	}
	
	public void DFSHelper(int node, boolean[] visited) {
		System.out.println(node);
		
		for (int nbr: ls[node]) {
			if (!visited[nbr]) {
				visited[nbr] = true;
				DFSHelper(nbr, visited);
			}
		}
		
		return;
	}
	
	
	public static void main(String [] args) {
		Graph g = new Graph(6); // create a graph of six nodes
		g.addEdge(0, 1, true);
		g.addEdge(0, 4, true);
		g.addEdge(2, 1, true);
		g.addEdge(3, 4, true);
		g.addEdge(4, 5, true);
		g.addEdge(2, 3, true);
		g.addEdge(3, 5, true);
		
		g.printAdjLs();
		
		g.BFS(1);
		
		g.printShortestPathAndDistanceUsingBFS(1,5);
		
		g.DFS(1);
	}
	

}
