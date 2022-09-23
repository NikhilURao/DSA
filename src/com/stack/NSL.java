/*
 * NGL Nearest/Next Smaller to left using stacks
 * Given an array of integers, find the closest (not considering distance, but value) greater on left of every 
 * element. If an element has no greater on the left side, print -1 
 * 
 */
package com.stack;

import java.util.Arrays;
import java.util.Stack;

public class NSL {
	
	public static int [] getNSL(int arr[]) { 
		
		int n = arr.length;
		if (n==0) return arr;
		
		int res[] = new int[n];
		Arrays.fill(res, 0);
		Stack<Integer> st = new Stack<>();
		
		for (int i=0; i<n; i++) {
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
		int [] nsl = getNSL(arr);
		
		for (int i=0; i<=nsl.length -1 ; i++) {
			System.out.print(nsl[i]+" ");
		}
	}

}
