package com.recursion;

public class Fibonacci {

	static int Fib(int n) {
		
		if (n<=1) {
			return 0;
		}
		if (n==2) {
			return 1;
		}
		else {
			return Fib(n-1) + Fib(n-2);
		}
	}
	public static void main(String[] args) {
		
		System.out.println(Fib (7));
			}

}
