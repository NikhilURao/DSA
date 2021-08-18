package com.recursion;

public class StringPalindrome {
	static void IsStringPalindrome(String seq) {
		int len = seq.length();
		if (len == 1 || len ==0) {
			System.out.println("Palindrome");
		}
		else if (seq.charAt(0) == seq.charAt(len-1)) {
			//seq = seq.substring(0,len-1).substring(1);
			IsStringPalindrome(seq.substring(1,seq.length()-1));
			
		}
		else System.out.println("Not a Palindrome");
			
	}


	public static void main(String[] args) {
		IsStringPalindrome("rotor");
	}
}
	
