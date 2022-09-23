/*
 * 56. Merge Intervals

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 and return an array of the non-overlapping intervals that cover all the intervals in the input.


Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */

package google.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals {
	
	public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return intervals;
        // sort the intervals array based on the start time of the interval.
        Arrays.sort(intervals, new Comparator<int []>(){
        	@Override
            public int compare(int [] a, int [] b){
                return a[0] - b[0];
                // return Integer.compare(a[0], b[0]);
            }     
        });
        // stack to store the intervals after merging 
        Stack<int []> stack = new Stack<>();
        // push the first interval to the stack
        stack.push(intervals[0]);
        
        for (int i=1; i<intervals.length; i++){
            // overlap
            if (!stack.isEmpty() && stack.peek()[1]>=intervals[i][0]){
                int [] temp = stack.pop();
                temp[1] = Math.max(temp[1], intervals[i][1]);
                stack.push(temp);
            }
            else{
                stack.push(intervals[i]);
            }
        }
        // all the intervals in the stack will now be merged intervals
		// putting the intervals in stack to the output 2D matrix
        ArrayList<int []> mergedIntervals = new ArrayList<>(); 
        for (int [] interval : stack) {
				mergedIntervals.add(interval);
			}
			
        return mergedIntervals.toArray(new int [mergedIntervals.size()][]);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		int [][] mergedIntervals = merge(intervals);
		for (int i=0; i<mergedIntervals.length; i++) {
			for (int j=0; j<mergedIntervals[i].length; j++) {
				System.out.print(mergedIntervals[i][j]+",");
			}
			System.out.print(" ");
		}
		

	}

}
