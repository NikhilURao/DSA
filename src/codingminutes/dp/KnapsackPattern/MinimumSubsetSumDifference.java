/*
 * 2035. Partition Array Into Two Arrays to Minimize Sum Difference

You are given an integer array nums of 2 * n integers. 
You need to partition nums into two arrays of length n to minimize the absolute difference of the sums of the
 arrays. To partition nums, put each element of nums into one of the two arrays.

Return the minimum possible absolute difference.

Example 1:

Input: nums = [3,9,7,3]
Output: 2
Explanation: One optimal partition is: [3,9] and [7,3].
The absolute difference between the sums of the arrays is abs((3 + 9) - (7 + 3)) = 2.
Example 2:

Input: nums = [-36,36]
Output: 72
Explanation: One optimal partition is: [-36] and [36].
The absolute difference between the sums of the arrays is abs((-36) - (36)) = 72.
Example 3:

example-3
Input: nums = [2,-1,0,4,-2,-9]
Output: 0
Explanation: One optimal partition is: [2,4,-9] and [-1,0,-2].
The absolute difference between the sums of the arrays is abs((2 + 4 + -9) - (-1 + 0 + -2)) = 0.
 

Constraints:

1 <= n <= 15
nums.length == 2 * n
-107 <= nums[i] <= 107

Time Complexity = O(n*sum) where n is the number of elements and sum is the sum of all elements.
 * 
 */
package codingminutes.dp.KnapsackPattern;

import java.util.Arrays;

public class MinimumSubsetSumDifference {
	
    public static int minimumSubsetSumDifference(int[] nums) {
    	
    	int n = nums.length;
    	if (n==0) return 0;
    	
    	int sum = 0;
    	for (int num: nums) {
    		sum += num;
    	}
    	
    	boolean [][] arr = isSubsetSumBottomUp(n, nums, sum);
    	int minDifference = Integer.MAX_VALUE;
//    	for (int i=0; i<arr.length/2; i++) {
//    		if (arr[i]) {
//    			minDifference = Math.min(minDifference, sum - 2*i);
//    		}
//    	}
        for (int j = sum / 2; j >= 0; j--) {
            // Find the
            if (arr[n][j] == true) {
            	minDifference = sum - 2 * j;
                break;
            }
        }
    	
        return minDifference;
    }
    
    public static boolean [][] isSubsetSumBottomUp(int N, int arr[], int sum){
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
        return dp;
        
    }

	public static void main(String[] args) {
		int[] nums = {3,9,7,3};
		System.out.println(minimumSubsetSumDifference(nums));

	}

}
