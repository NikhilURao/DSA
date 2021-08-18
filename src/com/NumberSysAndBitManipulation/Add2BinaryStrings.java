/*
 * Given two binary strings, return their sum (also a binary string).

Example:

a = "100"

b = "11"
Return a + b = "111".
 */
package com.NumberSysAndBitManipulation;

public class Add2BinaryStrings {
	
	public String BinSum(String a, String b) {
		
		int len = Math.max(a.length(),b.length());
		boolean sum, carry = false, total;
		String res = "";
		for (int i=1; i<=len; i++) {
			
			boolean abit =  (i<=a.length() && a.charAt(a.length()-i)=='1')? true : false;
			boolean bbit =  (i<=b.length() && b.charAt(b.length()-i)=='1')? true : false;
			
			sum = (!abit && bbit) || (abit && !bbit);
			total = (!sum && carry) || (sum && !carry);
			carry = (carry && abit)|| (carry && bbit) || (abit && bbit);
			res =  ((total)? "1" : "0")+res;
		}
		
		return ((carry)? "1" : "")+res;
	}

	public static void main(String[] args) {
		/*
		 * A : "1010110111001101101000"
B : "1000011011000000111100110"
		 */
		String a = "1";
		String b = "1";
		Add2BinaryStrings binaddition = new Add2BinaryStrings();
		System.out.println(binaddition.BinSum(a, b));
        int A=2000000000;

	}

}
