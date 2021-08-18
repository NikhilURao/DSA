/*
 * Given a positive integer A, the task is to count the total number of 
 * set bits in the binary representation of all the numbers from 1 to A.
 * Problem Constraints
1 <= A <= 109

Output Format
Return an integer denoting the ( Total number of set bits in the binary representation of all the numbers from 1 to A )modulo 109 + 7.
A=3
output=4
DECIMAL    BINARY  SET BIT COUNT
    1          01        1
    2          10        1
    3          11        2
 1 + 1 + 2 = 4 
 Answer = 4 % 1000000007 = 4
 */
package com.NumberSysAndBitManipulation;

public class CountTotalSetBits {
	
	public int solve(int A) {
		if (A<=0) {
			return 0;
		}
		int x=0;
		while (((1<<(x+1)) -1) <= A) { // find max(int x) such that (2^x-1)<= A  
			x++;
		}
		
		int res=0;
		int mod = 1000000007;
		
		int numSetBits0To2raiseXminus1 = (1 << (x-1)) * x;
		int numSetBits2raiseXToAFor2raiseXbit = A - (1 << x) + 1;
		res = (res + numSetBits0To2raiseXminus1 + 
				numSetBits2raiseXToAFor2raiseXbit +
				solve (A - (1 << x)))%mod;
		res = res % mod;
		return res;
		
		
	}

	public static void main(String[] args) {
		CountTotalSetBits ctsb = new CountTotalSetBits();
		System.out.println(ctsb.solve(2));
	}

}
