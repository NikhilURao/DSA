/*
 * Multiple left rotations of the array
Problem Description

Given an array of integers A and multiple values in B which represents number of times array A needs to be left
rotated.

Find the rotated array for each value and return the result in the from of a matrix where i'th row represents 
the rotated array for the i'th value in B.



Problem Constraints
1 <= length of both arrays <= 2000 -10^9 <= A[i] <= 10^9 0 <= B[i] <= 2000


Input Format
The first argument given is the integer array A.
The second argument given is the integer array B.


Output Format
Return the resultant matrix.


Example Input
Input 1:
 
    A = [1, 2, 3, 4, 5]
    B = [2, 3]

Input 2:

  
    A = [5, 17, 100, 11]
    B = [1]




Example Output
Output 1:
 
    [ [3, 4, 5, 1, 2]
     [4, 5, 1, 2, 3] ]


Output 2:

    
    [ [17, 100, 11, 5] ]



Example Explanation
for input 1 -> B[0] = 2 which requires 2 times left rotations

1: [2, 3, 4, 5, 1]

2: [3, 4, 5, 1, 2]

B[1] = 3 which requires 3 times left rotation

1: [2, 3, 4, 5, 1]

2: [3, 4, 5, 1, 2]

2: [4, 5, 1, 2, 4]
 */
package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LeftRotateArray {
	
	public static ArrayList<Integer> reverseArray(ArrayList<Integer> arr){
		if (arr.size()>0) {
			int size = arr.size()-1;
			ArrayList<Integer> rev= new ArrayList<>
			(Arrays.asList(new Integer[size+1]));
			Collections.fill(rev, 0);
			for (int i=arr.size()-1; i>=0; i--) {
				rev.set((size - i), arr.get(i));
			}
			
			return rev;
		}
		else return new ArrayList<Integer>();
		
	}
    
    public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	for (int i=0; i<B.size();i++) {
    		res.add(new ArrayList<Integer>(A.size()));
    	}
        Collections.fill(res, new ArrayList<Integer>());
        
        
        for(int j=0; j<B.size(); j++){
            int k = B.get(j)%(A.size());
            int b = A.size()-k;
            ArrayList<Integer> rev = reverseArray(A);
            ArrayList<Integer> k1 = new ArrayList<Integer>(Arrays.asList(new Integer[b]));
			Collections.fill(k1, 0);
			ArrayList<Integer> k2 = new ArrayList<Integer>(Arrays.asList(new Integer[rev.size()-b]));
			Collections.fill(k2, 0);
			for (int i=0; i<b; i++) {
				k1.set(i,rev.get(i));
			}
			ArrayList<Integer> k1rev = reverseArray(k1);
			for (int i=b; i<rev.size(); i++) {
				k2.set(i-b,rev.get(i));
			}
			ArrayList<Integer> k2rev = reverseArray(k2);
			
			ArrayList<Integer> b_rotated_array = new ArrayList<Integer>(Arrays.asList(new Integer [A.size()]));
			
			for (int i=0; i<k1rev.size();i++) {
				b_rotated_array.set(i,k1rev.get(i));
			}
			for (int i=0; i<k2rev.size();i++) {
				b_rotated_array.set(i+b,k2rev.get(i));
			}
			res.set(j,b_rotated_array);
        }
    
        return res;
    }

	public static void main(String[] args) {
		LeftRotateArray lra = new LeftRotateArray();
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(2,3));
		ArrayList<ArrayList<Integer>> out = lra.solve(A,B);
		
		for (int i=0; i<out.size(); i++) { 
			for (int j=0; j<out.get(i).size();j++) {
				System.out.print(out.get(i).get(j)+" ");
			}
			System.out.println("");
		}

	}

}
