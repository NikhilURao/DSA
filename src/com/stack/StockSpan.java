/*
 * 901. Online Stock Span
Medium

2800

213

Add to List

Share
Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backward) for which the stock price was less than or equal to today's price.

For example, if the price of a stock over the next 7 days were [100,80,60,70,60,75,85], then the stock spans would be [1,1,1,2,1,4,6].
Implement the StockSpanner class:

StockSpanner() Initializes the object of the class.
int next(int price) Returns the span of the stock's price given that today's price is price.
 

Example 1:

Input
["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
Output
[null, 1, 1, 1, 2, 1, 4, 6]

Explanation
StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // return 1
stockSpanner.next(80);  // return 1
stockSpanner.next(60);  // return 1
stockSpanner.next(70);  // return 2
stockSpanner.next(60);  // return 1
stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
stockSpanner.next(85);  // return 6
 

Constraints:

1 <= price <= 105
At most 104 calls will be made to next.
 */
package com.stack;

import java.util.*;

public class StockSpan {
	
    // List to track stock prices of past days
    private ArrayList<Integer> stock_prices;
    
    public StockSpan() {
        this.stock_prices = new ArrayList<Integer>();
    }
    
    public int next(int price) {
    	// add the current day's stock price to the list
        stock_prices.add(price);
        
        int n = stock_prices.size();
        
        // stack to store the indexes of the elements in the list
        Stack<int []> st = new Stack<>();
        // ngl index
        int [] ind = new int [n];
        // array to store the span result
        int span[] = new int [n];
        
        for (int i=0; i<n; i++){
            while (!st.isEmpty() && st.peek()[0] <= stock_prices.get(i)){
                st.pop();
            }
            if (st.isEmpty()){
                ind[i] = -1;
                st.push(new int [] {stock_prices.get(i), i});
                continue;
            }
            ind[i] = st.peek()[1];
            st.push(new int [] {stock_prices.get(i), i});
        }
        
        return (n-1) - ind[n-1];
    }

	public static void main(String[] args) {
		StockSpan sp = new StockSpan();
		System.out.println(sp.next(100));
		System.out.println(sp.next(80));
		System.out.println(sp.next(60));
		System.out.println(sp.next(70));
		System.out.println(sp.next(60));
		System.out.println(sp.next(75));
		System.out.println(sp.next(85));
		

	}

}
