/*
 * Search an element in a rotated sorted array with distinct elements.
 * Example: Input: A -> 50, 60, 100, 3, 9, 10, 25, 30, 35 -> Rotated Sorted Array (right rotated by 3) 
 * Target Element: 25
 * 
 * Output: return the target element if found else -1
 * 
 * Observations: Array is a concatenation of 2 sorted arrays P1-> 50, 60, 100 and P2-> 3, 9, 10, 25, 30, 35
 * All elements in P > elements in P2
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
	
	public int searchElementInRotatedSortedBinarySearch(int[] arr, int target) {
		
		int left = 0; int right = arr.length -1;
		while (left <= right) {
			int mid = Integer.valueOf((left+right)/2);
			
			if (arr[mid] == target)
				return arr[mid];
			
			else if (arr[mid] < arr[0]) { // mid belongs to P2 since A[mid] < A[0] and all elements in P1 > A[0] (since P1 is sorted in ascending order)
					
					if (target >= arr[0] || target < arr[mid]) // target belongs to P1 and to the left of the middle element
						right = mid-1;
					else // target belongs to P2 or to the right of the middle element 
						left = mid+1;
				}
				
				else { // target belongs to P1 since arr[mid] > arr[0]
					
					if (target > arr[0] || target < arr[mid]) // target belongs to P1 and right of the middle element
						left = mid+1;
					
					else // target belongs to P1 and to the right of the middle element
						right = mid-1;
				}	
	}
		return -1;
}

	public static void main(String[] args) {
		int [] array = {8, 9, 1, 3, 5, 6};
		RotatedSortedArrayBinarySearch ser = new RotatedSortedArrayBinarySearch();
		System.out.println(ser.searchElementInRotatedSortedBinarySearch(array, 5));

	}

}
