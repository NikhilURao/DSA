package com.array;

public class BinarySearch 
{
	public boolean BinSearchIterative(int [] a, int max, int min, int key)
	{
		while (max >= min)
		{
			int mid = (int)(Math.floor((max+min)/2));
			
			if (a[mid] == key)
				return true;
			else if (a[mid] < key)
				min = mid+1;
			else if (a[mid] > key)
				max = mid-1;
		}
		return false;
		
	}
	
	public void BinSearchRec(int [] a, int min, int max, int key)
	{
		if (max < min)
			System.out.println(false);
		else
		{
			int mid = (int) Math.floor((max-min)/2);
			if (a[mid] == key)
				System.out.println(true);
			else if (a[mid] < key)
				BinSearchRec(a, mid+1, max, key);
			else if (a[mid] > key)
				BinSearchRec(a, min, mid-1, key);
		}
							
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
		BinarySearch bin = new BinarySearch();
		System.out.println(bin.BinSearchIterative(primes, primes.length-1, 0, 47));
		bin.BinSearchRec(primes, primes.length-1, 0, 47);
		
		

	}

}
