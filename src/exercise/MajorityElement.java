package exercise;

import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
    	
    	int n = a.length;
    	HashMap<Integer, Integer> h_map = new HashMap<>();
    	
    	for (int i=0; i<n; i++)
    	{
    		if (!h_map.containsKey(a[i]))
    		{
    			h_map.put(a[i], 1);
    		}
    		else 
    		{
    			h_map.put(a[i], h_map.get(a[i])+1);
    		}
    	}
    	
    	//System.out.println(h_map);
    	
    	for (int count : h_map.values())
    	{
    		if (count > n/2)
    		{
    			return 1;
    		}
    	}
    	return 0;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(getMajorityElement(a, 0, a.length));
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


