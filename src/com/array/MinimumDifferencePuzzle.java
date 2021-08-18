/*
 * There is a shop whose assistant told you that there are A puzzles in the shop and you want to buy B of them. They might differ in difficulty and size. The first jigsaw puzzle consists of A1 pieces, the second one consists of A2 pieces and so on.

You decided that the difference between the numbers of pieces in bought puzzles must be as small as possible. Let x be the number of pieces in the largest puzzle that the you buy and y be the number of pieces in the smallest such puzzle. You want to choose such B puzzles that x-y is as minimum as possible. Find the least possible value of x-y.



Problem Constraints
1 <= A <= 103

1 <= B <= A

1 <= A[i] <= 106



Input Format
First argument is a vector A whose ith element represents number of pieces of ith puzzle.

Second argument is an integer B as per the question.



Output Format
Return an integer showing minimum possible value of x-y.



Example Input
Input 1:

A={10, 12, 10, 7, 5, 22}, B=4


Example Output
Output 1:

5


Example Explanation
Explanation 1:

Selected puzzles are 10, 10, 12, 7: (Max-Min) = (12-7) = 5.
 */
package com.array;

import java.util.*;

public class MinimumDifferencePuzzle {
    public static int solve(ArrayList<Integer> A, int B) {
    	int res = Integer.MAX_VALUE;
    	// sort the array with in-built sorting method (Java uses Tim Sort)
    	Collections.sort(A);
    	// for a window of B in the sorted array find the dif of min and max in the window
    	for (int i=0; i<=A.size()-B; i++) {
    		res = Math.min(res, A.get(i+B-1) - A.get (i));
    	}
    	return res==Integer.MAX_VALUE? 0 : res;
    }

	public static void main(String[] args) {
		System.out.println(solve(
				new ArrayList<Integer>(Arrays.asList(10, 12, 10, 7, 5, 22)), 5));

	}

}
