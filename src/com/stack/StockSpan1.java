/*
 * 
 * The Stock Span Problem

The stock span problem is a financial problem where we have a series of n daily price quotes for a stock 
and we need to calculate the span of the stock’s price for all n days. 
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days 
just before the given day, for which the price of the stock on the current day is less than its price on 
the given day. 

Example:

Input: N = 7, price[] = [100 80 60 70 60 75 85]
Output: 1 1 1 2 1 4 6
Explanation: Traversing the given input span for 100 will be 1, 80 is smaller than 100 so the span is 1, 
60 is smaller than 80 so the span is 1, 70 is greater than 60 so the span is 2 and so on. 
Hence the output will be 1 1 1 2 1 4 6.

Input: N = 6, price[] = [10 4 5 90 120 80]
Output:1 1 2 4 5 1
Explanation: Traversing the given input span for 10 will be 1, 4 is smaller than 10 so the span will be 1, 
5 is greater than 4 so the span will be 2 and so on. Hence, the output will be 1 1 2 4 5 1.
 */

package com.stack;

import java.util.*;

public class StockSpan1 {
	
	
	/**
	 * 
	 * Time Complexity: O(n). It seems more than O(n) at first look. If we take a closer look, we can observe that every element of the array is added and removed from the stack at most once. So there are total 2n operations at most. Assuming that a stack operation takes O(1) time, we can say that the time complexity is O(n).
		Auxiliary Space: O(n) in the worst case when all elements are sorted in decreasing order.
	 * @param prices
	 * @return
	 */
	public static int[] calculateSpan(int [] prices) {
		
		int n = prices.length;
		if (n==0) return prices;
		
		// stack to save {NGL, index of NGL} of prices
		Stack<int[]> st = new Stack<>();
		int res[] = new int [n];
		
		// calculate ngl
		for (int i=0; i<n; i++) {
			
			while (!st.isEmpty() && st.peek()[0] <= prices[i]) {
				st.pop();
			}
			
			if (st.isEmpty()) {
				res[i] = -1;
				st.push(new int [] {prices[i], i});
				continue;
			}
			
			res[i] = st.peek()[1];
			st.push(new int [] {prices[i], i});
		}
		
		int [] span = new int [n];
		
		for (int i=0; i<n;i++) {
			span[i] = i - res[i];
		}
		
		return span;
		
	}

	public static void main(String[] args) {
		int prices [] = {100,80,60,70,60,75,85}; // 1 1 1 2 1 4 6
		int span[] = calculateSpan(prices);
		
		for (int i=0; i<=span.length -1 ; i++) {
			System.out.print(span[i]+" ");
		}

	}

}
