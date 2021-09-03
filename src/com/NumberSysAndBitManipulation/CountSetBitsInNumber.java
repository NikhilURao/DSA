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
	/* 1. Find if the LSB of the number is 1 by (num & 1) == 1 count++
	 * 2. RS num by one time so that the LSB is underflowed/ flushed.
	 * 3. continue till num > 0
	 * 
	 *  count = 0
	 *  a = 13 (1101)
	 *  1) 	a = 1101
	 *  	1101 & 0001 = 1 => count = 1
	 *  	a = 1101 >> 1 => 110 | 1=> underflow 1 in LSB
	 *  
	 *  2)	Now a = 110
	 *  	110 & 001 = 0 != 1 => count = 1
	 *  	a = 110 >> 1 => 11 | 0=> underflow 0 in LSB
	 *  
	 *  3) 	Now a = 11
	 *  	11 & 01 = 1 => count = 2
	 *  	a = 11 >> 1 => 1 | 1=> underflow 1 in LSB
	 *  
	 *  4)	Now a = 1
	 *  	1 & 1 = 1 => count = 3
	 *  	1 >> 1 = 0 | 1=> underflow 1 in LSB
	 *  
	 *  5) a == 0 => a <= 0 exit
	 *  
	 */
	public int numSetBits(long a) {
	    
	   	int count = 0;
		while(a > 0) {
			
			if((a & 1) == 1) {// a & 1 == 1 if lsb is 1
			
				count = count+1;
			}
		  a = a >> 1; // right shift LSB by 1 to underflow 1 in LSB
		}		
		return count;
	}
	
	/*
	 *  Observation: num & (num-1) will always unset the last set bit in the num
	 */
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
