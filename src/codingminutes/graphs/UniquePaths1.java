/*
 * Unique Paths 1
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). 
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either 
 * down or right at any point in time.
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to 
 * reach the bottom-right corner.
 * Example 1:
 * Input: m = 3, n = 7
 * Output: 28
 * 
 * 
 * Example 2:
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 * 
 * Constraints: 1 <= m, n <= 100
 */
package codingminutes.graphs;

import java.util.Arrays;

public class UniquePaths1 {
	
	/** Algorithm: 
	 * 1. Since robot can move either down or right, 
	 * there is only one path to reach the cells in the first row: right->right->...->right.
	 * 
	 * 2. The same is valid for the first column, though the path here is down->down-> ...->down.
	 * 
	 * 3. For other cells (m, n) : one could move either from the cell on the left (m, n - 1), 
	 * or from the cell above (m - 1, n). That means that the total number of paths to move into (m, n) cell 
	 * is uniquePaths(m - 1, n) + uniquePaths(m, n - 1).
	 */
	
	// Brute Force Recursive
	public static int numOfUniquePathsRec(int m, int n) {
		if (m==1 || n==1) return 1;
		
		else
			return numOfUniquePathsRec(m-1, n) + numOfUniquePathsRec(m, n-1);
		
	}
	
	
	// Recursive + Memoization = Top-Down
	public static int numOfUniquePathsTopDown(int m, int n) {
		int dp[][] = new int [m+1][n+1];
		for (int i=0; i<m+1; i++) {
			int [] temp = new int[n+1];
			Arrays.fill(temp, -1);
			dp[i] = temp;
		}
		
		return numOfUniquePathsTopDownRec(m, n, dp);
		
	}
	
	public static int numOfUniquePathsTopDownRec(int m, int n, int dp[][]) {
		
		if (dp[m][n] != -1) return  dp[m][n];
		
		if (m==1 || n==1) return dp[m][n] = 1;
		
		else {
 			int left=0; int above = 0;
			
			if (dp[m-1][n] != -1) 
				left = dp[m-1][n];
			else 
				left = numOfUniquePathsTopDownRec(m-1, n, dp);
			
			if (dp[m][n-1] != -1) 
				above = dp[m][n-1];
			else 
				above = numOfUniquePathsTopDownRec(m, n-1, dp);
			
			return left + above;
		}
			//return numOfUniquePathsTopDownRec(m-1, n, dp) + numOfUniquePathsTopDownRec(m, n-1, dp);
			
	}
	  // Bottom-Up DP
	  public static int numOfUniquePathsBottomUp(int m, int n) {
		    int[][] dp = new int[m+1][n+1];

		    for(int i=0; i<m+1; i++) {
		      int [] temp = new int [n+1];
		      Arrays.fill(temp, 0);
		      dp[i] = temp;
		    }
		    
		    
		    for(int row = 0; row < m; row++){
		    	
		    	for(int col = 0; col < n; col++) {
		    		
		    		if (row==0 || col ==0) dp[row][col] = 1;
		    		
		    		else 
		    			dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
		      }
		    }
		    return dp[m-1][n-1];
		  }

	public static void main(String[] args) {
		int m = 3, n = 7;
		System.out.println(numOfUniquePathsRec(m,n));
		System.out.println(numOfUniquePathsTopDown(m,n));
		System.out.println(numOfUniquePathsBottomUp(m,n));

	}

}
