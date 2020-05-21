/**
 * Sort an array when two halves are sorted
Given an integer array of which both first half and second half are sorted. 
Task is to merge two sorted halves of array into single sorted array.

Examples:
                0  1  2   3  4  5
Input : A[] = { 2, 3, 8, -1, 7, 10 }
                |         |       |
                start    mid     end
                or i     or m    or j

Output : -1, 2, 3, 7, 8, 10 

Input : A[] = {-4, 6, 9, -1, 3 }
Output : -4, -1, 3, 6, 9 

USED IN MERGE SORT
 */
package com.array;

//import java.util.Random;
/*
 * Test Array = {.........,3,5,6,8,12,15,7,8,9,10,17,19,23,25,..............}
 */
public class Sort_Array_2 {
	static void merge(int i,int m,int j,int a []) {
		int start = i;
		int mid = m;
		int end = j;
		int temp[] = new int [j-i+1];
		int k=0;
		while (start<=m && mid<=end) {
			
			if(a[start] < a[mid]) {
				temp[k] = a[start];
				start++;
				k++;
				}
			else {
			temp[k] = a[mid];
			mid++;
			k++;
			}
		}
		while (start < m) {
			temp[k] = a[start];
			start ++;
			k++;
			}
		while (mid <= end) 
		{
			temp[k] = a[mid];
			mid++;
			k++;
			}
	for (int l=0;l<temp.length;l++) {
		a[i]=temp[l];
		i++;
	}
	}
public static void main(String []args)
{
/*	Random rand = new Random();
	for (int i=0;i<test.length;i++) {
		test[i]=rand.nextInt(10);
	}
*/	
	//int [] test = new int [10];
	int [] test = {7,9,2,8};
	System.out.println("Before Sorting : ");
	for (int i=0;i<test.length;i++) {
		System.out.print(test[i]);
		System.out.print(" ");
	}
	System.out.println(" ");
	merge(0,1, test.length-1, test);
	
	System.out.println("After Sorting : ");
	for (int i =0;i<test.length;i++) {
		System.out.print(test[i]);
		System.out.print(" ");
	}
	
}
}
