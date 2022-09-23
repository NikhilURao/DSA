/*
 * 
 * 494. Target Sum

You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in 
nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build 
the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

 

Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
Example 2:

Input: nums = [1], target = 1
Output: 1
 

Constraints:

1 <= nums.length <= 20
0 <= nums[i] <= 1000
0 <= sum(nums[i]) <= 1000
-1000 <= target <= 1000
 * 
 */

package codingminutes.dp.KnapsackPattern;

import java.util.Arrays;

public class TargetSum {
	
	public int findTargetSumWays(int [] nums, int target) {
		
		int n = nums.length;
		
		if(n==0) return 0;
		
		// we need to split the array into 2 subsets s1 and s2 such that s1-s2 = diff
		// let the sum of the elements in the array be sum.
		// So s1+s2 = sum => Eq1, also s1-s2=diff => Eq2
		// Eq1 + Eq2 = 2s1 = sum +diff => s1 = (sum + diff) / 2
		// So this problem reduces to finding the number of subsets in the array, whose sum is equal to (sum + diff) / 2
		// we can easily find that using the count subset sum solution
		int sum = 0;
		for (int num: nums) {
			sum += num;
		}
		if ((sum+target)%2 != 0 || Math.abs(target) > sum) return 0;
		int target_subset_sum = (sum + target)/2;
				
		int [][] dp = new int [n+1][target_subset_sum+1];
		
		for (int i=0; i<n+1; i++) {
			int [] temp = new int [target_subset_sum+1];
			Arrays.fill(temp, 0);
			dp[i] = temp;
		}
		dp[0][0] = 1;
		
	    for(int i = 1; i < target_subset_sum+1; i++)
	        dp[0][i] = 0;
	    
		for(int i=1; i<n+1; i++) {
			for (int j=0; j<target_subset_sum+1; j++) {
				if (nums[i-1]<=j) {
					dp[i][j]= dp[i-1][j] + dp[i-1][j-nums[i-1]];
				}
				else
					dp[i][j]= dp[i-1][j];
			}
		}
		return dp[n][target_subset_sum];
		
		//return CountSubsetsSumWithGivenSum.countSubsetSum(nums, target_subset_sum);
	}
	

	public static void main(String[] args) {
		TargetSum ts = new TargetSum();
		//int [] nums = {1}; int target = 2; edge case 1
		//int [] nums = {0,0,0,0,0,0,0,0,1}; int target = 1; edge case 2
		int [] nums = {1,1,2,3}; int target = 1;
		System.out.println(ts.findTargetSumWays(nums, target));

	}


}
