package google.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MaximumProfitInJobScheduling {
	/**
	 * 
	 * Approach 1: Top-Down Dynamic Programming + Binary Search
	 * 
	 * Intuition
	 * Let's start at time zero, before the startTime of any job, at this point we can choose any job to 
	 * schedule first. Once the first job has ended, we can iterate over all of the jobs and only consider 
	 * scheduling those that start after the current time. The process of repeatedly iterating over the jobs 
	 * array is very time-consuming and we can do better: if we sort our jobs according to start time, 
	 * then we can apply binary search to find the next job. After sorting jobs according to startTime, 
	 * to find the index of the first non-conflicting job, binary search for the endTime of the current 
	 * job in the list of start times for all jobs.
	 * 
	 * For each job, we will try two options:
	 * Schedule this job and move on to the next non-conflicting job using binary search.
	 * Skip this job and move on to the next available job.
	 * 
	 * Then we can make an informed decision about whether we should schedule the job based on which of 
	 * the above two options results in the greater profit.
	 * 
	 * This recursive approach will have repeated subproblems; this can be observed in the figure below. 
	 * Notice, the subtree with root 22 is repeated signifying that we must solve this subproblem more than once.
	 * 
	 * To address this issue, the first time we calculate maxProfit for a certain position,
	 * we will store the value in an array; this value represents the maximum profit we can get from the jobs 
	 * at indices from position to the end of the array. The next time we need to calculate maxProfit for 
	 * this position, we can look up the result in constant time. This technique is known as memoization 
	 * and it helps us avoid recalculating repeated subproblems.
	 * 
	 * Algorithm
	 * 
	 * Store the startTime, endTime and profit of each job in jobs.
	 * 
	 * Sort the jobs according to their starting time.
	 * 
	 * Iterate over jobs from left to right, where position is the index of the current job. For each job, 
	 * we must compare two options:
	 * i. Skip the current job (earn 0 profit) and move on to consider the job at the index position + 1.
	 * ii. Schedule the current job (earn profit for the current job) and move on to the next non-conflicting 
	 * job whose index is nextIndex. nextIndex is determined by using binary search in the startTime array.
	 * 
	 * 
	 * Return the maximum profit of the two choices and record this profit in the array memo (memoization).
	 * 
	 * 
	 * Complexity Analysis
	 * 
	 * Let N be the length of the jobs array.
	 * 
	 * Time complexity: O(NlogN)
	 * Sorting jobs according to their starting time will take O(NlogN).
	 * The time complexity for the recursion (with memoization) is equal to the number of times findMaxProfit 
	 * is called times the average time of findMaxProfit. The number of calls to findMaxProfit is 2*N
	 * because each non-memoized call will call findMaxProfit twice. Each memoized call will take O(1)
	 * time while for the non-memoized call, we will perform a binary search that takes O(log N)
	 * time, hence the time complexity will be O(NlogN+N).
	 * The total time complexity is therefore equal to O(NlogN).
	 *  
	 *  Space complexity: O(N)
	 *  Storing the starting time, ending time, and profit of each job will take 3N space. 
	 *  Hence the complexity is O(N)
	 *  The space complexity of the sorting algorithm depends on the implementation of each programming language. 
	 *  For instance, in Java, the Arrays.sort() for primitives is implemented as a variant of quicksort 
	 *  algorithm whose space complexity is O(logN). In C++ sort() function provided by STL is a hybrid of 
	 *  Quick Sort, Heap Sort and Insertion Sort with the worst-case space complexity of O(logN). 
	 *  Thus the use of inbuilt sort() function adds O(logN) to space complexity.
	 *  The result for each position will be stored in memo and position can have the values from 0 to N,
	 *  thus the space required is O(N). 
	 *  Also, stack space in recursion is equal to the maximum number of active functions. 
	 *  In the scenario where every job is not scheduled, the function call stack will be of size N.
	 *  The total space complexity is therefore equal to O(N).
	 */
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    	
    	int n = startTime.length;
    	
    	int [] maxProfit = new int [n];
    	Arrays.fill(maxProfit, -1);
    	
    	// Store the startTime, endTime and profit of each job in jobs.
    	ArrayList<ArrayList<Integer>> jobs = new ArrayList<>(); 
    	
    	for (int i=0; i<n; i++) {
    		ArrayList<Integer> currJob = new ArrayList<>();
    		currJob.add(startTime[i]);
    		currJob.add(endTime[i]);
    		currJob.add(profit[i]);
    		jobs.add(currJob);
    	}
    	
    	// sort jobs by start time
    	jobs.sort(new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.get(0), o2.get(0));
			}
		});
    	
        // binary search will be used in startTime so store it as separate list
        for (int i = 0; i < n; i++) {
            startTime[i] = jobs.get(i).get(0);
        }
        
        return findMaxProfitRecursive(jobs, startTime, n, 0, maxProfit);
        
    }
    
    private int findMaxProfitRecursive(ArrayList<ArrayList<Integer>> jobs, int[] startTime, int n, int position, 
    		int [] maxProfit) {
        // 0 profit if we have already iterated over all the jobs
        if (position == n) {
            return 0;
        }
        
        // return result directly if it's calculated 
        if (maxProfit[position] != -1) {
            return maxProfit[position];
        }
        /*
         *  We have 2 choices for each job/ currentJob 
         *  1. Pick the job and find the next job whose startTime >= current job's endTime
         *  2. Or don't pick the job and move to the next job in the jobs array 
         */
        ArrayList<Integer> curJob = jobs.get(position);
        int curJobStartTime  = jobs.get(position).get(0);
        int curJobEndTime  = jobs.get(position).get(1);
        int curJobProfit  = jobs.get(position).get(2);
        
        // nextIndex is the index of next non-conflicting job
        // we use binary search to find the next job
        int nextJobIndex = findNextJobBinarySearch(startTime, curJobEndTime);
        
        // find the maximum profit of our two options: skipping or scheduling the current job
        int maximumProfit = Math.max(findMaxProfitRecursive(jobs, startTime, n, position + 1, maxProfit), 
        		curJobProfit + findMaxProfitRecursive(jobs, startTime, n, nextJobIndex, maxProfit));
        
        // return maximum profit and also store it for future reference (memoization)
        return maxProfit[position] = maximumProfit;
    }
    
    private int findNextJobBinarySearch(int[] startTime, int lastEndingTime) {
        int start = 0, end = startTime.length - 1, nextIndex = startTime.length;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            if (startTime[mid] >= lastEndingTime) {
                nextIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return nextIndex;
    }

	public static void main(String[] args) {
		int [] startTime = {1,2,3,4,6};
		int [] endTime = {3,5,10,6,9};
		int [] profit = {20,20,100,70,60};
		
		MaximumProfitInJobScheduling mpjs = new MaximumProfitInJobScheduling();
		System.out.println(mpjs.jobScheduling(startTime, endTime, profit));

	}

}
