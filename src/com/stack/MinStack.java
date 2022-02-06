/*
 * Min Stack

Problem Description

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

NOTE:

All the operations have to be constant time operations.
getMin() should return -1 if the stack is empty.
pop() should return nothing if the stack is empty.
top() should return -1 if the stack is empty.


Problem Constraints

1 <= Number of Function calls <= 10^7



Input Format

Functions will be called by the checker code automatically.



Output Format

Each function should return the values as defined by the problem statement.



Example Input

Input 1:

push(1)
push(2)
push(-2)
getMin()
pop()
getMin()
top()
Input 2:

getMin()
pop()
top()


Example Output

Output 1:

 -2 1 2
Output 2:

 -1 -1


Example Explanation

Explanation 1:

Let the initial stack be : []
1) push(1) : [1]
2) push(2) : [1, 2]
3) push(-2) : [1, 2, -2]
4) getMin() : Returns -2 as the minimum element in the stack is -2.
5) pop() : Return -2 as -2 is the topmost element in the stack.
6) getMin() : Returns 1 as the minimum element in stack is 1.
7) top() : Return 2 as 2 is the topmost element in the stack.
Explanation 2:

Let the initial stack be : []
1) getMin() : Returns -1 as the stack is empty.
2) pop() :  Returns nothing as the stack is empty.
3) top() : Returns -1 as the stack is empty.

 *
 *Solution 1: Using Another stack 
 *	
 */
package com.stack;

import java.util.Stack;

public class MinStack {
	
	// aSt stack to support push, pop and top operations.
	Stack<Integer> aSt = new Stack<>();
	// minSt stack to support only getMin operation.
	Stack<Integer> minSt = new Stack<>();
	
    public void push(int x) {
        // push x as is into aSt
    	aSt.push(x);
    	// push minimum of x and the peek of minSt into minSt
    	if (!minSt.isEmpty()) {
    		minSt.push(Math.min(x, minSt.peek()));
    	}
    	else
    		minSt.push(x);
    }

    public void pop() {
        // remove the element at the top of both aSt and minSt
    	if (!aSt.isEmpty()) aSt.pop();
    	if (!minSt.isEmpty()) minSt.pop();
    }

    public int top() {
    	// return the top of aSt
    	if (!aSt.isEmpty())return aSt.peek();
    	else return -1;
        
    }

    public int getMin() {
    	// return top of minSt
    	if (!minSt.isEmpty())return minSt.peek();
    	else return -1;
        
    }

	public static void main(String[] args) {
		MinStack minSt = new MinStack();
		minSt.push(1);
		minSt.push(2);
		minSt.push(-2);
		System.out.println(minSt.getMin());
		minSt.pop();
		System.out.println(minSt.getMin());
		System.out.println(minSt.top());

	}

}
