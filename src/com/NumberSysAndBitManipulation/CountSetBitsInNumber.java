/*
 * Write a function that takes an unsigned integer and returns the number
 *  of  1 bits it has.
Example:

The 32-bit integer 11 has binary representation

00000000000000000000000000001011
so the function should return 3.
 */
package com.NumberSysAndBitManipulation;

public class CountSetBitsInNumber {

	public int numSetBits(long a) {
	    
	   	int count = 0;
		while(a > 0) {
			
			if((a & 1) == 1) {// a & 1 == 1 if lsb is 1
			
				count = count+1;
			}
		  a = a >> 1; // right shift LSB by 1 to overflow LSB
		}		
		return count;
	}
	
	public int numSetBits1(long a) {
        int count=0;
        while (a>0){
            count++;
            a = a & (a-1); //(x & (x - 1)) will unset the last set bit in x (which is why x&(x-1) is 0 for powers of 2).
        }

        return count;
	}
	public static void main(String[] args) {
		CountSetBitsInNumber count = new CountSetBitsInNumber();
		System.out.println(count.numSetBits(7));
		System.out.println(count.numSetBits1(7));

	}

}
