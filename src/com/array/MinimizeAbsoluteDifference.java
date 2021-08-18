/*
 * Minimize the absolute difference
Given three sorted arrays A, B and Cof not necessarily same sizes.

Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively. i.e. minimize | max(a,b,c) - min(a,b,c) |.

Example :

Input:

A : [ 1, 4, 5, 8, 10 ]
B : [ 6, 9, 15 ]
C : [ 2, 3, 6, 6 ]
Output:

1
Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.

Solution: 
1. Start with the largest elements in each of the arrays A, B & C. 
2. Maintain a variable to update the answer during each of the steps 
to be followed. 
3. In every step, the only possible way to decrease the difference is 
to decrease the maximum element out of the three elements. 
So traverse to the next largest element in the array containing the 
maximum element for this step and update the answer variable. 
4. Repeat this step until the array containing the maximum element ends.

TC=> O(n)
SC=> O(1) 
 */
package com.array;

import java.util.*;

public class MinimizeAbsoluteDifference {
	
    public static int getMinimumAbsoluteDifference(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
    	// keep pointers for the last index of each array
    	int i = A.size()-1;
    	int j = B.size()-1;
    	int k = C.size()-1;
    	// calculate the minAbsDiff of maximum elements of all 3 Arrays
    	int minAbsDif = Math.abs(
				Math.max(A.get(i),Math.max(B.get(j), C.get(k))) - 
				Math.min(A.get(i),Math.min(B.get(j), C.get(k))));
    	
    	while (i >=0 && j>=0 && k>=0) {
    		int maxOfAll=Math.max(A.get(i),Math.max(B.get(j), C.get(k)));
    		int minOfAll=Math.min(A.get(i),Math.min(B.get(j), C.get(k))); 
    		int diff = Math.abs(maxOfAll - minOfAll); // current diff
    		// if current dif < minAbsDiff
    		if (diff < minAbsDif) {
    			minAbsDif = diff;
    		}
    		// only possible way to decrease the difference is to decrease the maximum element out of the three elements
    		// if maxOfAll belongs to A array decrement the index i of A.
    		if (A.get(i) == maxOfAll)
    			i--;
    		// if maxOfAll belongs to B array decrement the index j of B.
    		else if (B.get(j) == maxOfAll)
    			j--;
    		else k--;
    	}
    	return minAbsDif;
    }

	public static void main(String[] args) {
		System.out.println(
		getMinimumAbsoluteDifference(
				new ArrayList<Integer>(Arrays.asList(-1)), 
				new ArrayList<Integer>(Arrays.asList(-2)), 
				new ArrayList<Integer>(Arrays.asList(-3))));

	}

}
