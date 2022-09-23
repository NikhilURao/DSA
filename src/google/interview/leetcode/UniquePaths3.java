/*
 * 
 * 980. Unique Paths III

You are given an m x n integer array grid where grid[i][j] could be:

1 representing the starting square. There is exactly one starting square.
2 representing the ending square. There is exactly one ending square.
0 representing empty squares we can walk over.
-1 representing obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

 

Example 1:


Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
Example 2:


Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
Example 3:


Input: grid = [[0,1],[2,0]]
Output: 0
Explanation: There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 20
1 <= m * n <= 20
-1 <= grid[i][j] <= 2
There is exactly one starting cell and one ending cell.
 * 
 */

package google.interview.leetcode;

import java.util.Arrays;

public class UniquePaths3 {
	
	static int ans = 0;
	
	private static final int directions [][] = {{-1,0}, {1,0}, {0,1}, {0,-1}};
	
	
	/**
	 * Let NN be the total number of cells in the input grid.
	 * 
	 * Time Complexity: (3^N)
	 * Although technically we have 4 directions to explore at each step, we have at most 3 directions to try at 
	 * any moment except the first step. The last direction is the direction where we came from, 
	 * therefore we don't need to explore it, since we have been there before.
	 * In the worst case where none of the cells is an obstacle, we have to explore each cell. 
	 * Hence, the time complexity of the algorithm is (4 * 3 ^{(N-1)}) = O(3^N).
	 * 
	 * Space Complexity: O(nxm) where n and m dimensions of the grid
	 * On the other hand, we apply recursion in the algorithm, which could incur O(N) space in the function 
	 * call stack.
	 * Hence, the overall space complexity of the algorithm isO(nxm).
	 */
    public static int uniquePathsIII(int[][] grid) {
        
    	int n = grid.length; int m = grid[0].length;
    	
    	// visited array to keep track on the visited empty spaces
    	boolean [][] visited = new boolean[n][m];
    	// initialize with false
    	for (boolean [] row: visited) {
    		Arrays.fill(row, false);
    	}
    	
    	int totalEmptySpaceCount = 0;
    	int start_x=0; int start_y = 0;
    	
    	for (int i=0; i<n; i++) {
    		for (int j=0; j<m; j++) {
    			if (grid[i][j] == 0) totalEmptySpaceCount++;
    			
    			if (grid[i][j] == 1) {
    				start_x = i;
    				start_y = j;
    			}
    		}
    	}
    	
    	DFS(start_x, start_y, grid, visited, 0, totalEmptySpaceCount);
    	return ans;
    }
    
    public static void DFS(int i, int j, int[][] grid, boolean[][] visited, int emptySpaceCount, int  totalEmptySpaceCount) {
    	int n = grid.length; int m = grid[0].length;
    	// mark as visited
    	visited[i][j] = true;
    	
        // If end block reached
        if (grid[i][j] == 2){
          // If path covered all the non-
          // obstacle blocks
          if (emptySpaceCount == totalEmptySpaceCount) {
        	  ans++;
              visited[i][j] = false;
              return;
          }
        }
    	
        if (grid[i][j] == 0)
        	emptySpaceCount++;
        
    	for (int [] dir: directions) {
    		int new_i = i + dir[0];
    		int new_j = j+ dir[1];
    		
    		if (new_i>=0 && new_i<n && new_j>=0 && new_j<m &&
    				!visited[new_i][new_j] && grid[new_i][new_j] != -1) {
    			
    			DFS(new_i, new_j, grid, visited, emptySpaceCount,totalEmptySpaceCount);
    		}
    	}
    	
    	// un-mark as visited
    	visited[i][j] = false;
    	
    }
	

	public static void main(String[] args) {
		int[][] grid = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } };
	    System.out.println(uniquePathsIII(grid));

	}

}
