/*
 * 
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 */
package google.interview.leetcode;

import java.util.ArrayList;

public class LongestIncreasingSubsequence {
	
	
	/**
	 * the difficult part of this problem is deciding if an element is worth using or not. 
	 * Consider the example nums = [8, 1, 6, 2, 3, 10]. Let's try to build an increasing subsequence 
	 * starting with an empty one: sub = [].
	 * 
	 * At the first element 8, we might as well take it since it's better than nothing, so sub = [8].
	 * At the second element 1, we can't increase the length of the subsequence since 8 >= 1, 
	 * so we have to choose only one element to keep. Well, this is an easy decision, l
	 * et's take the 1 since there may be elements later on that are greater than 1 but less than 8,
	 *  now we have sub = [1].
	 *  
	 *  At the third element 6, we can build on our subsequence since 6 > 1, now sub = [1, 6].
	 *  
	 *  At the fourth element 2, we can't build on our subsequence since 6 >= 2, but can we improve on it for 
	 *  the future? Well, similar to the decision we made at the second element, if we replace the 6 with 2, 
	 *  we will open the door to using elements that are greater than 2 but less than 6 in the future, 
	 *  so sub = [1, 2].
	 *  
	 *  At the fifth element 3, we can build on our subsequence since 3 > 2. 
	 *  Notice that this was only possible because of the swap we made in the previous step, 
	 *  so sub = [1, 2, 3].
	 *  
	 *  At the last element 10, we can build on our subsequence since 10 > 3, giving a final subsequence 
	 *  sub = [1, 2, 3, 10]. The length of sub is our answer.
	 *  
	 *  It appears the best way to build an increasing subsequence is: for each element num, if num is greater 
	 *  than the largest element in our subsequence, then add it to the subsequence. Otherwise, perform a 
	 *  linear scan through the subsequence starting from the smallest element and replace the first element that 
	 *  is greater than or equal to num with num. This opens the door for elements that are greater than num but 
	 *  less than the element replaced to be included in the sequence.
	 *  
	 *  One thing to add: this algorithm does not always generate a valid subsequence of the input, 
	 *  but the length of the subsequence will always equal the length of the longest increasing subsequence. 
	 *  For example, with the input [3, 4, 5, 1], at the end we will have sub = [1, 4, 5], which isn't a 
	 *  subsequence, but the length is still correct. The length remains correct because the length only 
	 *  changes when a new element is larger than any element in the subsequence. In that case, the element is 
	 *  appended to the subsequence instead of replacing an existing element.
	 *  
	 *  
	 *  Algorithm
	 *  
	 *  1. Initialize an array sub which contains the first element of nums.
	 *  
	 *  2. Iterate through the input, starting from the second element. For each element num:
	 *  If num is greater than any element in sub, then add num to sub.
	 *  Otherwise, perform a binary search in sub to find the smallest element that is greater than or equal 
	 *  to num. Replace that element with num.
	 *  
	 *  3. Return the length of sub.
	 *  
	 *  Given NN as the length of nums,

Time complexity: O(N⋅log(N))

Binary search uses log(N) time as opposed to the O(N) time of a linear scan, which improves our time O(N⋅log(N)).

Space complexity: O(N)

When the input is strictly increasing, the sub array will be the same size as the input.
	 *  
	 */
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n==0) return 0;
        
        ArrayList<Integer> LIS = new ArrayList<>();
        LIS.add(nums[0]);
        
        for (int i=1; i<n; i++){
            if (nums[i] > LIS.get(LIS.size()-1)){
                LIS.add(nums[i]);
            }
            else{
                int index = binarySearch(LIS, nums[i]);
                LIS.set(index, nums[i]);
            }
        }
        
        return LIS.size();
        
    }
    
    public static int binarySearch(ArrayList<Integer> lis, int num){
        int start =0; int end = lis.size() - 1;
        
        while (start<=end){
            int mid = start + ((end-start)/2);
            
            if (lis.get(mid) == num)
                return mid;
            else if (lis.get(mid) > num){
                end = mid -1;
            }
            else{
               start = mid + 1; 
            }
        }
        
        return start;
    }

	public static void main(String[] args) {
		int nums[] = {10,9,2,5,3,7,101,18};
		System.out.println(lengthOfLIS(nums));

	}

}
