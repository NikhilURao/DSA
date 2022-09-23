/*
 * 
 * 63. Unique Paths II or Unique Paths With Obstacles

You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m-1][n-1]). The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.


 

Example 1:


Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
Example 2:


Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
 

Constraints:

m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 1.
 */

package google.interview.leetcode;

import java.util.Arrays;

public class UniquePaths2 {
	
	
	// Using Dp
	/**
	 * Time Complexity:O(N×M). The rectangular grid given to us is of size M×N and we process each cell just once.
	 * Space Complexity: O(N×M). We are utilizing the N×M space for DP 2D array.
	 */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int n = obstacleGrid.length; int m = obstacleGrid[0].length;
    	
    	if (n==0 || obstacleGrid[0][0] == 1) return 0;
    	
    	int [][] dp = new int [n][m];
    	for (int i=0; i<n; i++) {
    		int temp[] = new int [m];
    		Arrays.fill(temp, 0);
    		dp[i] = temp;
    	}
    	/*
    	 * If the first cell i.e. obstacleGrid[0,0] contains 1, this means there is an obstacle in the first cell. 
    	 * Hence the robot won't be able to make any move and we would return the number of ways as 0.
    	 * Otherwise, if obstacleGrid[0,0] has a 0 originally we set it to 1 and move ahead.
    	 */
    	dp[0][0] = 1;
    	
    	// initializing first column value
    	/*
    	 * Iterate the first column. If a cell originally contains a 1, this means 
    	 * the current cell has an obstacle and shouldn't contribute to any path. 
    	 * Hence, set the value of that cell to 0. Otherwise, set it to the value of previous cell 
    	 * i.e. obstacleGrid[i,j] = obstacleGrid[i-1,j]
    	 */
    	for (int i=1; i<n; i++) {
    		if (obstacleGrid[i][0] == 1)
    			dp[i][0] = 0;
    		else
    			dp[i][0] = dp[i-1][0];
    	}
    	
    	// initializing first column value
    	/*
    	 * Iterate the first row. If a cell originally contains a 1, this means the current cell has an 
    	 * obstacle and shouldn't contribute to any path. Hence, set the value of that cell to 0. 
    	 * Otherwise, set it to the value of previous cell i.e. obstacleGrid[i,j] = obstacleGrid[i,j-1]
    	 */
    	for (int j=1; j<m; j++) {
    		if (obstacleGrid[0][j] == 1)
    			dp[0][j] = 0;
    		else
    			dp[0][j] = dp[0][j-1];
    	}
    	
        // Starting from cell(1,1) fill up the values
        // No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
        // i.e. From above and left.
    	for (int i=1; i<n; i++) {
    		for (int j=1; j<m; j++) {
    			if (obstacleGrid[i][j]==1)
    				dp[i][j] = 0;
    			else
    				dp[i][j] = dp[i-1][j] + dp[i][j-1];
    		}
    		
    	}
    	
    	return dp[n - 1][m - 1];
        
    }

	public static void main(String[] args) {
		int [][]obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(uniquePathsWithObstacles(obstacleGrid));

	}

}
