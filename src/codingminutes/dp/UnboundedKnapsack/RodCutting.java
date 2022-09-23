/*
 * Rod Cutting 

Given a rod of length L meters and an array of prices, price[] that contains prices of all pieces of 
size smaller than N. Determine the maximum value obtainable by cutting up the rod and selling the pieces.

 

Example 1:

Input:
N = 8
Price[] = {1, 5, 8, 9, 10, 17, 17, 20}
Output:
22
Explanation:
The maximum obtainable value is 22 by
cutting in two pieces of lengths 2 and 
6, i.e., 5+17=22.
Example 2:

Input:
N=8
Price[] = {3, 5, 8, 9, 10, 17, 17, 20}
Output: 24
Explanation: 
The maximum obtainable value is 
24 by cutting the rod into 8 pieces 
of length 1, i.e, 8*3=24. 

Your Task:  
You don't need to read input or print anything. 
Your task is to complete the function cutRod() which takes the array A[] and its size N as
inputs and returns the maximum price obtainable.


Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 1000
1 ≤ Ai ≤ 105
 * 
 * 
 */
package codingminutes.dp.UnboundedKnapsack;

import java.util.Arrays;

public class RodCutting {
	
	// Solution 1: Recursion
	public static int cutRodRec(int [] price, int n){   
	    
		return cutRodUtilRecursive(price, n, n);
	}
	
	public static int cutRodUtilRecursive(int [] price, int len, int index) {
		
		if (len <= 0 || index <=0)
			return 0;
		
		if (index <= len) {
			return Math.max( price[index-1] + cutRodUtilRecursive(price, len - index, index), // choose
					cutRodUtilRecursive(price, len, index-1)); // no choose
			
		}
		else {
			return cutRodUtilRecursive(price, len, index-1);
		}
	}
	
	// Solution 2: Top-Down : Recursion + Memoization
	public static int cutRodTopDown(int [] price, int n){   
	    int [][] dp = new int [n+1][n+1];
	    for (int i=0; i<n+1; i++) {
	    	int [] temp = new int [n+1];
	    	Arrays.fill(temp, -1);
	    	dp[i] = temp;
	    }
	    return cutRodUtilTopDown(price, n, n ,dp);
	}
	
	public static int cutRodUtilTopDown(int [] price, int len, int index, int [][] dp) {
		
		if (len <= 0 || index <=0)
			return dp[index][len] = 0;
		
		// check if already computed
	    if (dp[index][len] != -1)
	        return dp[index][len];
	    
		
		if (index <= len) {
			return dp[index][len] = Math.max( price[index-1] + cutRodUtilTopDown(price, len - index, index, dp), // choose
					cutRodUtilTopDown(price, len, index-1, dp)); // no choose
			
		}
		else {
			return dp[index][len] = cutRodUtilTopDown(price, len, index-1, dp);
		}
	}
	
	// Solution 2: Bottom-Up 
	public static int cutRodBottomUp(int [] price, int n){   
	    int[] length_cap = new int [n];
	    for(int i=1;i<=n;i++)
	       length_cap[i-1]=i;
	    
	    int [][] dp = new int [n+1][n+1];
	    for (int i=0; i<n+1; i++) {
	    	int [] temp = new int [n+1];
	    	Arrays.fill(temp, -1);
	    	dp[i] = temp;
	    }
	    	    
	    for (int i=0; i<n+1; i++) {
	    	for (int j=0; j<n+1; j++) {
	    		
	    		if (i==0 || j==0) dp[i][j] = 0;
	    		
	    		else if (length_cap[i-1]<=j) {
	    			dp[i][j] = Math.max( price[i-1] + dp[i][j - length_cap[i-1]], dp[i-1][j]);
	    		}
	    		else
	    			dp[i][j] =  dp[i-1][j];
	    	}
	    }
	    return dp[n][n];
	}

	public static void main(String[] args) {
		int L = 8;
		int [] prices = {1, 5, 8, 9, 10, 17, 17, 20 };
		System.out.println(cutRodRec(prices, L));
		System.out.println();
		System.out.println(cutRodTopDown(prices, L));
		System.out.println();
		System.out.println(cutRodBottomUp(prices, L));

	}

}
