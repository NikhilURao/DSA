/*
 * Hamming Distance

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, return the Hamming distance between them.

 

Example 1:

Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
The above arrows point to positions where the corresponding bits are different.
Example 2:

Input: x = 3, y = 1
Output: 1
 

Constraints:

0 <= x, y <= 231 - 1
 */

package com.NumberSysAndBitManipulation;

public class HammingDistance {

	  public static int findHammingDistance(int x, int y) {
		    
		  int xor = x ^ y;
		  int hammingDistance = 0;
		  
		  while (xor != 0) {
			  if ((xor & 1) == 1) {
				  hammingDistance += 1;
			  }
			  xor = xor >> 1;
		    }
		  
		  return hammingDistance;
		  }
	  
	public static void main(String[] args) {
		
		System.out.println(findHammingDistance(1, 4));
		
	}

}
