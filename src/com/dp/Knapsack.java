package com.dp;
import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        
    	int n = w.length;
    	int [][] k = new int [n+1][W+1];
        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= W; j++)
            {
                if (i==0 || j==0)
                    k[i][j] = 0;
                else if (w[i-1] <= j)
                    k[i][j] = Math.max(w[i-1] + k[i-1][j-w[i-1]],  k[i-1][j]);
                else
                    k[i][j] = k[i-1][j];
            }
        }
    	/*
        int result = 0;
        for (int i = 0; i < w.length; i++) {
          if (result + w[i] <= W) {
            result += w[i];
          }
        }
        */
        return k[n][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}


