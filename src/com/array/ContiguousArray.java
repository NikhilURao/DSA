/*
 * Contiguous Array
Given an array of integers A consisting of only 0 and 1.

Find the maximum length of a contiguous subarray with equal number of 0 and 1.



Input Format

The only argument given is the integer array A.
Output Format

Return the maximum length of a contiguous subarray with equal number of 0 and 1.
Constraints

1 <= length of the array <= 100000
0 <= A[i] <= 1
For Example

Input 1:
    A = [1, 0, 1, 0, 1]
Output 1:
    4
    Explanation 1:
        Subarray from index 0 to index 3 : [1, 0, 1, 0]
        Subarray from index 1 to index 4 : [0, 1, 0, 1]
        Both the subarrays have equal number of ones and equal number of zeroes.

Input 2:
    A = [1, 1, 1, 0]
Output 2:
    2
 */
package com.array;

import java.util.*;

public class ContiguousArray {
	
	public static int getMaxLenSubArray(int [] A) {
		int max_len = Integer.MIN_VALUE;
		
		// replace all 0s with -1 in A
		for (int i=0; i<A.length; i++) {
			if (A[i]==0)
				A[i] = -1;
		}
		
		// calculate prefix sum/ cumulative sum of A
		int [] prefix_sumA = new int [A.length+1];
		prefix_sumA[0] = 0;
		prefix_sumA[1] = A[0];
		for (int i=2; i<prefix_sumA.length; i++) {
			prefix_sumA[i] = prefix_sumA[i-1] + A[i-1];
		}
		
		// for repeating elements in the prefix_sumA, calculate the max len
		HashMap<Integer, Integer []> hmap = new HashMap<Integer, Integer []>();
		
		for (int i=0; i<prefix_sumA.length; i++) {
			if (!hmap.containsKey(prefix_sumA[i])) 
				hmap.put(prefix_sumA[i], new Integer[] {i,i});
			else {
				Integer [] temp = hmap.get(prefix_sumA[i]);
				temp[1] = i;
				hmap.put(prefix_sumA[i], temp);
			}
		}
		for (Map.Entry<Integer, Integer[]> entry : hmap.entrySet()) {
			max_len = Math.max(max_len, entry.getValue()[1] - entry.getValue()[0]);
		}
		
		return max_len;
	}

	public static void main(String[] args) {
		System.out.println(getMaxLenSubArray(new int [] {1, 1, 1, 0}));

	}

}
