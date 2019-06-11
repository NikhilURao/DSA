/**
 * Print all the leader numbers in an array.
 * A Leader number is a numbers which doesn't have a number greater than itself towards its right.
 * 
 * For example consider the array 6,5,10,12,2,0,1. Leader numbers are 2 and 12.
 *
 */
package com.array;

import java.util.Random;

public class Leader_Number {
	

	public static void main(String[] args) {
		int [] test = new int[10];
		Random ran = new Random();
		for (int i=0;i<test.length;i++) {
			test[i] = ran.nextInt(100);
			}
		System.out.println("The array is : ");
		for (int i=0;i<test.length;i++) {
			System.out.print(test[i]);
			System.out.print(" ");
			}
		System.out.println("");
		int n=test.length;
		int max = test[n-1];
		System.out.println("Leaders in the given array are "+ max);
		
		for (int i=n-2;i>=0;i--) {
			if (test[i] > max ) {
				max = test[i];
				System.out.print(test[i]);
				System.out.print(" ");
				}
		}

	}

}
