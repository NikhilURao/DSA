/*
 * Given a sorted array where every element appears twice except 1 element.
 * Find that element.
 */
package com.Algorithms.binarySearch;

public class SortedArray2RepeatingExcept1 {
	
	public int search(int[]arr) {
		if (arr.length/2 == 0) // length of the array has to be odd since the array is sorted and each element in repeated twice except for one element
			return -1;
		else {
			int left=0; int right=arr.length-1;
			
			while (left <= right) {
				int mid = (int) Math.floor((left+right)/2);
				
				if ((mid+1>=arr.length || arr[mid]!=arr[mid+1]) && (mid-1<0 || arr[mid]!=arr[mid-1])) 
					return arr[mid];
				else if ((arr[mid]!=arr[mid-1] || mid-1<0) && 
						(arr[mid]==arr[mid+1] || mid+1>=arr.length) && 
						mid%2!=0 && ((arr.length-1) - (mid+1))%2==0) // move left
					right = mid-1;
				else // move right 
					left = mid+1;
			}
			
			return -1;
		}
	}

	public static void main(String[] args) {
		int [] arr = {2,2,5,5,6,6,8,8,13,13,18};
		SortedArray2RepeatingExcept1 sare = new SortedArray2RepeatingExcept1();
		System.out.println(sare.search(arr));

	}

}
