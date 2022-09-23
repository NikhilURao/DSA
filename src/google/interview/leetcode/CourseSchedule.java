/*
 * 210. Course Schedule II

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.
 */

package google.interview.leetcode;
import java.util.*;

public class CourseSchedule {
	
	// Solution 1- Using TopologicalSort BFS
	class Graph{
        int V; // num of nodes
        ArrayList<Integer>[] adjacencyList;
        
        public Graph(int V){
            this.V = V;
            adjacencyList = new ArrayList[V];
            
            for (int i=0; i<V; i++){
                adjacencyList[i] = new ArrayList<Integer>();
            }
        }
        
        public void addEdge(int [][] edges){
            for (int [] edge: edges){
                adjacencyList[edge[1]].add(edge[0]);
            }
        }
        
        public ArrayList<Integer>[] getAdjacency(){
            return this.adjacencyList;
        }
    }
	
	

    public int[] findOrderBFS(int numCourses, int[][] prerequisites) {
        // create a graph of given number of courses and add edges according to the prerequisites. prerequisites[i] = [ai, bi] i.e. to take up ai you first need to complete bi. [0, 1], indicates that to take course 0 you have to first take course 1.
        Graph g = new Graph(numCourses);
        g.addEdge(prerequisites);
        ArrayList<Integer>[] adjLs = g.getAdjacency();
        
        int [] indegree = new int [numCourses];
        int [] order = new int [numCourses];
        // populate the indegree i.e the number of prerequisites for each of the courses.
        for (int i=0; i<adjLs.length; i++){
            for (int nbr: adjLs[i]){
                indegree[nbr]++;
            }
        }
        // add all courses which have 0 prerequisites. i.e. the indegree of the course is 0
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<indegree.length; i++){
            if (indegree[i] == 0)
                q.add(i);
        }
        
        // BFS
        int i=0;
        while (!q.isEmpty()){
            int course = q.poll();
            order[i] = course;
            i++;
            // explore all its neighbors 
            for (int nbr: adjLs[course]){
                // decrease the in-degree of the course
                indegree[nbr]--;
                if (indegree[nbr]==0){
                    q.add(nbr);
                }
            }   
        }
        
        if(i==numCourses) 
        	return order;
        else return new int [0];

    }
    
    public int [] findOrderDFS(int numCourses, int [][] prerequisites) {
        // create a graph of given number of courses and add edges according to the prerequisites. prerequisites[i] = [ai, bi] i.e. to take up ai you first need to complete bi. [0, 1], indicates that to take course 0 you have to first take course 1.
        Graph g = new Graph(numCourses);
        g.addEdge(prerequisites);
        ArrayList<Integer>[] adjLs = g.getAdjacency();
        
        boolean [] visited = new boolean [numCourses];
        boolean [] callStack = new boolean [numCourses];
        LinkedList<Integer> ordering = new LinkedList<>();
        
        for (int i=0; i<numCourses; i++) {
        	if (!visited[i]) {
        		DFS(i, visited, adjLs, callStack, ordering);
        	}
        }
        int [] res = new int [numCourses];
        
        Arrays.fill(callStack, false);
        for (int i=0; i<ordering.size(); i++) {
        	if (!visited[i])
        		res[i] = ordering.get(i);
        	else
        		return new int [0];
        }
        
        return res;
    }
    
    public void DFS(int node, boolean [] visited, ArrayList<Integer>[] adjLs, boolean [] callStack, 
    		LinkedList<Integer> ordering) {
    	
    	visited[node] = true;
    	callStack[node] = true;
    	
    	for (int nbr: adjLs[node]) {
    		
			if (callStack[nbr])
				return;
			
    		if (!visited[nbr]) {
    			DFS(nbr, visited, adjLs, callStack, ordering);
    		}
    	}
    	
    	callStack[node] = false;
    	ordering.addFirst(node);
    	return;
    }

	public static void main(String[] args) {
		CourseSchedule cs = new CourseSchedule();
		int numCourses = 4;
		int [][] preRequisites = {{0,1},{1,0}} ;//{{1,0},{2,0},{3,1},{3,2}};
		int [] res= cs.findOrderBFS(numCourses, preRequisites);
		for (int i=0; i<res.length; i++) {
			System.out.print(res[i]+ " ");
		}
		System.out.println();
		int [] ans= cs.findOrderDFS(numCourses, preRequisites);
		for (int i=0; i<ans.length; i++) {
			System.out.print(ans[i]+ " ");
		}
	}

}
