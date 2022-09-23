/*
 * NGR - Nearest/Next Smaller Element to the Right
 * 
 * Given an array, print the Next Smaller Element (NGE) for every element. 
 * The Next greater Element for an element x is the first greater element on the right side of x in array. 
 * Elements for which no greater element exist, consider next greater element as -1.
 * 
 */
package com.stack;

import java.util.Arrays;
import java.util.Stack;

public class NSR {
	
	public static int [] getNSR(int arr[]) { 
		
		int n = arr.length;
		if (n==0) return arr;
		
		int res[] = new int[n];
		Arrays.fill(res, 0);
		Stack<Integer> st = new Stack<>();
		
		for (int i=n-1; i>=0; i--) {
			while (!st.isEmpty() && st.peek()>=arr[i]) {
				st.pop();
			}
			if (st.isEmpty()) {
				res[i] = -1;
				st.push(arr[i]);
				continue;
			}
			res[i] = st.peek();
			st.push(arr[i]);
		}
		
		return res;
	}

	public static void main(String[] args) {
		int [] arr = new int []{1,0,9,2,4,3,7};
		int [] nsr = getNSR(arr);
		
		for (int i=0; i<=nsr.length -1 ; i++) {
			System.out.print(nsr[i]+" ");
		}
	}

}
