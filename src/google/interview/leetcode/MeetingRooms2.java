/*
 * 253. Meeting Rooms II

Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

 

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
 

Constraints:

1 <= intervals.length <= 104
0 <= starti < endi <= 106
 */
package google.interview.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {
	
	// Solution 1: Using min priority queue
	/**
	 * Algorithm

	Sort the given meetings by their start time.
	Initialize a new min-heap and add the first meeting's ending time to the heap. We simply need to keep track of the ending times as that tells us when a meeting room will get free.
	For every meeting room check if the minimum element of the heap i.e. the room at the top of the heap is free or not.
	If the room is free, then we extract the topmost element and add it back with the ending time of the current meeting we are processing.
	If not, then we allocate a new room and add it to the heap.
	After processing all the meetings, the size of the heap will tell us the number of rooms allocated. This will be the minimum number of rooms needed to accommodate all the meetings.
	 
	 Complexity Analysis

	Time Complexity: O(NlogN).

	There are two major portions that take up time here. One is sorting of the array that takes O(NlogN) 
	considering that the array consists of N elements.
	Then we have the min-heap. In the worst case, all N meetings will collide with each other. 
	In any case we have NN add operations on the heap. In the worst case we will have N extract-min operations
	as well. Overall complexity being (NlogN) since extract-min operation on a heap takes O(logN).
	
	Space Complexity: O(N) because we construct the min-heap and that can contain N elements in the worst case as described 
	above in the time complexity section. Hence, the space complexity is O(N).
	 
	 * @param intervals
	 * @return
	 */
	public static int minMeetingRooms(int[][] intervals) {
		
		int n = intervals.length;
		if (n==0 || n==1) return n;
		
		// sort the meeting intervals array by start time
		Arrays.sort(intervals, new Comparator<int []>() {

			@Override
			public int compare(int[] i1, int[] i2) {
				return i1[0] - i2[0];
			}
		});
		
		// Initialize a minimum queue to save the end time of meeting intervals
		PriorityQueue<Integer> minQueue = new PriorityQueue<>(n, new Comparator<Integer>() {
			
			@Override
			public int compare(Integer a, Integer b) {
				return a - b;
			}
		});
		
		// push the end time first interval in the sorted intervals array into the minQueue
		minQueue.add(intervals[0][1]);
		
		// iterate over the rest of the intervals and compare the start time of each interval with the top of minQueue
		for (int i=1; i<n; i++) {
			int startTime = intervals[i][0];
			int endTime = intervals[i][1];
			
			if (!minQueue.isEmpty() && startTime < minQueue.peek()) {
				minQueue.add(endTime);
			}
			else if (!minQueue.isEmpty() && startTime >= minQueue.peek()) {
				minQueue.poll();
				minQueue.add(endTime);
			}
		}
		return minQueue.size();
	}
	
	// Solution 2: Using Chronological Ordering
	/**
	 * Algorithm

	Separate out the start times and the end times in their separate arrays.
	Sort the start times and the end times separately. Note that this will mess up the original correspondence of start times and end times. They will be treated individually now.
	We consider two pointers: s_ptr and e_ptr which refer to start pointer and end pointer. The start pointer simply iterates over all the meetings and the end pointer helps us track if a meeting has ended and if we can reuse a room.
	When considering a specific meeting pointed to by s_ptr, we check if this start timing is greater than the meeting pointed to by e_ptr. If this is the case then that would mean some meeting has ended by the time the meeting at s_ptr had to start. So we can reuse one of the rooms. Otherwise, we have to allocate a new room.
	If a meeting has indeed ended i.e. if start[s_ptr] >= end[e_ptr], then we increment e_ptr.
	Repeat this process until s_ptr processes all of the meetings.
	
	Complexity Analysis

	Time Complexity: O(NlogN) because all we are doing is sorting the two arrays for start timings and end timings individually and each of them would contain N elements considering there are N intervals.

	Space Complexity: O(N) because we create two separate arrays of size N, one for recording the start times and one for the end times.
	
	 * @param intervals
	 * @return
	 */
	public static int minMeetingRoomsChronologicalOrdering(int[][] intervals) {
		
		int n = intervals.length;
		if (n==0 || n==1) return n;
		
		// Create 2 arrays and store the start and end times in those arrays
		int start[] = new int [n];
		int end[] = new int [n];
		
		for (int i=0; i<n; i++) {
			start[i] = intervals[i][0];
			end[i] = intervals[i][1];
		}
		
		// sort start and end arrays
		Arrays.sort(start);
		Arrays.sort(end);
		
		// take 2 pointer startPtr and endPtr
		int startPtr = 0, endPtr = 0, countOfMeetingRooms =0;
		
		while (startPtr < n && endPtr < n) {
			if (start[startPtr] < end[endPtr]) {
				countOfMeetingRooms ++;
				startPtr++;
			}
			else if (start[startPtr] >= end[endPtr]) {
				endPtr++;
				startPtr++;
			}
		}
		
		return countOfMeetingRooms;
		
	}
	
	public static void main(String[] args) {
		//int intervals[][] = {{1, 10}, {2, 7}, {3, 19}, {8, 12}, {10, 20}, {11, 30}};
		int intervals[][] = {{13,15},{1,13},{6,9}};//{{0,30},{5,10},{15,20}};
		System.out.println(minMeetingRooms(intervals));
		
		System.out.println(minMeetingRoomsChronologicalOrdering(intervals));
		

	}

}
