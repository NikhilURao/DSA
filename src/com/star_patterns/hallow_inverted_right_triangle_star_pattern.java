package com.star_patterns;

public class hallow_inverted_right_triangle_star_pattern {

	public static void main(String[] args) {
		int n=5,i,j;
		for (i=1;i<=n;i++) {
			for (j=0;j<=n-i;j++) {
				if (i==1||i==n||j==0||j==n-i) {
					System.out.print("*");	
				}
				else System.out.print(" ");
			}
			System.out.println("");
		}

	}
}
