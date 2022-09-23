/*
 * Subset Sum Problem 

Given an array of non-negative integers, and a value sum, 
determine if there is a subset of the given set with sum equal to given sum. 

Example 1:
Input:
N = 6
arr[] = {3, 34, 4, 12, 5, 2}
sum = 9
Output: 1/ True 

Explanation: Here there exists a subset with
sum = 9, 4+3+2 = 9.

Example 2:
Input:
N = 6
arr[] = {3, 34, 4, 12, 5, 2}
sum = 30
Output: 0/ False
Explanation: There is no subset with sum 30.
 * 
 */
package codingminutes.dp.KnapsackPattern;

import java.util.*;

public class SubsetSum {
	
    public static Boolean isSubsetSumRec(int N, int arr[], int sum, boolean [][] dp){
        
    	if (N < 0 || (N==0 && sum > 0)) return dp[N][sum] = false;
    	
        if (N==0 && sum==0) return dp[N][sum] = true;
        
        else if (arr[N-1] <= sum) 
            return dp[N][sum] = (isSubsetSumRec(N-1, arr, sum - arr[N-1], dp) || 
            isSubsetSumRec(N-1, arr, sum, dp));
        
        else return dp[N][sum] = isSubsetSumRec(N-1, arr, sum, dp);
    }

    public static Boolean isSubsetSumTopDown(int N, int arr[], int sum){
        boolean [][] dp = new boolean[N+1][sum+1]; 
        for (int i=0; i<dp.length; i++){
            boolean [] temp = new boolean [sum+1];
            Arrays.fill(temp, false);
            dp[i] = temp;
        }
        
        if (dp[N][sum] == true) return true;
        
        else 
            return dp[N][sum] = isSubsetSumRec(N, arr, sum, dp);
        }
    
    public static Boolean isSubsetSumBottomUp(int N, int arr[], int sum){
        boolean [][] dp = new boolean[N+1][sum+1]; 
        for (int i=0; i<dp.length; i++){
            boolean [] temp = new boolean [sum+1];
            Arrays.fill(temp, false);
            dp[i] = temp;
        }
        
        for (int i=0; i<N+1; i++) {
        	for (int j=0; j<sum+1; j++) {
        		if (i==0) dp[i][j] = false; 
        		else if (j==0) dp[i][j] = true; 
        		
        		else if (arr[i-1] <= j) {
        			dp[i][j] = ( dp[i-1][j-arr[i-1]] || dp[i-1][j] );
        		}
        		
        		else {
        			dp[i][j] = dp[i-1][j];
        		}
        	}
        }
        return dp[N][sum];
        
    }

	public static void main(String[] args) {
		int N = 6;
		int arr[] = {14,9,8,4,3,2};
		int sum = 20;
		//System.out.println(isSubsetSumTopDown(N, arr, sum));
		System.out.println(isSubsetSumBottomUp(N, arr, sum));

	}

}
