/**
 * Matrix Multiplication
 *  Consider 2 matrices a and b of order m x n i.e. 2x3 and n x p i.e. 3x2 respectively
 *  The resultant matrix of the order m x p i.e. 2x2
 **/  
/* Time Complexity : order of mxnxp i.e. O(mxnxp)... 
 * If m=n=p O(n Cube)
 */


package com.two_dimensional_array;

public class Matrix_Multiplication {

	public static void main(String[] args) {
		int [][] a = {{1,2,3},{4,5,6}}; //order of mxn 2*3
		int [][] b = {{7,8},{8,9},{9,10}};// order nxp 3*2
		int [][] c = {{0,0},{0,0}};// product of order mxp 2*2
		
		for (int i=0;i<2;i++) {// 0 to m-1
			
			for (int j=0;j<2;j++) {// 0 to p-1 
				
				for (int k=0;k<3;k++) {// 0 to n-1
					
					c[i][j] = c[i][j] + (a[i][k] * b[k][j]);
				
				}System.out.println(c[i][j]);
			}
		}
	}
}


