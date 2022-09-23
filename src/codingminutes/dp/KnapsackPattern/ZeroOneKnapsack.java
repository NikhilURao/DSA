package codingminutes.dp.KnapsackPattern;

import java.util.Arrays;

public class ZeroOneKnapsack {
	
	// Solution 1: Recursion by brute force
	/**
	 * In the following recursion tree, K() refers to knapSack(). The two parameters indicated in the 
	 * following recursion tree are n and W. The recursion tree is for following sample inputs.
	 * weight[] = {1, 1, 1}, W = 2, 
	 * value[] = {10, 20, 30}
	 * Recursion tree for Knapsack capacity 2 units and 3 items of 1 unit weight.
	 * Complexity Analysis: 
	 * Time Complexity: O(2^n).As there are redundant subproblems.
	 * Auxiliary Space :O(1) + O(N). As no extra data structure has been used for storing values 
	 * but O(N) auxiliary stack space(ASS) has been used for recursion stack.
	 * 
                       K(n, W)
                       K(3, 2)  
                   /            \ 
                 /                \               
            K(2, 2)                  K(2, 1)
          /       \                  /    \ 
        /           \              /        \
       K(1, 2)      K(1, 1)        K(1, 1)     K(1, 0)
       /  \         /   \              /        \
     /      \     /       \          /            \
K(0, 2)  K(0, 1)  K(0, 1)  K(0, 0)  K(0, 1)   K(0, 0)

	 * @param value
	 * @param weight
	 * @param C
	 * @param n
	 * @return
	 */
	public static int knapsackRecursiveBruteForce(int [] value, int [] weight, int C, int n) {
		/*
		 *  base condition: If the number of items in value and weight array is 0 i.e. there are no items
		 *  to add into the knapsack, then the maximum value of the knapsack will also be 0.
		 *  Similarly if the capacity of the given knapsack is 0 then the maximum value of the knapsack will also 
		 *  be 0 since we can't fit any item into it at all.
		 */
		if (n==0 || C==0)
			return 0;
		
		// We start from the last element in the array. We have 2 choices either pick the element or don't pick it.
		// Then either ways we end up reducing the size of our subproblem by excluding the last element.
		
		/*
		 *  In a 0/1 Knapsack you either pick the entire element or you don't pick it at all, there is no option
		 *  of picking a fraction of an element. So if the weight of a given element is greater than the capacity
		 *  of the knapsack we can't pick the element simply because it won't fit in the knapsack.
		 */
		if (weight[n-1] > C)
			return knapsackRecursiveBruteForce (value, weight, C, n-1);
		
		/*
		 * if the weight of a given element is less than the Capacity, then we have 2 options, either pick the
		 * element which would reduce the capacity of our knapsack by w1, but increase the value of our knapsack by
		 * v1. Or we can decide not to pick the item, then both the capacity and value of our knapsack would remain
		 * the same. Since we need to maximize the value of our knapsack we choose the maximum of the above two
		 * conditions.
		 */
		
		else {
			return Math.max( ( value[n-1] + knapsackRecursiveBruteForce (value ,  weight, C - weight[n-1], n-1) ),
							   knapsackRecursiveBruteForce (value, weight, C, n-1));
								
		}
		
	}
	
	// Solution 2: Recursion + Memoization = Top-Down DP
	/**
	 * This method uses Memoization Technique (an extension of recursive approach).
	 * This method is basically an extension to the recursive approach so that we can overcome the problem of
	 * calculating redundant cases and thus increased complexity. 
	 * We can solve this problem by simply creating a 2-D array that can store a particular state (n, w) 
	 * if we get it the first time. Now if we come across the same state (n, w) again instead of 
	 * calculating it in exponential complexity we can directly return its result stored in the table in 
	 * constant time. This method gives an edge over the recursive approach in this aspect.
	 * 
	 * Time Complexity: O(N*W). As redundant calculations of states are avoided.
	 * Auxiliary Space: O(N*W) + O(N). The use of 2D array data structure for storing intermediate states 
	 * and O(N) auxiliary stack space(ASS) has been used for recursion stack.
	 * 
	 * Memoization (Top Down): The memoized program for a problem is similar to the 
	 * recursive version with a small modification that looks into a lookup table before 
	 * computing solutions. We initialize a lookup array with all initial values as NIL. 
	 * Whenever we need the solution to a subproblem, we first look into the lookup table. 
	 * If the precomputed value is there then we return that value, otherwise, we calculate the 
	 * value and put the result in the lookup table so that it can be reused later.
	 * 
	 * @param value
	 * @param weight
	 * @param C
	 * @param n
	 * @return
	 */
	public static int knapsackTopDown(int [] value, int [] weight, int C, int n) {
		
		/* 
		 * 2D table for storing the results of subproblems. This will help reduce the redundant re-computations
		 * of already solved subproblems increasing the performance hugely. For the dimensions of the dp table
		 * we should always consider the changing parameters of the recursive calls made. Here both the size of
		 * array and the weight of the knapsack reduces, hence we choose n and C as the dimensions of the table.
		 */
		int [][] dp = new int [n+1][C+1];
		
		// fill them with -1
		for (int i=0; i<dp.length; i++) {
			int [] temp = new int [C+1];
			Arrays.fill(temp, -1);
			dp[i] = temp;
		}
		
		return knapsackRecTopDown(value, weight, C, n, dp);
		
	}
	
	public static int  knapsackRecTopDown(int [] value, int [] weight, int C, int n, int [][] dp) {
		
		// if this subproblem is already computed simply return the answer store in dp table.
		if (dp[n][C] != -1) return dp[n][C];
		// base condition same as knapsackRecursiveBruteForce. 
		if (n==0 || C==0) return 0;
		
		else if (weight[n-1]>C) return dp[n][C] = knapsackRecTopDown(value, weight, C, n-1, dp);
		
		else {
			return dp[n][C] = Math.max( ( value[n-1] +  knapsackRecTopDown(value, weight, C - weight[n-1], n-1, dp) ) ,
					knapsackRecTopDown(value, weight, C, n-1, dp) );
		}
		
		
	}
	// Solution 3: Bottom-Up DP
	/**
	 *  In the Dynamic programming we will work considering the same cases as mentioned in the recursive approach.
	 *  In a DP[][] table let’s consider all the possible weights from ‘1’ to ‘W’ as the columns and 
	 *  weights that can be kept as the rows. The state DP[i][j] will denote maximum value of ‘j-weight’ 
	 *  considering all values from ‘1 to ith’. So if we consider ‘wi’ (weight in ‘ith’ row) we can fill 
	 *  it in all columns which have ‘weight values > wi’. Now two possibilities can take place;
	 *  Fill ‘wi’ in the given column.
	 *  Do not fill ‘wi’ in the given column.
	 *  Now we have to take a maximum of these two possibilities, formally if we do not fill ‘ith’ weight 
	 *  in ‘jth’ column then DP[i][j] state will be same as DP[i-1][j] but if we fill the weight, DP[i][j]
	 *  will be equal to the value of ‘wi’+ value of the column weighing ‘j-wi’ in the previous row. 
	 *  So we take the maximum of these two possibilities to fill the current state
	 *  
	 *   Time Complexity: O(N*W). where ‘N’ is the number of weight element and ‘W’ is capacity.
	 *   As for every weight element we traverse through all weight capacities 1<=w<=W.
	 *   Auxiliary Space: O(N*W). The use of 2-D array of size ‘N*W’.
	 *   
	 *   
	 * @param value
	 * @param weight
	 * @param C
	 * @param n
	 * @return
	 */
	public static int  knapsackBottomUp(int [] value, int [] weight, int C, int n) {
		int [][] dp = new int [n+1][C+1];
		for (int i=0; i<dp.length; i++) {
			int [] temp = new int [C+1];
			dp[i] = temp;
		}
		
		for (int i=0; i<n+1; i++) {
			for (int j=0; j<C+1; j++) {
				if (i==0 || j==0) dp[i][j] = 0;
				
				else if (weight[i-1] > j) 
					dp[i][j] = dp[i-1][j];
				
				else if (weight[i-1] <= j){
					dp[i][j] = Math.max(value[i-1]+ dp[i-1][j - weight[i-1]], dp[i-1][j]);
				}
			}
		}
		
		return dp[n][C];
		
	}
	

	public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 15, 30 };
        int capacity = 50;
        int n = val.length;
        System.out.println(knapsackRecursiveBruteForce(val, wt, capacity, n));
        System.out.println();
        System.out.println(knapsackTopDown(val, wt, capacity, n));
        System.out.println();
        System.out.println(knapsackBottomUp(val, wt, capacity, n));

	}

}
