/*
 * Majority Element
Problem Description

Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.
You may assume that the array is non-empty and the majority element always exist in the array.

Example :

Input : [2, 1, 2]
Return  : 2 which occurs 2 times which is greater than 3/2.

Brute force approach:
Iterate over the array and calculate the occurrence of each element in the array 
and store the frequency of occurrence in a hashmap. Iterate over the hashmap and
return the element with occurrence greater than n/2.
TC => O(n) SC=> O(n) for hashmap worst case has n elements


Efficient Solution with constant SC:
1. Assume ME to be at index 0 of A. ME assume A[0]. 2 variable assumed_ME=A[0] and 
assumed_ME_count = 1.
2. Iterate over the array and if you find assumed ME at a index increment the
assumed_ME_count. If you find a non-ME at any index then decrement assumed_ME_count 
because "Given an array of size N, if we delete one occurrence of ME and 
one occurrence of non-ME then the ME will still be the old ME; it will not change
the ME in the new array of size N-2".
3. If at any point during the above operation assumed_ME_count becomes 0 
assume the element in the very next index to be our new assumed ME and reset 
assumed_ME_count to 1.
4. After completely iterating over the array once we have a candidate for ME in 
variable assumed_ME. Confirm if the assumed ME is actual ME by iterating once over 
the array again and counting the occurrence of assumed ME. If count > n/2 return 
assumed_ME else -1.

TC => O(n) SC=> O(1)


 */

package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	
	public static int findMajorityElementBruteForce(ArrayList<Integer> A) {
		HashMap<Integer, Integer> frequency_map = new HashMap<>();
		
		// hash A
		for (int i=0; i<A.size(); i++) {
			frequency_map.put(A.get(i), frequency_map.getOrDefault(A.get(i),0)+1);
		}
		
		for (Map.Entry<Integer, Integer> element: frequency_map.entrySet()) {
			if (element.getValue() > A.size()/2)
				return element.getKey();
		}
		
		return -1;
	}
	public static int findMajorityElementOptimised(ArrayList<Integer> A) {
		int assumed_ME = A.get(0);
		int assumed_ME_count = 1;
		
		for (int i=1; i<A.size(); i++) {
			if (assumed_ME_count <=0) {
				assumed_ME = A.get(i);
				assumed_ME_count = 1;
			}
			else {
			if (A.get(i) == assumed_ME)
				assumed_ME_count++;
			else
				assumed_ME_count--;
			}
		}
		int actual_count=0;
		for (int i=0; i<A.size(); i++) {
			if (A.get(i)==assumed_ME)
				actual_count++;
		}
		
		return actual_count > A.size()/2? assumed_ME : -1;
		
	}

	public static void main(String[] args) {
		System.out.println(
				findMajorityElementBruteForce
				(new ArrayList<Integer>(Arrays.asList(3,4,4,3,4,2,4,4,3))));
		
		System.out.println(
				findMajorityElementOptimised
				(new ArrayList<Integer>(Arrays.asList(3,4,4,3,4,2,4,4,3))));

	}

}
