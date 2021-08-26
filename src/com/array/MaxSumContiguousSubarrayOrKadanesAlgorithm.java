/*
 * Max Sum Contiguous Subarray
Problem Description

Find the contiguous subarray within an array, A of length N which has the largest sum.
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.


Problem Constraints
1 <= N <= 1e6
-1000 <= A[i] <= 1000



Input Format
The first and the only argument contains an integer array, A.



Output Format
Return an integer representing the maximum possible sum of the contiguous subarray.



Example Input
Input 1:

 A = [1, 2, 3, 4, -10] 
Input 2:

 A = [-2, 1, -3, 4, -1, 2, 1, -5, 4] 


Example Output
Output 1:

 10 
Output 2:

 6 


Example Explanation
Explanation 1:

 The subarray [1, 2, 3, 4] has the maximum possible sum of 10. 
Explanation 2:

 The subarray [4,-1,2,1] has the maximum possible sum of 6. 
 
 Brute Force Solution:
 For all the subarrays in the given array of size 'N' (total no of subarrays possible in an 
 array of size N is N*(N+1)/2 if N=9 then total no of subarrays is 9*10/2 = 45    )
 , find the sum of all possible subarrays and return the maximum sum.
 TC => O(n^2) SC=> O(1)
 
 Solution using Kadane's Algorithm:
 For each element at index i (i-> 1 to A.len-1) in the array, there are two choices, 
 one is to join the previous subarray or form a new subarray starting from that element
 depending on whether the subarray sum if it joins previous array is larger or smaller
 than the subarray sum formed by subarray starting with the element.
  
 Initialize:
     overall_subarray_max = A[0]
     cur_subarray_max = A[0]

Loop for each element of the array i-> 1 to A.length -1
  (a) cur_subarray_max = cur_subarray_max + a[i]
  (b) if(overall_subarray_max < cur_subarray_max)
            overall_subarray_max = cur_subarray_max
  (c) if(cur_subarray_max < 0)
            cur_subarray_max = 0
return overall_subarray_max
TC => O(n)  SC=> O(1)

Example: A [-2,1,-3,4,-1,2,1,-5,4]

cur_subarray_max	overall_subarray_max
-2 -> -2			-2 -> -2
 1 -> 1				 1 -> 1
-3 -> 1,-3 			 1 -> 1
 4 -> 4				 4 -> 4
 3 -> 4,-1			 4 -> 4
 5 -> 4,-1,2		 5 -> 4,-1,2
 6 -> 4,-1,2,1		 6 -> 4,-1,2,1
 1 -> 4,-1,2,1,-5	 6 -> 4,-1,2,1
 5 -> 4,-1,2,1,-5,4	 6 -> 4,-1,2,1
 
 			
 ^^^^^^^^*******^^ TO:DO Solution using Divide and Conquer Approach TC=> O(nlogn)^^^^^^^^^********^^
 */

package com.array;

import javafx.util.Pair;

public class MaxSumContiguousSubarrayOrKadanesAlgorithm {
	
	public static int getMaximumSumSubarrayBruteForce(int [] A) {
		int maxSum = Integer.MIN_VALUE;
		
		for (int i=0; i<A.length; i++) {
			int sum = 0;
			for (int j=i; j<A.length; j++) {
				sum+=A[j];
				maxSum = Math.max(maxSum, sum);
			}
		}
		
		return maxSum;
	}
	
	public static Pair<Integer,int[]> getMaximumSumSubarrayBruteForceUsingKadanesAlgo(int [] A) {
		int cur_subarray_max = A[0];
		int overall_subarray_max = A[0];
		int [] index = new int [2];
		int start=0; int end=0; int _start = 0; int _end = 0;
		
		for (int i=1; i<A.length; i++) {
			if (cur_subarray_max > 0) {
				cur_subarray_max += A[i];
				end = i;
			}
				
			else {
				cur_subarray_max = A[i];
				start = i;
			}
			
			if (cur_subarray_max > overall_subarray_max) {
				overall_subarray_max = cur_subarray_max;
				_start = start;
				_end = end;
			}
		}
		
		index[0] = _start; index[1] = _end;
		return  new Pair<Integer, int[]>(overall_subarray_max, index);
	}

	public static void main(String[] args) {
		System.out.println(getMaximumSumSubarrayBruteForce(new int [] {-2,1,-3,4,-1,2,1,-5,4}));
		Pair<Integer, int[]> pout = getMaximumSumSubarrayBruteForceUsingKadanesAlgo(new int [] {-2,1,-3,4,-1,2,1,-5,4});
		System.out.println(pout.getKey()+" "+pout.getValue()[0]+":"+pout.getValue()[1]);

	}

}
