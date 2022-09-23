package codingminutes.graphs;

import java.util.*;

import codingminutes.graphs.graphrepresentation.Graph;

public class IsGraphBipartile {

	/*
	 * Condition to check if a graph is Bipartite.
	 * A graph is not bipartite only if it contains a cycle and the number of nodes is odd,
	 * else its a bipartite graph
	 */
	
	public boolean IsBipartite(int V, int[][] edges, int src) {
		
		Graph g = new Graph(V);
		
		for (int[] edge: edges) {
			g.addEdge(edge[0], edge[1], true);
		}
		
		ArrayList<Integer>[] adjacencyList = g.getAdjacencyList();
		
		// visited array 0 -> not visited, 1-> Visited and color 1, 2-> Visited and color 2
		int [] visited = new int[V];
		Arrays.fill(visited, 0);
		int color = 1;
		boolean ans = DFS(src, adjacencyList, visited, color, -1);
		
		return ans;
	}
	
	public boolean DFS(int node, ArrayList<Integer>[] adjacencyList, int [] visited, int color, int parent) {
		// mark as visited
		visited[node] = color;
		
		for (int nbr: adjacencyList[node]) {
			if (visited[nbr] == 0) {
				boolean res = DFS(nbr, adjacencyList, visited, 3-color, node);
				if (res) {
					return false;
				}
			}
			else if (color!= visited[nbr]) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int start = 0; start < n; ++start) {
            if (color[start] == -1) {
                Stack<Integer> stack = new Stack();
                stack.push(start);
                color[start] = 0;

                while (!stack.empty()) {
                    Integer node = stack.pop();
                    for (int nei: graph[node]) {
                        if (color[nei] == -1) {
                            stack.push(nei);
                            color[nei] = color[node] ^ 1;
                        } else if (color[nei] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
	
	public static void main(String[] args) {
		//int [][] edges = {{0,1}, {1,2}, {0,4}, {4,3}, {3,5}, {4,5}, {2,6}};
		int [][] edges = {{0,1}, {0,2}, {1,2}};
		IsGraphBipartile igb = new IsGraphBipartile();
		System.out.println(igb.IsBipartite(3, edges, 0));

	}

}
