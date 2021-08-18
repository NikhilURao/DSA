/*
 * Sort the Unsorted Array
Problem Description

You are given an integer array A having N integers.

You have to find the minimum length subarray A[l..r] such that sorting this subarray makes the whole array sorted.



Problem Constraints
1 <= N <= 105

-109 <= A[i] <= 109



Input Format
First and only argument is an integer array A.



Output Format
Return an integer denoting the minimum length.



Example Input
Input 1:

 A = [0, 1, 15, 25, 6, 7, 30, 40, 50] 
Input 2:

 A = [10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60] 


Example Output
Output 1:

 4 
Output 2:

 6 


Example Explanation
Explanation 1:

 The smallest subarray to be sorted to make the whole array sorted =  A[3..6] i.e, subarray lying between positions 3 and 6. 
Explanation 2:

 The smallest subarray to be sorted to make the whole array sorted =  A[4..9] i.e, subarray lying between positions 4 and 9. 
 */
package com.array;

import java.util.*;

public class SortUnsortedArray {
	
    public static void solve(ArrayList<Integer> A) {
        ArrayList<Integer> sortedA = new ArrayList<Integer>(Collections.nCopies(A.size(),0));
        Collections.copy(sortedA, A);
        Collections.sort(sortedA);
        if (sortedA.equals(A))
        	System.out.print(0+" start index "+0+" end index "+0);
        else {
            int l=0;
            int r=sortedA.size()-1;
            while (l<=r){
                if (A.get(l)!=sortedA.get(l))
                    break;
                l++;
            }
            while (r>=0){
                if (A.get(r)!=sortedA.get(r))
                    break;
                r--;
            }
            System.out.print(r-l+1+" start index "+l+" end index "+r);
            //System.out.print(r-l+1+" "+ l+" "+r);
        }

    }

	public static void main(String[] args) {
		solve(new ArrayList<Integer>(Arrays.asList(-146316343, 179840175, 760528516)));

	}

}
