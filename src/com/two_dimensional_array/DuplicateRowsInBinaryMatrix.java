/*
 * Find duplicate rows in a binary matrix
Given a binary matrix A of integers 0 and 1, of size N x M.

Find and return the indices of the rows which are duplicate of rows which are already present in the matrix.

If row[i] and row[j] are same and i < j then answer will contain only index j.

Note: Rows are numbered from top to bottom and columns are numbered from left to right. There will be at least one duplicate row in the matrix.


Input Format

The first argument given is the integer matrix A.
Output Format

Return the indices of the rows in the form of an integer array.
Constraints

2 <= N, M <= 1000
0 <= A[i] <= 1
For Example

Input 1:
    A = [   [1, 0, 0]
            [0, 1, 0]
            [0, 1, 0]   ]
Output 1:
    [3]

Input 2:
    A = [   [1, 1, 1, 0]
            [0, 0, 0, 1]
            [1, 1, 1, 0]
            [0, 0, 0, 1]    ]
Output 2:
    [3, 4]


 */
package com.two_dimensional_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Trie
{
    boolean isLeaf;    // set when the node is a leaf node
    Trie[] character = new Trie[2];
 
    // Constructor
    Trie() {
        isLeaf = false;
    }
}
public class DuplicateRowsInBinaryMatrix {
	
    public static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        HashSet<Integer> hs = new HashSet<Integer>();
        ArrayList<Integer> duplicateRows = new ArrayList<Integer>();
        for (int i=0; i<A.size(); i++){
            int decimalValue = 0;
            for (int j=0; j<A.get(i).size(); j++){
                decimalValue += A.get(i).get(j) * Math.pow(2, A.get(i).size() - j -1);
            }
            
            if (hs.contains(decimalValue))
                duplicateRows.add(i+1);
            else hs.add(decimalValue);
        }
        
        return duplicateRows;
    }
    
    public static boolean insert(Trie head, ArrayList<Integer>  a)
    {
        // start from the root node
        Trie curr = head;
 
        for (int i: a)
        {
            // create a new node if the path doesn't exist
            if (curr.character[i] == null) {
                curr.character[i] = new Trie();
            }
 
            // go to the next node
            curr = curr.character[i];
        }
 
        // if the row is inserted before, return false
        if (curr.isLeaf) {
            return false;
        }
 
        // mark leaf node and return true
        return (curr.isLeaf = true);
    }
    
    public static ArrayList<Integer> solve1(ArrayList<ArrayList<Integer>> A) {
    	ArrayList<Integer> duplicateRows = new ArrayList<Integer>();
    	Trie head = new Trie();
    	for (int i = 0; i < A.size(); i++)
        {
            if (!insert(head, A.get(i))) {
            	duplicateRows.add(i+1);
            }
        }
		return duplicateRows;
    }

	public static void main(String[] args) {
		/*
		 * A : 
[
  [1, 0, 0]
  [0, 1, 0]
  [0, 1, 0]
]
		 */
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		arr.add(new ArrayList<Integer>(Arrays.asList(1, 0, 0)));
		arr.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0)));
		arr.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0)));
		solve(arr).forEach(p -> System.out.print(p+" "));
		System.out.println();
		solve1(arr).forEach(p -> System.out.print(p+" "));
	}

}
