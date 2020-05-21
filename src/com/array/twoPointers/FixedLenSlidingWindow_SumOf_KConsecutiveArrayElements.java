/*
 * Sliding Window Algorithm.
Given an array, imagine that we have a fixed size window, and we can 
slide it forward each time. If we are asked to compute
the sum of each window, the bruteforce solution would be O(kn) where k is
the window size and n is the array size by using two nested for loops, one to
set the starting point, and the other to compute the sum. A sliding window
algorithm applied here used the property that the sum of the current window
(Sc) can be computed from the last winodow (Sl) knowling the items that
just slided out and moved in as ao and ai. Then Sc = Sl - ao + ai. Not
necessarily using sum, we generalize it as state, if we can compute Sc from Sl,
ao and ai in O(1), a function Sc = f(Sl, ao, ai) then we name this sliding
window property. Therefore the time complexity will be decreased to
O(n).  
 *
 */
package com.array.twoPointers;

public class FixedLenSlidingWindow_SumOf_KConsecutiveArrayElements 
{
	public int maxSumofKConsecutiveArrayElement(int [] A, int window_size)
	{
		int len = A.length;
		int sum = 0;
		
	// For calculating the sum of the first window 0 to window_size - 1 of len k
		for (int i=0; i<window_size; i++)
		{
			sum += A[i]; 
		}
		
		int ans = sum;
		
		for (int start=1; start<=len-window_size; start++)
		{
			int rear = start + window_size-1;
			
			sum = sum - A[start-1] + A[rear];
			
			ans = Math.max(ans, sum);
			
		}
		return ans;
	}
	public static void main(String[] args) 
	{
		FixedLenSlidingWindow_SumOf_KConsecutiveArrayElements fl = new FixedLenSlidingWindow_SumOf_KConsecutiveArrayElements();
		int [] Array = {8,5,10,7,9,4,15,12,90,13};
		System.out.println(fl.maxSumofKConsecutiveArrayElement(Array, 3));
		

	}

}
