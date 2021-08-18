/*
 * 
 */
package com.two_dimensional_array;

public class SubMatrixSum {

    public static int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
    	int q = B.length;
    	int n = A.length;
    	int m = A[0].length;
    	int[] submatrix_sum = new int [q];
    	int [][] TwoDPrefixSum = new int [n][m]; // 2D Prefix Sum of A
    	
    	// row wise prefix sum of A
    	for (int i=0; i<n; i++) {
    		for (int j=0; j<m; j++) {
    			if (j==0) 
    				TwoDPrefixSum[i][j] = A[i][j];
    			else
    				TwoDPrefixSum[i][j] = A[i][j] + TwoDPrefixSum[i][j-1];
    		}
    	}
    	
    	// column wise prefix sum of row wise prefix sum of A = 2D prefix sum
    	for (int i=1; i<n; i++) {
    		for (int j=0; j<m; j++) {
    			TwoDPrefixSum[i][j] = TwoDPrefixSum[i][j] + TwoDPrefixSum[i-1][j];
    		}
    	}
    	
    	for (int i=0; i<q; i++) {
    		int b = B[i]-1; int c = C[i]-1; int d = D[i]-1; int e = E[i]-1;
    		int sum = 0;
    		if (b==0 && c==0)
    			sum = TwoDPrefixSum[d][e];
    		else if (b==0 && c!=0)
    			sum = TwoDPrefixSum[d][e] - TwoDPrefixSum[d][e-1];
    		else 
    			sum = TwoDPrefixSum[d][e] - 
    				(TwoDPrefixSum[d][c-1] + TwoDPrefixSum[b-1][e]) + 
    				TwoDPrefixSum[b-1][c-1];
    		submatrix_sum[i] = sum;
    	}
    	
    	/* print ps
    	for (int i=0; i<n; i++) {
    		for (int j=0; j<m; j++) {
    			System.out.print(TwoDPrefixSum[i][j]+" ");
    		}
    		System.out.println();
    	}*/
    	
    	
    	return submatrix_sum;
    }
    
	public static void main(String[] args) {
		int [][] a = new int [2][4];
		a[0] = new int [] {5, 17, 100, 11};
		a[1] = new int [] {0, 0, 2, 8};
		
		//a[2] = new int [] {7,8,9};
		//a[3] = new int [] {2,4,8,9};
		
		int[] res = solve(a, new int[] {1,1},  new int[] {1,4},  new int[] {2,2},  new int[] {2,4});
		
		for (int i=0; i<res.length; i++) {
			System.out.print(res[i]+" ");
		}

}
}
