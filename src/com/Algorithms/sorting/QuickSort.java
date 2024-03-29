/*
 * Since we are randomly choosing the pivot, the best case time complexity is when the pivot divides 
 * the array into exactly 2 halves. So the best case tc => O(nlogn) .i.e the pivot element's value is the 
 * median of the array. n -> n/2 -> n/4 -> n/8 -> ........ -> 1
 * On the contrary  the worst case TC is when the pivot chosen divides the array into n-1 and 1 parts. 
 * every recursive call the problem reduces by 1. So worst case TC is O(n^2)
 * n -> n-1 -> n-2 -> .............. -> 1 (n+n-1+n-2+n-3+n-4+n-5+........ = n(n+1)/2 = O(n^2))
 * Average case lies between nlogn and n^2, but it will be closer to nlogn, just the base of log varies 
 */
package com.Algorithms.sorting;

public class QuickSort 
{
	public void quickSort(int [] A, int l, int r)
	{
		if (l < r)
		{
			int pivot = getPartition(A, l, r);
			// A[pivot] is in the final position
			quickSort(A, l, pivot-1);
			quickSort(A, pivot+1, r);
		}
		else 
			return;
	}
	
	public int getPartition(int [] A, int l, int r)
	{	
		// Finding a random index in the range of l and r.
		int randomIndex = (int) (Math.random() * (r-l+1)) + l;
		// Assigning the value of the element at the randomIndex i.e. A[randomIndex] to x
		int x = A[randomIndex];
		//Swapping the element at l with the element at the randomIndex to make sure that the element at randomIndex is in the 
		//first position in the array.
		A[randomIndex] = A[l];
		A[l] = x;
		// Assigning l to j 
		int j = l;
		// loop to compare the elements at index ranging from 1 to r with the l
		for (int i=l+1; i<=r; i++)
		{
			//condition to check if A[i] is less than A[l]
			if (A[i] < A[l])
			{
				//Increment j
				j++;
				//Swap A[j] with A[i]
				int temp = A[j];
				A[j] = A[i];
				A[i] = temp;
				// {A[l+1.....j] <= x and A[j+1....i] > x}
			}
		}
		// Swap the last element in the window i.e A[j] with A[l] so that pivot is
		//at the right position
		// elements to the left of the pivot are less than or equal to the pivot 
		// while those to the right of the pivot are greater than pivot.
		int tmp = A[j];
		A[j] = A[l];
		A[l] = tmp;
		// return the index of the pivot
		return j;
		
	}

	public static void main(String[] args) 
	{
		int [] Array = {4, 7, 3, 9, 2, 1};
		// print
		System.out.println("Array before sorting: ");
		
		for (int i=0; i< Array.length; i++)
		{
			System.out.print(Array[i]+" ");
		}
		
		QuickSort qs = new QuickSort();
		
		qs.quickSort(Array, 0, Array.length -1);
		
		// print
		System.out.println();
		System.out.println("Array after sorting: ");
		for (int i=0; i< Array.length; i++)
		{
			System.out.print(Array[i]+" ");
		}

	}

}
