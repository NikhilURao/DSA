package codingminutes.dp.UnboundedKnapsack;

import java.util.Arrays;

public class CoinChange1 {
	
        public static int coinChange(int[] coins, int amount) {
        	if (amount == 0) return 0;
            int n = coins.length;
	        int dp[][] = new int [n+1][amount+1];
	        for (int i=0; i<n+1; i++){
	            int temp [] = new int [amount+1];
	            Arrays.fill(temp, -1);
	            dp[i] = temp;
            }
            int int_max = Integer.MAX_VALUE - 1;
            for (int col=0; col<amount+1; col++){
	            dp[0][col] = int_max;
            }
            for (int row=0; row<n+1; row++){
	            dp[row][0] = 0;
            }
            for (int col=1; col<amount+1; col++){
	            if (col % coins[0] == 0)
    		        dp[1][col] = col/coins[0];
	            else 
		            dp[1][col] = int_max;
            }
            for (int row=2; row<n+1; row++){
	            for (int col=1; col<amount+1; col++){
	                if (coins[row-1]<=col){
	                dp[row][col] = Math.min(dp[row-1][col], 1 + dp[row][col-coins[row-1]]);
            }
            else{
	            dp[row][col] =dp[row-1][col];
            }
            }
            }
            if (dp[n][amount] == int_max || dp[n][amount] == Integer.MAX_VALUE) return -1;
            else return dp[n][amount];
    }

	public static void main(String[] args) {
		int [] coins = {1,2}; int amount = 2;
		//int [] coins = {1,2,5}; int amount = 11;
		System.out.println(coinChange(coins, amount));

	}

}
