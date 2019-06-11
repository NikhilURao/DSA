/**Insertion Sort
 * 2 4 1 3 7 5 9 6
 * 
 */
/*
 * Time Complexity : O(n^2)
 */

package com.Algorithms;

public class Insertion_Sort {

	public void Inser_Sort(int [] arr) {
		int n = arr.length;
		for(int i=1;i<n;i++) {
			int key=arr[i]; 
			int j=i-1;
			while (j>=0 && arr[j]>key) {
				arr[j+1]=arr[j];
				j--;
				}
			arr [j+1] = key;	
		}
			
}
	static void printArray(int [] arr) {
		int n =arr.length;
		for (int i=0;i<n;i++) {
			System.out.print(arr[i]);
		}
	}
		
	
	public static void main(String[] args) {
		int random_array[] = {2,4,1,3,7,5,9,6,0};
		//int n =random_array.length -1;
		Insertion_Sort ob = new Insertion_Sort();
		ob.Inser_Sort(random_array);
		printArray(random_array);
		
		
		

	}

}
