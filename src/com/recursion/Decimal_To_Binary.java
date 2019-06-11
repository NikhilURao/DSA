package com.recursion;

public class Decimal_To_Binary {
	
	static void DecToBin(int n) {
		if (n>0) {
			DecToBin(n/2);
			System.out.print(n%2);
		}
		
	}
	

	public static void main(String[] args) {
		DecToBin(10);
/*	Iterative Approach	
 		int n=10;
		while (n>0) {
			System.out.print(n%2);
			n=n/2;
			}
*/		

	}

}
