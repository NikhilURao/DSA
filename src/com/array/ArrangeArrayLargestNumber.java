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
Given two numbers X and Y, which number to put first – 
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
		
		ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(121, 839, 643, 713, 837, 39, 273, 130, 400, 864, 415, 2, 19, 291, 117, 812, 617, 185, 160, 597, 542, 555, 231, 49, 600, 543, 233, 847, 350, 392, 572, 592, 415, 282, 190, 608, 501, 491, 880, 579, 47, 258, 977, 593, 282, 491, 77, 532, 987, 309, 999, 740, 735, 322, 823, 149, 514, 874, 558, 7, 178, 964, 38, 227, 927, 299, 262, 914, 622, 675, 490, 355, 154, 392, 957, 703, 217, 648, 758, 456, 433, 119, 784, 563, 876, 700, 851, 698, 126, 406, 266, 150, 746, 883, 369, 859, 717, 848, 160, 98, 869, 58, 792, 172, 80, 974, 522, 738, 159, 407, 917, 397, 458, 687, 838, 506, 83, 116, 967, 779, 698, 877, 739, 321, 573, 257, 716, 413, 57, 135, 342, 860, 17, 820, 675, 182, 752, 674, 62, 43, 127, 412, 663, 81, 494, 399, 586, 48, 78, 498, 802, 201, 164, 332, 371, 540, 677, 754, 321, 195, 952, 334, 801, 628, 486, 455, 520, 164, 259, 616, 326, 339, 202, 711, 62, 443, 696, 633, 591, 507, 26, 853, 402, 359, 363, 177, 489, 484, 537, 630, 381, 253, 184, 438, 925, 635, 219, 168, 880, 2, 65, 253, 923, 30, 775, 206, 382, 436, 844, 904, 556, 144, 329));
		// 51, 6, 10, 8, 22, 61, 56, 48, 88, 85, 21, 98, 81, 76, 71, 68, 18, 6, 14, 23, 72, 18, 56, 30, 97, 100, 81, 5, 99, 2, 85, 67, 46, 32, 66, 51, 76, 53, 36, 31, 81, 56, 26, 75, 69, 54, 54, 54, 83, 41, 86, 48, 7, 32, 85, 23, 47, 23, 18, 45, 79, 95, 73, 15, 55, 16, 66, 73, 13, 85, 14, 80, 39, 92, 66, 20, 22, 25, 34, 14, 51, 14, 17, 10, 100, 35, 9, 83, 31, 60, 24, 37, 69, 62
		System.out.println(solve(array));
		for (int i=0; i<array.size();i++){
			System.out.print(array.get(i)+" ");
		}
		//System.out.println(largestNumber(array));
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
