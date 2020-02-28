package com.stack;

import java.util.EmptyStackException;

public class BalancingSymbol {
	
	// Creating a stack using array
	int top = 0;
	int cap = 10;
	char [] stackArray = new char[cap];
	
	public void push(char c) throws StackOverflowError
	{
		if (top == cap)
		{
			throw new StackOverflowError();
		}
		else
		{
			stackArray[top] = c;
			top++;
		}
	}
	
	public void pop() throws EmptyStackException
	{
		if (top == 0)
		{
			throw new EmptyStackException();
		}
		else
		{
			char c_out = stackArray[top];
			stackArray[top] = 0;
			top--;
			//System.out.println(c_out);
			
		}
	}
	
	public char top()
	{
		return stackArray[top-1];
	}
	
	public boolean isEmpty()
	{
		if (top == 0)
		{
			return true;
		}
		
		return false;
	}
	
	public boolean isValidSymbolPatter(String s)
	{
		System.out.println(s);
		if (s.length() == 0 || s == null)
		{
			return true;
		}
		
		for (int i=0; i< s.length();i++) // for each character in the string s 
		{
			if (s.charAt(i)==')')
			{
				if (!isEmpty() && top() == '(')
				{
					pop();
				}
				else
				{
					return false;
				}
					
			}
			else if (s.charAt(i)=='}')
			{
				if (!isEmpty() && top() == '{')
				{
					pop();
				}
				else
				{
					return false;
				}
			}
			else if (s.charAt(i)==']')
			{
				if (!isEmpty() && top() == '[')
				{
					pop();
				}
				else 
				{
					return false;
				}
			}
			
			else 
			{
				push(s.charAt(i));
			}
				
		}
		
		if (isEmpty())
		{
			return true;
		}
			
		else 
		{
			return false;
		}
			
	}
 	
	public static void main(String[] args) {
		BalancingSymbol bsl = new BalancingSymbol();
		System.out.println(bsl.isValidSymbolPatter("()(()[{])"));

	}

}
