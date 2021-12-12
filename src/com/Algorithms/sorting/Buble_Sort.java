/*
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly
 *  swapping the adjacent elements if they are in wrong order.
 *  This sorting algorithm is comparison-based algorithm in which each pair of 
 *  adjacent elements is compared and the elements are swapped if they are not in order.
 *  1. Pick the first element and compare with the adjacent element.
 *  2. If the pair elements are in wrong order
 *  (if first element is greater than the second element in the case of 
 *  sorting the array into a non decreasing array) then swap elements.
 *  3. Go to second element and compare with the third element.
 *  4. At each iteration the greatest elements comes to the end of the array. (i.e for the first iteration the largest element comes to the end of the array, 2nd iteration the 2nd largest element comes to the last but one place of the array so on )
 *  5. Continue the process till the whole array is sorted.
 *  
 *  Time Complexity: Worst case is O(n^2)
 *  Best case using the boolean flag and just need one run to find if the array is already sorted. O(n)
 *  Order of n^2. Polynomial order 
 *  
 *  Disadvantages: 
 *  1. Polynomial Order TC=> O(n^2)
 *  2. 
 *  
 *  Advantages:
 *  1. In-place sorting, no need for extra space/ constant space: O(1) 
 */
package com.Algorithms.sorting;

import java.util.Random;

public class Buble_Sort {
	
	public void sort_bubble_nonDecreasing(int [] a)
	{
		Boolean isSorted = true;
		
		for (int i=0; i<a.length; i++)
		{
			for (int j=0; j<a.length-i-1;j++)
			{
				if (a[j]>a[j+1])
				{
					isSorted = false;
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
			
			if(isSorted)
			{
				break;
			}
				
		}
	}
	
	public void sort_bubble_nonIncreasing(int [] a)
	{
		boolean isSorted = true;
		
		for (int i=0;i<a.length; i++)
		{
			for (int j=0; j<a.length-i-1; j++)
			{
				if (a[j] < a[j+1])
				{
					isSorted = false;
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
			
			if (isSorted)
			{
				break;
			}
		}
	}
	
	public void print(int [] test)
	{
		for (int i=0;i<test.length;i++) {
			System.out.print(test[i]);
			System.out.print(" ");
		}
	}

	public static void main(String[] args) {
		
		Buble_Sort bls = new Buble_Sort();
		
		Random ran = new Random();
		int [] test = new int [15];
		
		for (int i=0;i<test.length;i++) {
			test[i]=ran.nextInt(100);
		}
		
		System.out.println("Array  before sorting : ");
		
		bls.print(test);
		
		bls.sort_bubble_nonDecreasing(test);
		
		System.out.println("");
		
		System.out.println("Array after BubleSort Non Decreasing : ");
		
		bls.print(test);
		
		System.out.println("");
		
		bls.sort_bubble_nonIncreasing(test);
		
		System.out.println("Array after BubleSort Non Increasing : ");
		
		bls.print(test);
		
		
	}

}
