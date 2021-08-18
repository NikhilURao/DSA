package com.two_dimensional_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AntiDiagonals {
    public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> res = 
        		new ArrayList<ArrayList<Integer>>((2*A.size())-1);
        for (int i=0; i<(2*A.size())-1; i++) {
        	res.add(new ArrayList<Integer>(Collections.nCopies(A.size(),0)));
        }
        
        for (int i=0;i<A.size();i++){ // row index
            for (int j=0; j<A.get(i).size();j++){ // col index
                if (i+j < A.get(i).size())
                    res.get(i+j).set(i,A.get(i).get(j));
                else
                    res.get(i+j).set(A.get(i).size()-1-j,A.get(i).get(j));
                // if (j==A.get(i).size()-1){
                //     res.get(i+j).set(0,A.get(i).get(j));
                // }
                // else if (i==A.size()-1) {
                // 	res.get(i+j).set(i-j,A.get(i).get(j));
                // }
                // else if (i==j && i!=0 && i==A.size()-2) {
                // 	res.get(i+j).set(1,A.get(i).get(j));
                // }
                // else{
                // 	res.get(i+j).set(i,A.get(i).get(j));
                // }
   
            }
            
        }
        return res;
    }
    
	public static void print2DArray (ArrayList<ArrayList<Integer>> a) {
		for (int i=0; i<a.size(); i++) {
			for (int j=0; j<a.get(i).size(); j++) {
				System.out.print(a.get(i).get(j)+" ");
			}
			System.out.println(" ");
		}
	}
    

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> input_array = new ArrayList<ArrayList<Integer>>(3);
		input_array.add(new ArrayList<Integer>(Arrays.asList(1,2,3,4)));
		input_array.add(new ArrayList<Integer>(Arrays.asList(5,6,7,8)));
		input_array.add(new ArrayList<Integer>(Arrays.asList(9,10,11,12)));
		input_array.add(new ArrayList<Integer>(Arrays.asList(13,14,15,16)));
		//input_array.add(new ArrayList<Integer>(Arrays.asList(21,22,23,24,25)));
		print2DArray(diagonal(input_array));
		

	}

}
