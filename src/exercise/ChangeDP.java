package exercise;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class ChangeDP 
{
    private static int getChangeBottomUpApproach(int m, int [] coins) 
	{
    	int [] T = new int [m+1];
    	Arrays.fill(T, Integer.MAX_VALUE-1);
    	T[0] = 0;
    		
        	for (int i=0; i<coins.length; i++)
        	{
        		for (int j=1; j<=m; j++)
        		{
        			if (j >= coins[i])
        			{
        				if (T[j - coins[i]]+1 < T[j])
        				{
        					T[j] = T[j - coins[i]]+1;
        				}
        			}
        		}
        	}
        	return T[m];
	}

    private static int getChangeTopDown(int m, int [] coins, TreeMap<Integer, Integer> map)
    {
    	if (m == 0)
    		return 0;
    	else 
    	{
    		if (map.containsKey(m))
    			return map.get(m);
    		
    		for (int i=0; i<coins.length; i++)
    		{
    			int min = Integer.MAX_VALUE;
    			if (m >= i)
    			{
    				min = Math.min(min, getChangeTopDown(m - coins[i], coins,map));
    			}
    		}
    	}
    	
    	map.put(key, value)
    }

    public static void main(String[] args) 
	{
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int [] coins = {4,3,1};
        System.out.println(getChange(m));

    }
}


