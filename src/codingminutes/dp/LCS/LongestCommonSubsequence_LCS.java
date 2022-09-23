/*
 * 1143. Longest Common Subsequence

Given two strings text1 and text2, return the length of their longest common subsequence. 
If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters 
(can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.


Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.
 * 
 */
package codingminutes.dp.LCS;

import java.util.Arrays;

public class LongestCommonSubsequence_LCS {
	
	// Solution 1: Brute Force Recursive
    public static int longestCommonSubsequenceRecursive(String text1, String text2) {
    	int l1 = text1.length();
    	int l2 = text2.length();
    	
    	if (l1==0 || l2==0) return 0;
    	else return lcsRecursive(text1, text2, l1, l2);
        
    }
    
    public static int lcsRecursive(String text1, String text2, int l1, int l2) {
    	
    	if (l1==0 || l2==0) return 0;
    	else if (text1.charAt(l1-1) == text2.charAt(l2-1))
    		return 1 + lcsRecursive(text1, text2, l1-1, l2-1);
    	else {
    		return Math.max(lcsRecursive(text1, text2, l1, l2-1), lcsRecursive(text1, text2, l1-1, l2));
    	}
    	
    }
    
    // Solution 2: Recursion + Memoization (Top-Down DP)
    public static int longestCommonSubsequenceTopDown(String text1, String text2) {
    	int l1 = text1.length();
    	int l2 = text2.length();
    	
    	if (l1==0 || l2==0) return 0;
    	
    	int [][] dp = new int [l1+1][l2+1];
    	for (int i=0; i<l1+1; i++) {
    		int [] temp = new int [l2+1];
    		Arrays.fill(temp, -1);
    		dp[i] = temp;
    	}
    	
    	 
    	return lcsRecursiveTopDown(text1, text2, l1, l2, dp);
        
    }
    
    public static int lcsRecursiveTopDown(String text1, String text2, int l1, int l2, int dp[][]) {
    	
    	if (l1==0 || l2==0) return dp[l1][l2] = 0;
    	
    	if (dp[l1][l2] != -1) return dp[l1][l2];
    	
    	else if (text1.charAt(l1-1) == text2.charAt(l2-1))
    		return dp[l1][l2] = 1 + lcsRecursiveTopDown(text1, text2, l1-1, l2-1, dp);
    	else {
    		return dp[l1][l2] = Math.max(lcsRecursiveTopDown(text1, text2, l1, l2-1, dp),
    				lcsRecursiveTopDown(text1, text2, l1-1, l2, dp));
    	}
    	
    }
    
    // Solution 3: Bottom-Up DP
    public static int longestCommonSubsequenceBottomUp(String text1, String text2) {
    	int l1 = text1.length();
    	int l2 = text2.length();
    	if (l1==0 || l2==0) return 0;
    	
    	int [][] dp = new int [l1+1][l2+1];
    	for (int i=0; i<l1+1; i++) {
    		int [] temp = new int [l2+1];
    		Arrays.fill(temp, 0);
    		dp[i] = temp;
    	}
    	
    	for (int row = 0; row<l1+1; row++) {
    		for (int col=0; col<l2+1; col++) {
    			if (row==0 || col==0) dp[row][col] = 0;
    			
    			else if (text1.charAt(row-1) == text2.charAt(col-1)) {
    				dp[row][col] = 1 + dp[row-1][col-1];
    			}
    			
    			else dp[row][col] = Math.max(dp[row-1][col], dp[row][col-1]);
    		}
    	}
    	
    	return dp[l1][l2];
    	
    }
     
    
	public static void main(String[] args) {
		String text1 = "abcde", text2 = "ace" ;
		System.out.println(longestCommonSubsequenceRecursive(text1, text2));
		System.out.println(longestCommonSubsequenceTopDown(text1, text2));
		System.out.println(longestCommonSubsequenceBottomUp(text1, text2));

	}

}
