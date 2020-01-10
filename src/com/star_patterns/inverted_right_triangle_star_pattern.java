package com.star_patterns;

public class inverted_right_triangle_star_pattern {

	public static void main(String[] args) {
		int n=5,i,j;
		for (i=1;i<=n;i++) {
			for (j=0;j<=n-i;j++) {
				System.out.print("*");
			}
			System.out.println("");
		}

	}

}
