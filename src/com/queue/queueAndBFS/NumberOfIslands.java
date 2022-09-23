/*
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

 */
package com.queue.queueAndBFS;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    
    	  public int numIslandsBFS(char[][] grid) {
    	    if (grid == null || grid.length == 0) {
    	      return 0;
    	    }

    	    int nr = grid.length;
    	    int nc = grid[0].length;
    	    int num_islands = 0;
    	    int [][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
    	    for (int r = 0; r < nr; ++r) {
    	      for (int c = 0; c < nc; ++c) {
    	        if (grid[r][c] == '1') {
    	          ++num_islands;
    	          grid[r][c] = '0'; // mark as visited
    	          Queue<int[]> neighbors = new LinkedList<>();
    	          neighbors.add(new int [] {r,c});
    	          while (!neighbors.isEmpty()) {
    	            int [] curPos = neighbors.remove();
    	            int row = curPos[0];
    	            int col = curPos[1];
    	            
    	            for (int [] dir: dirs) {
    	            	int nrow = row + dir[0];
    	            	int ncol = col + dir[1];
    	            	
    	            	if (nrow<nr && nrow>=0 && ncol<nc && ncol>=0 && grid[nrow][ncol] == '1') {
    	            		neighbors.add(new int[] {nrow, ncol});
    	            		grid[nrow][ncol] = '0';
    	            	}

    	            }
//					or    	            
//    	            if (row - 1 >= 0 && grid[row-1][col] == '1') {
//    	              neighbors.add(new int[] {row-1, col});
//    	              grid[row-1][col] = '0';
//    	            }
//    	            if (row + 1 < nr && grid[row+1][col] == '1') {
//    	              neighbors.add(new int [] {row+1, c});
//    	              grid[row+1][col] = '0';
//    	            }
//    	            if (col - 1 >= 0 && grid[row][col-1] == '1') {
//    	              neighbors.add(new int[] {row, col-1});
//    	              grid[row][col-1] = '0';
//    	            }
//    	            if (col + 1 < nc && grid[row][col+1] == '1') {
//    	              neighbors.add(new int[] {row, col+1});
//    	              grid[row][col+1] = '0';
//    	            }
    	          }
    	        }
    	      }
    	    }

    	    return num_islands;
    	  }
    	  
    		  void dfs(char[][] grid, int r, int c) {
    		    int nr = grid.length;
    		    int nc = grid[0].length;

    		    if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
    		      return;
    		    }

    		    grid[r][c] = '0';
    		    dfs(grid, r - 1, c);
    		    dfs(grid, r + 1, c);
    		    dfs(grid, r, c - 1);
    		    dfs(grid, r, c + 1);
    		  }

    		  public int numIslandsDFS(char[][] grid) {
    		    if (grid == null || grid.length == 0) {
    		      return 0;
    		    }

    		    int nr = grid.length;
    		    int nc = grid[0].length;
    		    int num_islands = 0;
    		    for (int r = 0; r < nr; ++r) {
    		      for (int c = 0; c < nc; ++c) {
    		        if (grid[r][c] == '1') {
    		          ++num_islands;
    		          dfs(grid, r, c);
    		        }
    		      }
    		    }

    		    return num_islands;
    		  }
    	

	public static void main(String[] args) {
		NumberOfIslands noi = new NumberOfIslands();
		char[][] grid1 = {
				  {'1','1','1','1','0'},
				  {'1','1','0','1','0'},
				  {'1','1','0','0','0'},
				  {'0','0','0','0','0'}
				};
		System.out.println(noi.numIslandsBFS(grid1));
		System.out.println();
		char[][] grid2 = {
				  {'1','1','1','1','0'},
				  {'1','1','0','1','0'},
				  {'1','1','0','0','0'},
				  {'0','0','0','0','0'}
				};
		System.out.println(noi.numIslandsDFS(grid2));

	}

}
