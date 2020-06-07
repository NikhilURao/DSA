package com.dp;
import java.util.*;

public class LCS2 {

    private static int LongestCommonSubsequenceOf2(int[] a, int[] b) 
    {
    	int [][] t = new int [a.length+1][b.length+1];
    	
    	for (int i=0; i<=a.length; i++)
    	{
    		for (int j=0; j<=b.length; j++)
    		{
    			if (i==0 || j==0)
    			{
    				t[i][j] = 0;
    			}
    			
    			else if (a[i-1] == b[j-1])
    			{
    				t[i][j] = t[i-1][j-1] + 1;
    			}
    			else 
    				t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
    		}
    	}
    	
    	return t[a.length][b.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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

        System.out.println(LongestCommonSubsequenceOf2(a, b));
    }
}

