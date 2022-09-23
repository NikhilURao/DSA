package com.stack;

import java.util.*;

public class MaximalRectangle {
	
	// method to find the next/nearest smaller element to the left of each element in arr
    public static int[] getNSLIndex(int [] arr){
        int n = arr.length;
        if (n==0) return arr;
        int nsl_index[] = new int [n]; 
        Stack<int []> st = new Stack<>();
        
        for (int i=0; i<n; i++){
            while (!st.isEmpty() && st.peek()[0] >= arr[i]){
                st.pop();
            }
            if (st.isEmpty()){
                nsl_index[i] = -1;
                st.push(new int [] {arr[i], i});
                continue;
            }
            nsl_index[i] = st.peek()[1];
            st.push(new int [] {arr[i], i});
        }
        
        return nsl_index;
        
    }
    // method to find the next/nearest smaller element to the right of each element in arr
    public static int[] getNSRIndex(int [] arr){
        int n = arr.length;
        if (n==0) return arr;
        int nsr_index[] = new int [n]; 
        Stack<int []> st = new Stack<>();
        
        for (int i=n-1; i>=0; i--){
            while (!st.isEmpty() && st.peek()[0] >= arr[i]){
                st.pop();
            }
            if (st.isEmpty()){
                nsr_index[i] = n;
                st.push(new int [] {arr[i], i});
                continue;
            }
            nsr_index[i] = st.peek()[1];
            st.push(new int [] {arr[i], i});
        }
        
        return nsr_index;
    }
    
    public static int maximumAreaHistogram(int [] arr){
        int n = arr.length;
        if (n==0) return 0;
        int [] nsl_index = getNSLIndex(arr);
        int [] nsr_index = getNSRIndex(arr);
        int [] width = new int [n];
        
        for (int i=0; i<n; i++){
            width[i] = nsr_index[i] - nsl_index[i] - 1;
        }
        
        int [] area = new int [n]; int maxArea = Integer.MIN_VALUE;
        for (int i=0; i<n; i++){
            area[i] = width[i] * arr[i];
            maxArea = Math.max(maxArea, area[i]);
        }
        
        return maxArea;
    }
    
    public static int maximalRectangle(char[][] matrix) {
        int n = matrix.length; int m = matrix[0].length;
        if (n==0) return 0;
        
        // array to prepare the 1D array for the histogram
        int [] a = new int [m];
        Arrays.fill(a, 0);
        
        for (int j=0; j<m; j++) {
        	if (matrix[0][j] == '0')
        		a[j] = 0;
        	else 
        		a[j] = 1;
        }
        
        int maxArea = maximumAreaHistogram(a);
        
        for (int i=1; i<n; i++){
        	for (int j=0; j<m; j++) {
        		if (matrix[i][j] == '0')
        			a[j] = 0;
        		else
        			a[j] = a[j] + 1;
        	}
        	maxArea = Math.max(maxArea, maximumAreaHistogram(a));
        }
        return maxArea;
    }

	public static void main(String[] args) {
		char[][] matrix = { {'1','0','1','0','0'},
							{'1','0','1','1','1'},
							{'1','1','1','1','1'},
							{'1','0','0','1','0'}};
		System.out.println(maximalRectangle(matrix));

	}

}
