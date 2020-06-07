package com.dp;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TileIt 
{
    public int GetMaxScore(int A, int [][] B)
    {
        int [] dp_tab = new int [10005];
        Arrays.fill(dp_tab, 0);
        
        for (int i=A-1; i>=0; i--)
        {
            dp_tab[i] = Math.max((B[i][0] + dp_tab[i+1]), B[i][1] + dp_tab[i+2]);
        }
        
        return dp_tab[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int [][] B = new int[A][2];
        for (int i=0; i<A; i++)
        {
            for (int j=0; j<2; j++)
            {
                B[i][j] = sc.nextInt();
            }
        }
        
        TileIt s = new TileIt();
        System.out.println(s.GetMaxScore(A, B));
                              
    }
}
