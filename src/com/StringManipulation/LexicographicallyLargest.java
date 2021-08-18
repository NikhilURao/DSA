/*
 * Lexicographically Largest
You are given a string S. You want to change it to the lexicographically largest possible string by changing some of its characters. But you can only use characters of the string T as a replacement for characters of S. Formally, find the lexicographically largest string you can form by replacing some(or none) of the characters of S by using only the characters of string T. Note: Each character of T can be used at the most once.

Constraints:

1.   1 <= Length of S and T <= 50
2.   All the alphabets of S and T are lower case (a - z)
Input: A string A containing S and T separated by "_" character. (See example below)

Output: Lexicographically largest string P that can be formed by changing some or (none) characters of S using the characters of T.

Example:

Input:

A : "abb_c"
This implies S is "abb" and T is "c".

Output:

P = "cbb"


 */
package com.StringManipulation;

import java.util.Arrays;

public class LexicographicallyLargest {
    public static String getLargest(String A) {
    	String S = A.split("_")[0];
    	String T = A.split("_")[1];
    	StringBuilder sortedT = new StringBuilder();
    	StringBuilder sortedS = new StringBuilder(S);
    	
    	
    	// sort string T alphabetically using count sort
    	int [] t_occ = new int [26];
    	Arrays.fill(t_occ, 0);
    	for (int i=0; i<T.length(); i++) {
    		t_occ[T.charAt(i) - 'a']++;
    	}
    	for (int i=t_occ.length-1; i>=0;i--) {
    		while (t_occ[i]>0) {
    			sortedT.append((char) ('a'+i));
    			t_occ[i]--;
    		}
    	}
    	
    	// replace characters of s 
    	int len = sortedT.length() < sortedS.length()? sortedT.length():sortedS.length();
    	for (int i=0; i< (sortedT.length() < sortedS.length()? sortedT.length():sortedS.length());i++) {
    		for (int j=0; j<(sortedT.length() < sortedS.length()? sortedT.length():sortedS.length()); j++) {
        		if (sortedS.charAt(j)<sortedT.charAt(0)) {
        			sortedS.setCharAt(j, sortedT.charAt(0));
        			sortedT.deleteCharAt(0);
        			
        		}
    		}

    	}
    	
    	
    	
    	return sortedS.toString();
    }

	public static void main(String[] args) {
		System.out.println(getLargest("abc_jn"));
		

	}

}
