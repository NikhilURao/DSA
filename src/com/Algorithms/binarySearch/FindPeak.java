/*
 * Find a peak element
Problem Description

Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors.

For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.

NOTE: Users are expected to solve this in O(log(N)) time.

Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 109

Input Format
The only argument given is the integer array A.

Output Format
Return the peak element.


Example Input
Input 1:

A = [1, 2, 3, 4, 5]
Input 2:

A = [5, 17, 100, 11]


Example Output
Output 1:

 5
Output 2:

 100


Example Explanation
Explanation 1:

 5 is the peak.
Explanation 2:

 100 is the peak.
 */
package com.Algorithms.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FindPeak {
	
    public static int findPeakElement(ArrayList<Integer> A) {
    	int left = 0;
    	int right = A.size()-1;
    	
    	while (left <= right) {
    		
    		int mid = left + ((right - left)/2);
    		
    		// return mid if A[mid] > A[mid-1] and A[mid] > A[mid+1] i.e. A[mid] is greater than the neighboring elements
    		if ((mid <= 0 || A.get(mid) > A.get(mid - 1)) && (mid >= A.size()-1 || A.get(mid) >= A.get(mid + 1)))
    			return A.get(mid);
    		else if ((mid <= 0 || A.get(mid-1) < A.get(mid)) && (mid >= A.size()-1 || A.get(mid+1) >= A.get(mid))) // if A[mid-1] < A[mid] < A[mid+1] move right
    			left = mid + 1;
    		else
    			right = mid - 1;		
    	}
    	
    	return -1;
    }

	public static void main(String[] args) {
		System.out.println(findPeakElement(new ArrayList<Integer>(Arrays.asList(2, 3, 3))));
		

	}

}
