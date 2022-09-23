/*
 * Merge Intervals
 * Given an array of intervals where intervals[i] = [starti, endi], 
 * merge all overlapping intervals, and return an array of the 
 * non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, 
merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104

Solution:

Question1: Is the intervals array sorted?
Answer1: No

Brute Force Approach:
start from the first interval and compare it with all other intervals 
for overlapping, if it overlaps with any other interval, 
then remove the other interval from the list and merge the other into 
the first interval. Repeat the same steps for remaining intervals after 
first.
TC=> O(n^2) | SC=> O(1)

Optimized Approach using Sorting and Stack:

1. Sort the interval array
2. For each interval in the array find if there are any overlaps by checking
if the end of the previous interval >= start of the current interval.
3. If yes merge the intervals by taking the start of the first interval
and end of the last overlapping interval and creating a new merged interval.
1. Sort the intervals based on increasing order of starting time.
2. Push the first interval on to a stack.
3. For each interval do the following
   a. If the current interval does not overlap with the stack top, push it.
   b. If the current interval overlaps with stack top and ending time of current interval is more than that of stack top, 
       update stack top with the ending  time of current interval.
4. At the end stack contains the merged intervals. 

TC=> O(nlogn) + O(n) {Sorting + Iteration/Merging}
SC=> O(n) => auxiliary space to store the intervals in stack

 */
package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals {
	
	public static int [][] mergeIntervals (int [][] intervals){
		if (intervals.length != 0) {
			ArrayList<int []> mergedIntervals = new ArrayList<>(); 
			// sort the given intervals in increasing order of start time
			Arrays.sort(intervals, new Comparator<int[]>(){
				@Override
				public int compare(int[] arg0, int[] arg1) {
					// return arg0[0] - arg1[0];
					return Integer.compare(arg0[0] ,arg1[0]);
				}
			});
			// merging overlapping intervals
			Stack<int []> st = new Stack<>();
			st.push(intervals[0]);
			for (int i=1; i<intervals.length; i++) {
				// interval overlapping
				if (st.peek()[1] >= intervals[i][0]) {
					int [] temp_interval = st.pop();
					// Otherwise update the ending time of top if ending of current interval is more
					temp_interval[1] = Integer.max(intervals[i][1], temp_interval[1]);
					st.push(temp_interval);
				}
				else {
					st.push(intervals[i]);
				}
			}
			
			// all the intervals in the stack will now be merged intervals
			// putting the intervals in stack to the output 2D matrix
			
			for (int [] interval : st) {
				mergedIntervals.add(interval);
			}
			
			return mergedIntervals.toArray(new int [mergedIntervals.size()][]);
		}
		else {
			return intervals;
		}
		
	}

	public static void main(String[] args) {
		int [][] intervals = new int [4][2];
		intervals[0] = new int []{1,3};
		intervals[1] = new int []{2,6};
		intervals[2] = new int []{15,18};
		intervals[3] = new int []{8,10};
		int [][] mergerIntervals = mergeIntervals(intervals);
		
		for (int i=0; i<mergerIntervals.length; i++) {
			for (int j=0; j<mergerIntervals[i].length; j++) {
				System.out.print(mergerIntervals[i][j]+",");
			}
			System.out.print("|");
		}

	}

}
