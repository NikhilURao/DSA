/*
 * 994. Rotting Oranges

You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
 * 
 * 
 */
package codingminutes.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
	// BFS
    // 1. linear scan the 2D grid and add all rotten oranges location(row, col) to the queue. 
	//    During the linear scan calculate total oranges in the grid. 
	//    This will help us to identify if all oranges can become rotten or not.
    // 2. For each rotten orange in the queue -> while q is not empty, pop from the queue and explore the 
	//    neighboring/adjacent fresh oranges in 4 directions using the directions matrix.
    // 3. If not already visited, Mark all the fresh oranges adjacent to the rotten oranges as rotten 
	//    and add them to the queue; increase the count of the rotten oranges each time you enqueue.
    // 4. return the count of levels as that is the time taken to rot all oranges if and only if the 
	//    count of the rotten oranges = total number of oranges in the grid.
	// 5. Else return -1
	/*
	 * Complexity
	 * Time Complexity: O(N), where N is the size of the grid.
	 * First, we scan the grid to find the initial values for the queue, which would take O(N) time.
	 * Then we run the BFS process on the queue, which in the worst case would 
	 * enumerate all the cells in the grid once and only once. Therefore, it takes O(N) time.
	 * Thus combining the above two steps, the overall time complexity would be O(N)+O(N)=O(N)
	 * 
	 * Space Complexity: O(N), where NN is the size of the grid.
	 * In the worst case, the grid is filled with rotten oranges. As a result, the queue would be 
	 * initialized with all the cells in the grid.
	 * By the way, normally for BFS, the main space complexity lies in the process rather than the initialization. 
	 * For instance, for a BFS traversal in a tree, at any given moment, 
	 * the queue would hold no more than 2 levels of tree nodes. 
	 * Therefore, the space complexity of BFS traversal in a tree would depend on the width of the input tree.
	 */
    
    
    public int orangesRotting(int[][] grid) {
        int [][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int nr = grid.length;
        int nc = grid[0].length;
        
        if (nr==0) return 0;
        
        Queue<int []> queue = new LinkedList<>();
        int totalOranges = 0;
        for (int r=0; r<nr; r++){
            for (int c=0; c<nc; c++){
                if (grid[r][c] == 2){
                    queue.add(new int[]{r,c});
                    totalOranges++;
                }
                if (grid[r][c] == 1)
                    totalOranges++;
            }
        }
        if (totalOranges == 0) return 0;
        int rottenOranges = 0;
        int time = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            rottenOranges += size;
            time++;
            for(int i=0; i<size; i++){
                int [] rotten = queue.remove();
                int row = rotten[0];
                int col = rotten[1];
                
                for (int [] dir: directions){
                    int nrow = row + dir[0];
                    int ncol = col + dir[1];
                    
                    if (nrow>=0 && ncol>=0 && nrow<nr && ncol<nc 
                       && grid[nrow][ncol]==1){
                        queue.add(new int []{nrow, ncol});
                        grid[nrow][ncol] = 2;
                    }
                }
            }
        }
        
        if (rottenOranges == totalOranges)
            return time-1;
        else return -1;
    }

	public static void main(String[] args) {
		RottingOranges ro = new RottingOranges();
		int [][] grid = {{2,1,1},{1,1,0},{0,1,1}};
		System.out.println(ro.orangesRotting(grid));

	}

}
