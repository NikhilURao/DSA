/*
 * SUBARRAY OR
Problem Description

Given an array of integers A of size N.

Value of a subarray is defined as BITWISE OR of all elements in it.

Return the sum of Value of all subarrays of A % 109 + 7.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 108



Input Format
The first argument given is the integer array A.



Output Format
Return the sum of Value of all subarrays of A % 109 + 7.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [7, 8, 9, 10]


Example Output
Output 1:

 71
Output 2:

 110


Example Explanation
Explanation 1:

 Value([1]) = 1
 Value([1, 2]) = 3
 Value([1, 2, 3]) = 3
 Value([1, 2, 3, 4]) = 7
 Value([1, 2, 3, 4, 5]) = 7
 Value([2]) = 2
 Value([2, 3]) = 3
 Value([2, 3, 4]) = 7
 Value([2, 3, 4, 5]) = 7
 Value([3]) = 3
 Value([3, 4]) = 7
 Value([3, 4, 5]) = 7
 Value([4]) = 4
 Value([4, 5]) = 5
 Value([5]) = 5
 Sum of all these values = 71
Explanation 2:

 Sum of value of all subarray is 110.

 */
package com.array;

public class SubarrayORIntegers {
	
	public static int getTotalsubarrayORvalues0s1s(int [] A) {
		int subarrayWith1ORValue = 0;
		int n = A.length;
		int totalSubarrays = (n * (n+1))/2;
		// find subarrays with all 0s
		int subarrayWithAll0s = 0; // count of subarrays with all 0s, so OR value will also be 0
		int start=0; int end=0;
		
		while (start<=end && end<n) {
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
	public static int [] convertDecimalToBin(int n, int len) {
		int [] binArray = new int [len];
		int i=0;
		while (n>0) {
			binArray[len-i-1] = n%2;
			n = n/2;
			i++;
		}
		return binArray;
	}
	public static int getTotalsubarrayORvaluesIntegers(int [] A) {
		int max = Integer.MIN_VALUE; // variable to store the max element in array
		int sum = 0; 
		// find max element in the array
		for (int i=0; i<A.length; i++) {
			max = Math.max(max, A[i]);
		}
		int m = A.length; // no of columns of 2D marix = number of elements in ip array
		int n = (int)(Math.log(max) / Math.log(2)) +1; // // no of rows of 2D marix = number of bits required to express the maximum element in binary form
		int [][] TwoDArray = new int [n][m];
		// build 2D matrix
		for (int i=0; i<A.length; i++) {
			int [] bin = convertDecimalToBin(A[i],n);
			for (int j=0; j<bin.length; j++) {
				TwoDArray[j][i] = bin[j];
			}
		}
		
		// for each row in 2D matrix calculate the subarray OR value of the array and mulitply it with 2^ n-i
		for(int i=0; i<n; i++) {
			sum += getTotalsubarrayORvalues0s1s(TwoDArray[i]) * Math.pow(2, n-i-1);
		}
		
		return sum;
		
		
	}

	public static void main(String[] args) {
		System.out.println(getTotalsubarrayORvaluesIntegers(new int [] {1, 2, 3, 4, 5}));
		/*
		int [] arr = convertDecimalToBin(2);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}*/
	}

}
