/*
 * Merge Sort
 * 
 *  Merge Sort is a Divide and Conquer Algorithm. It divides the input array into 2 halves, recursively calls 
 * itself until the array can no longer be divided i.e. 2 single elements. Base case is that a single element is 
 * always sorted. It then merges the 2 sorted halves. The merge() function is used for merging two halves.
 * The merge(arr, start, mid, end) is key process that assumes that arr[start....mid] and arr[mid+1...right] 
 * are sorted and merges the two sorted sub-arrays into one in a sorted manner. 
 * 
 * Time Complexity: 
 * Time complexity of Merge Sort is Theta(nLogn) in all 3 cases (worst, average and best) as merge sort always 
 * divides the array in two halves and take linear time to merge two halves.
 * 
 * Space Complexity: One of the disadvantages of merge sort is that it needs an auxiliary space of n,
 * its not an in-place sorting algorithm in its typical form. 
 * Auxiliary Space: O(n)
 * 
 * Advantages:
 * 1. Stable Algorithm. Handles equal elements
 * 2. Performs better for LinkedLists, however QuickSort outperforms MergeSort for arrays
 * 3. Can be used for external sorting
 * 
 * Algorithm: 
 * mergeSort(arr[], start,  end)
 * If start < end
     1. Find the middle point to divide the array into two halves:  
             middle mid = (start+end)/2
     2. Call mergeSort for first half:   
             Call mergeSort(arr, start, mid)
     3. Call mergeSort for second half:
             Call mergeSort(arr, mid+1, right)
     4. Merge the two halves sorted in step 2 and 3:
             Call merge(arr, start, mid, end)
             

 */
package com.Algorithms.sorting;

public class Merge_Sort 
{
	static void merge(int Arr[], int start, int mid, int end) 
	{
		// create a temp array
		int temp[] = new int[end - start + 1];
		
		// crawlers for both intervals and for temp
		int i = start; 
		int j = mid+1;
		int k = 0;// for temp pointer
		
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
			int mid = (start + end) / 2; // optimize to avoid overflow=> mid = start + (end - start)/2;
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
		int [] test = {3,8,4,2,7,9,1};
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
