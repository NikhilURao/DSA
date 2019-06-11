/** Display the elements of the given Matrix in ZigZag Order
 * 
 * 	a00	a01	a02
 *  b00	b01	b02     => O/P : a00 a01 a02 b02 b01 b00 c00 c01 c02
 *  c00	c01	c02
 * 
 */


package com.two_dimensional_array;

import java.util.Scanner;

public class Matrix_Elements_Display_1 {

	public static void main(String[] args) {
//Take input of the base and elements of the matrix from user
	int n;
	Scanner input = new Scanner (System.in);
	System.out.println("Enter the base of the matrix");
	n = input.nextInt();
	int [][] a = new int [n][n];
	System.out.println("Enter the elements of the matrix row wise");
	for (int i=0;i<n;i++) {
		
		for (int j=0;j<n;j++) {
			
			a[i][j] = input.nextInt();
		}
	}input.close();
// Logic is that if the row is even then print in proper order 
// else if row is odd then print in reversed order
for (int i=0;i<=n-1;i++) {
	if (i%2 ==0) { //checking if the row is even
		for (int j=0;j<=n-1;j++) {
			System.out.println(a[i][j]);// when even, printing in correct order
		}}
		else {
			for (int j=n-1;j>=0;j--) {
			System.out.println(a[i][j]);//when odd, prinitng in reversed order
			
			}
		}
	}
}
	



}
