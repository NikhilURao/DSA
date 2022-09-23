/*
 * 
 * 72. Edit Distance a.k.a minimum number of ops to convert str1 to str2

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 

Constraints:

0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters.
 * 
 */

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
  public static void main(String args[]) {

    String s = "horse";
    String t = "ros";
    
    System.out.println(EditDistance(s, t));
  }

}

