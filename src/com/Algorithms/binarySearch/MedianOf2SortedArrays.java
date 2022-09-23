package com.Algorithms.binarySearch;

public class MedianOf2SortedArrays {
	
	
	// TC => O(log(min(m,n))) where m and n are the length of nums1 and nums2 respectively
	// SC => O(1)
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 =nums1.length; int n2= nums2.length;
        
        // always pick n1 as the least of the size of the 2 arrays.
        if (n2<n1) return findMedianSortedArrays(nums2, nums1);
        
        /*
         * If we merge the 2 sorted arrays we know that the length of the merged array will be n1+n2
         * The median of merged array will be at the index n1+n2/2 if n1+n2 is odd and 
         * at 2 indexes (n1+n2/2) and (n1+n2/2) -1 th if n1+n2 is even.
         * The idea is to find where to partition nums1 such that all the elements left to this partition 
         * will be present in the left of the partition even in the merged array. Once we find this partition 
         * in nums1, we can find the number of elements to the left of this partition and subtract it with the
         * total number of elements in the merged array to get the number of elements to come from nums2.
         * 
         */
        int start=0; int end=n1;
        
        while (start <= end) {
        	int partitionNums1 = (start+end)/2;
        	int partitionNums2 = (n1+n2+1)/2 - partitionNums1;
        	
        	int left1 = partitionNums1 == 0? Integer.MIN_VALUE: nums1[partitionNums1 - 1];
        	int left2 = partitionNums2 == 0? Integer.MIN_VALUE: nums2[partitionNums2 - 1];
        	
        	int right1 = partitionNums1 == n1? Integer.MAX_VALUE: nums1[partitionNums1];
        	int right2 = partitionNums2 == n2? Integer.MAX_VALUE: nums2[partitionNums2];
        	
        	if (left1<=right2 && left2<=right1) {
        		// if the number of elements in the final merged array is even 
        		if ((n1+n2) % 2 == 0 )
        			return (Math.max(left1, left2) + Math.min(right1, right2))/2.0;
        		// if the number of elements in the final merged array is odd 
        		else
        			return Double.valueOf(Math.max(left1, left2));
        			
        	}
        	// if left1 > right1, we need to take less elements from nums1 hence move the partition to left
        	else if (left1>right2) {
        		end = partitionNums1 - 1;
        	}
        	else {
        		start = partitionNums1 + 1;
        	}
        }
        
        return 0.0;
    }

	public static void main(String[] args) {
		int ar1[] = {-5, 3, 6, 12, 15};
        int ar2[] = {-12, -10, -6, -3, 1};
		System.out.println(findMedianSortedArrays(ar1, ar2));

	}

}
