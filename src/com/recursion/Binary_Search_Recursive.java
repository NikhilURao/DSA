package com.recursion;

public class Binary_Search_Recursive {

static boolean BinSearch(int start,int end,int key,int [] arr) {
		
	if (start<=end) {
		int mid = (start+end)/2;
		if (arr[mid]==key) return true;
		
		else if (arr[mid]>key) 
			BinSearch(start,mid-1,key,arr);
		
		else if(arr[mid]<key) 
			BinSearch(mid+1,end,key,arr);
	}
	return false;
	
}
	
	public static void main(String[] args) {
		int [] arr = {1,2,5,9,10,11,42};
		int start=0;
		int end = arr.length-1;
		int key =5;
		boolean res = BinSearch(start,end,key,arr);
		System.out.println(res);
		

	}

}
