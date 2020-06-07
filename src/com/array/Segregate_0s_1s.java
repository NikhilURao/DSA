/**
 * Array contains 0s and 1s. Segregate 0s to the left and 1s to the right.
 * 
 * 
 */
package com.array;
import java.util.Random;

public class Segregate_0s_1s {
	
	static int [] Segregate_using_countSort(int [] Arr)
	{
		int [] count_array = new int [2];
		
		for (int i=0; i<Arr.length; i++)
		{
			count_array[Arr[i]]++;
		}
		
		count_array[1] += count_array[0];
		int [] fin_array = new int [Arr.length];
		
		for (int i=Arr.length-1; i>=0; i--)
		{
			fin_array[count_array[Arr[i]]-1] = Arr[i];
			count_array[Arr[i]]--;
		}
		
		return fin_array;
	}
	
static void Segregate(int arr[],int start,int end) 
{

	int temp=0;
	while(start<end) {
		
		while (arr[start]==0) {
			start++;
		}
		while (arr[end]==1) {
			end--;
		}
		if (start<end) {
		temp = arr[start];
		arr[start] = arr[end];
		arr[end]=temp;
		}
		}
	}
	public static void main(String[] args) {
		int [] test = new int [10];
		Random rand = new Random();
		for (int i=0;i<test.length;i++) {
			test[i]= rand.nextInt(2);
		}
		System.out.println("Array before sorting");
		for (int i=0;i<test.length;i++) {
			System.out.print(test[i]);
			System.out.print(" ");
		}
		System.out.println("");	
		Segregate(test, 0,test.length-1);
		System.out.println("Array after sorting using 2 pointers technique");
		for (int i=0;i<test.length;i++) {
			System.out.print(test[i]);
			System.out.print(" ");
		}
		
		int [] demo = Segregate_using_countSort(test);
		System.out.println();
		System.out.println("Array after sorting using counting sort technique");
		for (int i=0; i<demo.length; i++)
		{
			System.out.print(demo[i]+" ");
		}
	}

}
