package com.star_patterns;

import java.util.ArrayList;

public class mirrored_right_triangle_star_pattern {

	public static void main(String[] args) {
		int n=5,i,j;
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		for (i=0;i<n;i++) {
			for (j=0;j<n-i;j++){
				a.get(i).set(j,0);
			}
			for (j=i;j>0;j--) {
				a.get(i).set(j,j);
			}
			//System.out.println(" ");
		}
		
		for (i=1;i<n;i++) {
			for (j=0;j<n;j++){
				System.out.print(a.get(i).get(j));
			}}

	}

}
