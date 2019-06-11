/**
 * Array contains 0s and 1s. Segregate 0s to the left and 1s to the right.
 * 
 * 
 */
package com.array;

import java.util.Random;

public class Segregate_0s_1s {
	
static void Segregate(int arr[],int start,int end) {
		//int start=0;
		//int end=arr.length;
		int temp=0;
	while(start<end) {
		
		while (arr[start]==0) {
			start++;
		}
		while (arr[end]==1) {
			end--;
		}
		if (start<end) {
		temp = arr[start];
		arr[start] = arr[end];
		arr[end]=temp;
		}
		}
	}
	public static void main(String[] args) {
		int [] test = new int [10];
		Random rand = new Random();
		for (int i=0;i<test.length;i++) {
			test[i]= rand.nextInt(2);
		}
		System.out.println("Array before sorting");
		for (int i=0;i<test.length;i++) {
			System.out.print(test[i]);
			System.out.print(" ");
		}
		System.out.println("");	
		Segregate(test, 0,test.length-1);
		System.out.println("Array after sorting");
		for (int i=0;i<test.length;i++) {
			System.out.print(test[i]);
			System.out.print(" ");
		}
	}

}
