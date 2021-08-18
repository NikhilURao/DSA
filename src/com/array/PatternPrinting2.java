package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class PatternPrinting2 {
	public static ArrayList<ArrayList<Integer>> solve(int A) {
		// Initialize 2D arraylist with nulls/0s
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for (int i=0; i<A; i++){
        	ArrayList<Integer> arr = new ArrayList<Integer>(Collections.nCopies(A, 0));
            res.add(arr);
        }
        
        for (int i=0; i<res.size(); i++){ 
        	int j=res.size()-1;
        	for (int val=1; val<=i+1; val++) {
        		res.get(i).set(j, val);
        		j--;
        	}

	}
        
        return res;
	}

	public static void main(String[] args) {
		
		//ArrayList<ArrayList<Integer>> res = solve(3);
		ArrayList<Integer> A = new ArrayList<Integer>
		(Arrays.asList(9,1,5,19,4,22));
        int dif=0; int fmin=Integer.MAX_VALUE;int smin=Integer.MAX_VALUE;
        for (int i=0;i<A.size();i++){
            if (A.get(i)<fmin){
                smin = fmin;
                fmin = A.get(i);
            }
            
            else if (A.get(i)<smin) {
            	smin = A.get(i);
            	
            }
        }
        
        System.out.println(fmin+"   "+smin);
		/*for (int i=0; i<res.size(); i++){ 
            for (int j=0; j<res.size(); j++){
                System.out.print(res.get(i).get(j)+" ");
            }
            
            System.out.println();*/
            

	}

}

