/*
 * Aggressive cows
Problem Description

Farmer John has built a new long barn, with N stalls. Given an array of integers A of size N where each element 
of the array represents the location of the stall, and an integer B which represent the number of cows.

His cows don't like this barn layout and become aggressive towards each other once put into a stall. 
To prevent the cows from hurting each other, John wants to assign the cows to the stalls, 
such that the minimum distance between any two of them is as large as possible. 
What is the largest minimum distance?



Problem Constraints
2 <= N <= 100000
0 <= A[i] <= 109
2 <= B <= N



Input Format
The first argument given is the integer array A.
The second argument given is the integer B.



Output Format
Return the largest minimum distance possible among the cows.

Example 1:
N=6 C=4
stalls = 0 3 4 7 10 9

Sample Output 1: 3

N=6 C=3
0 4 3 7 10 9

Sample Output 2 :4

Explanation:
In the first test case, the largest minimum distance will be 3 when 4 cows are placed at positions {0, 3, 7, 10}.

In the second test case, the largest minimum distance will be 4 when 3 cows are placed at positions {0, 4, 10}.

Solution:

We'll be doing the binary search for finding the best possible maximum difference.

Since the maximum difference range between 0 to max of array.
If we sort the array then binary search starts with l=0 and r=A[n-1] and weve to find the maximum distance.
For mid in binary search, we will check whether there are B stalls such that the minimum distance is greater 
than equal to mid.
Finally store the maximum value we can get.

Algorithm: 
1. Sort the array with the location of the stalls/barns in ascending order as it may not be in order
2. The possible answer i.e. largest minimum distance ranges between 1 and 
(max element in arr - min element in arr)
3. So search space is between 1 and max - min. So low = 1 and high = A[len-1] - A[0].
4. Find mid
5. Check if we can place 'k' cows in array list stalls in any conf with minimum distance between any 2 cows 
being mid
if yes then, save mid in res and check if any larger distance can be achieved by low = mid+1. 
Discarding all values lower than mid. search space is now mid+1 to high
if no then, discard all distances higher than mid and reduce the search space to low to mid-1 -> high = mid-1

TC => O(nlogn) <Sorting> + O(nlogn) <Processing>
SC => O(1)
 */

package com.Algorithms.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AggressiveCows {
	
	 public static int aggressiveCows(ArrayList<Integer> stalls, int k) {
	        // the location of stalls may not be given in order
	        Collections.sort(stalls);
	        int low = 0; // minimum distance possible
	        int high = stalls.get(stalls.size()-1) - stalls.get(0); // maximum distance possible
	        int res = high; // to store intermediate results
	        // return max - min if there are only 2 cows to be placed in the array. They will be placed in the extreme ends of the array
	        if (k == 2)
	            return res;
	        else{
	            while (low <= high){
	                int mid = low + ((high - low)/2);
	                // check if we can place 'k' cows in arraylist stalls in any conf with minimum distance between any 2 cows being mid
	                int lastCowsLoc = stalls.get(0), remainingCows = k-1;
	                for (int i=1; i<stalls.size() && remainingCows>0;i++){
	                    if (stalls.get(i) - lastCowsLoc >= mid){
	                        remainingCows --;
	                        lastCowsLoc = stalls.get(i);
	                    }
	                    if (remainingCows == 0) { // possible to place-> save mid in res and check if any larger distance can be achieved by low = mid+1. Discarding all values lower than mid. search space is now mid+1 to high
		                    res = mid;
		                    low = mid+1;
		                    break;
		                }
	                }
	                if (remainingCows != 0) // not possible to place, discard all distances higher than mid and reduce the search space to low to mid-1 -> high = mid-1
	                    high = mid-1;
	            }
	            return res;
	        }
	    }

	public static void main(String[] args) {
		System.out.println(aggressiveCows(new ArrayList<Integer>(Arrays.asList(0,4,3,7,10,9)), 3));
		
	}
}
