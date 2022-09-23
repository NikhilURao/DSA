/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

Note that division between two integers should truncate toward zero.

It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.

 

Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 

Constraints:

1 <= tokens.length <= 104
tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].


SOLUTION:

Intuition
It requires a lot of set-up code, and in practice requires more space than the elegant Stack approach we're going to look at now.

We don't want to repeatedly delete items from the middle of a list, as this inevitably leads to O(n^2)O(n 
2) time performance. So recall that the above algorithm scanned through the list from left to right, and each time it reached an operator, it'd replace the operator and the 2 numbers immediately before it with the result of applying the operator to the 2 numbers.

The two key steps of the above algorithm were:

Visit each operator, in linear order. Finding these can be done with a linear search of the original list.
Get the 2 most recently seen numbers that haven't yet been replaced. These could be tracked using a Stack.

Complexity Analysis

Let nn be the length of the list.

Time Complexity : O(n)O(n).

We do a linear search to put all numbers on the stack, and process all operators. Processing an operator requires removing 2 numbers off the stack and replacing them with a single number, which is an O(1)O(1) operation. Therefore, the total cost is proportional to the length of the input array. Unlike before, we're no longer doing expensive deletes from the middle of an Array or List.

Space Complexity : O(n)O(n).

In the worst case, the stack will have all the numbers on it at the same time. This is never more than half the length of the input array.



 */
package google.interview.leetcode;

import java.util.Stack;


public class EvaluateReversePolishNotation {
	
	public static int evalRPN(String[] tokens) {
		
		int resSoFar = 0;
		Stack<Integer> operands = new Stack<Integer>();
        
		int tokensLen = tokens.length;
        if (tokensLen > 1) {
        	for (int i=0; i<tokensLen; i++) {
        		String token = tokens[i];
        		if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {

                    int operand2 = operands.pop();
                    int operand1 = operands.pop();
                    
            		switch(token){
            		case "+":
            			resSoFar = operand1 + operand2;
            			break;
            		case "-":
            			resSoFar = operand1 - operand2;
            			break;
            		case "*":
            			resSoFar = operand1 * operand2;
            			break;
            		case "/":
            			resSoFar = operand1 / operand2;
            			break;
        		}
            	
            		operands.push(resSoFar);
            		
        		}
        		else {
        			operands.add(Integer.parseInt(token));
        		}
        	}
        	return operands.pop();
        }
        else if (tokensLen == 1) {
        	return Integer.parseInt(tokens[0]);
        }
        else return 0;
        
        
    }

	public static void main(String[] args) {
		String [] tokens = {"4","-2","/","2","-3","-","-"};
		System.out.println(evalRPN(tokens));

	}

}
