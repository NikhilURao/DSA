/*
 * Find any local minima in an unsorted array with distinct elements. (Applying Binary Search on a sorted array use case)
 * An element in the array is said to be a local minima if its smaller than the neighboring 2 elements and in the case of corner elements
 * smaller than just the 1 neighboring element.
 * 
 * A[i] is said to be a local minima if A[i-1] > A[i] < A[i+1]
 * 
 * In case of corner elements A[0] and A[A.len -1] then A[i] < A[i+1] and A[A.len-1] < A[A.len-2]
 */

package com.Algorithms.binarySearch;

public class LocalMinima {
	
	public int searchMinima(int[] arr) {
		int left=0;
		int right = arr.length -1;
		
		while (left<=right) {
			
			int mid= (int)Math.floor(left+right)/2;
			
			if ((mid-1<0 || arr[mid] < arr[mid-1])&&(mid+1 >= arr.length || arr[mid] < arr[mid+1])) // A[mid-1]>A[mid]<A[mid+1] mid is a local minima
				return arr[mid];
			else if ((mid-1<0 || arr[mid]<arr[mid-1]) && (mid+1>= arr.length || arr[mid]>arr[mid+1])) // move right
				left = mid+1;
			else // if ((mid+1>= arr.length || arr[mid] < arr[mid+1]) && ((mid-1<0 || arr[mid] > arr[mid-1])) || move left
				// (((mid+1>= arr.length || arr[mid] > arr[mid+1]) && (mid-1<0 || arr[mid] > arr[mid-1]))) --> local maxima move left 
				right = mid-1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int [] array = {10, 9, 1, 3, 5, 6};
		int [] array1 = {6,7,8,9,10};
		int [] array2 = {11,10,9,8,7};
		LocalMinima lm = new LocalMinima();
		System.out.println(lm.searchMinima(array));
		System.out.println(lm.searchMinima(array1));
		System.out.println(lm.searchMinima(array2));
		
		

	}

}
