/*
 * Maximum Absolute Difference
Problem Description

You are given an array of N integers, A1, A2, .... AN.

Return the maximum value of f(i, j) for all 1 <= i, j <= N. f(i, j) is defined as 
|A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.



Problem Constraints
1 <= N <= 100000

-109 <= A[i] <= 109



Input Format
First argument is an integer array A of size N.



Output Format
Return an integer denoting the maximum value of f(i, j).



Example Input
Input 1:

A = [1, 3, -1]
Input 2:

 
A = [2]


Example Output
Output 1:

5
Output 2:

0


Example Explanation
Explanation 1:

f(1, 1) = f(2, 2) = f(3, 3) = 0
f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

So, we return 5.
Explanation 2:

Only possibility is i = 1 and j = 1. That gives answer = 0.

Soultion:

f(i, j) = |A[i] - A[j]| + |i - j| can be written in 4 ways (Since we are looking at max value, we don’t even care if the value becomes negative as long as we are also covering the max value in some way).

(A[i] + i) - (A[j] + j)
-(A[i] - i) + (A[j] - j) 
(A[i] - i) - (A[j] - j) 
(-A[i] - i) + (A[j] + j) = -(A[i] + i) + (A[j] + j)
Note that case 1 and 4 are equivalent and so are case 2 and 3.

We can construct two arrays with values: A[i] + i and A[i] - i. Then, for above 2 cases, we find the maximum value possible. For that, we just have to store minimum and maximum values of expressions A[i] + i and A[i] - i for all i.

TC=> O(n) SC=> O(n)
 */
package com.array;

public class MaximumAbsoluteDifference {
	
    public static int maxArr(int[] A) {
    	
    	int [] SumIndexA = new int [A.length];
    	int [] DifIndexA = new int [A.length];
    	int maxSumIndexA = Integer.MIN_VALUE; int maxDifIndexA = Integer.MIN_VALUE;
    	int minSumIndexA = Integer.MAX_VALUE; int minDifIndexA = Integer.MAX_VALUE; 
    	for (int i=0; i<A.length; i++) {
    		SumIndexA[i] = A[i] + i;
    		DifIndexA[i] = A[i] - i;
    		maxSumIndexA = Math.max(maxSumIndexA, A[i] + i);
    		minSumIndexA = Math.min(minSumIndexA, A[i] + i);
    		maxDifIndexA = Math.max(maxDifIndexA, A[i] - i);
    		minDifIndexA = Math.min(minDifIndexA, A[i] - i);
    	}
    	
    	return Math.max((maxSumIndexA - minSumIndexA),(maxDifIndexA - minDifIndexA));
    }

	public static void main(String[] args) {
		System.out.println(maxArr(new int [] {-98, -5, 37, -97, 38, 22, 70, 42, 61, 84 }));

	}

}
