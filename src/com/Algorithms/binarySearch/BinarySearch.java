/* Linear Search
 * Linear Search means to sequentially traverse a given list or array and check if an element is present in the 
 * respective array or list. The idea is to start traversing the array and compare elements of the array one by one 
 * starting from the first element with the given element until a match is found or end of the array is reached.
 * Time Complexity: O(N). Since we are traversing the complete array, so in worst case when the element X does not
 *  exists in the array, number of comparisons will be N. Therefore, worst case time complexity of the 
 *  linear search algorithm is O(N).
 *  
 *  Binary Search
 *  Binary Search is a searching algorithm for searching an element in a sorted list or array. 
 *  Binary Search is efficient than Linear Search algorithm and performs the search operation in logarithmic time 
 *  complexity for sorted arrays or lists.
 *  Binary Search performs the search operation by repeatedly dividing the search interval in half. 
 *  The idea is to begin with an interval covering the whole array. Find the middle index in the search space.
 *  If the value of the search key is less than the item in the middle of the interval, discard the upper half and 
 *  narrow the interval to the lower half. Otherwise narrow it to the upper half by discarding the lower half. 
 *  Repeatedly check until the value is found or the interval is empty.
 *  Iterative binary search algorithm: TC=> O(log2 n) and SC=> O(1)
 *  Recursive binary search algorithm: TC=> O(log2n) and SC=> O(log2 n) for the function call stack in case of recursion
 *  
 *  Ternary Search:
 *  Ternary Search is a Divide and Conquer Algorithm used to perform search operation in a sorted array. 
 *  This algorithm is similar to the Binary Search algorithm but rather than dividing the array into two parts, 
 *  it divides the array into three equal parts.
 *  In this algorithm, the given array is divided into three parts and the key (element to be searched) 
 *  is compared to find the part in which it lies and that part is further divided into three parts.
 *  We can divide the array into three parts by taking mid1 and mid2 which can be calculated as shown below. Initially, l and r will be equal to 0 and N-1 respectively, where N is the length of the array.
 *  mid1 = l + (r-l)/3
 *  mid2 = r – (r-l)/3
 *  First, we compare the key with the element at mid1. If found equal, we return mid1.
 *  If not, then we compare the key with the element at mid2. If found equal, we return mid2.
 *  If not, then we check whether the key is less than the element at mid1. If yes, then recur to the first part.
 *  If not, then we check whether the key is greater than the element at mid2. If yes, then recur to the third part.
 *  If not, then we recur to the second (middle) part between mid1 and mid2.
 *  Time Complexity: O(Log3N), where N is the number of elements in the array.
 */

package com.Algorithms.binarySearch;
import java.io.*;
import java.util.*;

public class BinarySearch {

    static int binarySearch_Iterative(int[] a, int x) {
        int left = 0, right = a.length-1;
        while (right >= left)
		{
			int mid = (int)(Math.floor((right+left)/2));
			
			if (a[mid] == x)
				return mid;
			else if (a[mid] < x)
				left = mid+1;
			else if (a[mid] > x)
				right = mid-1;
		}
        return -1;
    }
    
    static int binarySearch_Recursive(int [] a, int key, int start, int end) {
    	if (start> end) 
    		return -1;
    	
    	int mid = start + ((end-start)/2);
   		
    	if (a[mid] == key) 
    		return mid; 
    		
    	else if (a[mid] < key) 
    		return binarySearch_Recursive(a, key, mid+1, end);
    		
    	else 
    		return binarySearch_Recursive(a, key, start, mid-1);
    		
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }
    
    static int ternarySearch_Iterative(int [] a, int x) {
    	int l = 0; int r = a.length -1;
    	
    	while (l<=r) {

    		// find m1 and m2 to divide the array into 3 equal parts.
    		// P1-> l to m1-1
    		// P2-> m1 to m2
    		// P3-> m2+1 to r
    		int m1 = l + ((r - l)/3);
    		int m2 = r - ((r - l)/3);
    		
    		// check if key is at m1 index
    		if (a[m1] == x)
    			return m1;
    		
    		// check if key is at m2 index
    		if (a[m2] == x)
    			return m2;
    		
    		// if key is not a m1 or m2 then check the 3 parts. Choose one part and discard 2 parts
    		
    		// if the key is less than element at m1, then the key is in P1.  
    		else if (x < a[m1])
    			r = m1-1;

    		// if key is greater than the element at m2, then the key is in P3
    		else if (x > a[m2])
    			l = m2+1;
    		
    		// if key is greater than element at m1 but less than the elementat m2 then key is in P2
    		else {
    			l = m1+1;
    			r = m2-1;
    		}
    	}
    	return -1; // key not found
    }
    
    static int ternarySearch_Recursive(int ar[], int key, int l, int r) 
    { 
        if (r >= l) 
        { 
            // Find mid1 and mid2 
            int mid1 = l + (r - l) / 3; 
            int mid2 = r - (r - l) / 3; 
      
            // Check if key is present at any mid 
            if (ar[mid1] == key)  
            { 
                return mid1; 
            } 
            if (ar[mid2] == key) 
            { 
                return mid2; 
            } 
      
            // Since key is not present at mid, 
            // check in which region it is present 
            // then repeat the Search operation 
            // in that region 
            if (key < ar[mid1])  
            { 
      
                // The key lies in between l and mid1 
                return ternarySearch_Recursive(ar, key, l, mid1-1); 
            } 
            else if (key > ar[mid2])  
            { 
      
                // The key lies in between mid2 and r 
                return ternarySearch_Recursive(ar, key, mid2 + 1, r); 
            } 
            else
            { 
      
                // The key lies in between mid1 and mid2 
                return ternarySearch_Recursive(ar, key, mid1 + 1, mid2 - 1); 
            } 
        } 
      
        // Key not found 
        return -1; 
    }
    
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
   
        int[] b = new int[m];
        
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
          
          
        }
        for (int i = 0; i < m; i++) {
            System.out.println(binarySearch_Iterative(a, b[i]) + " ");
            System.out.println(binarySearch_Recursive(a, b[i],0,a.length-1) + " ");
            System.out.println(ternarySearch_Iterative(a, b[i]) + " ");
            System.out.println(ternarySearch_Recursive(a, b[i],0,a.length-1) + " ");
            System.out.println(linearSearch(a, b[i]) + " ");
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
