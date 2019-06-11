/*
 * Write a C program to find sum of elements of array using recursion.
 */
package com.recursion;

public class SumOfElementsInArray {
	
	int Sum(int [] arr,int index,int res) {
		if (index < arr.length) {
			res = res+ arr[index];
			return Sum(arr, index+1, res);
		}
		else return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
SumOfElementsInArray s = new SumOfElementsInArray();
int [] arr = {1,2,3,4,5,6,10,13};
System.out.println(s.Sum(arr, 0, 0));
	}

}
