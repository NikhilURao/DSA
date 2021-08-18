/*
 * Is Dictionary?
Problem Description

In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given an array of words A of size N written in the alien language, and the order of the alphabet denoted by string B of size 26, return 1 if and only if the given words are sorted lexicographicaly in this alien language else return 0.



Problem Constraints
1 <= N, length of each word <= 105

Sum of length of all words <= 2 * 106



Input Format
First argument is a string array A of size N.

Second argument is a string B of size 26 denoting the order.



Output Format
Return 1 if and only if the given words are sorted lexicographicaly in this alien language else return 0.



Example Input
Input 1:

 A = ["hello", "scaler", "interviewbit"]
 B = "adhbcfegskjlponmirqtxwuvzy"
Input 2:

 A = ["fine", "none", "no"]
 B = "qwertyuiopasdfghjklzxcvbnm"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 The order shown in string B is: h < s < i for the given words. So return 1.
Explanation 2:

 "none" should be present after "no". Return 0.
 */
package com.hashing;

import java.util.*;

public class IsDictionary {
    public static int solve(ArrayList<String> A, String B) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(B.length());
        
        for(int i=0; i<B.length(); i++){
            map.put(B.charAt(i),i+1);
        }
        ArrayList<Integer> arr = new ArrayList<Integer>(A.size());
        for (int i=0; i<A.size(); i++){
            String str = A.get(i); int sum_char = 0;
            for (int j=0; j<str.length(); j++){
                sum_char += map.get(str.charAt(j));
            }
            arr.add(sum_char);
        }
        boolean ascending= true, descending= true;
        for (int i=1; i<arr.size() && (ascending || descending); i++) {
            ascending = ascending && arr.get(i)>=arr.get(i-1);
            descending = descending && arr.get(i) <= arr.get(i-1);
        }
        if (ascending || descending)
            return 1;
        else 
            return 0;
    }
	public static void main(String[] args) {
		System.out.println(solve(new ArrayList<String>(Arrays.asList("ipial", "qjqgt", "vfnue", "vjqfp", "eghva", "ufaeo", "atyqz", "chmxy", "ccvgv", "ghtow")), "nbpfhmirzqxsjwdoveuacykltg"));

	}

}
