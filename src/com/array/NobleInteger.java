/*
 * Noble Integer
Given an integer array, find if an integer p exists in the 
array such that the number of integers greater than p in the 
array equals to p 


×

 */
package com.array;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NobleInteger {
	
	
	public static int findNobleInteger(ArrayList<Integer> A) {
        Collections.sort(A);
        for (int i=0;i<A.size();i++){
            if ( i+1< A.size() && A.get(i)==A.get(i+1)){
                continue;
                }
            else{
                if (A.get(i)==A.size()-1-i){
                    return A.get(i);
            }
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,2,4,1,5,3,4));
		System.out.println(findNobleInteger(A));

	}

}
