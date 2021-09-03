/*
 * Delete one
Problem Description

Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.

Find the maximum value of GCD.



Problem Constraints
2 <= N <= 105
1 <= A[i] <= 109



Input Format
First argument is an integer array A.



Output Format
Return an integer denoting the maximum value of GCD.



Example Input
Input 1:

 A = [12, 15, 18]
Input 2:

 A = [5, 15, 30]


Example Output
Output 1:

 6
Output 2:

 15


Example Explanation
Explanation 1:

 
 If you delete 12, gcd will be 3.
 If you delete 15, gcd will be 6.
 If you delete 18, gcd will 3.
 Maximum vallue of gcd is 6.
Explanation 2:

 If you delete 5, gcd will be 15.
 If you delete 15, gcd will be 5.
 If you delete 30, gcd will be 5.
 * 
 */
package com.Math.GCD;

public class DeleteOneMaximiseGCD {
	
    public static int MaximiseGCDByDeletingOneElement(int[] A) {
    	
    	// find cumulative prefix GCD array of A
    	int [] prefixGCD = new int [A.length];
    	prefixGCD[0] = A[0];
    	for (int i=1; i<A.length; i++) {
    		int temp = getGCD(prefixGCD[i-1],A[i]);
    		prefixGCD[i] = temp;
    	}
    	
    	// find cumulative suffix GCD array of A
    	int [] suffixGCD = new int [A.length];
    	suffixGCD[A.length - 1] = A[A.length - 1];
    	for (int i=A.length - 2; i>=0; i--) {
    		int temp = getGCD(suffixGCD[i+1],A[i]);
    		suffixGCD[i] = temp;
    	}
    	
    	// Then,for each index, i:1 to N calculate 
    	// getGCD(prefix[i-1],suffix[i+1]) and return the maximum among all.
    	int maxGCD = 1;
    	for (int i=0; i<A.length; i++) {
    		if (i==0)
    			maxGCD = Math.max(maxGCD, suffixGCD[i+1]);
    		else if(i==A.length-1)
    			maxGCD = Math.max(maxGCD, prefixGCD[i-1]);
    		else
    			maxGCD = Math.max(maxGCD, getGCD(prefixGCD[i-1], suffixGCD[i+1]));
    	}
    	return maxGCD;
    }
    
    // function to find gcd of 2 numbers using Euclidean Algorithm
    public static int getGCD(int a, int b) {
    	if (a==0)
    		return b;
    	else if (b==0)
    		return a;
    	else return getGCD(b, a%b);
    }

	public static void main(String[] args) {
		System.out.println(MaximiseGCDByDeletingOneElement(new int [] {50,1,5,10,20}));
	}

}
