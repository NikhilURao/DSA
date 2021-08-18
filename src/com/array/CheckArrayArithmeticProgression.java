package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CheckArrayArithmeticProgression {
	
	public static int CheckIfArrayArithmeticProgression(ArrayList<Integer> A) {
        HashSet<Integer> hs = new HashSet<Integer>(A.size());
        for (int i=0;i<A.size();i++){
            if (!hs.contains(A.get(i))){
                hs.add(A.get(i));
            }
        }
        
        int fmin=Integer.MAX_VALUE;int smin=Integer.MAX_VALUE;
        for (int i=0;i<A.size();i++){
            if (A.get(i)<fmin){
                smin = fmin;
                fmin = A.get(i);
            }
            else if (A.get(i)<smin) {
            	smin = A.get(i);
            }
        }
        
        int dif=smin-fmin;
        int i=0;
        while (i<A.size()){
            if (!hs.contains(fmin+(dif*i))){
                return 0;
            }
            i++;
        }
        
        return 1;
        
    }

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,4,7,10));
		System.out.println(CheckIfArrayArithmeticProgression(A));
	}

}
