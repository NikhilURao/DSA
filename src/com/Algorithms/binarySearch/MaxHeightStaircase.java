/*
 * Maximum height of staircase
Problem Description

Given an integer A representing the number of square blocks. The height of each square block is 1. The task is to create a staircase of max height using these blocks.

The first stair would require only one block, the second stair would require two blocks and so on.

Find and return the maximum height of the staircase.



Problem Constraints
0 <= A <= 109


Input Format
The only argument given is integer A.



Output Format
Return the maximum height of the staircase using these blocks.



Example Input
Input 1:

 A = 10
Input 2:

 20


Example Output
Output 1:

 4
Output 2:

 5
 */
package com.Algorithms.binarySearch;

public class MaxHeightStaircase {
    public static int findMaxHeightStaircase(int A) {
        int low = 0;
        int high = Integer.MAX_VALUE; 
        int ans = 0;
        while(low <= high){
            int mid = (high - low) / 2 + low;
            
            if ((long)mid * (mid + 1) / 2 == A)
            	return mid;
            
            else if((long)mid * (mid + 1) / 2 > A)
                high = mid - 1;   
            else{
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }

	public static void main(String[] args) {
		System.out.println(findMaxHeightStaircase(7837));

	}

}
