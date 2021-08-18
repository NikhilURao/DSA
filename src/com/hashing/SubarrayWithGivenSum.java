package com.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SubarrayWithGivenSum {
	
	public static ArrayList<Integer> getSubarrayWithGivenSum(ArrayList<Integer> A, int B){
		int curSum =0;
		int j=-1;
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		
		for (int i=0; i<A.size();i++) {
			curSum += A.get(i);
			
			if ((curSum - B) == 0) {
				ArrayList<Integer> res = new ArrayList<Integer>();
				for (int k=0; k<=i; k++) {
					res.add(A.get(k));
				}
				return res;//new ArrayList<Integer>(Arrays.asList(A.get(0),A.get(i)));
			}
			
			if (hmap.containsKey(curSum - B)) {
				ArrayList<Integer> res = new ArrayList<Integer>();
				for (int k=hmap.get((curSum - B))+1; k<=i; k++) {
					res.add(A.get(k));
				}
				return res;//new ArrayList<Integer>(Arrays.asList(A.get(hmap.get(curSum - B)+1),A.get(i))); 
			}
			
			hmap.put(curSum, i);
		}
		
		return new ArrayList<Integer>(Arrays.asList(-1));
	}
	public static int solve(ArrayList<Integer> A) {
        int curSum =0;
		HashSet<Integer> hset = new HashSet<Integer>();
		
		for (int i=0; i<A.size();i++) {
			curSum += A.get(i);
			
			if (A.get(i)==0 || curSum == 0 || hset.contains(curSum)){
			    return 1;
			}
			
			hset.add(curSum);
    }
    
    return 0;
}
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));//42, 9, 38, 36, 48, 33, 36, 50, 38, 8, 13, 37, 33, 38, 17, 25, 50, 50, 41, 29, 34, 18, 16, 6, 49, 16, 21, 29, 41, 7, 37, 14, 5, 30, 35, 26, 38, 35, 9, 36, 34, 39, 9, 4, 41, 40, 3, 50, 27, 17, 14, 5, 31, 42, 5, 39, 38, 38, 47, 24, 41, 5, 50, 9, 29, 14, 19, 27, 6, 23, 17, 1, 22, 38, 35, 6, 35, 41, 34, 21, 30, 45, 48, 45, 37));
		getSubarrayWithGivenSum(arr, 5).forEach(s-> System.out.print(s+" "));
		System.out.println(solve(arr));

	}

}
