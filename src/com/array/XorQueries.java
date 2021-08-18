/*
 * Xor queries
Problem Description

You are given an array A (containing only 0 and 1) as element of N length.
Given L and R, you need to determine value of XOR of all elements from L to R (both inclusive) and number of unset bits (0's) in the given range of the array.



Problem Constraints
1<=N,Q<=100000
1<=L<=R<=N


Input Format
First argument contains the array of size N containing 0 and 1 only. 
Second argument contains a 2D array with Q rows and 2 columns, each row represent a query with 2 columns representing L and R.


Output Format
Return an 2D array of Q rows and 2 columns i.e the xor value and number of unset bits in that range respectively for each query.


Example Input
A=[1,0,0,0,1]
B=[ [2,4],
    [1,5],
    [3,5] ]


Example Output
[[0 3]
[0 3]
[1 2]]


Example Explanation
In the given case the bit sequence is of length 5 and the sequence is 1 0 0 0 1. 
For query 1 the range is (2,4), and the answer is (array[2] xor array[3] xor array[4]) = 0, and number of zeroes are 3, so output is 0 3. 
Similarly for other queries.
 */
package com.array;

public class XorQueries {

    public static int[][] solve(int[] A, int[][] B) {
        int [][] res = new int [B.length][2];
        int [] ZeroPrefixSumA = new int [A.length + 1];
        // calculate the 0 prefix sum of A 
        ZeroPrefixSumA[0] = 0;
        for (int i=1; i<ZeroPrefixSumA.length;i++){
            if (A[i-1]==0)
            	ZeroPrefixSumA[i] = ZeroPrefixSumA[i-1] + 1;
            else 
            	ZeroPrefixSumA[i] = ZeroPrefixSumA[i-1];
        }
        
        for (int j=0; j<B.length; j++){
            int [] arr = new int [2];
            int l = B[j][0];
            int r = B[j][1];
            int len = r - l + 1;
            arr[1] = ZeroPrefixSumA[r] - ZeroPrefixSumA[l-1];
            arr[0] = (len - arr[1])%2==0? 0 : 1;
            res[j] = arr;
        }
        
        return res;
    }
	public static void main(String[] args) {
		/*
		 * A=[1,0,0,0,1]
B=[ [2,4],
    [1,5],
    [3,5] ]
		 */
		int [][] B = new int [3][2];
		B[0] = new int [] {2,4};
		B[1] = new int [] {1,5};
		B[2] = new int [] {3,5};
		int [][] result = solve(new int [] {1,0,0,0,1}, B);
		
		for (int i=0; i<result.length; i++) {
			for (int j=0; j<result[i].length; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}

	}

}
