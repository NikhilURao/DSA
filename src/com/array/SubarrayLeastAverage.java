package com.array;

import java.util.ArrayList;
import java.util.Arrays;

public class SubarrayLeastAverage {

    public static int solve(ArrayList<Integer> A, int B) {
        int min_sum = 0; int index = 0;
        for (int i=0; i<B; i++){
            min_sum += A.get(i);
        }
        int cur_window_sum = min_sum;
        for (int i=B; i<A.size(); i++){
        	cur_window_sum = cur_window_sum - A.get(i-B) + A.get(i);
        	if (cur_window_sum < min_sum) {
        		min_sum = Math.min(min_sum, cur_window_sum);
        		index = i-B+1;
        	}
        }
        
        return index;
    }
    
	public static void main(String[] args) {
		System.out.println(solve(new ArrayList<Integer>(Arrays.asList(15, 7, 11, 7, 9, 8, 18, 1, 16, 18, 6, 1, 1, 4, 18 )), 6));

	}

}
