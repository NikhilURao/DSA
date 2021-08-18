package com.Algorithms.binarySearch;
import java.io.*;
import java.util.*;

public class BinarySearch {

    static int binarySearch(int[] a, int x) {
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

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
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
            System.out.print(binarySearch(a, b[i]) + " ");
            //System.out.print(linearSearch(a, b[i]) + " ");
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
