/*
 * Given an array arr[] of length N and an integer X, the task is to find the number of subsets with 
 * a sum equal to X.

Examples: 

Input: arr[] = {1, 2, 3, 3}, X = 6 
Output: 3 
All the possible subsets are {1, 2, 3}, 
{1, 2, 3} and {3, 3}

Input: arr[] = {1, 1, 1, 1}, X = 1 
Output: 4 

Input: N = 6, arr[] = {2, 3, 5, 6, 8, 10}, sum = 10
Output: 3
Explanation: {2, 3, 5}, {2, 8}, {10}

 */
package codingminutes.dp.KnapsackPattern;

import java.util.Arrays;

public class CountSubsetsSumWithGivenSum {
	
	public static int countSubsetSum(int arr[], int sum) {
		
		int n = arr.length;
		if (n==0) return 0;
		
		int [][] dp = new int [n+1][sum+1];
		for (int i=0; i<n+1; i++) {
			int [] temp = new int [sum+1];
			Arrays.fill(temp, 0);
			dp[i] = temp;
		}
	    // Initializing the first value of matrix
	    dp[0][0] = 1;
	 
	    for(int i = 1; i <= sum; i++)
	        dp[0][i] = 0;

		for (int nr=1; nr<n+1; nr++) {
			for (int nsum=0; nsum<sum+1; nsum++) {
				
				if (arr[nr-1]<=nsum) {
					dp[nr][nsum] = dp[nr-1][nsum-arr[nr-1]] + dp[nr-1][nsum];
				}				
				else {
					dp[nr][nsum] = dp[nr-1][nsum];
				}
				
			}
		}
		
		return dp[n][sum];
		
	}

	public static void main(String[] args) {
		int arr[] = {1}; /*{2, 3, 5, 6, 8, 10};*/ int sum = 2;
		System.out.println(countSubsetSum(arr, sum));

	}

}
