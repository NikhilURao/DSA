package com.Algorithms;
import java.util.*;
/*
 * Counting sort is a sorting technique based on keys between a specific 
 * range (k- Range of the input = Highest value - Lowest value)
 * It works by counting the number of objects having distinct key values 
 * (kind of hashing). 
 * Then doing some arithmetic to calculate the position of each object in the 
 * output sequence.
 * 
 * Algorithm:
 * 1. Given an array (A) of 'n' elements and the its range 'k' 
 *    (k- Range of the input = Highest value - Lowest value). Create an array (T)
 *    of size 'k' to track the occurrences of numbers in the array or counts. 
 * 2. Initialize the counts to 0 in the array T. Indices of array T are considered 
 *    as elements/keys in array A to store the count of each unique object.
 * 3. Count the occurrences of each element in the array A and store the result in 
 *    the array T at respective indices/keys.
 * 4. Calculate running sum of array T. Running sum for an element at position i
 *    is equal to the sums of the elements in the previous positions + the element 
 *    at position i.
 * 5. Now in array T the value of the index indicates the final/last index/position
 * 	  that key can take in the final array. Create a final array 'F' of 
 *    size equal to the size of input array A.
 * 6. Initialize a pointer at the last element of the input array and decrement till
 *    the start of the array. Go to the T array/count array for that element as index
 *    and place that element at the position = value of the key in T. And decrement 
 *    the value by one.Output each object from the input sequence followed by 
 * 	  decreasing its count by 1.Process the input data from the last.
 * 	  Put data in the respective position by looking at the index: value -1. 
 * 	  Decrease count by 1 to place in count array.
 *    
 * Time Complexity: O(n+k) where n is the number of elements in input array 
 * and k is the range of input.
 * Auxiliary Space: O(n+k)
 */

public class Counting_Sort 
{
	public void countingSort(int [] arr, int k)
	{
		int [] count_arr = new int [k+1];
		Arrays.fill(count_arr, 0);
		// Calculating the occurrences/counts of unique elements in the input array
		for (int i=0; i<arr.length; i++)
		{
			count_arr[arr[i]]++;
		}
		
		// Calculating the running sum for the count_arr
		for (int i=1; i<count_arr.length; i++)
		{
			count_arr[i] += count_arr[i-1];
		}
		
		int [] fin_arr = new int [arr.length];
		// Positioning to the final array
		for (int i=arr.length-1; i>=0; i--)
		{			
			fin_arr[(count_arr[arr[i]]) - 1] = arr[i];
			count_arr[arr[i]]--;
		}
		
		for (int j=0; j<fin_arr.length; j++)
		{
			System.out.print(fin_arr[j]+" ");
		}

	}

	public static void main(String[] args) 
	{
		int [] array = {1, 4, 1, 2, 7, 5, 2};
		// Range of the input array. Range = high - low + 1 = 7-1+1 = 7
		int k = 7;
		Counting_Sort cs = new Counting_Sort();
		cs.countingSort(array, k);

	}

}
