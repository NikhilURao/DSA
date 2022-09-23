/*
 * 1615. Maximal Network Rank
 * 
There is an infrastructure of n cities with some number of roads connecting these cities. Each roads[i] = [ai, bi] indicates that there is a bidirectional road between cities ai and bi.

The network rank of two different cities is defined as the total number of directly connected roads to either city. If a road is directly connected to both cities, it is only counted once.

The maximal network rank of the infrastructure is the maximum network rank of all pairs of different cities.

Given the integer n and the array roads, return the maximal network rank of the entire infrastructure.

 

Example 1:



Input: n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
Output: 4
Explanation: The network rank of cities 0 and 1 is 4 as there are 4 roads that are connected to either 0 or 1. The road between 0 and 1 is only counted once.
Example 2:



Input: n = 5, roads = [[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]]
Output: 5
Explanation: There are 5 roads that are connected to cities 1 or 2.
Example 3:

Input: n = 8, roads = [[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]
Output: 5
Explanation: The network rank of 2 and 5 is 5. Notice that all the cities do not have to be connected.
 

Constraints:

2 <= n <= 100
0 <= roads.length <= n * (n - 1) / 2
roads[i].length == 2
0 <= ai, bi <= n-1
ai != bi
Each pair of cities has at most one road connecting them.
 * 
 * 
 */

package codingminutes.graphs;

import java.util.ArrayList;

public class MaximumNetworkRank {
	
	// Solution 1: Using Adjacency list
    public static int maximalNetworkRank(int n, int[][] roads) {
    	
    	if (n==0 || roads.length == 0)
    		return 0;
    	
    	// find the adjacency list for each city using roads
    	ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();
    	for (int i=0; i<n; i++) {
    		adjLs.add(new ArrayList<Integer>());
    	}
    	
    	for (int i=0; i<roads.length; i++) {
    		int [] road = roads[i];
    		int fromCity = road[0]; int toCity = road[1];
    		adjLs.get(fromCity).add(toCity);   
    		adjLs.get(toCity).add(fromCity);
    	}
    	
    	// calculate maximum network rank
    	int maxNetworkRank = Integer.MIN_VALUE;
    	
    	for (int i=0; i<n; i++) {
    		ArrayList<Integer> neighborsCity1 = adjLs.get(i);
    		for (int j=i+1; j<n; j++) {
    			int count = 0;
    			ArrayList<Integer> neighborsCity2 = adjLs.get(j);
    			for (int neighbors : neighborsCity1) {
    				if (neighbors != j) {
    					count++;
    				}
    			}
    			count += neighborsCity2.size();
    			maxNetworkRank = Math.max(maxNetworkRank, count);
    		}
    		
    	}
    	
    	return maxNetworkRank;
    	
        
    }
    
    // Solution 2: Using Adjacency matrix
    public int maximalNetworkRank1(int n, int[][] roads) {
        
        int deg[]=new int[n];
        int grid[][]=new int[n][n];
        for(int i=0;i<roads.length;i++){
            deg[roads[i][0]]++;
            deg[roads[i][1]]++;
            grid[roads[i][0]][roads[i][1]]=1; 
            grid[roads[i][1]][roads[i][0]]=1;
        }
        
        int result=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int numberOfDirectRoadsForIJ = deg[i]+deg[j];
                int numberOfDirectRoadsBWIJ = grid[i][j];
            	result = Math.max(result,numberOfDirectRoadsForIJ - numberOfDirectRoadsBWIJ);
                    
            }
        }
        
        return result;
    }
    
    public static void main (String[] args) {
    	int [][] roads = {{0,1},{0,3},{1,2},{1,3}};
    		//{{0,1},{0,3},{1,2},{1,3},{2,3},{2,4}};
    	System.out.println(maximalNetworkRank(4, roads));
    	
    }

}
