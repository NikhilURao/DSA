package com.star_patterns;

public class mirrored_right_triangle_star_pattern {

	public static void main(String[] args) {
		int n=5,i,j;
		for (i=1;i<=n;i++) {
			for (j=1;j<=n-i;j++){
				System.out.print(" ");
			}
			for (j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println(" ");
		}

	}

}
