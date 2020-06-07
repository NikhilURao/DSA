package com.dp;
import java.util.*;

class EditDistance 
{
  public static int EditDistance(String s, String t) 
  {
    int [][] dptab = new int [s.length()+1][t.length()+1];
    
    for (int i=0; i<=s.length(); i++)
    {
    	for (int j=0; j<=t.length(); j++)
    	{
    		if (i==0)
    		{
    			dptab[i][j] = j;
    		}
    			
    		else if (j==0)
    		{
    			dptab[i][j] = i;
    		}
    			
    		else if (s.charAt(i-1) == t.charAt(j-1))
    		{
    			dptab[i][j] = dptab[i-1][j-1];
    		}
    		
    		else
    		{
    			dptab[i][j] = minimumOf3( dptab[i-1][j-1], dptab[i][j-1], dptab[i-1][j]) + 1 ;
    		}
    	}
    }

	  return dptab[s.length()][t.length()];
  }
  
  public static int minimumOf3 (int n1, int n2, int n3)
  {
	  int res = Math.min(n1, n2);
	  res = Math.min(res, n3);
	  return res;
  }
  public static void main(String args[]) 
  {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();
    
    System.out.println(EditDistance(s, t));
  }

}

