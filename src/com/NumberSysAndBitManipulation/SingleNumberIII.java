/* Single Number III
 * 
 * Problem Description

Given an array of numbers A , in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Note: Output array must be sorted.



Problem Constraints
2 <= |A| <= 100000
1 <= A[i] <= 109



Input Format
First argument is an array of integer of size N.



Output Format
Return an array of two integers that appear only once.



Example Input
Input 1:

A = [1, 2, 3, 1, 2, 4]
Input 2:

A = [1, 2]


Example Output
Output 1:

[3, 4]
Output 2:

[1, 2]


Example Explanation
Explanation 1:

 3 and 4 appear only once.
Explanation 2:

 1 and 2 appear only once.
 

Solution: 

If extra memory is used, we can directly store the count and find the 
elements which occur only once.

To solve without extra memory
We can use the xor operation , as the xor of two elements gives 0. 
Take the xor of all the elements of the array. Elements
which occurs twice will not contribute anything to the xor value.

Suppose that the ith bit is set in the xor value which means that exactly one 
of the two required number has that bit set.

If we the divide the array elements int two groups: 
one group contain all elements which have the ith bit set and 
the other group conatins elements which have 0 at the ith bit.

Each group contains one of the two required numbers and for other numbers 
both of their occurrences will be in the same group.

Now, Xor of elements in the first group gives a number which occurs exactly 
once.
Xor of elements in the second group gives another number which occurs exactly 
once.

TC => O(n)
SC => O(1)
 */
package com.NumberSysAndBitManipulation;

public class SingleNumberIII {
	
    public static int[] solve(int[] A) {
    	
    	int [] res = new int [2];
    	
    	// find the XOR value of all the elements in the array
    	int xorA = A[0];
    	for (int i=1; i<A.length; i++) {
    		xorA = xorA ^ A[i];
    	}
    	
    	// check the bit in the xorA where the bit is set or equal to 1
    	int bit; // var to store the bit that is set in xorA
    	for (bit=0; bit<32; bit++) {
    		if ((xorA & (1<<bit)) > 0)  // check if the bit position is 1
    			break;
    	}
    	
    	// bit in xorA is set only if the 2 culprit numbers have different bit at this bit position
    	// iterate over the numbers in the array and divide the numbers into
    	// 2 different groups based on the bit value at ith position.
    	// ith bit is set => XOR1 group
    	// ith bit is not set => XOR2 group
    	// Once we divide the numbers into 2 groups, the 2 culprit numbers don't
    	// belong to the same group then, the problem essentially
    	// translates to finding a number that appears only once in an array of
    	// numbers where each number appears twice. To find a number appearing
    	// once in a group of numbers that appear twice, we need to xor the list 
    	// of all the numbers, the xor value will be equal to the number that is 
    	// appearing only once
    	int xor1 = 0; int xor2 = 0;
    	for (int j=0; j<A.length; j++) {
    		if ((A[j] & (1<<bit)) > 0) {
    			xor1 = xor1 ^ A[j];
    		}
    		else {
    			xor2 = xor2 ^ A[j];
    		}
    	}
    	
    	// sorted res
    	if (xor1 < xor2) {
    		res[0] = xor1;
    		res[1] = xor2;
    	}
    	else {
    		res[0] = xor2;
    		res[1] = xor1;
    	}
    	
    	return res;
    	
    	
    
    }

	public static void main(String[] args) {
		int [] ans = solve(new int []{186, 256, 102, 377, 186, 377});
		System.out.println(ans[0]+" "+ans[1]);
		

	}

}
