/*
 * Spiral Order Matrix I
 * 
 * Given an integer matrix A. Print it in the spiral form
 * 
 * A= 
 */
package com.two_dimensional_array;

import java.util.ArrayList;

public class SpiralOrderMatrix1 {
	
	public static void printSpiralOrder(int [][] a) {
		int top=0; // starting index of row
		int bottom = a.length-1; // ending index of row
		int left=0; // starting index of column
		int right = a[0].length-1; // ending index of column 
		
		while (left <= right && top<= bottom) {
			// left to right column traversal along top row
			for (int i=left; i<=right; i++) {
				System.out.print(a[top][i]+" ");
			}
			top++;
			
			// top to bottom row traversal along right column
			for (int i=top; i<=bottom; i++) {
				System.out.print(a[i][right]+" ");
			}
			right--;
			
			// right to left column traversal along bottom row
			for (int i=right; i>=left; i--) {
				System.out.print(a[bottom][i]+" ");
			}
			bottom--;
			
			// bottom to top row traversal along left column
			for (int i=bottom; i>=top; i--) {
				System.out.print(a[i][left]+" ");
			}
			left++;
		}
		
	}

	public static void main(String[] args) {
		
		int [][] a = new int[4][5];
		int r = 1;
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a[i].length; j++) {
				a[i][j] = r;
				r++;
			}
		}
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a[i].length; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println("");
		}
		
		printSpiralOrder(a);
		
		
		
	}

}
