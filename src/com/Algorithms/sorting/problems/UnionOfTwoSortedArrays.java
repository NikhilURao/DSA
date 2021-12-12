/*
 * Union of Two Sorted Arrays
 * 
 * Union of two arrays can be defined as the common and distinct elements in the two arrays.
Given two sorted arrays of size n and m respectively, find their union.


Example 1:

Input: 
n = 5, arr1[] = {1, 2, 3, 4, 5}  
m = 3, arr2 [] = {1, 2, 3}
Output: 1 2 3 4 5
Explanation: Distinct elements including 
both the arrays are: 1 2 3 4 5.
 

Example 2:

Input: 
n = 5, arr1[] = {2, 2, 3, 4, 5}  
m = 5, arr2[] = {1, 1, 2, 3, 4}
Output: 1 2 3 4 5
Explanation: Distinct elements including 
both the arrays are: 1 2 3 4 5.
 

Example 3:

Input:
n = 5, arr1[] = {1, 1, 1, 1, 1}
m = 5, arr2[] = {2, 2, 2, 2, 2}
Output: 1 2
Explanation: Distinct elements including 
both the arrays are: 1 2.

Your Task: 
You do not need to read input or print anything. Complete the function findUnion() that takes two arrays arr1[], arr2[], and their size n and m as input parameters and returns a list containing the union of the two arrays. 
 

Expected Time Complexity: O(n+m).
Expected Auxiliary Space: O(n+m).
 

Constraints:
1 <= n, m <= 105
1 <= arr[i], brr[i] <= 106
 */
package com.Algorithms.sorting.problems;

import java.util.ArrayList;

public class UnionOfTwoSortedArrays {

	public static ArrayList<Integer> findUnion(int arr1[], int arr2[]){
        ArrayList<Integer> unionArr = new ArrayList<Integer>();
        int n = arr1.length;
        int m = arr2.length;
        int i = 0;
        int j = 0;
        
        while (i<n && j<m){
            if (i!=n-1 && arr1[i] == arr1[i+1]){
                i++;
                continue;
            }
            if (j!=m-1 && arr2[j] == arr2[j+1]){
                j++;
                continue;
            }
            else if (arr1[i] < arr2[j]){
                unionArr.add(arr1[i]);
                i++;
            }
            else if (arr2[j] < arr1[i]){
                unionArr.add(arr2[j]);
                j++;
            }
            else {
                unionArr.add(arr1[i]);
                i++;
                j++;
            }
        }
        while (i<n){
            if (i!=n-1 && arr1[i]==arr1[i+1]){
                i++;
                continue;
                }
            else {
            	unionArr.add(arr1[i]);
            	i++;
            }
        }
        
        while (j<m){
            if (j!=m-1 && arr2[j]==arr2[j+1]){
                j++;
                continue;
                }
            else {
            	unionArr.add(arr2[j]);
            	j++;
            
            }
        }
        
        return unionArr;
        
    }
	public static void main(String[] args) {
		findUnion(new int [] {2,4,6,7,9,13,14,14,14,17,22,33,36,37,46}, new int [] {1,9,12,17,22,23,24,30,32,33,36,45,45,47,47})
		.forEach(element -> System.out.print(element+" "));

	}

}
