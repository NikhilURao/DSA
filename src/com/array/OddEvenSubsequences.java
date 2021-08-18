/*
 * Given an array of integers A of size N. Find the longest subsequence of A which is odd-even.

A subsequence is said to odd-even in the following cases:

The first element of the subsequence is odd, second element is even, third element is odd and so on. For example: [5, 10, 5, 2, 1, 4], [1, 2, 3, 4, 5]

The first element of the subsequence is even, second element is odd, third element is even and so on. For example: [10, 5, 2, 1, 4, 7], [10, 1, 2, 3, 4]

Return the maximum possible length of odd-even subsequence.

Note: An array B is a subsequence of an array A if B can be obtained from A by deletion of several (possibly, zero or all) elements.

Input 1:
    A = [1, 2, 2, 5, 6]
Output 1:
    4
    Explanation 1:
        Maximum length odd even subsequence is [1, 2, 5, 6]

Input 2:
    A = [2, 2, 2, 2, 2, 2]
Output 2:
    1
    Explanation 2:
        Maximum length odd even subsequence is [2]
 */
package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class OddEvenSubsequences {
	
	public int countOddEvenSubsequences(ArrayList<Integer> A) {
		int count=0; char nxt;
		if(A.get(0)%2==0)
			nxt = 'e';
		else nxt = 'o';
		
		for (int i=0; i<A.size();i++) {
			if (nxt=='o' && A.get(i)%2==0) {
				count++;
				nxt='e';
			}
			else if(nxt=='e' && A.get(i)%2!=0) {
				count++;
				nxt='o';
			}
		}
		
		return count+1;
	}

	public static void main(String[] args) {
		ArrayList<Integer> arr = 
				new ArrayList<Integer>(Arrays.asList(2,2,2,2,2));
		OddEvenSubsequences ods = new OddEvenSubsequences();
		System.out.println(ods.countOddEvenSubsequences(arr));
		HashMap<Integer, Integer> map = new HashMap<>();
		HashSet<Integer> set = new HashSet<>();
		set.contains(2);
		set.add(10);
		set.remove(10);
		for (int num: set) {
			
		}
	}

}
