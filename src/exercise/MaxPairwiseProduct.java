package exercise;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.ToLongFunction;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(long[] numbers) {
        long max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = Math.max(max_product,
                    numbers[first] * numbers[second]);
            }
        }

        return max_product;
    }
    
    static long getMaxPairwiseProductFast(long[] numbers) {
        int index1 = 0;
        long n = numbers.length;
        
        for (int i=1;i<n;i++) {
        	
        		if ((index1 == 0) || (numbers[i] > numbers[index1])) {
        			index1 = i;
        		}
        	}
        int index2 = 0;
        for (int j=1; j<n;j++) {
        	if((j!=index1) && (numbers[j]>numbers[index2])) {
        		index2 = j;
        	}
        }
        return numbers[index1]*numbers[index2];
        
    }

    public static void main(String[] args) {
    	//Stress Test
    	/*while(true) {
    		Random ran = new Random(21);
    		
    		int n = ran.nextInt(100) +2;
    		long a [] = new long[n];
    		
    		for (int i=0;i<n;i++) {
    			long num = ThreadLocalRandom.current().nextLong(0,1000);
    			a[i] = num;
    		}
    		
    		for (int i=0;i<n;i++) {
    			System.out.print(a[i]+" ");
    		}
    		System.out.println();
    		long res1 = getMaxPairwiseProduct(a);
    		long res2 = getMaxPairwiseProductFast(a);
    		
    		if (res1 == res2) {
    			System.out.println("OK");
    		}
    		else {
    			System.out.println("WRONG "+res1+" "+res2);
    			break;
    		}
    		
    	}*/
    	
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        //System.out.println(getMaxPairwiseProduct(numbers));
        System.out.println(getMaxPairwiseProductFast(numbers));
        
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
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
