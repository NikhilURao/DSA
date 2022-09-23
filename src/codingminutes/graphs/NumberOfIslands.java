/**
 * 
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 * 
 */

package codingminutes.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
	
	/*
	 * Solution 1: DFS
	 *  1. Linearly scan the grid to find a '1'. 
	 *  2. Trigger DFS from this node. This is the root node for the DFS scan.
	 *  3. During DFS, every visited node should be set as '0' to mark as visited node.
	 *  4. Count the number of root nodes that trigger DFS, 
	 *  this number would be the number of islands since each DFS starting at some root identifies an island.
	 *  
	 *  Time complexity : O(M * N) where M is the number of rows and N is the number of columns in the grid.
	 *  Space complexity : worst case O(M * N) in case that the grid map is filled with lands where DFS goes by M×N deep.
	 */

	public final int [][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	
    public int numIslandsDFS(char[][] grid) {
        int nrows = grid.length;
        int ncolumns = grid[0].length;
        int numOfIslands = 0;
        
        if (nrows == 0)
        	return numOfIslands;
        
        
        
        // linear scan the grid to find '1'
        for (int r=0; r<nrows; r++) {
        	for (int c=0; c<ncolumns; c++) {
        		if (grid[r][c] == '1') {
        			numOfIslands++;
        			DFS(grid, r, c);
        		}
        	}
        }
        
        return numOfIslands;
        
    }
    
    public void DFS(char[][] grid, int row, int col) {
        int nr = grid.length;
        int nc = grid[0].length;
        
        // mark as visited -> make '1' to '0'
        grid[row][col] = '0';
        
        for (int [] dir: directions) {
        	int nrow = row + dir[0];
        	int ncol = col + dir[1];
        	
        	if (nrow >= 0 && ncol >=0 && nrow < nr && ncol < nc && grid[nrow][ncol] == '1') {
        		DFS(grid, nrow, ncol);
        	}
        }        
    }
    /*
     * Solution 2: BFS
     *  1. Linear scan the 2d grid map, if a node contains a '1'.
     *  2. Then it is a root node that triggers a Breadth First Search. 
     *  3. Put it into a queue and set its value as '0' to mark as visited node. 
     *  4. Iteratively search the neighbors of enqueued nodes until the queue becomes empty.
     *  
     *  Time complexity : O(M * N) where MM is the number of rows and NN is the number of columns.
     *  Space complexity : O(min(M,N)) because in worst case where the grid is filled with lands, the size of queue can grow up to min(M,N).
     * 
     */
    public int numIslandsBFS(char[][] grid) {
    	int nrows = grid.length;
    	int ncolumns = grid[0].length;
    	int numOfIslands = 0;
    	if (nrows == 0) return 0;
    	
    	for (int r=0; r<nrows; r++) {
    		for (int c=0; c<ncolumns; c++) {
    			if (grid[r][c] == '1') {
    				numOfIslands ++;
    				Queue<int[]> queue = new LinkedList<>();
    				queue.add(new int [] {r,c});
    				grid[r][c] = '0';
    				
    				// BFS
    				while (!queue.isEmpty()) {
    					int [] gridLOC = queue.remove();
    					int row = gridLOC[0];
    					int col = gridLOC[1];
    					
    					for (int [] dir: directions) {
    						int nrow = row + dir[0];
    						int ncol = col + dir[1];
    						
    			        	if (nrow >= 0 && ncol >=0 && nrow < nrows && ncol < ncolumns 
    			        			&& grid[nrow][ncol] == '1') {
    			        		queue.add(new int [] {nrow, ncol});
    			        		grid[nrow][ncol] = '0';
    			        	}
    					}
    					
    				}
    			}
    		}
    	}
    	
    	return numOfIslands;
    }
    
    
	public static void main(String[] args) {
		NumberOfIslands noi = new NumberOfIslands();
		char [][] grid1 = {
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}
		};
		System.out.println(noi.numIslandsDFS(grid1));
		char [][] grid2 = {
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}
		};
		System.out.println(noi.numIslandsBFS(grid2));

	}

}
