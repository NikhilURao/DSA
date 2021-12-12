/**Insertion Sort
 * The analogy can be understood from the style we arrange a deck of cards. 
 * This sort works on the principle of inserting an element at a 
 * particular position, hence the name Insertion Sort.
 * 1. The first step involves the comparison of the element in question 
 *    with its adjacent element.
 * 2. And if at every comparison reveals that the element in question can be
 *    inserted at a particular position, then space is created for it 
 *    by shifting the other elements one position to the right and 
 *    inserting the element at the suitable position.
 * 3. The above procedure is repeated until all the element in the array is 
 * 	  at their apt position.
 * 
 *  * Disadvantages:
 * 1. TC => O(n^2)
 * 2. lot of shifts are involved in insertion sort
 *  
 *  * Advantages 
 *  1. In place sorting algorithm 
 */
/*
 * Time Complexity : O(n^2)
 */

package com.Algorithms.sorting;

public class Insertion_Sort {

	public void Insert_Sort(int [] arr) 
	{
		int n = arr.length;
		for(int i=1;i<n;i++) 
		{
			int key=arr[i]; 
			int j=i-1;
			while (j>=0 && arr[j]>key) 
			{
				arr[j+1]=arr[j];
				j--;
			}
			arr [j+1] = key;	
		}
			
}
	static void printArray(int [] arr) {
		int n =arr.length;
		for (int i=0;i<n;i++) {
			System.out.print(arr[i]+" " );
		}
	}
		
	
	public static void main(String[] args) {
		int random_array[] = {1,4,3,7,2};
		//int n =random_array.length -1;
		Insertion_Sort ob = new Insertion_Sort();
		ob.Insert_Sort(random_array);
		printArray(random_array);
		
		
		

	}

}
