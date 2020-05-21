/*
 * 1. Find the minimum element in the array.
 * 2. Swap the minimum with the element in the first index.
 * 3. Forget the first element and repeat the process for 
 * 	  the remaining part of the array.
 * The array continues to sink till the last valid case.
 * 
 * O(n^2)
 */
package com.Algorithms;

public class Selection_Sort 
{
	public void selectionSort(int [] arr)
	{
		int len = arr.length;
		
		for (int i=0; i<len; i++)
		{
			for (int j=i+1; j<len; j++)
			{
				if (arr[j] < arr[i])
				{
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}
	public static void main(String[] args) 
	{
		int [] array = {1,4,3,7,2};
		
		for (int i=0; i<array.length; i++)
		{
			System.out.print(array[i]+ " ");
		}
		System.out.println();
		
		Selection_Sort ss = new Selection_Sort();
		
		ss.selectionSort(array);
		
		for (int i=0; i<array.length; i++)
		{
			System.out.print(array[i]+ " ");
		}
	}

}
