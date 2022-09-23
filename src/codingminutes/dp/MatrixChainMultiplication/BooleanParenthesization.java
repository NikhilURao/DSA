/*
 * 
 * 
 * Given a boolean expression with following symbols. 

Symbols
    'T' ---> true 
    'F' ---> false 
And following operators filled between symbols 

Operators
    &   ---> boolean AND
    |   ---> boolean OR
    ^   ---> boolean XOR 
Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true. 
Let the input be in form of two arrays one contains the symbols (T and F) in order and the other contains operators
 (&, | and ^}

Examples: 

Input: symbol[]    = {T, F, T}
       operator[]  = {^, &}
Output: 2
The given expression is "T ^ F & T", it evaluates true
in two ways "((T ^ F) & T)" and "(T ^ (F & T))"

Input: symbol[]    = {T, F, F}
       operator[]  = {^, |}
Output: 2
The given expression is "T ^ F | F", it evaluates true
in two ways "( (T ^ F) | F )" and "( T ^ (F | F) )". 

Input: symbol[]    = {T, T, F, T}
       operator[]  = {|, &, ^}
Output: 4
The given expression is "T | T & F ^ T", it evaluates true
in 4 ways ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) 
and (T|((T&F)^T)). 
 */

package codingminutes.dp.MatrixChainMultiplication;
import java.util.*;
public class BooleanParenthesization {
	
	public static int countWaysTrue(String s) {
		int n = s.length();
		
		if (n==0) return 0;
		// map to store key => i""+j+""isTrue
		HashMap<String, Integer> visited = new HashMap<>();
		visited.clear();
		// find i,j
		int i=0; int j=n-1;
		return countWaysRec(s, i, j, true, visited);
		
	}
	
	public static int countWaysRec(String s, int i, int j, boolean isTrue, HashMap<String, Integer> visited) {
		// base condition
		// empty string. can't convert empty string to true
		if (i>j) return 0;
		
		if (i==j) {
			if (isTrue) {
				if (s.charAt(i)=='T') {
					return 1;
				}
			}
			
			else {
				if (s.charAt(i)=='F') {
					return 1;
				}
					
			}
		}
		String key = new StringBuilder().append(i).append(" ").append(j).append(" ").append(isTrue).toString();
		
		if (visited.containsKey(key)) {
			return visited.get(key);
		}
		int ans = 0;
		
		for (int k=i+1; k<j; k=k+2) {
			
			int leftTrue = countWaysRec(s, i, k-1, true, visited);
			int leftFalse = countWaysRec(s, i, k-1, false, visited);
			int rightTrue = countWaysRec(s, k+1, j, true, visited);
			int rightFalse = countWaysRec(s, k+1, j, false, visited);
			
			if (s.charAt(k) == '&') {
				if (isTrue) {
					ans = ans + leftTrue * rightTrue;
				}
				else
					ans = ans + leftTrue * rightFalse + leftFalse * rightFalse + leftFalse * rightTrue;
			}
			
			if (s.charAt(k) == '|') {
				if (isTrue) {
					ans = ans + leftTrue * rightTrue + leftTrue * rightFalse + rightTrue * leftFalse;
				}
				else
					ans = ans + leftFalse * rightFalse;
			}
			
			if (s.charAt(k) == '^') {
				if (isTrue) {
					ans = ans + leftTrue * rightFalse + leftFalse * rightTrue;
				}
				else
					ans = ans + leftTrue * rightTrue + leftFalse * rightFalse;
			}
		}
		visited.put(key, ans);
		return ans;
				
	}

	public static void main(String[] args) {
		String expression = "T|F^F&T|F^F^F^T|T&T^T|F^T^F&F^T|T^F";
		System.out.println(countWaysTrue(expression));

	}

}
