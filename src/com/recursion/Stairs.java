/**
 * Count ways to reach the n�th stair
There are n stairs, a person standing at the bottom wants to reach the top. 
The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, 
the person can reach the top.

Input: n = 1
Output: 1
There is only one way to climb 1 stair

Input: n = 2
Output: 2
There are two ways: (1, 1) and (2)

Input: n = 4
Output: 5
(1, 1, 1, 1), (1, 1, 2), (2, 1, 1), (1, 2, 1), (2, 2)
 */

package com.recursion;

public class Stairs {
	 
	    // A simple recursive program to find n'th fibonacci number 
	    static int fib(int n) 
	    { 
	       if (n <= 1) 
	          return n; 
	       return fib(n-1) + fib(n-2); 
	    } 
	      
	    // Returns number of ways to reach s'th stair 
	    static int countWays(int s) 
	    { 
	        return fib(s + 1); 
	    } 
	  
	   
	    public static void main (String args[]) 
	    { 
	          int s = 3; 
	            System.out.println(countWays(s)); 
	    } 

}
