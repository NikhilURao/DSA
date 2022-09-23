/*
 * 516. Longest Palindromic Subsequence

Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no 
elements without changing the order of the remaining elements.

 

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
 

Constraints:

1 <= s.length <= 1000
s consists only of lowercase English letters.
 * 
 */
package codingminutes.dp.LCS;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
	
    public static int longestPalindromeSubseq(String s) {
    	int n = s.length();
    	if (n==0) return 0;
    	
    	// reverse of string s
    	String revs = new StringBuilder(s).reverse().toString();
    	
    	int dp[][] = new int [n+1][n+1];
    	for (int i=0; i<n+1; i++) {
    		int temp[] = new int [n+1];
    		Arrays.fill(temp, 0);
    		dp[i] = temp;
    	}
    	
    	for (int i=0; i<n+1; i++) {
    		for (int j=0; j<n+1; j++) {
    			
    			if (i==0 || j==0) dp[i][j] = 0;
    			
    			else if (s.charAt(i-1) == revs.charAt(j-1)) 
    				dp[i][j] = 1 + dp[i-1][j-1];
    			
    			
    			else
    				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
    				
    		}
    	}
    	
    	return dp[n][n];
        
    }
    
    public static String printlongestPalindromeSubseq(String s) {
    	int n = s.length();
    	if (n==0) return "";
    	
    	// reverse of string s
    	String revs = new StringBuilder(s).reverse().toString();
    	
    	int dp[][] = new int [n+1][n+1];
    	for (int i=0; i<n+1; i++) {
    		int temp[] = new int [n+1];
    		Arrays.fill(temp, 0);
    		dp[i] = temp;
    	}
    	
    	for (int i=0; i<n+1; i++) {
    		for (int j=0; j<n+1; j++) {
    			
    			if (i==0 || j==0) dp[i][j] = 0;
    			
    			else if (s.charAt(i-1) == revs.charAt(j-1)) 
    				dp[i][j] = 1 + dp[i-1][j-1];
    			
    			
    			else
    				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
    				
    		}
    	}
    	StringBuilder LCS = new StringBuilder();
    	int row = n; int col = n;
    	while (row>0 && col>0) {	
    		Character c1 = s.charAt(row-1);
    		Character c2 = revs.charAt(col-1);
    		if (c1 == c2) {
    			LCS.append(s.charAt(row-1));
    			row--;
    			col--;
    		}
    		else {
    			if (dp[row-1][col] >= dp[row][col-1]) {
    				row--;
    			}
    			else {
    				col--;
    			}
    		}
    	}
    	
    	return LCS.reverse().toString();
    }
    

	public static void main(String[] args) {
		String s = "Aknockonthedoortattarrattat";
		System.out.println("Length of the longest palindromic subsequence is :"+
		longestPalindromeSubseq(s));	
		System.out.println("longest palindromic subsequence is :"+
		printlongestPalindromeSubseq(s));

	}

}
