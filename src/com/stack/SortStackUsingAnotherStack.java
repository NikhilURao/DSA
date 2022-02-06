/*
 * Sort stack using another stack

Problem Description

Given a stack of integers A, sort it using another stack.

Given a stack of integers, sort it in ascending order using another temporary stack.

Return the array of integers after sorting the stack using another stack.



Problem Constraints

1 <= |A| <= 5000

0 <= A[i] <= 1000000000



Input Format

The only argument given is the integer array A.



Output Format

Return the array of integers after sorting the stack using another stack.



Example Input

Input 1:

 A = [5, 4, 3, 2, 1]
Input 2:

 A = [5, 17, 100, 11]


Example Output

Output 1:

 [1, 2, 3, 4, 5]
Output 2:

 [5, 11, 17, 100]


Example Explanation

Explanation 1:

 Just sort the given numbers.
Explanation 2:

 Just sort the given numbers.
 
 
 * Solution Approach
1. Create a temporary stack i.e. helperSt.

2. While input stack is not empty do the following:
	a. pop an element from input stack calls it x.
	b. if x > the peek of helperSt then simply push x into helperSt
	c. while the temporary stack is not empty and top of the temporary stack is greater than x 
	pop from the temporary stack and push it into input stack.
	c. push x in the temporary stack.

The sorted numbers are in the temporary stack.

******************************************
* TC=> O(n^2) | SC=> O(n) for temp stack
******************************************

 *
 
 
 */
package com.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class SortStackUsingAnotherStack {
	
	public static ArrayList<Integer> sortStack(ArrayList<Integer> A) {
        
		// prep input stack from input list
        Stack<Integer> ipSt = new Stack<>();
        for (int i=0; i<A.size(); i++){
            ipSt.push(A.get(i));
        }
        // aux helper stack
        Stack<Integer> helperSt = new Stack<>();

        while (!ipSt.isEmpty()){
            int element = ipSt.peek();
            ipSt.pop();

            if (helperSt.isEmpty() || element >= helperSt.peek()){
                helperSt.push(element);
            }
            else{
                while( !helperSt.isEmpty() && element < helperSt.peek()){
                    ipSt.push(helperSt.peek());
                    helperSt.pop();
                }
                helperSt.push(element);
            }
        }

        // copy elements from helper to ipSt
        while (!helperSt.isEmpty()){
            ipSt.push(helperSt.peek());
            helperSt.pop();
        }

        // pre output list from ipSt
        for (int i=0; i<A.size(); i++){
            A.set(i, ipSt.peek());
            ipSt.pop();
        }
        
        return A;


    }

	public static void main(String[] args) {
		ArrayList<Integer> op = sortStack(new ArrayList<Integer>(Arrays.asList(5,-1,1,3,2)));
		op.forEach(t-> System.out.print(t+" "));

	}

}
