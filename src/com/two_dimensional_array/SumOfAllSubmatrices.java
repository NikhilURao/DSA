/*
 * 
 * 
Sum of all Submatrices

Problem Description
Given a 2D Matrix A of dimensions N*N, we need to return sum of all possible 
submatrices.

Problem Constraints
1 <= N <=30
0 <= A[i][j] <= 10

Input Format
Single argument representing a 2-D array A of size N x N.

Output Format
Return an integer denoting the sum of all possible submatrices in the 
given matrix.

Example Input
A = [ [1, 1]
      [1, 1] ]


Example Output
16

Example Explanation
Number of submatrices with 1 elements = 4, so sum of all 
such submatrices = 4 * 1 = 4
Number of submatrices with 2 elements = 4, so sum of all such 
submatrices = 4 * 2 = 8
Number of submatrices with 3 elements = 0
Number of submatrices with 4 elements = 1, so sum of such 
submatrix = 4
Total Sum = 4+8+4 = 16


Simple Solution: A naive solution is to generate all the possible 
submatrices and sum up all of them. 
The time complexity of this approach will be O(n6).

Efficient Solution : 

For each element of the matrix, let us try to find the 
number of sub-matrices, the element will lie in. 
This can be done in O(1) time. Let us suppose the index of an element be (X, Y) in 0 based indexing, then the number of submatrices (Sx, y) for this element will be in can be given by the formula Sx, y = (X + 1) * (Y + 1) * (N – X) * (N – Y). This formula works, because we just have to choose two different positions on the matrix that will create a submatrix that envelopes the element. Thus, for each element, ‘sum’ can be updated as sum += (Sx, y) * Arrx, y.

Below is the implementation of the above approach: 

Here we need to try to solve this question in the Reverse lookup  Technique:

1) For a particular element what are the possible submatrices where this 
element will be included.

2) When we get the number of possible submatrices then we can count the 
contribution of that particular element by doing ( a[i]* total number of 
submatrices where this will be included) where a[i] = current element

3) Now Question comes how to find the number of possible submatrices for a 
particular element.

 [[1 2 3]

  [4 5 6]

  [7 8 9]]

So let’s consider the current element as 5 , so for 5 there are (X+1)*(Y+1) 
choices where co-ordinates of submatrix starting point can lie,(Top Left)




Similarly, there will be (N-X)*(N-Y) choices where the end  co-ordinates of 
that submatrix can lie (Bottom Right)

 Number of choices for Top Left = (X+1)*(Y+1)

Number of choices for Bottom Right = (N-X)*(N-Y)

Total number of choices for the current element to be included in the 
submatrix will be : (X+1)*(Y+1) * (N-X)*(N-Y)

Contribution of the current element which can be included in all the possible 
submatrices will be  = arr[X][Y] * (X+1)*(Y+1) * (N-X)*(N-Y)
where X and Y  are index of the submatrices.

Time Complexity: O(N^2)

Space Complexity: O(1)

 */
package com.two_dimensional_array;

public class SumOfAllSubmatrices {
    
	public static int getSumOfAllSubmatrices(int[][] A) {
		int sum=0;
		for (int i=0; i<A.length; i++) {
			for (int j=0; j<A.length; j++) {
				sum += ((i+1)*(j+1)*(A.length - i)*(A.length - j))*A[i][j];
			}
		}
		
		return sum;
    }

	public static void main(String[] args) {
		int [][] input = new int [2][2];
		input[0] = new int []{9,6};
		input[1] = new int []{5,4};
		
		System.out.println(getSumOfAllSubmatrices(input));
		
	}

}
