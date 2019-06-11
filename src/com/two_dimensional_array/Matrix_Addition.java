/*
 *  Matrix Addition

 * The order of the 2 Matrices should be same in order to perform addition op
 * The sum matrix also has the same order as the additive matrices
 *                 
 */

package com.two_dimensional_array;

public class Matrix_Addition {

	public static void main(String[] args) {
		//int [][] a1= new int [3][];
		int [][] a1 = {{1,2,3},{7,8,9}};//a1 of order 2*3
		int [][] a2 = {{4,5,6},{1,0,1}};//a1 of order 2*3
		int [][] sum = {{0,0,0},{0,0,0}};// resultant matrix of order 2*3
		//int [][] sum = new int [1][];
		
		
		for (int i=0;i<=1;i++) { // 0 to no of rows
			for (int j=0;j<=2;j++) { // 0 to no of columns
				//System.out.println(a1[i][j]);
				//System.out.println(a2[i][j]);
				sum[i][j] = a1[i][j] + a2[i][j];
				System.out.println(sum[i][j]);
			}
		}
		
	}

}
