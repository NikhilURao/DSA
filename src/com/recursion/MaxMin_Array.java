package com.recursion;

public class MaxMin_Array {
	
	int MaxAndMin(int []arr, int index,int max)
	{
		if (index < arr.length) 
		{
			if (arr[index]> max) 
			{
				max = arr[index];
			}
			return MaxAndMin(arr, index+1, max);
		}
		else return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxMin_Array m = new MaxMin_Array();
		int [] arr = {-7,-3,-2,-5,-21,-1,-11};
		System.out.println(m.MaxAndMin(arr,0, Integer.MIN_VALUE));

	}

}
