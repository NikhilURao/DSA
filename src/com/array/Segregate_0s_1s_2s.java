package com.array;

import java.util.Arrays;

public class Segregate_0s_1s_2s 
{
	public void segregateUsingDutchNationalFlag(int [] a)
	{
		int low = 0;
		int mid = 0;
		int high = a.length-1;
		
		while (mid <= high)
		{
			if (a[mid] == 0)
			{
				//swap a[mid] & a[low]
				int t = a[mid];
				a[mid] = a[low];
				a[low] = t;
				
				low++;
				mid++;
			}
			
			else if (a[mid] == 2)
			{
				//swap a[mid] & a[high]
				int t = a[mid];
				a[mid] = a[high];
				a[high] = t;
				
				high--;
			}
			
			else if(a[mid] == 1)
				mid++;
		}
		// print
		for (int i=0; i<a.length; i++)
		{
			System.out.print(a[i]+ " ");
		}
	}
	
	public void segregateUsingCountingSort(int [] a)
	{
		int [] count_arr = new int [3];
		Arrays.fill(count_arr, 0);
		
		for (int i=0; i<a.length; i++)
		{
			count_arr[a[i]]++;
		}
		
		for (int i=1; i<count_arr.length; i++)
		{
			count_arr[i] += count_arr[i-1]; 
		}
				
		int [] fin_arr = new int [a.length];
		
		for (int i=a.length-1; i>=0; i--)
		{
			fin_arr[count_arr[a[i]]-1] = a[i];
			count_arr[a[i]]--;
		}
		
		// print
		for (int i=0; i<fin_arr.length; i++)
		{
			System.out.print(fin_arr[i]+" ");
		}
	}

	public static void main(String[] args) 
	{
		int [] arr = {1,2,1,1,0,2,0,1};
		System.out.println("Array before sorting: ");
		// print
		for (int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println("Array after sorting using Dutch National Flag Technique: ");
		Segregate_0s_1s_2s szot = new Segregate_0s_1s_2s();
		szot.segregateUsingDutchNationalFlag(arr);
		System.out.println();
		System.out.println("Array after sorting using Counting Sort Technique: ");
		szot.segregateUsingCountingSort(arr);
	}

}
