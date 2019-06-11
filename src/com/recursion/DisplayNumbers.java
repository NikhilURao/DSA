/*
 * Write a program to display all array elements using recursion.
 */
package com.recursion;

public class DisplayNumbers {
	
	void Disp(int index,int []arr) {
		int len = arr.length;
		if (index < len) {
			Disp(index+1, arr);
			System.out.print(arr[index]);
		}
		
		
		
	}
	public static void main(String []ar) {
		DisplayNumbers d = new DisplayNumbers();
		int [] arr = {1,2,3,4,5,6,7,8};
		d.Disp(0, arr);
	}
}
 