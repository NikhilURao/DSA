/*
 * Pascal Triangle
Problem Description

Write a program to input an integer N from user and print pascal triangle up to N rows.



Problem Constraints
1 <= N <= 25



Input Format
First line is an integer N.



Output Format
N lines whose each row contains N+1 space separated integers.



Example Input
Input 1:

3
Input 2:

5


Example Output
Output 1:

1 0 0 
1 1 0 
1 2 1 
Output 2:

1 0 0 0 0
1 1 0 0 0
1 2 1 0 0
1 3 3 1 0
1 4 6 4 1 


Example Explanation
Explanation 1:

Row 1 = 1 0 0 0 0
Row 2 = 1C0 1C1 0 0 0= 1 1 0 0 0
Row 3 = 2C0 2C1 2C2 0 0= 1 2 1 0 0
Row 4 = 3C0 3C1 3C2 3C3 0= 1 3 3 1 0

 */
package com.two_dimensional_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PascalTriangle {
	
    public static ArrayList<ArrayList<Integer>> createPascalTriangle(int A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(A+1);
        for (int i=0; i<=A; i++) {
        	res.add(new ArrayList<Integer>(Collections.nCopies(A+1,0)));
        }
        for (int i=0; i<=A; i++) {
        	for (int j=0; j<=i; j++) {
        		if (j==0 || i==j) {
        			res.get(i).set(j,1);
        		}
        		else res.get(i).set(j,(res.get(i-1).get(j) + res.get(i-1).get(j-1)));
        	}
        }
        return res;
    }
    
	public static void print2DArray (ArrayList<ArrayList<Integer>> a) {
		for (int i=0; i<a.size(); i++) {
			for (int j=0; j<a.get(i).size(); j++) {
				System.out.print(a.get(i).get(j)+" ");
			}
			System.out.println(" ");
		}
	}

	public static void main(String[] args) {
		print2DArray(createPascalTriangle(2));

	}

}
