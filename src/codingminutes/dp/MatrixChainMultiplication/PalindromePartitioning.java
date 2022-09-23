/*
 * Palindrome Partitioning | DP-17

Given a string, a partitioning of the string is a palindrome partitioning if every substring of the 
partition is a palindrome. For example, “aba|b|bbabb|a|b|aba” is a palindrome partitioning of 
“ababbbabbababa”. Determine the fewest cuts needed for a palindrome partitioning of a given string. 
For example, minimum of 3 cuts are needed for “ababbbabbababa”. The three cuts are “a|babbbab|b|ababa”. 
If a string is a palindrome, then minimum 0 cuts are needed. 
If a string of length n containing all different characters, then minimum n-1 cuts are needed. 

Examples :  

Input : str = “geek” 
Output : 2 
We need to make minimum 2 cuts, i.e., “g ee k”
Input : str = “aaaa” 
Output : 0 
The string is already a palindrome.
Input : str = “abcde” 
Output : 4
Input : str = “abbac” 
Output : 1 
 * 
 * 
 * 
 */
package codingminutes.dp.MatrixChainMultiplication;

import java.util.Arrays;

public class PalindromePartitioning {
	
	public static boolean isPalindrome(String s, int start, int end) {
		
		if (end < start) return true;
		
		// An empty string or a string with just one character is a palindrome.
		if ( end - start == 0) return true;
		
		while (start <= ((start+end)/2) && end >= ((start+end)/2) && start <= end) {
			if (s.charAt(start) != s.charAt(end)) return false;
			start++;
			end--;
		}
		
		return true;
		
	}
	
	// Solution 1: Brute Force Recursion 
	public static int minPalindromePartitioning(String s) {
		int n = s.length();
		
		int i=0; int j = n-1;
		
		if (isPalindrome(s, i, j)) return 0;
		
		return minPalindromePartitioningRecursive(s, i,j);
		
	}
	
	public static int minPalindromePartitioningRecursive(String s, int i, int j) {
		
		int min = Integer.MAX_VALUE;
		
		if (i>=j) return 0;
		
		if (isPalindrome(s, i, j)) return 0;
		
		for (int k=i; k<j; k++) {
			int temp = 1+ minPalindromePartitioningRecursive(s, i, k) + 
					minPalindromePartitioningRecursive(s, k+1, j);
			
			min = Math.min(min, temp);
			
		}
		
		return min;
		
	}
	
	// Solution 2: Recursion + Memoization = Top-Down Dp
	public static int minPalindromePartitioningTopDown(String s) {
		int n = s.length();
		
		int i=0; int j = n-1;
		
		if (isPalindrome(s, i, j)) return 0;
		
		int dp[][] = new int[n+1][n+1];
		for (int l=0; l<n+1; l++) {
			int temp[] = new int [n+1];
			Arrays.fill(temp, -1);
			dp[l] = temp;
		}
		
		return minPalindromePartitioningRecursiveTopDown(s, i,j, dp);
		
	}
	
	public static int minPalindromePartitioningRecursiveTopDown(String s, int i, int j, int dp[][]) {
		
		if (dp[i][j] != -1) return dp[i][j];
		
		int min = Integer.MAX_VALUE;
		
		
		if (i>=j) return dp[i][j] =  0;
		
		if (isPalindrome(s, i, j)) return dp[i][j] = 0;
		
		for (int k=i; k<j; k++) {
			int temp = 1+ minPalindromePartitioningRecursiveTopDown(s, i, k, dp) + 
					minPalindromePartitioningRecursiveTopDown(s, k+1, j, dp);
			
			min = Math.min(min, temp);
			
		}
		
		return dp[i][j] = min;
		
	}

	public static void main(String[] args) {

		System.out.println(minPalindromePartitioning("geek"));
		System.out.println(minPalindromePartitioning("nitin"));
		
		
		System.out.println(minPalindromePartitioningTopDown("geek"));
		System.out.println(minPalindromePartitioningTopDown("nitin"));

	}

}
