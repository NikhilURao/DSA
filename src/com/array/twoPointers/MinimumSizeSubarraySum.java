/*
 * Given an array of n positive integers and a positive integer s, 
 * find the minimal length of a contiguous subarray of which the sum >= s. 
 * If there isn't one, return 0 instead.

Example: 
Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.

Algorithm:
1.We place a 'window' with left and right as i and j at the first item firstGet the optimal subarray starts from current i, 0: Then we first move
the j pointer to include enough items that sum[0:j+1]>=s, this is the
process of getting the optimial subarray that starts with 0. And assume
j stops at e0
2.	Get the optimal subarray ends with current j, e0: we shrink the window
size by moving the i pointer forward so that we can get the optimal
subarray that ends with current j and the optimal subarray starts from
s0.
3.	Now, we find the optimal solution for subproblem [0:i,0:j](the start
point in range [0, i] and end point in range [0,j]. Starts from next i
and j, and repeat step 1 and 2. 
*/
package com.array.twoPointers;

public class MinimumSizeSubarraySum {
	public int findMinSize_SubarraySum(int [] A, int s)
	{
		int n = A.length;
		int i=0,j=0;
		int sum=0; int res = Integer.MAX_VALUE;
		while (j<n)
		{
			sum = sum + A[j];
			
			while (sum >= s)
			{
				res = Math.min(res, j-i+1);
				sum = sum - A[i];
				i++;
			}
			
			j++;
		}
		
		return res;
	}

	public static void main(String[] args) {

		int [] arr = {2 , 3 , 1 , 2 , 4 , 3};
		MinimumSizeSubarraySum mss = new MinimumSizeSubarraySum();
		System.out.println(mss.findMinSize_SubarraySum(arr, 9));
		
	}

}
