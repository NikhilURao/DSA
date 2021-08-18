/*
 * Check whether K-th bit is set or not 
 * Given a number N and a bit number K, check if Kth bit of N is set or not. 
 * A bit is called set if it is 1. Position of set bit '1' should be 
 * indexed starting with 0 from LSB side in binary representation of the
 * number.
 
Example 1:
Input: N = 4, K = 0
Output: No
Explanation: Binary representation of 4 is 100, 
in which 0th bit from LSB is not set. 
So, return false.
Example 2:
Input: N = 4, K = 2
Output: Yes
Explanation: Binary representation of 4 is 100, 
in which 2nd bit from LSB is set. 
So, return true.
 */
package com.NumberSysAndBitManipulation;

public class CheckKthBitSetOrNot {
    static boolean checkKthBit(int n, int k)
    {
        int binlr1 = 1 << k; // Left shift 1 by k to create a number that has only set bit as kth bit.
        if ((n & binlr1) > 0) { // If bitwise AND of n and binlr1 is non-zero, then kth bit is SET else kth bit is NOT SET.
        	return true;
        }
        else
        return false;
    }

	public static void main(String[] args) {
		CheckKthBitSetOrNot check = new CheckKthBitSetOrNot();
		System.out.println(check.checkKthBit(500, 4));
		

	}

}
