/*
 * Spiral Order Matrix II
Problem Description

Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.



Problem Constraints
1 <= A <= 1000



Input Format
First and only argument is integer A


Output Format
Return a 2-D matrix which consists of the elements in spiral order.



Example Input
Input 1:

1
Input 2:

2


Example Output
Output 1:

[ [1] ]
Output 2:

[ [1, 2], [4, 3] ]


Example Explanation
Explanation 1:

 
Only 1 is to be arranged.
Explanation 2:

1 --> 2
      |
      |
4<--- 3
 */
package com.two_dimensional_array;

import java.util.ArrayList;
import java.util.Arrays;

public class SpiralOrderMatrix2 {
	
	public static void print2DArray (ArrayList<ArrayList<Integer>> a) {
		for (int i=0; i<a.size(); i++) {
			for (int j=0; j<a.get(i).size(); j++) {
				System.out.print(a.get(i).get(j)+" ");
			}
			System.out.println(" ");
		}
	}
	
	public static ArrayList<ArrayList<Integer>> createSpiralOrderMatrix(int A){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(A);
		for (int i=0;i<A;i++) {
			res.add(new ArrayList<Integer>(Arrays.asList(new Integer[A])));
		}
		int top=0;
		int bottom=A-1; 
		int left=0;
		int right=A-1;
		int count=1;
		

		while (left <= right && top<= bottom) {
			// left to right column traversal along top row
			for (int i=left; i<=right; i++) {
				res.get(top).set(i, count);
				count++;
			}
			top++;
			
			// top to bottom row traversal along right column
			for (int i=top; i<=bottom; i++) {
				res.get(i).set(right, count);
				count++;
			}
			right--;
			
			// right to left column traversal along bottom row
			for (int i=right; i>=left; i--) {
				res.get(bottom).set(i, count);
				count++;
			}
			bottom--;
			
			// bottom to top row traversal along left column
			for (int i=bottom; i>=top; i--) {
				res.get(i).set(left, count);
				count++;
			}
			left++;
		}
		
		return res;
	}

	public static void main(String[] args) {
		print2DArray(createSpiralOrderMatrix(3));
		
	}

}
