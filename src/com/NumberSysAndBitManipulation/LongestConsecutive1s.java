/*
 * Longest Consecutive 1's
 * Given a number N. Find the length of the longest consecutive 1s in its 
 * binary representation. 

Example 1:
Input: N = 14
Output: 3
Explanation: 
Binary representation of 14 is 
1110, in which 111 is the longest 
consecutive set bits of length is 3.

Example 2:
Input: N = 222
Output: 4
Explanation: 
Binary representation of 222 is 
11011110, in which 1111 is the 
longest consecutive set bits of length 4. 

 */

package com.NumberSysAndBitManipulation;
/*
 * Solution: AND a bit sequence with a shifted version of itself, 
 * we're effectively removing the trailing 1 from every sequence of 
 * consecutive 1s.
 * 
 * For N=222
 * 
 * 					128 64 32 16 8 4 2 1
 *                 ( 1  1  0  1  1 1 1 0 ) -> x in binary
 *     overflow<-1 ( 1  0  1  1  1 1 0 0 ) -> x << 1 ->x ls 1
 *------------------------------------------------------
 *                 ( 1  0  0  1  1 1 0 0) -> x & (x<<1) compare with x. operation x = (x & (x << 1)) reduces length of every sequence of 1s by one in binary representation of x. If we keep doing this operation in a loop, we end up with x = 0. The number of iterations required to reach 0 is actually length of the longest consecutive sequence of 1s. 
 *	    overflow<-1( 0  0  1  1  1 0 0 0) -> x << 1
 *------------------------------------------------------
 *                 ( 0  0  0  1  1 0 0 0) -> x & (x<<1)
 *      overflow<-0( 0  0  1  1  0 0 0 0) -> x << 1
 *------------------------------------------------------
 *                 ( 0  0  0  1  0 0 0 0) -> x & (x<<1)
 *      overflow<-0( 0  0  1  0  0 0 0 0) -> x << 1
 *------------------------------------------------------
 *                 ( 0  0  0  0  0 0 0 0) -> x & (x<<1)      
 *      
 * So, no of iterations taken for the number to be 0 is equal 
 * to the length of the longest consecutive 1s in the number.
 * 
 * TC => O(k) k being the length of the longest consecutive 1s in the number.
 * SC => O(1)
 * 
 */

import java.util.Scanner;

public class LongestConsecutive1s {
    public int maxConsecutiveOnes(int N) {
    	int count=0;
    	while (N>0) {
    		N = (N & (N<<1));//  reduces length of every sequence of 1s by one in binary representation of N
    		count++;
    	}
    	return count;
        
    }

	public static void main(String[] args) {
		LongestConsecutive1s l = new LongestConsecutive1s();
		System.out.println(l.maxConsecutiveOnes(222));

	}

}
