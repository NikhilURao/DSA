package com.star_patterns;

public class right_triangle_hallow_star_pattern {

	public static void main(String[] args) {
			int n=5,i,j;
			for (i=1;i<=n;i++) {
				for (j=1;j<=i;j++) {
					if (i==1||i==n||j==1||j==i) {
					System.out.print("*");
					}
					else System.out.print(" ");
				}
				System.out.println("");
			}

		}

	}
