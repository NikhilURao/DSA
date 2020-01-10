package com.star_patterns;

public class hallow_rhombus_star_pattern {

	public static void main(String[] args) {
		int n=5,i,j;
		for (i=1;i<=n;i++) {
			for (j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			for (j=1;j<=n;j++) {
				if (i==1||i==n||j==1||j==n) {
				System.out.print("*");
				}
				else System.out.print(" ");
			}
			System.out.println("");
		}

	}

}
