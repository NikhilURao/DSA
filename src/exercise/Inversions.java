/*
 * Inversion Count for an array indicates – how far (or close) the array is from 
 * being sorted. If array is already sorted then inversion count is 0. 
 * If array is sorted in reverse order that inversion count is the maximum.
 * Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] 
 * and i < j

Example:
Input: arr[] = {8, 4, 2, 1}
Output: 6

Explanation: Given array has six inversions:
(8,4), (4,2),(8,2), (8,1), (4,1), (2,1).


Input: arr[] = {3, 1, 2}
Output: 2

Explanation: Given array has two inversions:
(3, 1), (3, 2) 

Approach using the enhanced merge sort technique:
Suppose the number of inversions in the left half and right half of the array
(let be inv1 and inv2), what kinds of inversions are not accounted for in
Inv1 + Inv2? The answer is – the inversions that need to be counted during the
merge step. Therefore, to get a number of inversions, that needs to be added
a number of inversions in the left subarray, right subarray and merge().

How to get number of inversions in merge()?
In merge process, let i is used for indexing left sub-array and j for right 
sub-array. At any step in merge(), if a[i] is greater than a[j], then 
there are (mid – i) inversions. because left and right subarrays are sorted, 
so all the remaining elements in left-subarray (a[i+1], a[i+2] … a[mid]) will 
be greater than a[j]

Algorithm:
1. The idea is similar to merge sort, divide the array into two equal or almost equal
   halves in each step until the base case is reached.
2. Create a function merge that counts the number of inversions when two halves
   of the array are merged, create two indices i and j, i is the index for first 
   half and j is an index of the second half. if a[i] is greater than a[j], 
   then there are (mid – i +1) inversions, because left and right subarrays 
   are sorted, so all the remaining elements in left-subarray 
   (a[i+1], a[i+2] … a[mid]) will be greater than a[j].
3. Create a recursive function to divide the array into halves and find the answer
   by summing the number of inversions is the first half, number of inversion in 
   the second half and the number of inversions by merging the two.The base case 
   of recursion is when there is only one element in the given half.
4. Print the answer

Complexity Analysis:
1. Time Complexity: O(n log n), The algorithm used is divide and conquer, 
   So in each level one full array traversal is needed and there are 
   log n levels so the time complexity is O(n log n).
2. Space Compelxity:O(1), No extra space is required.
 */
package exercise;
import java.util.*;

public class Inversions {

    private static long getNumberOfInversionsUsingMergeSort
    (int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (left < right)
        {
        int ave = (left + right) / 2;
        numberOfInversions = getNumberOfInversionsUsingMergeSort(a, b, left, ave);
        numberOfInversions += getNumberOfInversionsUsingMergeSort(a, b, ave+1, right);
        numberOfInversions += MergeCount(a,b,left,ave,right);
        }
        return numberOfInversions;
    }
    
    private static long MergeCount(int [] Arr, int [] temp, int start, int mid, int end)
    {
    	// crawlers for both intervals and for temp
    			int i = start; 
    			int j = mid+1;
    			int k = 0;
    			int inv_count = 0;
    			// traverse both arrays and in each iteration add smaller of both elements in temp 
    			while(i <= mid && j <= end) {
    				if(Arr[i] <= Arr[j]) 
    				{
    					temp[k] = Arr[i];
    					k += 1; 
    					i += 1;
    				}
    				else {
    					temp[k] = Arr[j];
    					k += 1; 
    					j += 1;
    					inv_count = inv_count + (mid - i + 1);
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
    return inv_count;
    
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversionsUsingMergeSort(a, b, 0, a.length-1));
    }
}



