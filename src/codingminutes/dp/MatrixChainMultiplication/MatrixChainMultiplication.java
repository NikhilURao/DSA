/*
 * 
 * Matrix Chain Multiplication
 * 
 * Given a sequence of matrices, find the most efficient way to multiply these matrices together. 
 * The problem is not actually to perform the multiplications, but merely to decide in which order to perform 
 * the multiplications.
 * We have many options to multiply a chain of matrices because matrix multiplication is associative. 
 * In other words, no matter how we parenthesize the product, the result will be the same. 
 * For example, if we had four matrices A, B, C, and D, we would have: 
 * (ABC)D = (AB)(CD) = A(BCD) = .... 
 * However, the order in which we parenthesize the product affects the number of simple arithmetic operations 
 * needed to compute the product, or the efficiency. For example, suppose A is a 10 × 30 matrix, 
 * B is a 30 × 5 matrix, and C is a 5 × 60 matrix. Then,  
 * (AB)C = (10×30×5) + (10×5×60) = 1500 + 3000 = 4500 operations
 * A(BC) = (30×5×60) + (10×30×60) = 9000 + 18000 = 27000 operations.
 * 
 * Clearly the first parenthesization requires less number of operations.
 * 
 * Given an array p[] which represents the chain of matrices such that the ith matrix Ai is of dimension p[i-1] x p[i]. We need to write a function MatrixChainOrder() that should return the minimum number of multiplications needed to multiply the chain. 

Input: p[] = {40, 20, 30, 10, 30}   
Output: 26000  
There are 4 matrices of dimensions 40x20, 20x30, 30x10 and 10x30.
Let the input 4 matrices be A, B, C and D.  The minimum number of 
multiplications are obtained by putting parenthesis in following way
(A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30

Input: p[] = {10, 20, 30, 40, 30} 
Output: 30000 
There are 4 matrices of dimensions 10x20, 20x30, 30x40 and 40x30. 
Let the input 4 matrices be A, B, C and D.  The minimum number of 
multiplications are obtained by putting parenthesis in following way
((AB)C)D --> 10*20*30 + 10*30*40 + 10*40*30

Input: p[] = {10, 20, 30}  
Output: 6000  
There are only two matrices of dimensions 10x20 and 20x30. So there 
is only one way to multiply the matrices, cost of which is 10*20*30
 * 
 */


package codingminutes.dp.MatrixChainMultiplication;

import java.util.Arrays;

public class MatrixChainMultiplication {
	
	// Solution 1: Brute Force Recursion
	public static int mcm(int [] p) {
		int n = p.length;
		if (n==0 || n==1) return 0;
		// Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
		// find i and j
		int i=1; int j= n-1;
		
		return mcmRecursive(p, i, j);
		
		
	}
	
	public static int mcmRecursive(int [] p, int i, int j) {
		int n = p.length;
		
		int min = Integer.MAX_VALUE;
		
		if (i>=j) return 0;

        // place parenthesis at different places between
        // first and last matrix, recursively calculate
        // count of multiplications for each parenthesis
        // placement and return the minimum count
		for (int k=i; k<j; k++) {
			int temp = mcmRecursive(p, i, k) + mcmRecursive(p, k+1, j) +
					p[i-1] * p[k] * p[j];
			
			min = Math.min(min, temp);
		}

		return min;
		
	}
	
	
	// Solution 2: Recursion + Memoization = Top-Down DP
	/**
	 * Time Complexity: O(n3 )
	 * 
	 * Space Complexity: Auxiliary Space: O(n2) ignoring recursion stack space
	 * 
	 */
	public static int mcmTopDown(int [] p) {
		int n = p.length;
		if (n==0 || n==1) return 0;
		
		// find i and j
		int i=1; int j= n-1;
		
		// dp table 
		int dp[][] = new int[i+1][j+1];
		for (int l=0; l<n+1; l++) {
			int [] temp = new int [n+1];
			Arrays.fill(temp, -1);
			dp[i] = temp;
		}
		
		return mcmTopDownRecursive(p, i, j, dp);
		
		
	}
	
	public static int mcmTopDownRecursive(int [] p, int i, int j, int dp[][]) {
		int n = p.length;
		
		int min = Integer.MAX_VALUE;
		
		if (i>=j) return 0;
		
		if (dp[i][j] != -1) return dp[i][j];

		for (int k=i; k<j; k++) {
			int temp = mcmRecursive(p, i, k) + mcmRecursive(p, k+1, j) +
					p[i-1] * p[k] * p[j];
			
			min = Math.min(min, temp);
		}

		return dp[i][j] = min;
		
	}
	

	// Solution 3: Bottom-Up DP
    static int mcmBottomUp(int p[]){
    	
    	int n = p.length;
    	
        /* For simplicity of the
        program, one extra row and
        one extra column are allocated in m[][].  0th row
        and 0th column of m[][] are not used */
        int m[][] = new int[n][n];
 
        int i, j, k, L, q;
 
        /* m[i, j] = Minimum number of scalar
        multiplications needed to compute the matrix
        A[i]A[i+1]...A[j] = A[i..j] where
        dimension of A[i] is p[i-1] x p[i] */
 
        // cost is zero when multiplying one matrix.
        for (i = 1; i < n; i++)
            m[i][i] = 0;
 
        // L is chain length.
        for (L = 2; L < n; L++)
        {
            for (i = 1; i < n - L + 1; i++)
            {
                j = i + L - 1;
                if (j == n)
                    continue;
                m[i][j] = Integer.MAX_VALUE;
                for (k = i; k <= j - 1; k++)
                {
                    // q = cost/scalar multiplications
                    q = m[i][k] + m[k + 1][j]
                        + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }
 
        return m[1][n - 1];
    }
	
	public static void main(String[] args) {
		
		int p[] = {10, 30, 5, 60};
		System.out.println("min cost of matrix multiplications: "+mcm(p));
		System.out.println("min cost of matrix multiplications: "+mcmTopDown(p));
		System.out.println("min cost of matrix multiplications: "+mcmBottomUp(p));

	}

}
