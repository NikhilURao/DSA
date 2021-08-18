/*
 * Anagram Substring Search (Or Search for all permutations)
 * Permutations of A in B
Problem Description

You are given two strings A and B of size N and M respectively.

You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only lowercase letters.



Problem Constraints
1 <= N < M <= 105



Input Format
Given two argument, A and B of type String.



Output Format
Return a single Integer, i.e number of permutations of A present in B as a substring.



Example Input
Input 1:

 A = "abc"
 B = "abcbacabc"
Input 2:

 A = "aca"
 B = "acaa"


Example Output
Output 1:

 5
Output 2:

 2


Example Explanation
Explanation 1:

 Permutations of A that are present in B as substring are:
    1. abc
    2. cba
    3. bac
    4. cab
    5. abc
    So ans is 5.
Explanation 2:

 Permutations of A that are present in B as substring are:
    1. aca
    2. caa 

 */
package com.hashing;

import java.util.HashMap;

public class PermutationsOfAInB {
	
    public static int countAllPermutationsOfAInB(String A, String B) {
        int count=0;
        // Amap to hash String A - Entries of characters in A to Amap 
        HashMap<Character, Integer> Amap = new HashMap<Character, Integer>(A.length());
        
        for (int i=0; i<A.length(); i++){
            if (!Amap.containsKey(A.charAt(i))){
                Amap.put(A.charAt(i),1);
                } 
            else {
            Amap.put(A.charAt(i),Amap.get(A.charAt(i))+1);
            }
        }
        int j=0; // 1st window  
        HashMap<Character, Integer> Bmap = new HashMap<Character, Integer>(B.length());
        while (j<A.length()) {
            if (!Bmap.containsKey(B.charAt(j))){
                Bmap.put(B.charAt(j),1);
                } 
            else {
            Bmap.put(B.charAt(j),Bmap.get(B.charAt(j))+1);
            }
            j++;
        }
        if (Bmap.equals(Amap)) {
        	count++;
        }
        for (int start=1; start<=B.length()-A.length();start++) {

        	int end = start+A.length()-1;
        	if (Bmap.get(B.charAt(start-1))==1) Bmap.remove(B.charAt(start-1));
        	else Bmap.put(B.charAt(start-1),Bmap.get(B.charAt(start-1))-1);
        	if (!Bmap.containsKey(B.charAt(end))) Bmap.put(B.charAt(end),1);
        	else {Bmap.put(B.charAt(end),Bmap.get(B.charAt(end))+1);}
            if (Bmap.equals(Amap)) {
            	count++;
            }
        	
        }

        
        
		return count;
}

	public static void main(String[] args) {
		System.out.println(countAllPermutationsOfAInB("q", "qedq"));
		String ans = "";
		ans = 1==1? ans : ans+"ans";

	}

}
