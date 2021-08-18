package com.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javafx.util.Pair;

public class ValidSudoku {
	
    public int isValidSudoku(final List<String> A) {
    	
    	HashMap<Integer, ArrayList<Pair<Integer, Integer>>> map = 
    			new HashMap<Integer, ArrayList<Pair<Integer, Integer>>>(); 
    	
    	for (int i=0; i<A.size(); i++) {
    		String row = A.get(i);
    		
    		for (int j=0; j<row.length(); j++) {
    			
    			if (row.charAt(j) != '.') {
    				int digit = Integer.parseInt((String.valueOf(row.charAt(j))));
    				
    				if (map.containsKey(digit)) {
    					
    					ArrayList<Pair<Integer, Integer>> ls = map.get(digit);
    					
    					for (Pair<Integer, Integer> indices : ls) {
    						int k = indices.getKey(); 
    						int l = indices.getValue();
        					// condition to check if same row or column 
        					if (k==i || l == j) {
        						return 0;
        					}
        					// condition to check if same sub-box
        					// 1st sub-box
        					else if ((k >=0 && k <=2) && (l >=0 && l <=2)
        							&& (i<=2 && j<=2)){
        						return 0;
        					}
        					// 2nd sub-box
        					else if ((k >=0 && k <=2) && (l >=3 && l <=5)
        							&& (i<=2 && (j>=3 && j <=5))){
        						return 0;
        					}
        					// 3rd sub-box
        					else if ((k >=0 && k <=2) && (l >=6 && l <=8)
        							&& (i<=2 && (j>=6 && j <=8))){
        						return 0;
        					}
        					// 4th sub-box
        					else if ((k >=3 && k <=5) && (l >=0 && l <=2)
        							&& ((i>=3 && i<=5) && j<=2)){
        						return 0;
        					}
        					// 5th sub-box
        					else if ((k >=3 && k <=5) && (l >=3 && l <=5)
        							&& ((i>=3 && i<=5) && (j>=3 && j <=5))){
        						return 0;
        					}
        					// 6th sub-box
        					else if ((k >=3 && k <=5) && (l >=6 && l <=8)
        							&& ((i>=3 && i<=5) && (j>=6 && j <=8))){
        						return 0;
        					}
        					// 7th sub-box
        					else if ((k >=6 && k <=8) && (l >=0 && l <=2)
        							&& ((i>=6 && i<=8) && j<=2)){
        						return 0;
        					}
        					// 8th sub-box
        					else if ((k >=6 && k <=8) && (l >=3 && l <=5)
        							&& ((i>=6 && i<=8) && (j>=3 && j <=5))){
        						return 0;
        					}
        					// 9th sub-box
        					else if ((k >=6 && k <=8) && (l >=6 && l <=8)
        							&& ((i>=6 && i<=8) && (j>=6 && j <=8))){
        						return 0;
        					}
    					}
    					ls.add(new Pair<Integer, Integer>(i,j));
    					map.put(digit, ls);
    					
    				}
    				
    				else {
    					ArrayList<Pair<Integer, Integer>> ls1 = new ArrayList<Pair<Integer, Integer>>();
    					ls1.add(new Pair<Integer, Integer>(i,j));
    					map.put(digit, ls1);
    				}
    			}
    		}
    		
    	}
    	return 1;
    }

	public static void main(String[] args) {
		ValidSudoku isValid = new ValidSudoku();
		List<String> A = new ArrayList<String>(
				Arrays.asList("53..7....", "...195...", 
						".9.....6.", "8...6...3", "4..8.3..1", 
						"7...2...6", ".6....28.", "...419..5", "....8..79"));
		System.out.println(isValid.isValidSudoku(A));

	}

}
