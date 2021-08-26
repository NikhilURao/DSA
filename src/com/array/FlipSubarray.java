package com.array;

import java.util.ArrayList;

public class FlipSubarray {
	
    public static ArrayList<Integer> flip(String A) {
    	ArrayList<Integer> index = new ArrayList<Integer>();
    	int numOnes = 0;
    	char [] charA = A.toCharArray();
    	int [] intA = new int [charA.length];
    	// construct intA by replacing all 1s with -1s and 0s with 1s
    	for (int i=0; i<charA.length; i++) {
    		if (charA[i] == '1') {
    			numOnes++;
    			intA[i] = -1; 
    		}
    		else 
    			intA[i] = 1;
    	}
    	
    	// use Kadane's Algorithm to determine subarray with max sum i.e with greater number of 0s than 1s
    	int curSum = intA[0]; int maxSum = intA[0];
    	int start = 0; int end = 0; int _start = 0; int _end = 0;
    	int i=1;
    	while (i<intA.length) {
    		if (curSum >= 0) {
    			curSum += intA[i];
    			end = i;
    		}
    		else {
    			curSum = intA[i];
    			start = i;
    			end = i;
    		}
    		
    		if (curSum > maxSum) {
    			maxSum = curSum;
    			_start = start;
    			_end = end;
    		}
    		
    		i++;
    	}
    	if (_end < _start)
    			_end = end;
    	if (numOnes < numOnes + maxSum) {
        	index.add(_start+1);
        	index.add(_end+1);
    	}
    	return index;
    }

	public static void main(String[] args) {
		ArrayList<Integer> MaxSubarrayIndex = flip("1101010001");
		System.out.print(MaxSubarrayIndex.get(0)+" "+MaxSubarrayIndex.get(1));

	}

}
