/*
 * Given 2 sorted arrays A and B of size n and m, print all the elements of A and B in a sorted order. 
 * In other words merge the 2 sorted arrays into one sorted array with elements from both the sorted array.
 * 
 * TC => Theta(Size of A + Size of B)
 * SC => O(1)
 */
package com.Algorithms.sorting.problems;

public class Merge2SortedArrays {
	
	public static void merge(int [] A, int [] B) {
		int m = A.length;
		int n = B.length;
		int k = 0; // pointer to access array A elements
		int l = 0; // pointer to access array B elements
		
		while (k<=m-1 && l<=n-1) {
			if (A[k] < B[l]) {
				System.out.print(A[k]+" ");
				k++;
			}
			else {
				System.out.print(B[l]+" ");
				l++;
			}
		}
		
		if (k<=m-1) {
			while (k<=m-1) {
				System.out.print(A[k]+" ");
				k++;
			}
		}
		
		if (l<=n-1) {
			while (l<=n-1) {
				System.out.print(B[l]+" ");
				l++;
			}
		}
	}

	public static void main(String[] args) {
		merge(new int [] {10, 15, 20, 20}, new int [] {1, 2, 12, 30});
		

	}

}
