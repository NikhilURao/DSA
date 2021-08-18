/*
 * A Dynamic Array a.k.a re-sizable array is an abstract data type that grows as
 * number of elements in the array grows without having to mention the size of 
 * the array while creating it (common implementations: java array lists, c++ vectors)
 * Whereas a dynamically allocated array e.g int my_arr = new int[size]; 
 * takes a variable as the size and is allocated at runtime.
 * While a static array e.g int my_arr[100]; takes value to size at the time of its
 * creation.
 *
 * Idea to create an abstract data type dynamic array: 
 * store a pointer to the dynamic allocated array and replace
 * it with a newly allocated 
 * dynamically allocated array as and when needed.
 * 
 * APIs:
 * get(i): Returns the element at ith position.
 * set(i, val): set the value of ith element to val.
 * pushBack(val): adds val to the end of the array.
 * remove(i): removes the element at the ith index. 
 * 
 * Amortized TC = O(1)=> random access/constant 
 * SP = O(n)
 * 
 */

package com.array;

public class DynamicArray 
{
	int size;
	int capacity;
	// Creating a dynamically allocated array
	int arr[];
	
	public DynamicArray(int initail_cap) {
		this.size = 0;
		this.capacity = initail_cap;
		arr = new int[this.capacity];
	}
	
	public int get (int i) throws IndexOutOfBoundsException
	{
		if (i < size && i >= 0)
		{
			return arr[i];
		}
		else 
		{
			throw new IndexOutOfBoundsException();
			
		}
		
	}
	
	public void set(int i, int val) throws IndexOutOfBoundsException
	{
		if (i < size && i >= 0)
		{
			arr[i] = val;
		}
		else throw new IndexOutOfBoundsException();
	}
	
	public void pushBack(int val)
	{
		if (size == capacity)
		{
			int new_arr[] = new int [capacity*2];
			
			for (int i=0; i<capacity; i++)
			{
				new_arr[i] = arr[i];
			}
			arr = new_arr;
			size++;
		}
		else
		{
			arr[size] = val;
		}
	}
	
	public void remove(int i) throws IndexOutOfBoundsException
	{
		if (i < size)
		{
			for (int j=i+1; j<size; j++)
			{
				arr[j] = arr[j+1];
			}
		}
		else throw new IndexOutOfBoundsException();
	}

	public static void main(String[] args) 
	{
		int my_arr[] = new int[2]; // static 
		int cap =2;
		int my_arr1[] = new int[cap]; // dynamically allocated array
		
		DynamicArray da = new DynamicArray(2);
		da.pushBack(10);
	}

}
