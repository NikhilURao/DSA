/*
 * The selection sort algorithm sorts an array by repeatedly finding the minimum element
 *  (considering ascending order) from unsorted part and putting it at the beginning. 
 *  The algorithm maintains two subarrays in a given array.
1) The subarray which is already sorted.
2) Remaining subarray which is unsorted.

In every iteration of selection sort, the minimum element (considering ascending order) 
from the unsorted subarray is picked and moved to the sorted subarray.
 * 1. Find the minimum element in the array.
 * 2. Swap the minimum with the element in the first index.
 * 3. Forget the first element and repeat the process for 
 * 	  the remaining part of the array.
 * The array continues to sink till the last valid case.
 * 
 * O(n^2)
 */
package com.Algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Selection_Sort 
{
	public void selectionSort_nonDecreasing(int [] arr)
	{
		int len = arr.length;
		int min_index = 0;
		
		for (int i=0; i<len; i++)
		{
			for (int j=i+1; j<len; j++)
			{
				if (arr[j] < arr[i])
				{
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
					min_index=j;
					
				}
			}
		}
	}
	
	public void selectionSort_nonIncreasing(int [] arr)
	{
		for (int i=0; i<arr.length; i++)
		{
			for (int j=i+1; j<arr.length; j++)
			{
				if (arr[i] < arr[j])
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public void print(int[] array)
	{
		for (int i=0; i<array.length; i++)
		{
			System.out.print(array[i]+ " ");
		}
	}
	
	public static ArrayList<Integer> solve(int [] arr) {
        int len = arr.length;
        int min_index=0;
		ArrayList<Integer> ind = new ArrayList<Integer>();
		for (int i=0; i<len; i++)
		{
			for (int j=i+1; j<len; j++)
			{
				if (arr[j] < arr[i])
				{
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
					min_index=j;
					
				}
			}
			ind.add(min_index);
		}
		return ind;
    }
	
    public static ArrayList<Integer> solve1(ArrayList<Integer> A) {
        int len = A.size();
        int min_index=0;
		ArrayList<Integer> ind = new ArrayList<Integer>();
		for (int i=0; i<len; i++)
		{
			for (int j=i+1; j<len; j++)
			{
			    int temp = A.get(j);
                A.set(j,A.get(i));
                A.set(i,temp);
                min_index=j;  
			}
			ind.add(min_index);
		}
		return ind;
    }
	
	public static void main(String[] args) 
	{
		
		Selection_Sort ss = new Selection_Sort();
		
		int [] array = new int [5];
		
		Random ran = new Random();
		
		for (int i=0; i<array.length; i++)
		{
			array[i] = ran.nextInt(10);
		}
		System.out.println("Array before sorting");
		ss.print(array);
		System.out.println("");
		
		ss.selectionSort_nonDecreasing(array);
		System.out.println("Array after sorting in non-decreasing order");
		ss.print(array);
		System.out.println();
		
		ss.selectionSort_nonIncreasing(array);
		System.out.println("Array after sorting in non-increasing order");
		ss.print(array);
		int [] arr1 = {3,1,2,4,7,5};
		ArrayList<Integer> ls =solve(arr1);
		System.out.println("");
		for (int i=0; i<ls.size(); i++)
		{
			System.out.print(ls.get(i)+ " ");
		}
		Integer [] a = {3,1,2,4,7,5};
		ArrayList<Integer> as = new ArrayList<Integer>(Arrays.asList(a));
		ArrayList<Integer> ls1 =solve1(as);
		System.out.println("");
		for (int i=0; i<ls1.size(); i++)
		{
			System.out.print(ls1.get(i)+ " ");
		}
	}

}
