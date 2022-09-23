/*
 * 84. Largest Rectangle in Histogram

Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
return the area of the largest rectangle in the histogram.

Example 1:

Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.

Example 2:


Input: heights = [2,4]
Output: 4
 

Constraints:	

1 <= heights.length <= 105
0 <= heights[i] <= 104
 * 
 * 
 */

package com.stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
	
	// Solution 1: Brute Force 
	/**
	 * Observation 1: height of the rectangle formed between any two bars will always be limited by the height 
	 * of the shortest bar lying between them.
	 * Considering every possible pair of bars and finding the area of the rectangle formed between them using 
	 * the height of the shortest bar lying between them as the height and the spacing between them as the width 
	 * of the rectangle. We can thus, find the required rectangle with the maximum area.
	 * For a pair of histogram, find the smallest height(h) between them and the width of the distance between them
	 * in the length(l). Find the area = l*h.
	 * 
	 **
	 * Complexity Analysis
	 * Time complexity: O(n^3). 
	 * We have to find the minimum height bar O(n) lying between every possible pair of bars O(n^2)
	 * 
	 * Space complexity: O(1). Constant space is used.
	 */
    public static int largestRectangleAreaBruteForce(int[] heights) {
        
    	int n = heights.length;
        if (n==0) return 0;
        int max_area = 0;
        
        for (int i=0; i<n; i++) {
        	for (int j=i+1; j<n;j++) {
        		int min_height = Integer.MAX_VALUE;
        		for (int k=i; k<=j; k++) {
        			min_height = Math.min(min_height, heights[k]);
        		}
        		
        		int area = min_height * (j-i+1);
        		max_area = Math.max(max_area, area);
        	}
        }
        
        return max_area;
    }
    
    
	// Solution 2: Better Brute Force 
	/**
	 * We can do one slight modification in the previous approach to optimize it to some extent. 
	 * Instead of taking every possible pair and then finding the bar of minimum height lying between them 
	 * every time, we can find the bar of minimum height for current pair by using the minimum height bar of the
	 * previous pair.
	 * 
	 * minheight = min(minheight,heights(j)), where heights(j) refers to the height of the jth bar.
	 * 
	 * Observation 1: height of the rectangle formed between any two bars will always be limited by the height 
	 * of the shortest bar lying between them.
	 * Considering every possible pair of bars and finding the area of the rectangle formed between them using 
	 * the height of the shortest bar lying between them as the height and the spacing between them as the width 
	 * of the rectangle. We can thus, find the required rectangle with the maximum area.
	 * For a pair of histogram, find the smallest height(h) between them and the width of the distance between them
	 * in the length(l). Find the area = l*h.
	 * 
	 **
	 * Complexity Analysis
	 * Time complexity: O(n^2). Every possible pair is considered
	 * 
	 * Space complexity: O(1). No extra space is used.
	 */
    public static int largestRectangleAreaOptimisedBruteForce(int[] heights) {
        
    	int n = heights.length;
        if (n==0) return 0;
        int max_area = 0;
        
        for (int i=0; i<n; i++) {
        	int min_height = Integer.MAX_VALUE;
        	for (int j=i; j<n;j++) {
        		min_height = Math.min(min_height, heights[j]);
        		int area = min_height * (j-i+1);
        		max_area = Math.max(max_area, area);
        	}
        }
        
        return max_area;
    }

    // Solution 3: Divide and Conquer 
    /**
     * Divide and Conquer Approach
     * Algorithm
     * This approach relies on the observation that the rectangle with maximum area will be the maximum of:
     * The widest possible rectangle with height equal to the height of the shortest bar.
     * The largest rectangle confined to the left of the shortest bar(subproblem).
     * The largest rectangle confined to the right of the shortest bar(subproblem).
     * 
     * Let's take an example:
     * 
     * [6, 4, 5, 2, 4, 3, 9]
     * Here, the shortest bar is of height 2. The area of the widest rectangle using this bar as height is 2x7=14.
     * Now, we need to look for cases 2 and 3 mentioned above. Thus, we repeat the same process to the left 
     * and right of 2. In the left of 2, 4 is the minimum, forming an area of rectangle 4x3=12. Further, 
     * rectangles of area 6x1=6 and 5x1=5 exist in its left and right respectively. Similarly we find an 
     * area of 3x3=9, 4x1=4 and 9x1=9 to the left of 2. Thus, we get 14 as the correct maximum area. 
     * 
     * Complexity Analysis
     * Time complexity:Average Case: O(nlogn).Worst Case: O(n^2). 
     * If the numbers in the array are sorted, we don't gain the advantage of divide and conquer.
     * 
     * Space complexity: O(n). Recursion with worst case depth n.
     * 
     */
    public static int largestRectangleAreaDivideAndConquer(int[] heights) {
        int n = heights.length;
        if (n==0) return 0;
        return largestRectangleAreaDivideAndConquerRecursive(heights, 0, n-1);
    }
    
    public static int largestRectangleAreaDivideAndConquerRecursive(int [] heights, int start, int end) {
    	if (start > end) return 0;
    	int min_ind = start;
    	
    	// find the index of the minimum height in the array from iterating from the range of start to end.
    	for (int i=start; i<=end; i++) {
    		if (heights[i] < heights[min_ind])
    			min_ind = i;
    	}
    	int area = heights[min_ind] * (end - start + 1);
    	return Math.max(area, Math.max(largestRectangleAreaDivideAndConquerRecursive(heights, start, min_ind-1), 
    			largestRectangleAreaDivideAndConquerRecursive(heights, min_ind+1, end)));
    	
    }
    
    // Solution 4: Approach 5: Using Stack
    /**
     * Algorithm
     * In this approach, we maintain a stack. Initially, we push a -1 onto the stack to mark the end. 
     * We start with the leftmost bar and keep pushing the current bar's index onto the stack until we get 
     * two successive numbers in descending order, i.e. until we get heights[i] < heights[i-1]. 
     * Now, we start popping the numbers from the stack until we hit a number stack[j] on the stack such that 
     * heights[stack[j]]≤heights[i]. Every time we pop, we find out the area of rectangle 
     * formed using the current element as the height of the rectangle and the difference between the 
     * the current element's index pointed to in the original array and the element stack[top−1]−1 as the width 
     * i.e. if we pop an element stack[top] and i is the current index to which we are pointing in the 
     * original array, the current area of the rectangle will be considered as:
     * 
     * area = (i−stack[top]−1)×heights[stack[top]].
     * 
     * Further, if we reach the end of the array, we pop all the elements of the stack and at every pop, 
     * this time we use the following equation to find the
     * 
     * area = (heights.length − stack[top]−1) × heights[stack[top]], where stack[top] refers to the element 
     * just popped. Thus, we can get the area of the of the largest rectangle by comparing the new area found 
     * every time.
     * 
     * Complexity Analysis
     * 
     * Time complexity: O(n). n numbers are pushed and popped.
     * Space complexity: O(n). Stack is used.
     */
    public static int largestRectangleAreaUsingStack(int[] heights) {
        int n = heights.length;
        if (n==0) return 0;
        
        Stack<Integer> st = new Stack<>();
        
        st.push(-1);
        
        int max_area = Integer.MIN_VALUE;
        
        for (int i=0; i<n; i++) {
        	while(st.peek() != -1 && heights[i] < heights[st.peek()]) {
        		int index = st.pop();
                int currentHeight = heights[index];
                int currentWidth = i - st.peek() - 1;
        		int area = currentHeight * currentWidth;
        		max_area = Math.max(max_area, area);
        	}
        	st.push(i);
        }
        
    	while(st.peek() != -1) {
    		int index = st.pop();
            int currentHeight = heights[index];
            int currentWidth = n - st.peek() - 1;
    		int area = currentHeight * currentWidth;
    		max_area = Math.max(max_area, area);
    	}
    	
    	return max_area;
    }
    
    public static int largestRectangleAreaUsingStack2(int[] heights) {
    	int n = heights.length;
    	if (n==0) return 0;
    	
    	// find the nearest smaller height histogram to right and left of each histogram.
    	
    	// find nsl
    	int nsl[] = new int [n];
    	// stack to store the {height, index}
    	Stack<int[]> st = new Stack<>();
    	for (int i=0; i<n; i++) {
    		while (!st.isEmpty() && st.peek()[0] >= heights[i]) {
    			st.pop();
    		}
    		if (st.isEmpty()) {
    			nsl[i] = -1;
    			st.push(new int [] {heights[i],i});
    			continue;
    		}
			nsl[i] = st.peek()[1];
			st.push(new int [] {heights[i],i});
    	}
    	
    	// find nsr
    	int nsr[] = new int [n];
    	// stack to store the {height, index}
    	Stack<int[]> s = new Stack<>();
    	for (int i=n-1; i>=0; i--) {
    		while (!s.isEmpty() && s.peek()[0] >= heights[i]) {
    			s.pop();
    		}
    		if (s.isEmpty()) {
    			nsr[i] = n;
    			s.push(new int [] {heights[i],i});
    			continue;
    		}
			nsr[i] = s.peek()[1];
			s.push(new int [] {heights[i],i});
    	}
    	
    	int width[] = new int [n];
    	
    	for (int i=0; i<n; i++) {
    		width[i] = nsr[i] - nsl[i] -1;
    	}
    	
    	int area[] = new int [n];
    	int max_area = Integer.MIN_VALUE;
    	for (int i=0; i<n; i++) {
    		area[i] = width[i] * heights[i];
    		max_area = Math.max(max_area, area[i]);
    	}
    	
    	return max_area;
    	
    }
    
	public static void main(String[] args) {
		int heights[] = {2,1,5,6,2,3};
		System.out.println(largestRectangleAreaBruteForce(heights));
		System.out.println(largestRectangleAreaOptimisedBruteForce(heights));
		System.out.println(largestRectangleAreaDivideAndConquer(heights));
		System.out.println(largestRectangleAreaUsingStack(heights));
		System.out.println(largestRectangleAreaUsingStack2(heights));
		
	}

}
