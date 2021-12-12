/*
 * SIXLETS
Problem Description

Given a array of integers A of size N and an integer B.

Return number of non-empty subsequences of A of size B having sum <= 1000.



Problem Constraints
1 <= N <= 20

1 <= A[i] <= 1000

1 <= B <= N



Input Format
The first argument given is the integer array A.

The second argument given is the integer B.



Output Format
Return number of subsequences of A of size B having sum <= 1000.



Example Input
Input 1:

    A = [1, 2, 8]
    B = 2
Input 2:

    A = [5, 17, 1000, 11]
    B = 4


Example Output
Output 1:

3
Output 2:

0


Example Explanation
Explanation 1:

 {1, 2}, {1, 8}, {2, 8}
Explanation 1:

 No valid subsequence
 */
package com.recursion;

import java.util.ArrayList;

import javax.annotation.Generated;

public class Sixlets {
	
    public static int solve(int[] A, int B) {
    	return countAllSubsequences(A, B, 0, 0, 0);

    }
    
    public static int countAllSubsequences(int [] A, int B, int sum, int count, int index) {
    	if (sum >= 1000) return 0;
    	if (count >= B) return 1;
    	if (index == A.length) return 0;
    	
    	// include + exclude
    	return countAllSubsequences(A, B, sum + A[index], count+1, index+1) +
    	countAllSubsequences(A, B, sum, count, index+1);
    	
    }
    
    // prints all subsequences of an array of size 'N'. Number of subsequences of an array of size 'N' is 2^N.
    public static void printAllSubsequences(int [] A, ArrayList<Integer> subsequences, int index) {
    	System.out.println(subsequences);
    	if (index == A.length) {
    		return;
    	}
    	subsequences.add(A[index]);
    	printAllSubsequences(A, subsequences, index+1);
    	subsequences.remove(subsequences.size() - 1);
    	printAllSubsequences(A, subsequences, index+1);
    	
    }

	public static void main(String[] args) {
		System.out.println(solve(new int [] {1,2,8}, 2));
		// ArrayList<Integer> sub = new ArrayList<Integer>();
		// printAllSubsequences(new int[] {1,2,4}, sub,0);

	}

}
