/*
 * Pick from both sides!
Problem Description

Given an integer array A of size N.

You can pick B elements from either left or right end of the array A to get maximum sum.

Find and return this maximum possible sum.

NOTE: Suppose B = 4 and array A contains 10 elements then

You can pick first four elements or can pick last four elements or can pick 1 from front and 3 from back etc . you need to return the maximum possible sum of elements you can pick.


Problem Constraints
1 <= N <= 105

1 <= B <= N

-103 <= A[i] <= 103



Input Format
First argument is an integer array A.

Second argument is an integer B.



Output Format
Return an integer denoting the maximum possible sum of elements you picked.



Example Input
Input 1:

 A = [5, -2, 3 , 1, 2]
 B = 3
Input 2:

 A = [1, 2]
 B = 1


Example Output
Output 1:

 8
Output 2:

 2


Example Explanation
Explanation 1:

 Pick element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
Explanation 2:

 Pick element 2 from end as this is the maximum we can get
 */
package com.array;

import java.util.*;

public class PickFromBothSides {
    public static int getMax(ArrayList<Integer> A, int B) {
        ArrayList<Integer> prefix_sumA = new ArrayList<Integer>(Collections.nCopies(A.size(), 0));
    	int max = Integer.MIN_VALUE;
    	prefix_sumA.set(0, A.get(0));
    	for (int i=1; i<A.size(); i++) {
    		prefix_sumA.set(i, prefix_sumA.get(i-1)+A.get(i));
    	}
    	int l=B;
    	int r = 0;
    	while (l>0 && r<=B) {
    		int sum = 0;
    		if (l==B)
    			sum =  prefix_sumA.get(l-1);
    		else if (r==B)
    			sum = prefix_sumA.get(prefix_sumA.size() - 1) - prefix_sumA.get(prefix_sumA.size() - r -1);
    		else
    			sum = prefix_sumA.get(l-1) + (prefix_sumA.get(prefix_sumA.size() - 1) - prefix_sumA.get(prefix_sumA.size()-r - 1));
    		
    		max = Math.max(max, sum);
    		l--;
    		r++;	
    	}
    	
    	return max;
    }

	public static void main(String[] args) {
		System.out.println(getMax(new ArrayList<Integer>(Arrays.asList(1,3,2,4)), 4));
		

	}

}
