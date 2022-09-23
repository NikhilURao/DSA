/*
 * 
 * Longest Repeated Subsequence

Given a string, print the longest repeating subsequence such that the two subsequence don’t have 
same string character at same position, i.e., any i’th character in the two subsequences shouldn’t have the 
same index in the original string.
 

Longest Repeated Subsequence

Examples: 

Input: str = "aabb"
Output: "ab"

Input: str = "aab"
Output: "a"
The two subsequence are 'a'(first) and 'a' 
(second). Note that 'b' cannot be considered 
as part of subsequence as it would be at same
index in both.
 * 
 */

package codingminutes.dp.LCS;

import java.util.Arrays;

public class LongestRepeatingSubsequence_LRS {
	
	public static int lengthLRS(String s) {
		int n = s.length();
		if (n==0) return 0;
		
		int dp[][] = new int [n+1][n+1];
		for (int i=0; i<n+1; i++) {
			int [] temp = new int [n+1];
			Arrays.fill(temp, 0);
			dp[i] = temp;
		}
		
		for (int i=0; i<n+1; i++) {
			for (int j=0; j<n+1; j++) {
				if (i==0 || j==0) dp[i][j] = 0;
				else if (s.charAt(i-1) == s.charAt(j-1) && i!=j) {
					dp[i][j] = 1+dp[i-1][j-1];
				}
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		return dp[n][n];
	}
	
	public static String printLRS(String s) {
		int n = s.length();
		if (n==0) return "";
		
		int dp[][] = new int [n+1][n+1];
		for (int i=0; i<n+1; i++) {
			int [] temp = new int [n+1];
			Arrays.fill(temp, 0);
			dp[i] = temp;
		}
		
		for (int i=0; i<n+1; i++) {
			for (int j=0; j<n+1; j++) {
				if (i==0 || j==0) dp[i][j] = 0;
				else if (s.charAt(i-1) == s.charAt(j-1) && i!=j) {
					dp[i][j] = 1+dp[i-1][j-1];
				}
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
    	StringBuilder LCS = new StringBuilder();
    	int row = n; int col = n;
    	while (row>0 && col>0) {	
    		Character c1 = s.charAt(row-1);
    		Character c2 = s.charAt(col-1);
    		if (c1 == c2 && row!=col) {
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
		String str = "AABEBCDD";
		System.out.println("Length of the Longest Repeating Subsequence is : "+lengthLRS(str));
		System.out.println("Longest Repeating Subsequence is : "+printLRS(str));
		

	}

}
