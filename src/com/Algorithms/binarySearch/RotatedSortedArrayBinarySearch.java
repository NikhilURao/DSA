/*
 * Search an element in a rotated sorted array with distinct elements.
 * Example: Input: A -> 50, 60, 100, 3, 9, 10, 25, 30, 35 -> Rotated Sorted Array (right rotated by 3) 
 * Target Element: 25
 * 
 * Output: return the target element if found else -1
 * 
 * Observations: Array is a concatenation of 2 sorted arrays P1-> 50, 60, 100 and P2-> 3, 9, 10, 25, 30, 35
 * All elements in P1 > elements in P2
 * 
 * Based on the above observations, we first find the mid. Decide if the mid belongs to P1 or P2 by comparing it with A[0]
 * We then compare the target with A[0] and determine if the target belongs to P1 or P2
 * 
 * 
 * 50, 60, 10, 12 , 15, 16 , 17 target: 10
 *  
 */

package com.Algorithms.binarySearch;

public class RotatedSortedArrayBinarySearch {
	
    public static int searchElementInRotatedSortedBinarySearch(final int[] A, int B) {
        int left = 0;
        int right = A.length -1;
        
        while (left <= right){ 
            int mid = left + ((right - left)/2);
            if (A[mid] == B)
                return mid;
            if (A[mid] > A[0]){ // mid belongs to P1
                if (B >= A[0] && B < A[mid]) // key belongs to P1 and to the left of mid
                    right = mid -1;
                else 
                    left = mid +1;
            } 
            
            else { // mid belongs to P2
                if (B <= A[0] && B > A[mid] ) // key belongs to P2 and to the right of mid
                	left = mid + 1;
                else 
                    right = mid -1;
            }
        }
        return -1;
    }

	public static void main(String[] args) {
		int [] array = {101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100};
		System.out.println(searchElementInRotatedSortedBinarySearch(array, 100));

	}

}
