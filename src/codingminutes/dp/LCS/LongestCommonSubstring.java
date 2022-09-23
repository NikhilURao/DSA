/*
 * Longest Common Substring | DP-29

Difficulty Level : Medium
Last Updated : 15 Nov, 2021
Given two strings ‘X’ and ‘Y’, find the length of the longest common substring. 

Examples : 

Input : X = “GeeksforGeeks”, y = “GeeksQuiz” 
Output : 5 
Explanation:
The longest common substring is “Geeks” and is of length 5.

Input : X = “abcdxyz”, y = “xyzabcd” 
Output : 4 
Explanation:
The longest common substring is “abcd” and is of length 4.

Input : X = “zxabcdezy”, y = “yzabcdezx” 
Output : 6 
Explanation:
The longest common substring is “abcdez” and is of length 6.
 * 
 */
package codingminutes.dp.LCS;

import java.util.Arrays;

public class LongestCommonSubstring {
	
    
    
    // Solution 3: Bottom-Up DP
    public static int longestCommonSubstringBottomUp(String text1, String text2) {
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
    			
    			else dp[row][col] = 0;
    		}
    	}
   	 	int maxLen=0;              // Now finding the max element
   	 	for(int i=1;i<=l1;i++){
   	 		for(int j=1;j<=l2;j++)
   	 			maxLen=Math.max(maxLen,dp[i][j]);
   	 	}
   	 	return maxLen;
    	
    	
    }

	public static void main(String[] args) {
		String text1 = "NikhilIsAGoogleEmployee", text2 = "Google";
		System.out.println(longestCommonSubstringBottomUp(text1, text2));

	}

}
