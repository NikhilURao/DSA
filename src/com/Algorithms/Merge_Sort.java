package com.Algorithms;

public class Merge_Sort 
{
	static void merge(int Arr[], int start, int mid, int end) 
	{
		// create a temp array
		int temp[] = new int[end - start + 1];

		// crawlers for both intervals and for temp
		int i = start; 
		int j = mid+1;
		int k = 0;
		
		// traverse both arrays and in each iteration add smaller of both elements in temp 
		while(i <= mid && j <= end) {
			if(Arr[i] <= Arr[j]) {
				temp[k] = Arr[i];
				k += 1; 
				i += 1;
			}
			else {
				temp[k] = Arr[j];
				k += 1; 
				j += 1;
			}
		}

		// add elements left in the first interval 
		while(i <= mid) {
			temp[k] = Arr[i];
			k += 1; 
			i += 1;
		}

		// add elements left in the second interval 
		while(j <= end) {
			temp[k] = Arr[j];
			k += 1; 
			j += 1;
		}

		// copy temp to original interval
		for(i = start; i <= end; i += 1) {
			Arr[i] = temp[i - start];
		}
	}

	// Arr is an array of integer type
	// start and end are the starting and ending index of current interval of Arr

	static void mergeSort(int Arr[], int start, int end) {

		if(start < end) {
			int mid = (start + end) / 2;
			mergeSort(Arr, start, mid);
			mergeSort(Arr, mid+1, end);
			merge(Arr, start, mid, end);
		}
	}	
	
	public static void main(String[] args) {
		/*
		Scanner sc = new Scanner(System.in);
		int [] test = new int[6];
		Random ran = new Random();
		for (int i=0;i<test.length;i++) {
			test[i]=sc.nextInt();
		}
		*/
		int [] test = {7,9,2,8,4};
		System.out.println("Array before MergeSort : ");
		for (int i=0;i<test.length;i++) {
			System.out.print(test[i]);
			System.out.print(" ");
		}
		System.out.println("");
		mergeSort(test, 0, test.length-1);
		System.out.println("Array after MergeSort : ");
		for (int i=0;i<test.length;i++) {
			System.out.print(test[i]);
			System.out.print(" ");
		}		
	}

}
