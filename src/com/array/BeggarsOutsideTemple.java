/*
 * There are N (N > 0) beggars sitting in a row outside a temple. Each beggar initially has an empty pot. 
 * When the devotees come to the temple, they donate some amount of coins to these beggars. 
 * Each devotee gives a fixed amount of coin(according to his faith and ability) to some K beggars 
 * sitting next to each other.
 * 
 * Given the amount donated by each devotee to the beggars ranging from i to j index, 
 * where 1 <= i <= j <= N, find out the final amount of money in each beggar's pot at the end of the day, 
 * provided they don't fill their pots by any other means.

Example:

Input:
N = 5, D = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]

Return: [10, 55, 45, 25, 25]

Explanation:
=> First devotee donated 10 coins to beggars ranging from 1 to 2. Final amount in each beggars pot after 
first devotee: [10, 10, 0, 0, 0]

=> Second devotee donated 20 coins to beggars ranging from 2 to 3. 
Final amount in each beggars pot after second devotee: [10, 30, 20, 0, 0]

=> Third devotee donated 25 coins to beggars ranging from 2 to 5. 
Final amount in each beggars pot after third devotee: [10, 55, 45, 25, 25]

Solution Approach: Optimized Approach

1) Initialize an array donations of size A(# beggars) with all element value 0
2) For each of devotees ([L,R,Amt]) set donations[L-1] += Amt
3) For each of devotees ([L,R,Amt]) set donations[R] -= Amt
4) Calculate cumulative sum/ prefix sum of donations in place and return value.

TC = O(n)
SC = O(n)
 */
package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BeggarsOutsideTemple {
	
	public static ArrayList<Integer> calculateDonations(int A, ArrayList<ArrayList<Integer>> B){
		ArrayList<Integer> donationsMoney = new ArrayList<Integer>(Collections.nCopies(A, 0));
		for (int i=0; i<B.size(); i++) {
			ArrayList<Integer> devotees = B.get(i);
			int start = devotees.get(0);
			int end = devotees.get(1);
			int amt = devotees.get(2);
			if (start>0) {
				donationsMoney.set(start-1, donationsMoney.get(start-1)+amt);
			}
			if (end<donationsMoney.size()) {
				donationsMoney.set(end, donationsMoney.get(end)-amt);
			}
		}
		
		for (int i=1; i<donationsMoney.size();i++) {
			donationsMoney.set(i, donationsMoney.get(i-1)+donationsMoney.get(i));
		}
		return donationsMoney;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		// [1, 2, 10], [2, 3, 20], [2, 5, 25]
		B.add(new ArrayList<Integer>(Arrays.asList(1, 2, 10)));
		B.add(new ArrayList<Integer>(Arrays.asList(2, 3, 20)));
		B.add(new ArrayList<Integer>(Arrays.asList(2, 5, 25)));
		calculateDonations(5, B).forEach(p->System.out.print(p+" "));

	}

}
