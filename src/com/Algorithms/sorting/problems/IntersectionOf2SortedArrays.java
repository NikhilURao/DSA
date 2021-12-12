/*
 * Intersection of Two Sorted Arrays
 * 
 * The intersection of two arrays contains the elements common to both the arrays. The intersection should not count duplicate elements.
Given two sorted arrays arr1[] and arr2[] of sizes N and M respectively. Find their intersection

 

Example 1:u

Input: 
N = 4, arr1[] = {1, 2, 3, 4}  
M = 5, arr2 [] = {2, 4, 6, 7, 8}
Output: 2 4
Explanation: 2 and 4 are only common 
elements in both the arrays.
 

Example 2:

Input: 
N = 5, arr1[] = {1, 2, 2, 3, 4}
M = 6, arr2[] = {2, 2, 4, 6, 7, 8}
Output: 2 4
Explanation: 2 and 4 are the only 
common elements.
 

Example 3:

Input:
N = 2, arr1[] = {1, 2}
M = 2, arr2[] = {3, 4}
Output: -1
Explanation: No common elements.

 

Your Task:
You do not need to read input or print anything. Complete the function printIntersection() that takes arr1,arr2,  N and M as input parameters and return a list of integers containing the intersection of two arrays. If the intersection is empty then then list should contain -1.


Expected Time Complexity: O(N + M).
Expected Auxiliary Space: O(min(N,M)).

 

Constraints:
1 <= N, M <= 105
1 <= arr[i], brr[i] <= 106

 
 */
package com.Algorithms.sorting.problems;

import java.util.ArrayList;

public class IntersectionOf2SortedArrays {
    public static ArrayList<Integer> printIntersection(int arr1[], int arr2[]) {
        ArrayList<Integer> intersectionArr = new ArrayList<Integer>();
        int n = arr1.length;
        int m = arr2.length;
        int i = 0;
        int j = 0;
        
        while (i<n && j<m){
            if (arr1[i] < arr2[j] || (i!=n-1 && arr1[i] == arr1[i+1])){
                i++;
            }
            else if (arr1[i] == arr2[j]){
                intersectionArr.add(arr1[i]);
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        
        return intersectionArr;
    }

	public static void main(String[] args) {
		printIntersection(new int [] {1, 2, 2, 2, 3, 4}, new int [] {2, 4, 4, 4, 6, 7, 8})
		.forEach(element -> System.out.print(element+" "));

	}

}
