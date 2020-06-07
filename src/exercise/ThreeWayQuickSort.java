package exercise;
import java.io.*;
import java.util.*;

public class ThreeWayQuickSort 
{
    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) 
    { 
    	int i = l;
    	int mid = l;
    	int j = r;
    	int x = a[l];
    	
    	while (mid <= j && i < r)
    	{
    		if (a[mid] < x)
    		{
    			// inc i; swap a[mid] with a[i]; inc mid
    			i++;
    			int temp = a[mid];
    			a[mid] = a[i];
    			a[i] = temp;
    			mid++;
    		}
    		
    		else if (a[mid] == x)
    			mid ++;
    		
    		else if (a[mid] > x)
    		{
    			// swap a[mid] and a[j]; dec a[j]
    			int temp = a[mid];
    			a[mid] = a[j];
    			a[j] = temp;
    			
    			j--;
    		}
    	}
    	// swap a[l] and a[i]
    	int temp = a[l];
    	a[l] = a[i];
    	a[i] = temp;
    	
    	int [] m = {i,j};
    	return m;
    }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        int [] m = partition3(a, l, r); 
        randomizedQuickSort(a, l, m[0] - 1);
        randomizedQuickSort(a, m[1] + 1, r);
        /*
        int m = partition2(a, l, r);
        randomizedQuickSort(a, l, m - 1);
        randomizedQuickSort(a, m + 1, r);
        */
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
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

