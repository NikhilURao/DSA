/*
 * Subarray OR 0s and 1s 
 * Given an array A of size n containing only 0s and 1s. Value of a 
 * subarray is the bitwise OR value of all the elements in the subarray.
 * Find the sum of total OR value of all the subarrays of A.
 */

package com.array;

public class SubarrayOR0s1s {
	
	public static int getTotalsubarrayORvalues(int [] A) {
		int subarrayWith1ORValue = 0;
		int n = A.length;
		int totalSubarrays = (n * (n+1))/2;
		// find subarrays with all 0s
		int subarrayWithAll0s = 0; // count of subarrays with all 0s, so OR value will also be 0
		int start=0; int end=0;
		
		while (start<=end && end<n-1) {
			if (A[start]==0) {
				while (end<n-1 && A[end+1]==0) {
					end++;
				}
				subarrayWithAll0s += ((end - start + 1) * (end - start + 2))/2;
				start = end;
			}
			start++;
			end++;
		}
		// subarrays with OR value as 1 = total subarrays that can be formed - subarrays with all 0s(subarrays with OR value as 0)
		subarrayWith1ORValue = totalSubarrays - subarrayWithAll0s;
		
		return subarrayWith1ORValue;
	}

	public static void main(String[] args) {
		System.out.println(getTotalsubarrayORvalues(new int [] {1,0,1}));//1,0,0,1,1,0,0,0

	}

}
