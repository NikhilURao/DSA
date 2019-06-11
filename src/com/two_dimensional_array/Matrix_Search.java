/** Search for an element in row wise and column wise sorted 2D array.


 * 
 * Approach 1 : Linear Search 
 * Time Complexity : Order of Squared n... O(n^2)
 * 
 * Approach 2 : Binary Search row wise or column wise
 * Time Complexity : O(m x logn)
 * 
 * Approach 3 : Start with the index 0 x nth column or mth row x 0
 * if the element in the index is > key --> j--
 * if the element in the index is < key --> i++
 * Boundary Condition : j>=0 and i<= no of rows -1
 **/
/*
 * Time Complexity : Order of n O(n)
 */
package com.two_dimensional_array;
import java.util.Scanner;

public class Matrix_Search {

	public static void main(String[] args) {
//Take input of the base and elements of the matrix from user
		int n,key;
		Scanner input = new Scanner (System.in);
		System.out.println("Enter the base of the matrix");
		n = input.nextInt();
		int [][] a = new int [n][n];
		System.out.println("Enter the elements of the matrix row wise");
		for (int i=0;i<n;i++) {
			
			for (int j=0;j<n;j++) {
				
				a[i][j] = input.nextInt();
			}
		}
		
//Take input of the key that is supposed to be searched in the given matrix		
		System.out.println("Enter the Key to be searched in the matrix");
		key = input.nextInt();
		input.close();
//Search Logic starts from here :
int j=n-1;
int i=0;

		while (j>=0 && i<= n-1) {
					if (a[i][j] == key) {
						//flag = true;
						System.out.println("Key found at ("+i+","+j+")");
						return;
						}
					else if (a[i][j] < key ) { 
						i++;
						}
					else if (a[i][j] > key) {
						
						j--;
					}		
		}
		System.out.println("Key not found");
		
		}
}
