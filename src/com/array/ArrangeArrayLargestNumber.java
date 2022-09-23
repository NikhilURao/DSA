/*
 * Largest Number
Problem Description

Given a array A of non negative integers, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.



Problem Constraints
1 <= len(A) <= 100000
0 <= A[i] <= 2*109



Input Format
First argument is an array of integers.



Output Format
Return a string representing the largest number.



Example Input
Input 1:

 A = [3, 30, 34, 5, 9]
Input 2:

 A = [2, 3, 9, 0]


Example Output
Output 1:

 "9534330"
Output 2:

 "9320"


Example Explanation
Explanation 1:

 A = [3, 30, 34, 5, 9]
 Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
Explanation 2:

 Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320. 
 
Solution Approach:
Given two numbers X and Y, which number to put first � 
we compare two numbers XY (Y appended at the end of X) and 
YX (X appended at the end of Y). If XY is larger, 
then X should come before Y in output, 
else Y should come before. For example, 
let X and Y be 542 and 60. To compare X and Y, 
we compare 54260 and 60542. Since 60542 is greater than 54260, 
we put Y first.

X, Y XY>YX then XY else YX

 */
package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ArrangeArrayLargestNumber {
	
    public static String largestNumber(final List<Integer> A) {

    	String largestNum = ""; boolean allZeros = true; 
    	
    	Collections.sort(A, new Comparator<Integer>()
        {

			@Override
			public int compare(Integer arg0, Integer arg1) {
				
				return (String.valueOf(arg0)+String.valueOf(arg1))
						.compareTo(String.valueOf(arg1)+String.valueOf(arg0))>0?
								-1:1;
			}});
        
            for (int i=0; i<A.size(); i++) {
        	largestNum += A.get(i);
        	if (A.get(i)!=0) allZeros = false;
        }
        	
        
        return allZeros? "0" : largestNum;

    }
    
    public static int solve(ArrayList<Integer> A) {
        int count=0;
        Collections.sort(A);
        /*
        System.out.println("Sorted Array ");
		for (int i=0; i<A.size();i++){
			System.out.print(A.get(i)+" ");
		}
		System.out.println("");*/
        for (int i=1; i<A.size();i++){
        	int prev = A.get(i-1);
        	int cur = A.get(i);
        	//if (i==59) 
        		//System.out.println("59");
        	if (prev==cur){
                A.set(i, cur+1);
                count++;
            }
        	if (prev>cur) {
        		count += (prev-cur) + 1 ;
        		A.set(i, cur+((prev-cur) + 1));
        	}
        }
        return count;
    }

	public static void main(String[] args) {
		
		ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(3, 30, 34, 5, 9));
		// 51, 6, 10, 8, 22, 61, 56, 48, 88, 85, 21, 98, 81, 76, 71, 68, 18, 6, 14, 23, 72, 18, 56, 30, 97, 100, 81, 5, 99, 2, 85, 67, 46, 32, 66, 51, 76, 53, 36, 31, 81, 56, 26, 75, 69, 54, 54, 54, 83, 41, 86, 48, 7, 32, 85, 23, 47, 23, 18, 45, 79, 95, 73, 15, 55, 16, 66, 73, 13, 85, 14, 80, 39, 92, 66, 20, 22, 25, 34, 14, 51, 14, 17, 10, 100, 35, 9, 83, 31, 60, 24, 37, 69, 62
		System.out.println(solve(array));
//		for (int i=0; i<array.size();i++){
//			System.out.print(array.get(i)+" ");
//		}
		System.out.println(largestNumber(array));
		//System.out.println(largestNumber(array));
		/*
		String num = ""; int i=999999; int j=9999; boolean flg=false;
		//System.out.println(String.valueOf(num).length());
		Long x = Long.parseLong(String.valueOf(i)+String.valueOf(j)) ;
		Long y = Long.valueOf(String.valueOf(j)+String.valueOf(i));
		if (x> y) {
			flg=true;
		}
		String ij = "9999999999";
		String ji = "999999999999999995";
		System.out.println(ij.compareTo(ji));
		System.out.println(flg);
		System.out.println(num);
		num = "";
		System.out.println(num);
		num="999999";
		System.out.println(num);*/
		

	}

}
