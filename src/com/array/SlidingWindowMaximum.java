/*
 * Sliding Window Maximum
Problem Description

Given an array of integers A. There is a sliding window of size B which is moving from the very left of the array to the very right. You can only see the B numbers in the window. Each time the sliding window moves rightwards by one position. You have to find the maximum for each window.

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
    		// if the NGETR of the element at j is within the window then jump j to that index. Till the NGETR of an element is not within the current window
    		while (NGETR[j]<i+B && j<=n-B+1) {
    			j = NGETR[j];
    		}
    		
    		// maximum of the current window is an element within the window whose NGETR is outside the current window
    		maxSlidingWindow[i] = A[j];
    	}
    	
    	return maxSlidingWindow;
    }
	
	public static void main(String[] args) {
		/*
		int [] res = slidingMaximum(new int [] {1,3,-1,-3,5,3,6,7}, 3);
		for (int i=0; i<res.length; i++) {
			System.out.print(res[i]+" ");
		}*/
		String [] arr = {"0:51:13","1:00:00","1:00:00","1:00:00","0:54:30","1:00:00","1:00:00","0:23:47","1:00:00","0:47:35","0:10:54","0:06:46","0:16:53","1:00:00","0:48:17","0:48:17","0:13:32","0:00:43","0:41:19","0:12:06","0:43:46","0:29:54","0:03:05","0:56:48","0:56:52","0:54:49","0:59:27","0:57:42","0:59:03","0:57:35","1:00:00","1:00:00","1:00:00","1:00:00","0:03:24","1:00:00","1:00:00","1:00:00","0:07:35","1:00:00","0:01:35","0:59:57","1:00:00","1:00:00","1:00:00","1:00:00","1:00:00","0:13:40","1:00:00","0:20:24","0:11:58","1:00:00","0:59:27","0:41:29","0:45:53","0:42:06","1:00:00","1:00:00","0:56:19","0:52:59","0:11:53","1:00:00","0:14:20","1:00:00","1:00:00","1:00:00","1:00:00","1:00:00","0:41:54","0:26:04","1:00:00","1:00:00","1:00:00","1:00:00","0:17:19","0:06:57","1:00:00","0:48:49","0:05:11","0:50:52","1:00:00","0:42:24","1:00:00","0:34:40","0:59:31","1:00:00","0:51:57","0:43:20","0:00:26","0:58:07","1:00:00","1:00:00","0:43:38","1:00:00","0:27:55","1:00:00","0:26:21","1:00:00","1:00:00","1:00:00","0:02:43","1:00:00","0:27:18","0:57:10","1:00:00","1:00:00","1:00:00","1:00:00","1:00:00","0:21:22","0:08:50","0:46:47","0:11:07","1:00:00","0:35:44","1:00:00","1:00:00","1:00:00","0:49:34","0:20:05","1:00:00","1:00:00","0:54:29","1:00:00","0:15:49","0:40:05","0:59:51","1:00:00","0:41:56","0:05:48","0:47:27","1:00:00","0:06:34","0:56:52","1:00:00","0:28:25","1:00:00","0:36:18","0:11:29","1:00:00","0:00:26","0:49:11","1:00:00","0:15:40","1:00:00","1:00:00","0:39:29","0:20:00","1:00:00","1:00:00","0:34:03","0:28:57","1:00:00","0:27:38","0:50:55","0:15:30","0:54:06","1:00:00","0:55:48","0:53:21","0:07:53","1:00:00","0:46:00","0:44:19","0:13:17","1:00:00","0:11:05","0:26:47","1:00:00","1:00:00","0:31:58","0:50:06","0:20:16","1:00:00","1:00:00","0:19:24","0:14:45","0:50:02","0:10:01","0:33:30","0:43:33","0:34:41","0:20:09","1:00:00","0:05:15","0:03:40","1:00:00","1:00:00","0:22:58","0:41:48","0:01:25","1:00:00","1:00:00","1:00:00","1:00:00","0:38:22","1:00:00","1:00:00","0:26:46","0:43:54","0:15:38","0:56:36","0:20:00","0:38:07","0:48:15","1:00:00","1:00:00","1:00:00","0:06:05","0:15:10","1:00:00","0:00:25","1:00:00","0:36:18","1:00:00","1:00:00","1:00:00","0:31:51","1:00:00","1:00:00","0:14:16","0:23:13","1:00:00","1:00:00","0:00:13","0:18:06","1:00:00","0:53:59","1:00:00","1:00:00","1:00:00","1:00:00","0:39:44","1:00:00","1:00:00","1:00:00","0:45:28","0:17:11","0:22:34","1:00:00","0:16:36","1:00:00","0:35:09","0:58:27","1:00:00","1:00:00","1:00:00","1:00:00","0:08:30","1:00:00","0:15:57","1:00:00","1:00:00","1:00:00","0:49:02","0:50:35","0:38:58","1:00:00","1:00:00","0:59:28","1:00:00","1:00:00","1:00:00","1:00:00","1:00:00","0:43:59","0:07:42","1:00:00","0:55:00","0:41:41","1:00:00","1:00:00","1:00:00","1:00:00","1:00:00","0:30:29","1:00:00","1:00:00","1:00:00","1:00:00","1:00:00","1:00:00","1:00:00","1:00:00","0:44:42","0:59:07"};
		float sum_hours = 0F;
		for (int i=0; i<arr.length; i++) {
			sum_hours += Float.valueOf(arr[i].split(":")[0]) + 
					Float.valueOf(arr[i].split(":")[1])/60 + 
					Float.valueOf(arr[i].split(":")[2])/3600;
		}
		
		System.out.println(sum_hours);
	}

}
