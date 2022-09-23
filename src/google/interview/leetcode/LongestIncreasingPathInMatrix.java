/*
 * Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

 

Example 1:


Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:


Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
Example 3:

Input: matrix = [[1]]
Output: 1
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
0 <= matrix[i][j] <= 231 - 1
 */

package google.interview.leetcode;

public class LongestIncreasingPathInMatrix {
	public static int [][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
	int m, n;
	
	// Naive DFS.
	public int longestIncreasingPath(int [][] mat) {
		m = mat.length;
		n = mat[0].length;
		int ans = 0;
		
		if (m == 0) return 0;
		else {
			for (int i=0; i<m; i++) {
				for (int j=0; j<n; j++) {
					ans = Math.max(ans, dfs(mat, i, j));
				}
			}
			return ans;
		}
	}
	
	// DFS + Memoization 
	public int longestIncreasingPathWithMemoization(int [][] mat) {
		m = mat.length;
		n = mat[0].length;
		int ans = 0;
		int [][] cache = new int [m][n];
		if (m == 0) return 0;
		else {
			for (int i=0; i<m; i++) {
				for (int j=0; j<n; j++) {
					ans = Math.max(ans, dfs(mat, i, j, cache));
				}
			}
			return ans;
		}
	}
	
	
	// Naive DFS. DFS can find the longest increasing path starting from any cell. We can do this for all the cells.
	/*
	 * Complexity Analysis

Time complexity : O(2^{m+n}). 
The search is repeated for each valid increasing path. In the worst case we can have O(2^{m+n}) calls.

Space complexity : O(mn). For each DFS we need O(h) space used by the system stack, 
where h is the maximum depth of the recursion. In the worst case, O(h) = O(mn).
	 */
	public int dfs(int [][]mat, int i, int j) {
		int ans = 0;
		for (int [] dir : directions) {
			int x = i + dir[0];
			int y = j + dir[1];
			if (x<m && x>=0 && y<n && y>=0 && mat[x][y] > mat[i][j]) {
				ans = Math.max(ans, dfs(mat,x,y));
			}
		}
		
		return ++ans;
	}
	
	/*
	 * Time complexity : O(m * n). Each vertex/cell will be calculated once and only once, 
	 * and each edge will be visited once and only once. The total time complexity is then O(V+E). 
	 * V is the total number of vertices and E is the total number of edges. 
	 * In our problem, O(V) = O(m * n), O(E) = O(4V) = O(m * n).

Space complexity : O(mn)O(mn). The cache dominates the space complexity.
	 */
	public int dfs(int [][]mat, int i, int j, int [][] cache) {
		if (cache[i][j]!=0) return cache[i][j];
		else {
			int ans = 0;
			for (int [] dir : directions) {
				int x = i + dir[0];
				int y = j + dir[1];
				if (0 <= x && x < m && 0 <= y && y < n && mat[x][y] > mat[i][j])
					cache[i][j] = Math.max(cache[i][j], dfs(mat, x, y, cache));
			}
			return ++cache[i][j];
		}
	}

	public static void main(String[] args) {
		int [][] grid = {{9,9,4},{6,6,8},{2,1,1}};
		
		LongestIncreasingPathInMatrix lipm = new LongestIncreasingPathInMatrix();
		
		System.out.print(lipm.longestIncreasingPath(grid));
		
		System.out.println();
		
		System.out.print(lipm.longestIncreasingPathWithMemoization(grid));
		

	}

}
