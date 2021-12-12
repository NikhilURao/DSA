/*
 * Given a sorted array where every element appears twice except 1 element.
 * Find that element.
 */
package com.Algorithms.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class SortedArray2RepeatingExcept1 {
	
	public int search(int[]arr) {
		if (arr.length/2 == 0) // length of the array has to be odd since the array is sorted and each element in repeated twice except for one element
			return -1;
		else {
			int left=0; int right=arr.length-1;
			
			while (left <= right) {
				int mid = (int) Math.floor((left+right)/2);
				
				if ((mid+1>=arr.length || arr[mid]!=arr[mid+1]) && (mid-1<0 || arr[mid]!=arr[mid-1])) {
					return arr[mid];
			}
				else { // find the first occurrence of the repeating element
					if ((arr[mid]==arr[mid-1] || mid-1<0) && (arr[mid]!=arr[mid+1] || mid+1>=arr.length)) // if mid is not the first occurrence then mid--
						mid = mid -1;
					if (mid%2!=0) // first occurrence in odd index -> move left && ((arr.length-1) - (mid+1))%2==0
						right = mid-1;
					else if (mid%2 == 0) // first occurrence in even index -> move right 
						left = mid+2;
			}
			}
			
			return -1;
		}
	}
	public int solve(ArrayList<Integer> A) {
        int left=0; int right=A.size()-1;
		while (left <= right) {
		    int mid = left + ((right-left)/2);
				
			if ((mid+1>=A.size() || A.get(mid)!=A.get(mid+1)) && (mid-1<0 || A.get(mid)!=A.get(mid-1))) {
				return A.get(mid);
			}

			else { // find the first occurrence of the repeating element
				if ((A.get(mid)==A.get(mid-1) || mid-1<0) && (A.get(mid)!=A.get(mid+1) || mid+1>=A.size())) // if mid is not the first occurrence then mid--
					mid = mid -1;
				if (mid%2!=0) // first occurrence in odd index -> move left && ((arr.length-1) - (mid+1))%2==0
					right = mid-1;
				else if (mid%2 == 0) // first occurrence in even index -> move right 
					left = mid+2;
			}
	}
	return -1;
}

	public static void main(String[] args) {
		int [] arr = {13, 13, 21, 21, 27, 50, 50, 102, 102, 108, 108, 110, 110, 117, 117, 120, 120, 123, 123, 124, 124, 132, 132, 164, 164, 166, 166, 190, 190, 200, 200, 212, 212, 217, 217, 225, 225, 238, 238, 261, 261, 276, 276, 347, 347, 348, 348, 386, 386, 394, 394, 405, 405, 426, 426, 435, 435, 474, 474, 493, 493};
		SortedArray2RepeatingExcept1 sare = new SortedArray2RepeatingExcept1();
		System.out.println(sare.search(arr));
	}

}
