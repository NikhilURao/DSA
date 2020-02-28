package com.stack;

import java.util.EmptyStackException;

public class InfixToPostfixConversion {
	
	int top = 0;
	int cap = 100;
	char [] CharArrayStack = new char[cap];
	
	public void push(char c) throws StackOverflowError
	{
		if (top == cap)
		{
			throw new StackOverflowError();
		}
		else
		{
			CharArrayStack[top] = c;
			top++;
		}
	}
	
	public char pop() throws EmptyStackException
	{
		if (top == 0)
		{
			throw new EmptyStackException();
		}
		else
		{
			char temp = CharArrayStack[top-1];
			CharArrayStack[top-1] = 0;
			top --;
			return temp;
		}
	}
	
	public char top()
	{
		return CharArrayStack[top-1];
	}
	
	public boolean isEmpty()
	{
		if (top == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void printStack()
	{
		for (int i=0; i<=cap;i++)
		{
			System.out.print(CharArrayStack[i]+" ");
		}
	}

	// Returns precedence of the operator 
	public int getPrecedence(char operator)
	{
		if (operator == '+' || operator == '-')
		{
			return 1;
		}
		else if (operator == '*' || operator == '/')
		{
			return 2;
		}
		else if (operator == '^')
		{
			return 3;
		}
		else 
			return 0;
	}
	
	// Program to Convert Infix Notation to Postfix Notation Expression
	public String convertInfixToPostfix(String exp)
	{	
		String postfix_exp = new String("");
		
		if (exp == null || exp.length()==0)
		{
			return exp;
		}
		
		for (int i=0; i<exp.length(); i++)
		{
			char c = exp.charAt(i);
			
			if(Character.isLetterOrDigit(c))
			{
				postfix_exp = postfix_exp + c; 
			}
			else if(c == '(')
			{
				push(c);
			}
			else if (c == ')')
			{
				while (!isEmpty() && top()!='(')
				{
					postfix_exp = postfix_exp + pop();
				}
				
				if (!isEmpty() && top()!='(')
				{
					System.out.println("Invalid Expression");
				}
				else 
				{
					pop();
				}
			}
			else
			{
				while(!isEmpty() && getPrecedence(c) <= getPrecedence(top()))
				{
					if (top == '(')
					{
						System.out.println("Invalid Expression");
					}
					else
					{
						postfix_exp = postfix_exp + pop();
					}
				}
				push(c);
			}
		}
		
		while (!isEmpty())
		{
			if (top == '(')
			{
				System.out.println("Invalid Expression");
			}
			else
			{
				postfix_exp = postfix_exp + pop();
			}
		}
		
		return postfix_exp;	
	}
	
	
	public static void main(String[] args) {
		
		InfixToPostfixConversion ipc = new InfixToPostfixConversion();
		String infix_exp = "";
		
		System.out.println(ipc.convertInfixToPostfix(infix_exp));

	}

}
