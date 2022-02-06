/*
 * The Stack is a linear data structure, which follows a particular order in which the operations are performed. The order may be LIFO(Last In First Out) or FILO(First In Last Out).
The LIFO order says that the element which is inserted at the last in the Stack will be the first one to be removed. In LIFO order, the insertion takes place at the rear end of the stack and deletion occurs at the front of the stack.
The FILO order says that the element which is inserted at the first in the Stack will be the last one to be removed. In FILO order, the insertion takes place at the rear end of the stack and deletion occurs at the front of the stack.

Mainly, the following three basic operations are performed in the stack:
Push: Adds an item in the stack. If the stack is full, then it is said to be an Overflow condition.
Pop: Removes an item from the stack. The items are popped in the reversed order in which they were pushed. If the stack is empty, then it is said to be an Underflow condition.
Peek or Top: Returns the top element of the stack.

isEmpty: Returns true if the stack is empty, else false.
 */
package com.stack;

import java.util.Stack;

public class Theory {
	/*
	 * Implementation: There are two ways to implement a stack.
	 * Using array
	 * Using linked list
	 */
	/*
	 * Implementing Stack using Arrays
	 * @ArrayStack
	 * Pros: Easy to implement. Memory is saved as pointers are not involved.
	 * Cons: It is not dynamic. It doesn’t grow or shrink depending on needs at runtime.
	 */
	/*
	 * Implementing Stack using Linked List
	 * @LinkedStack
	 * Pros: The linked list implementation of stack can either grow or shrink according to the needs at runtime.
     * Cons: Requires extra memory due to involvement of pointers.
	 */
	/*
	 * Java Collection framework provides a Stack class which models and implements the Stack data structure. 
	 * basic principle of last-in-first-out. In addition to the basic push and pop operations, 
	 * the class provides three more functions of empty, search and peek. 
	 * The class can also be said to extend Vector and treats the class as a stack with the five mentioned 
	 * functions. The class can also be referred to as the subclass of Vector. The class supports 
	 * one default constructor Stack() which is used to create an empty stack.
	 */
	
	// Operations of stack STL stack implementation   
    // Pushing element on the top of the stack
    static void stack_push(Stack<Integer> stack)
    {
        for(int i = 0; i < 5; i++)
        {
            stack.push(i);
        }
    }
    
    // Popping element from the top of the stack
    static void stack_pop(Stack<Integer> stack)
    {
        System.out.println("Pop :");

        for(int i = 0; i < 5; i++)
        {
            Integer y = (Integer) stack.pop();
            System.out.println(y);
        }
    }

    // Displaying element on the top of the stack
    static void stack_peek(Stack<Integer> stack)
    {
        Integer element = (Integer) stack.peek();
        System.out.println("Element on stack top : " + element);
    }
    
    // Searching element in the stack
    static void stack_search(Stack<Integer> stack, int element)
    {
        Integer pos = (Integer) stack.search(element);

        if(pos == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element is found at position " + pos);
    }

    public static void main (String[] args)
    {
        Stack<Integer> stack = new Stack<Integer>();

        stack_push(stack);
        stack_pop(stack);
        stack_push(stack);
        stack_peek(stack);
        stack_search(stack, 2);
        stack_search(stack, 6);
    }


}
