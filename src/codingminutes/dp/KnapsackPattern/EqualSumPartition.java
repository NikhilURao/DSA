/*
 * 
 * 416. Partition Equal Subset Sum

Given a non-empty array nums containing only positive integers, find if the array can be partitioned
into two subsets such that the sum of elements in both subsets is equal.

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 
Constraints:
1 <= nums.length <= 200
1 <= nums[i] <= 100
 */

package codingminutes.dp.KnapsackPattern;

import java.util.Arrays;

public class EqualSumPartition {
	
    public static boolean canPartition(int[] nums) {
        
    	int n = nums.length;
        if (n==0) return false;
        
    	int sum = 0;
    	for (int element: nums) {
    		sum+=element;
    	}
    	
    	if (sum%2 != 0) return false;
    	
    	else 
    		return subsetSum(nums, sum/2, n);
    	
    }
    public static boolean subsetSum(int[] nums, int sum, int n) {
    	
    	boolean [][] dp = new boolean[n+1][sum+1];
    	for (int i=0; i<dp.length; i++) {
    		boolean [] temp = new boolean[sum+1];
    		Arrays.fill(temp, false);
    		dp[i] = temp;
    	}
    	
    	for (int nr=0; nr<n+1; nr++) {
    		for (int nsum=0; nsum<sum+1; nsum++) {
    			if (nr==0) dp[nr][nsum] = false;
    			else if (nsum==0) dp[nr][nsum] = true;
    			
    			else if (nums[nr-1] <= nsum) {
    				dp[nr][nsum] = ( dp[nr-1][nsum - nums[nr-1]] || dp[nr-1][nsum]);
    			}
    			
    			else {
    				dp[nr][nsum] = dp[nr-1][nsum];
    			}
    		}
    	}
    	
    	return dp[n][sum];
    }

        
    	
    

	public static void main(String[] args) {
		//int[] nums  = {1,5,11,5};
		int[] nums  = {14,9,8,4,3,2};
		System.out.println(canPartition(nums));
		//System.out.println(subsetSum(nums, 20, 6));
	}

}
