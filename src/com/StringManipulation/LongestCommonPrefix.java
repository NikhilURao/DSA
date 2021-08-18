/*
 * Longest Common Prefix
Problem Description

Given the array of strings A, you need to find the longest string S which is the prefix of ALL the strings in the array.

Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

For Example: longest common prefix of "abcdefgh" and "abcefgh" is "abc".



Problem Constraints
0 <= sum of length of all strings <= 1000000



Input Format
The only argument given is an array of strings A.



Output Format
Return the longest common prefix of all strings in A.



Example Input
Input 1:

A = ["abcdefgh", "aefghijk", "abcefgh"]
Input 2:

A = ["abab", "ab", "abcd"];


Example Output
Output 1:

"a"
Output 2:

"ab"


Example Explanation
Explanation 1:

Longest common prefix of all the strings is "a".
Explanation 2:

Longest common prefix of all the strings is "ab".
 */
package com.StringManipulation;

import java.util.ArrayList;

public class LongestCommonPrefix {
	public String longestCommonPrefix(ArrayList<String> A) {
        String ans = A.get(0);
        for (int i=1;i<A.size();i++){
            String s = A.get(i);
            int len = s.length() < ans.length()? s.length():ans.length();
            for(int j=1; j<=len;j++){
            	String substr_ans = ans.substring(0,j);
            	String substr_s = s.substring(0,j);
                if (!substr_ans.equals(substr_s)){
                    ans = j==1? "" : ans.substring(0,j-1);
                    break;
                }
                if (j==len) {
                	ans = s.substring(0,j);
                }
            }
        }
        return ans;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
