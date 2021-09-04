/*
 * GCD (Greatest Common Divisor) or HCF(Highest Common Factor)
 * GCD(a,b) or HCF(a,b) => Largest number that divides both a and b. 
 * 
 * The term HCF stands for Highest Common Factor. 
 * The largest number that divides two or more numbers is the 
 * highest common factor (HCF) for those numbers. 
 * For example, consider the numbers 30 (2 x 3 x 5), 36 (2 x 2 x 3 x 3), 
 * 42 (2 x 3 x 7), 45 (3 x 3 x 5). 3 is the largest number that divides each of 
 * these numbers, and hence, is the HCF for these numbers.
 * 
 * Example: GCD(4,6) = 2
 * GCD(100, 200) = 100
 * GCD(7,9) = 1
 * 
 * Given 2 number a and b. Find the GCD of the a and b.
 * 
 * Naive Solution: 
 * 
 * 1. Start with the minimum of 2 the 2 numbers. int i = min(a,b)
 * 2. Check if i divides both a and b.
 * 3. If yes return i.
 * 4. Else decrement i till 1 i.e i>0;
 * 
 * TC=> Worst case, we start with the minimum of 2 number and decrement till 1
 * So TC=> O(min(a,b))
 * SC => O(1)
 * 
 * Efficient solution using Euclidean Algorithm
 * 
 * GCD(a, b) = GCD (a, b - a), where b > a
 * GCD(a, b) = GCD (a-b, b), where a>b
 * 
 * Or in other words if b>a, then GCD(a, b) = GCD(a, b%a) and 
 * b>a, then GCD(a, b) = GCD(a%b, b)
 * 
 * The Euclidean algorithm is based on the below facts:
 * If we subtract the smaller number from larger (we reduce larger number), 
 * GCD doesn't change. So if we keep subtracting repeatedly the larger of 
 * two, we end up with GCD.
 * Now instead of subtraction, if we divide the smaller number, the 
 * algorithm stops when the remainder is found to be 0.
 * 
 * TC => O(Log(min(a,b)))
 * 
 * 
 * 
 */
package com.Math.GCD;

public class FindGCD {
	
	public static int getGCD_Naive(int a, int b) {
		int gcd = Math.min(a, b);
		
		while (gcd > 0) {
			if (a%gcd == 0 && b%gcd == 0) {
				return gcd;
			}
			gcd --;
		}
		
		return gcd;
	}
	// Euclidean Algorithm using repeated subtraction 
	public static int getGCD_EuclideanAlgorithm(int a, int b) {
		while (a!=b) {
			if (a > b)
				a = a - b;
			else
				b = b - a;
		}
		return a;
	}
	
	/* Euclidean Algorithm using modular division 
	 * 
	 * wkt GCD(a,b) = GCD(a, b-a) considering b>a
	 * For example GCD(5, 9) = GCD(5, 4) = 1
	 * Instead of repeatedly subtracting we can use modular division
	 * For example GCD(5, 2255) = GCD(5, 2250) = GCD(5, 2245) ...... = GCD(5, 0) = 5
	 * Instead we can use GCD(5, 2255) = GCD(5, 2255%5) = GCD(5, 0) = 5
	 * Base condition GCD(num, 0) = num
	 * 
	 * The Euclidean algorithm is based on the below facts:
	 * If we subtract the smaller number from larger (we reduce larger number), 
	 * GCD doesn't change. So if we keep subtracting repeatedly the larger of 
	 * two, we end up with GCD.
	 * Now instead of subtraction, if we divide the smaller number, the 
	 * algorithm stops when the remainder is found to be 0.
	 */
	public static int getGCD_EuclideanAlgorithmOptimized(int a, int b) {
		// base case: GCD of 0 with 'a' is a.
		if (a==0)
			return b;
		else
			return getGCD_EuclideanAlgorithmOptimized(b%a, a);
	}
	/*
	 * Extended Euclidean Algorithm: 
	 * Extended Euclidean algorithm also finds integer coefficients x and y such that: 
	 * ax + by = gcd(a, b) 
	 * 
	 * Examples:  
	 * Input: a = 30, b = 20
	 * Output: gcd = 10
	 * x = 1, y = -1
	 * (Note that 30*1 + 20*(-1) = 10)
	 * Input: a = 35, b = 15
	 * Output: gcd = 5
	 * x = 1, y = -2
	 * (Note that 35*1 + 15*(-2) = 5)
	 * The extended Euclidean algorithm updates results of gcd(a, b) using the results calculated by recursive call gcd(b%a, a). Let values of x and y calculated by the recursive call be x1 and y1. x and y are updated using the below expressions. 
	 * x = y1 - ⌊b/a⌋ * x1
	 * y = x1
	 * 
	 * 
	 * 
	 */
	public static int getGCD_EuclideanAlgorithmExtended(int a, int b, int x, int y)
    {

        // Base Case
        if (a == 0)
        {
            x = 0;
            y = 1;
            return b;
        }
 
        int x1=1, y1=1; // To store results of recursive call
        int gcd = getGCD_EuclideanAlgorithmExtended(b%a, a, x1, y1);
 
        // Update x and y using results of recursive
        // call
        x = y1 - (b/a) * x1;
        y = x1;
 
        return gcd;
    }

	public static void main(String[] args) {
		System.out.println(getGCD_Naive(10000,11));
		System.out.println(getGCD_EuclideanAlgorithm(10000,11));
		System.out.println(getGCD_EuclideanAlgorithmOptimized(10000,11));
		System.out.println(getGCD_EuclideanAlgorithmExtended(35,15,1,1));
		

	}

}
