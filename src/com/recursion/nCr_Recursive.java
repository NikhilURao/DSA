package com.recursion;

public class nCr_Recursive {
	
	static int nCr_Rec (int n,int r) {
		
		if (n==r) return 1;
		else if (r==0) return 1;
		else return nCr_Rec(n-1, r) + nCr_Rec(n-1, r-1); 
		
	}
public static void main (String[] args) {
	int ncr = nCr_Rec(8,3);
	System.out.println(ncr);
}
}
