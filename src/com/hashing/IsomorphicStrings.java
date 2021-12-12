/*
 * Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
 

Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.
 */
package com.hashing;

import java.util.HashMap;
import java.util.Scanner;

public class IsomorphicStrings {
	
	public boolean isIsomorphic(String s1, String s2) {
		HashMap<Character, Character> charMapping = new HashMap<Character, Character>();
		HashMap<Character, Boolean> visitedChar = new HashMap<Character, Boolean>();
		
		for (int i=0; i<s1.length(); i++) {
			// check if character in s2 is visited or not and check if corresponding character at s1 doesn't have a mapping
			if (visitedChar.getOrDefault(s2.charAt(i), false) && charMapping.containsKey(s1.charAt(i)))
				return false;
			
			// 
			if (charMapping.containsKey(s1.charAt(i)) && s2.charAt(i) != charMapping.get(s1.charAt(i))) 
				return false;
			
			// add mapping
			else
				charMapping.put(s1.charAt(i), s2.charAt(i));
			
		}
		return true;
	}

	public static void main(String[] args) {
		    Scanner sc = new Scanner(System.in);
		    long[] p = new long[sc.nextInt()];
		    for (int q = 0; q < p.length; q++) {
		      p[q] = sc.nextLong();
		    }
		    for (long l : p) {
		      long q = l;
		      if (q == 1) q = 2;
		      long a = (q / 2);
		      for (long i = 2; i < q; i++) {
		        a += i;
		      }
		      System.out.println(a);
		    }

}
}
