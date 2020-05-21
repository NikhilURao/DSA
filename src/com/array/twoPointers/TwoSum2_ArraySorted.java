/*
 * Two Sum II - Input array is sorted
Given an array of integers that is already sorted in ascending order, 
find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two 
numbers such that they add up to the target, where index1 must be less than index2.

Note:
Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you 
may not use the same element twice.
Example:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

Algorithm:
1. 2 pointers are used i and j at the start (index-0) and end(len-1) of the array i.e.
   One pointer starts from the beginning while the other pointer starts from the end.
2. calculate the sum of the elements at i,j index and assign to a variable i.e. temp
3. if target == temp (arr[i] + arr[j]). found
4. if target < temp(arr[i] + arr[j]), then we need to increase the overall value
   hence we increment the value of i to increase the overall sum/value.
5. else if target > temp(arr[i] + arr[j]), then we need to decrease the overall val
   hence we decrement the value of j to decrease the overall sum/value.

Time Complexity: 
In the algorithm we use 2 pointer, one at the start and one at the 
end of the array and move them towards eachother and eventually meet eachother and 
terminate. The search target will help us to determine which pointer out of the 2
should be moved. This way, each element of the array is guarenteed to be visited 
atmost once by either of the 2 pointers, thus making the time complexity to be 
O(n) where n is the arbitrary size of the array.
 */
package com.array.twoPointers;

public class TwoSum2_ArraySorted 
{
	public int [] TwoSumSorted (int [] numbers, int target)
	{
		int n = numbers.length;
	    int i=0; int j = n-1;
	    int [] result = {-1, -1}; 
	        
	    while (i<j)
	    {
	        
	        int temp = numbers[i]+ numbers[j];
	        
	        if (temp == target)
	        {
	            result[0] = i+1;
	            result[1] = j+1;
	            return result;
	        }
	            
	        else if (temp < target)
	            i++;
	        else
	            j--;
	    }
	        return result;
	  }
	public static void main(String[] args) 
	{
		TwoSum2_ArraySorted tas = new TwoSum2_ArraySorted();
		int [] num_arr = {2,7,11,15};
		int [] res = tas.TwoSumSorted(num_arr, 18);
		for (int i=0; i<res.length; i++)
		{
			System.out.print(res[i]+" ");
		}

	}

}
