/*
 * 
 * 1092. Shortest Common Supersequence

Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. 
If there are multiple valid strings, return any of them.

A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the 
string s.

 

Example 1:

Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation: 
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.
Example 2:

Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
Output: "aaaaaaaa"
 

Constraints:

1 <= str1.length, str2.length <= 1000
str1 and str2 consist of lowercase English letters.
Accepted
47,637
Submissions
84,472
 * 
 */
package codingminutes.dp.LCS;

import java.util.Arrays;

public class ShortestCommonSupersequence {
	
	
	// Find the length of the Shortest Common Supersequence
	/**
	 * 1. Find the the length longest common subsequence :- length(LCS)
	 * 2. Length of the shortest common supersequence = length(str1) + length(str2) - length(LCS)
	 */
	public static int findLengthOfShortestCommonSupersequence(String str1, String str2) {
		int n = str1.length(); int m = str2.length();
		if (n==0 || m==0) return 0;
		
		int dp [][] = new int [n+1][m+1];
		for (int i=0; i<n+1; i++) {
			int [] temp = new int [m+1];
			Arrays.fill(temp, 0);
			dp[i] = temp;
		}
		for (int i=0; i<n+1; i++){
			for (int j=0; j<m+1; j++){
				
				if (i==0 || j==0) dp[i][j] = 0;
				
				else if (str1.charAt(i-1) == str2.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}

		return n+m-dp[n][m];

	}
	
	// print shortest common supersequence
	public static String printShortestCommonSupersequence(String str1, String str2){
		int n = str1.length(); int m = str2.length();
		if (n==0 || m==0) return "";
		
		int dp [][] = new int [n+1][m+1];
		for (int i=0; i<n+1; i++) {
			int [] temp = new int [m+1];
			Arrays.fill(temp, -1);
			dp[i] = temp;
		}
		
		for (int i=0; i<n+1; i++){
			for (int j=0; j<m+1; j++){
				
				if (i==0 || j==0) dp[i][j] = 0;
				
				else if (str1.charAt(i-1) == str2.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}

	StringBuilder scss = new StringBuilder();
		int i=n; int j=m;
		
		while (i>0 && j>0){
		if (str1.charAt(i-1) == str2.charAt(j-1)){
			scss.append(str1.charAt(i-1));
			i--;
			j--;
		}
		
		else if (dp[i-1][j]>=dp[i][j-1]){
			scss.append(str1.charAt(i-1));
			i--;
		}
		else {
			scss.append(str2.charAt(j-1));
			j--;
		}
		}
		
		while (i>0) {
			scss.append(str1.charAt(i-1));
			i--;
		}
		
		while (j>0) {
			scss.append(str2.charAt(j-1));
			j--;
		}

	return scss.reverse().toString();
	
	}


	public static void main(String[] args) {
		String str1 = "abac", str2 = "cab";
		System.out.println("Length of the shortest common supersequence is: "+
		findLengthOfShortestCommonSupersequence(str1, str2));
		System.out.println("shortest common supersequence is: "+
		printShortestCommonSupersequence(str1, str2));

	}

}
