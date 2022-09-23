/*
 * Sliding Window Maximum
Problem Description

Given an array of integers A. There is a sliding window of size B which is moving from the very left of the array
to the very right. You can only see the B numbers in the window. Each time the sliding window moves rightwards by
one position. You have to find the maximum for each window.

Return an array C, where C[i] is the maximum value in the array from A[i] to A[i+B-1].

Refer to the given example for clarity.

NOTE: If B > length of the array, return 1 element with the max of the array.



Problem Constraints
1 <= |A|, B <= 106



Input Format
The first argument given is the integer array A.

The second argument given is the integer B.



Output Format
Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].



Example Input
Input 1:

 A = [1, 3, -1, -3, 5, 3, 6, 7]
 B = 3
Input 2:

 A = [1, 2, 3, 4, 2, 7, 1, 3, 6]
 B = 6


Example Output
Output 1:

 [3, 3, 5, 5, 6, 7]
Output 2:

 [7, 7, 7, 7]


Example Explanation
Explanation 1:

 Window position     | Max
 --------------------|-------
 [1 3 -1] -3 5 3 6 7 | 3
 1 [3 -1 -3] 5 3 6 7 | 3
 1 3 [-1 -3 5] 3 6 7 | 5
 1 3 -1 [-3 5 3] 6 7 | 5
 1 3 -1 -3 [5 3 6] 7 | 6
 1 3 -1 -3 5 [3 6 7] | 7
Explanation 2:

 Window position     | Max
 --------------------|-------
 [1 2 3 4 2 7] 1 3 6 | 7
 1 [2 3 4 2 7 1] 3 6 | 7
 1 2 [3 4 2 7 1 3] 6 | 7
 1 2 3 [4 2 7 1 3 6] | 7
 */
package com.array;

import java.util.*;

public class SlidingWindowMaximum {

    public static int[] slidingMaximum(final int[] A, int B) {
        int n = A.length;
    	int [] maxSlidingWindow = new int [n-B+1]; // to store the maximum in each sliding window of size B possible in array A.
    	
    	// find next greater element to the right for each element in A. Store the index of NGETR
    	int [] NGETR = new int [n];
    	NGETR[n-1] = n; // since the last element in the array does not have NGETR default value is n.
    	Stack<Integer> st = new Stack<>();
    	st.push(n-1); // push the index of the last element in the array A into the stack.
    	
    	for (int i=n-2; i>=0; i--) {
    		// pop, ans, push
    		while (!st.isEmpty() && A[st.peek()] < A[i]) {
    			st.pop();
    		}
    		
    		// if stack is empty then the current element doesn't have a NGETR; the NGETR of the index of current element is n.
    		if (st.isEmpty())
    			NGETR[i] = n;
    		else 
    			NGETR[i] = st.peek();
    		
    		st.push(i);
    	}
    	
    	// for each window starting at index i find the maximum in that window
    	for (int i=0; i<n-B+1; i++) {
    		int j=i;
    		// if the NGETR of the element at j is within the window then jump j to that index. 
    		// Till the NGETR of an element is not within the current window
    		while (NGETR[j]<i+B && j<=n-B+1) {
    			j = NGETR[j];
    		}
    		
    		// maximum of the current window is an element within the window whose NGETR is outside the current window
    		maxSlidingWindow[i] = A[j];
    	}
    	
    	return maxSlidingWindow;
    }
	
	public static void main(String[] args) {
		int [] res = slidingMaximum(new int [] {1,3,-1,-3,5,3,6,7}, 3);
		for (int i=0; i<res.length; i++) {
			System.out.print(res[i]+" ");
		}
	}

}
