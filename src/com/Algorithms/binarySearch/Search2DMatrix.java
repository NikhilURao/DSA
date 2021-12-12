package com.Algorithms.binarySearch;

public class Search2DMatrix {
	
    public static int searchMatrix(int[][] A, int B) {
        // start with the top right element
        int row = 0;
        int col = A[0].length - 1;
        
        while (row <= A.length-1 && col >= 0){
            if (A[row][col] == B)
                return 1;
            else if (A[row][col] < B) // if the element at index (row, col) < B, then row++ i.e eliminate the entire row and move one row down 
                row++;
            else // if the element at index (row, col) > B, then col-- i.e eliminate the entire column and move one column left
                col--;
        }
        
        return 0;
    }

	public static void main(String[] args) {
		int [][] arr = new int [3][4];
		arr[0] = new int [] {1, 3, 5, 7};
		arr[1] = new int [] {10, 11, 16, 20};
		arr[2] = new int [] {23, 30, 34, 50};
		System.out.println(searchMatrix(arr, 3));

	}

}
