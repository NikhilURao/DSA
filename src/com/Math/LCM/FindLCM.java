/*
 * LCM (Least Common Multiple) 
 * The lowest number that is exactly divisible by each of the given numbers is 
 * called the least common multiple of those numbers. 
 * For example, consider the numbers 3, 31, and 62 (2 x 31). 
 * The LCM of these numbers would be 2 x 3 x 31 = 186.
 * 
 * Naive Solution:
 * 
 * 1. LCM of 2 number a,b  number ranges between the max(a,b) and a*b
 * 2. Start with i=max(a,b) till a*b.
 * 3. For each i, check if a and b exactly divides i.
 * 4. If true then return i. Else increment i.
 * 
 * TC => O(a*b)
 * SC => O(1)
 * 
 * Optimized Solution using GCD(a, b) * LCM(a, b) = a * b
 * 
 * 1. Find the GCD of the number using Euclidean Algorithm.
 * 2. Find LCM using LCM = a*b/GCD
 * 
 * TC => O(log(min(a,b)))
 * 
 */
package com.Math.LCM;

public class FindLCM {
	
	public static int getLCM_Naive(int a, int b) {
		for (int i=Math.max(a, b); i< a*b; i++) {
			if (i%a==0 && i%b==0)
				return i;
		}
		return a*b;
	}
	
	// Optimized Solution using GCD(a, b) * LCM(a, b) = a * b
	public static int getLCM_EuclideanAlgorithmOptimized(int a, int b) {
		
		return a*b / getGCD_EuclideanAlgorithmOptimized(a, b);
		
	}
	
	public static int getGCD_EuclideanAlgorithmOptimized(int a, int b) {
		// base case: GCD of 0 with 'a' is a.
		if (a==0)
			return b;
		else if (b==0)
			return a;
		else
			return getGCD_EuclideanAlgorithmOptimized(b, a%b);
	}

	public static void main(String[] args) {
		System.out.println(getLCM_Naive(1, 5));
		System.out.println(getLCM_EuclideanAlgorithmOptimized(1, 5));

	}

}
