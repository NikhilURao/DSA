package com.stack;

public class ArrayStack 
{
	int cap = 10;
	int [] arr = new int [cap];
	int top = 0;

	public void push(int data)
	{
		if (top == cap)
		{
			System.out.println("Stack Overflow");
		}
		else
		{
			arr[top] = data;
			top ++;	
		}
	}
	
	public int pop()
	{
		if (top == 0)
		{
			System.out.println("Stack Underflow");
			return 0;
		}
		else 
		{
			int temp = arr[top];
			arr[top] = 0;
			top--;
			return temp;
			
			
			
		}
	}
	
	public void print() 
	{
	for(int i=0; i< top;i++)
	{
		System.out.print(arr[i]+" ");
	}
	}
	public static void main(String[] args) 
	{
		ArrayStack as = new ArrayStack();
		as.push(10);
		as.push(20);
		as.push(33);
		as.push(44);
		as.print();
		System.out.println();
		as.pop();
		as.print();
		System.out.println();
		as.pop();
		as.print();
		System.out.println();
		as.pop();
		as.print();
		System.out.println();
		as.pop();
		as.print();
		System.out.println();
		as.pop();
		as.print();

	}

}
