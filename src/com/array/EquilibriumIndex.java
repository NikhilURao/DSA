/*
 * Equilibrium index of an array
Problem Description

You are given an array A of integers of size N.

Your task is to find the equilibrium index of the given array

Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.

NOTE:

Array indexing starts from 0.
If there is no equilibrium index then return -1.
If there are more than one equilibrium indexes then return the minimum index.



Problem Constraints
1<=N<=1e5
-1e5<=A[i]<=1e5


Input Format
First arugment contains an array A .


Output Format
Return the equilibrium index of the given array. If no such index is found then return -1.


Example Input
Input 1:
A=[-7, 1, 5, 2, -4, 3, 0]
Input 2:

A=[1,2,3]


Example Output
Output 1:
3
Output 2:

-1


Example Explanation
Explanation 1:
3 is an equilibrium index, because: 
A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
Explanation 1:

There is no such index.

Solution:
1. Create an array prefix_sum and calculate the prefix sum array for array A.
2. For each index in cumulative find and compare left sum and right sum.
	left sum of ith index = prefix_sum[i-1]
	right sum of ith index = sum of entire array - prefix_sum(i) = prefix_sum(n-1) - prefix_sum(i)
	
TC => O(n)
SC => O(n) to store prefix sum array prefix_sum.
 */
package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class EquilibriumIndex {
	
	public static int getEquilibriumIndex(int [] A) {
		
		// calculate the prefix sum/ cumulative sum of A
		int [] prefix_sum = new int [A.length + 1];
		Arrays.fill(prefix_sum, 0);
		prefix_sum[0] = 0;
		for (int i=1; i<prefix_sum.length; i++) {
			prefix_sum[i] = prefix_sum[i-1] + A[i-1];
		}
		
		// for each index in cumulative find the left sum and right sum.
		// left sum of ith index = prefix_sum[i-1]
		// right sum of ith index = sum of entire array - prefix_sum(i) = prefix_sum(n-1) - prefix_sum(i) 
		for (int i=1; i<prefix_sum.length; i++) {
			if (prefix_sum[i-1] == (prefix_sum[prefix_sum.length - 1] - prefix_sum[i])) {
				return i-1;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(getEquilibriumIndex(new int [] {1, 2, 3, 7, 1, 2, 3}));
		ArrayList<Integer> ls = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		Collections.sort(ls);
		ls.forEach(p -> System.out.print(p+" "));
	}

}
