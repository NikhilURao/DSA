/*
 * Write a program that returns an ArrayList<String> from numbers 1 to n with the 
 * following restrictions:
 * for multiples of 3 store "Fizz" instead of the number
 * for multiples of 5 store "Buzz" instead of the number 
 * for multiples of both 3 and 5 store "FizzBuzz" instead of the number.
 */
package com.array;

import java.util.ArrayList;
import java.util.Collections;

public class FizzBuzzTest {
	
	public ArrayList<String> returnFizzBuzzArray(int n){
		// initialize ArrayList of size n with 0
		ArrayList<String> result = new ArrayList<String>(Collections.nCopies(n, Integer.toString(0)));
		
		for (int i=1; i<=n; i++){
			if(i%3==0 && i%5==0) {
				result.set(i-1,"FizzBuzz");
			}
			else if(i%3==0) {
				result.set(i-1,"Fizz");
			}
			else if(i%5==0) {
				result.set(i-1,"Buzz");
			}
			else {
				result.set(i-1, Integer.toString(i));
			}
			
		}
		
		return result;
	}
	
	
	
	

	public static void main(String[] args) {
		FizzBuzzTest fbt = new FizzBuzzTest();
		fbt.returnFizzBuzzArray(15).forEach(n -> System.out.print(n+" "));

	}

}
