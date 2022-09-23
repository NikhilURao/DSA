/*
 * 
 * 518. Coin Change 2

You are given an integer array coins representing coins of different denominations and an integer amount 
representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any 
combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.

Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1
 

Constraints:

1 <= coins.length <= 300
1 <= coins[i] <= 5000
All the values of coins are unique.
0 <= amount <= 5000
 * 
 */

package codingminutes.dp.UnboundedKnapsack;

import java.util.Arrays;

public class CoinChange2 {
	
	// Solution 1: Brute Force Recursion
    public static int change(int amount, int[] coins) {
    	int n = coins.length;
        return changeRec(amount, coins, n);
    }
    
    public static int changeRec(int amount, int[] coins, int n) {
    	
    	if (n==0) return 0;
    	
    	if (n==0 && amount==0) return 1;
    	
    	else if (amount==0) return 1;
    	
    	else if (coins[n-1]<=amount) {
    		return changeRec(amount - coins[n-1], coins, n) + changeRec(amount, coins, n-1);
    	}
    	
    	else
    		return changeRec(amount, coins, n-1);
    	
    }
    
    // Solution 2: Recursion + Memoization (Top-Down DP)
    public static int changeTopDown(int amount, int[] coins) {
    	int n = coins.length;
    	int [][] dp = new int [n+1][amount+1];
    	for (int i=0; i<n+1; i++) {
    		int[] temp = new int [amount+1];
    		Arrays.fill(temp, -1);
    		dp[i] = temp;
    	}
        return changeRecTopDown(amount, coins, n, dp);
    }
    
    public static int changeRecTopDown(int amount, int[] coins, int n, int [][] dp) {
    	
    	if (n==0) return dp[n][amount] = 0;
    	
    	if (n==0 && amount==0) return dp[n][amount] = 1;
    	
    	else if (amount==0) return dp[n][amount] = 1;
    	
    	if (dp[n][amount] != -1) return dp[n][amount];
    	
    	else if (coins[n-1]<=amount) {
    		return dp[n][amount] = changeRec(amount - coins[n-1], coins, n) + changeRec(amount, coins, n-1);
    	}
    	else
    		return dp[n][amount] = changeRec(amount, coins, n-1);
    	
    }
    
    // Solution 3: Bottom Up DP
    public static int changeBottomUp(int amount, int[] coins) {
    	int n = coins.length;
    	int [][] dp = new int [n+1][amount+1];
    	for (int i=0; i<n+1; i++) {
    		int[] temp = new int [amount+1];
    		Arrays.fill(temp, 0);
    		dp[i] = temp;
    	}
    	
    	for (int row=0; row<n+1; row++) {
    		dp[row][0] = 1;
    	}
    	
    	for (int row=1; row<n+1; row++) {
    		for (int col=1; col<amount+1; col++) {
    			if (coins[row-1]<=col) {
    				dp[row][col] = dp[row-1][col] + dp[row][col - coins[row-1]];
    			}
    			else {
    				dp[row][col] = dp[row-1][col];
    			}
    		}
    	}
        return dp[n][amount];
    }

	public static void main(String[] args) {
		int amount = 5; int [] coins = {1,2,5};
		System.out.println(change(amount, coins));
		System.out.println();
		System.out.println(changeTopDown(amount, coins));
		System.out.println();
		System.out.println(changeBottomUp(amount, coins));
	}

}
