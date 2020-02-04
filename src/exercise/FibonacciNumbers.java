package exercise;
import java.util.*;

import java.io.BufferedReader;

public class FibonacciNumbers {
	// Naive Algorithm using Recursion
	static long FibRecurs(int n) {
		if (n<=1) {
			return n;
		}
		else {
			return FibRecurs(n-1)+FibRecurs(n-2);
		}
	}
	
	// Optimized Algorithm or Fibonacci Table
	static long FibTab(int n) {
		long a[] = new long[n+1];
		if (n==0) {
			a[0]=0;
		}
		else {
			a[0]=0;
			a[1]=1;
		}
		for (int i=2;i<=n;i++) {
			a[i] = (a[i-1]+a[i-2]);
		}
		// Retruning the nth Fibonacci Number
		return a[n];
		// Returning the unit's/last digit of the nth Fibonacci Number
		//return a[n]%10;
		
		
	}

	public static void main(String[] args) {
	
		Scanner ip = new Scanner(System.in);
		int n = ip.nextInt();
		//System.out.println(FibRecurs(n));
		System.out.println(FibTab(n));

	}

}
