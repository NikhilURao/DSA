/*
 * Given an array of size N. Find the next greater element to the right for all elements in the array.
 * Next greater element to the right of an element x is defined as the first element to the right of x which
 * having value greater than x. If no such element is present satisfying the above condition then -1.
 * 
 * Example: A[2,5,9,3,1,12,6,8,7]
 * NGETR array => [5,9,12,12,12,-1,8,-1,-1]
 * 
 * Solution:
 * 
 * Brute Force Approach: For each element i in the array (i-> 0 to len-1), iterate the array to the right of
 * the current element till you find an element greater than i.
 * TC=> O(n^2)
 * 
 * Optimized Approach using stack:
 * 1) Iterate from A.len-1 index position. NGETR of last array element i.e. A[len-1] is always -1 
 * since there are no elements to the right of it. Push the last element into a stack(LIFO)
 * 2) For every element in the array, pop all elements in the stack that are less than the current element
 * until we find an element which is greater than the current element in the stack or till the stack becomes
 * empty.
 * 3) If at any point the stack becomes empty then the NGETR of the current element is -1. add to result array
 * 4) else if the stack is not empty then the NGETR is at the peek position of the stack. add to result array
 * 5) Push the current element into the stack.
 * 
 *  TC => O(2n) => O(n)
 *  SC => O(n)
 * 
 */
package com.array;

import java.util.*;

public class NextGreaterElementToRight {

	public static int [] getNextGreaterElementToRight_UsingSrtack(int [] A) {
		
		int [] resNGETR = new int [A.length]; // to store the NGETR of each element in A
		resNGETR[A.length - 1] = -1; // NGTER of last element of array A is always -1
		Stack<Integer> stack = new Stack(); 
		stack.push(A[A.length-1]);
		
		for (int i=A.length -2; i>=0; i--) {
			// pop all elements in the stack which are smaller than the current element in the array 
			// pop elements in the stack until stack is empty or the peek element in greater than or equal to the current element 
			while (!stack.isEmpty() && stack.peek() < A[i]) {
				stack.pop();
			}
			
			// if stack is empty then the NGETR for the current element is -1
			if (stack.isEmpty())
				resNGETR[i] = -1;
			// else NGETR is the peek element in the stack(element to the right and greater than the current element)
			else resNGETR[i] = stack.peek();
			
			// push current element to the stack
			stack.push(A[i]);
		}
		
		return resNGETR;
	}
	public static void main(String[] args) {
		int [] ngetr = getNextGreaterElementToRight_UsingSrtack(new int [] {2,5,9,3,1,12,6,8,7});
		for (int i=0; i<ngetr.length; i++) {
			System.out.print(ngetr[i]+" ");
		}
		

	}

}
