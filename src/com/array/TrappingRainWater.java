/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

CHECK IMAGE rainwatertrap.png

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105

Rain Water Trapped
Problem Description

Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.



Problem Constraints
1 <= |A| <= 100000



Input Format
First and only argument is the vector A



Output Format
Return one integer, the answer to the question



Example Input
Input 1:

A = [0, 1, 0, 2]
Input 2:

A = [1, 2]


Example Output
Output 1:

1
Output 2:

0


Example Explanation
Explanation 1:

1 unit is trapped on top of the 3rd element.
Explanation 2:

No water is trapped.

 */
package com.array;

import java.io.InputStream;

public class TrappingRainWater {
	
	public static int trap(int[] height) {
		int n = height.length;
        int sumTrappedWater = 0;
        // find the tallest building to the left of each buildings in the array
        int [] leftMax = new int [n]; 
        leftMax[0] = height[0];
        // find the tallest building to the right of each buildings in the array
        int [] rightMax = new int [n];
        rightMax[n - 1] = height[n - 1];
        
        for (int i=1; i<leftMax.length; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);        
        }
        
        for (int i=rightMax.length - 2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]); 
        }
        
        // height of water on each building in the array is the minimum of tallest building to its left and right minus the current building's height
        for (int i=0; i<n; i++){
            sumTrappedWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        
        return sumTrappedWater;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trap(new int [] {0,1,0,2,1,0,1,3,2,1,2,1})); 
		// 4,2,0,3,2,5

	}

}
