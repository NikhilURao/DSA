package com.array;

import java.util.ArrayList;
import java.util.Arrays;

public class CountWaySumOfOddEvenIndexedElementsEqualByRemovingAnArrayElement {

    public static int solve(ArrayList<Integer> A) {
    	int count = 0; // count the number of special elements 
    	// Calculate prefix odd indexed elements sum in the array
    	// Calculate prefix even indexed elements sum in the array
    	int [] prefix_odd = new int [A.size()+1];
    	Arrays.fill(prefix_odd, 0);
    	int [] prefix_even = new int [A.size()+1];
    	Arrays.fill(prefix_even, 0);
    	for (int i=1; i<prefix_odd.length; i++) {
    		if (i%2!=1) {
    			prefix_odd[i] = prefix_odd[i-1] + A.get(i-1);
    			prefix_even[i] = prefix_even[i-1];
    		}

    		
    		else {
    			prefix_odd[i] = prefix_odd[i-1];
    			prefix_even[i] = prefix_even[i-1] + A.get(i-1);
    		}
    			
    	}
    	for (int i=0; i<A.size(); i++) {
    		int sum_odd_indexElements = prefix_odd[i] + 
    				(prefix_even[A.size()] - prefix_even[i+1]); 
    		int sum_even_indexElements = prefix_even[i] + 
    				(prefix_odd[A.size()] - prefix_odd[i+1]);
    		
    		if (sum_odd_indexElements == sum_even_indexElements)
    			count++;
    	}
		return count;
    }
	
	public static void main(String[] args) {
		System.out.println(solve(new ArrayList<Integer>(Arrays.asList(1,1,1))));

	}

}
