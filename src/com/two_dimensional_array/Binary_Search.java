package com.two_dimensional_array;
import java.util.Scanner;

public class Binary_Search {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the order of the matrix");
		int n = input.nextInt();
		int [][] a = new int [n][n];
		
		System.out.println("Enter the elements of the Matrix");
		for (int i=0;i<=n;i++) {
			
			for (int j=0;j<=n;j++) {
				
				a[i][j] = input.nextInt();
				
			}
		}
		int start=0,end=n-1;
		int mid = (start + end)/2;
		
		for (int i=0;i<=n-1;i++) {
			
			
			
			
		}
		

	}

}
