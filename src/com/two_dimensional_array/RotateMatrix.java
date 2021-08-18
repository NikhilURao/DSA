/*
 * Rotate Matrix
Problem Description

You are given a n x n 2D matrix A (square matrix) representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Problem Constraints
1 <= n <= 1000

Input Format
First argument is a 2D matrix A of integers

Output Format
Return the 2D rotated matrix.

Example Input
Input 1:

 [
    [1, 2],
    [3, 4]
 ]
Input 2:

 [
    [1]
 ]


Example Output
Output 1:

 [
    [3, 1],
    [4, 2]
 ]
Output 2:

 [
    [1]
 ]


Example Explanation
Explanation 1:

 After rotating the matrix by 90 degree:
 1 goes to 2, 2 goes to 4
 4 goes to 3, 3 goes to 1
Explanation 2:

 2D array remains the same as there is only element.
 */
package com.two_dimensional_array;

import java.util.ArrayList;
import java.util.Arrays;

public class RotateMatrix {
	/*
	 * transpose of an nxn 2d square martix in place -> 
	 * rows and columns get interchanged 
	 */
	public static void transpose (ArrayList<ArrayList<Integer>> a){
		for (int i=0; i<a.size(); i++) {
			for (int j=0; j<a.get(i).size(); j++) {
				if (j>i) {
					int temp = a.get(i).get(j);
					a.get(i).set(j,a.get(j).get(i));
					a.get(j).set(i,temp);
				}
			}
		}
		
	}
	/*
	 * Reverse an array in place using 2 pointers
	 */
	public static void reverseArray (ArrayList<Integer> a) {
		int l=0; int r = a.size()-1;
		
		while (l<r) {
			a.set(l,a.get(l) ^ a.get(r));
			a.set(r,a.get(l) ^ a.get(r));
			a.set(l,a.get(l) ^ a.get(r));
			l++;
			r--;
		}
	}
	public static ArrayList<ArrayList<Integer>> rotate (ArrayList<ArrayList<Integer>> a){
		transpose(a);
		for (int i=0; i<a.size();i++) {
			reverseArray(a.get(i));
		}
		
		return a;
		
	}
	
	public static void print2DArray (ArrayList<ArrayList<Integer>> a) {
		for (int i=0; i<a.size(); i++) {
			for (int j=0; j<a.get(i).size(); j++) {
				System.out.print(a.get(i).get(j)+" ");
			}
			System.out.println(" ");
		}
	}

	public static void main(String[] args) {
		/*
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		A.add(new ArrayList<Integer>(Arrays.asList(1,2,3)));
		A.add(new ArrayList<Integer>(Arrays.asList(4,5,6)));
		A.add(new ArrayList<Integer>(Arrays.asList(7,8,9)));
		System.out.println("Array A: ");
		print2DArray(A);
		transpose(A);
		System.out.println("Transpose A: ");
		print2DArray(A);
		ArrayList<Integer> ls = new ArrayList<Integer>(Arrays.asList(1,2,3));
		ls.forEach(i->System.out.print(i+" "));
		reverseArray(ls);
		ls.forEach(i->System.out.print(i+" "));
		*/
		
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		A.add(new ArrayList<Integer>(Arrays.asList(1,2,3)));
		A.add(new ArrayList<Integer>(Arrays.asList(4,5,6)));
		A.add(new ArrayList<Integer>(Arrays.asList(7,8,9)));
		System.out.println("Original 2D square matrix");
		print2DArray(A);
		rotate(A);
		System.out.println("After rotating 90 degrees clockwise");
		print2DArray(A);
		
		

	}

}
