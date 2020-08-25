package exercise;
import java.math.BigInteger;
import java.util.Queue;
import java.util.Stack;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import com.trees.BTNode;

/*
 * n! = n*(n-1)*........*1
 */

public class practice {
	
	public void lvlOrderTraverse(BTNode root)
	{
		if (root != null)
		{
			Queue<BTNode> q = new LinkedList<BTNode>();
			q.add(root);
			
			while (!q.isEmpty())
			{
				BTNode temp = q.remove();
				System.out.print(temp.data+" ");
				
				if (temp.left != null)
				{
					q.add(temp.left);
				}
				if (temp.right != null)
				{
					q.add(temp.right);
				}
			}
		}
		
	}
	
	public int FactorialIterative(int n)
	{
		int fact = 1;
		for (int i=n;i>=1;i--)
		{
			fact = fact * i;
		}
		
		return fact;
	}
	
	public int FactorialRec(int n)
	{
		if (n<=1)
		{
			return 1;
		}
		else
		{
			return n*FactorialRec(n-1);
		}
	}
	
	private static int[] partition3(int[] a, int l, int r) 
    {
    	int x = a[l];
    	int j = l;
    	int low = l;
    	int mid = l;
    	int high = r;
    	
    	while (mid <= r)
    	{
    		if (a[mid] < a[j])
    		{
    			int temp = a[mid];
    			a[mid] = a[low];
    			a[low] = temp;
    			low++;
    			mid++;
    		}
    		
    		else if (a[mid] > a[j])
    		{
    			int temp = a[mid];
    			a[mid] = a[high];
    			a[high] = temp;
    			high--;
    		}
    		
    		else if (a[mid] == a[j])
    			mid++;
    	}
    	
    	int temp = a[j];
    	a[j] = a[low - 1];
    	a[low - 1] = temp;
    	int [] m = {low, high};
    	
    	for (int i=0; i<a.length; i++)
    	{
    		System.out.print(a[i]+" ");
    	}
    	return m; 
    	
    	
    }
	
	public int MakeChange(int m, int[] coins)
	{
		int [] [] table = new int [coins.length+1][m+1];
		
		for (int [] rows : table)
		{
			Arrays.fill(rows, 0);
		}
		
		for (int row=0; row<= coins.length; row++)
		{
			table[row][0] = 1;
		}
		
		for (int col=0; col<=m; col++)
		{
			table[1][col] = 1;
		}
		
		for (int i=1; i<=coins.length; i++)
		{
			for (int j=1; j<=m; j++)
			{
				if (m >= coins[i])
				{
					table[i][j] = table[i-1][j] + table[i][j - coins[i - 1]];
				}
				else
				{
					table[i][j] = table[i-1][j];
				}
			}
		}
		
		for (int i=0; i<=coins.length; i++)
		{
			for (int j=0; j<=m; j++)
			{
				System.out.print(table[i][j]+" ");
			}
			System.out.println();
		}
		
		return 0;
	}

	
    public int minimumCoinBottomUp(int total, int coins[])
    {
        int T[] = new int[total + 1];
        int R[] = new int[total + 1];
        T[0] = 0;
        
        for(int i=1; i <= total; i++)
        {
            T[i] = Integer.MAX_VALUE-1;
            R[i] = -1;
        }
        
        for(int j=0; j < coins.length; j++)
        {
            for(int i=1; i <= total; i++)
            {
                if(i >= coins[j])
                {
                    if (T[i - coins[j]] + 1 < T[i]) 
                    {
                        T[i] = 1 + T[i - coins[j]];
                        R[i] = j;
                    }
                }
            }
        }
		return T[total]; 
		
		
		
    }

	public static void main(String[] args) {
		/*
		BTNode root = new BTNode(7);
		root.left = new BTNode(6);
		root.right = new BTNode(11);
		root.left.left = new BTNode(14);
		root.left.right = new BTNode(5);
		root.right.left = new BTNode(2);
		root.right.right = new BTNode(4);
		
		practice p = new practice();
		p.lvlOrderTraverse(root);
		*/
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(5);
		map.put(10, 20);
		map.put(10, 5);
		System.out.println(map.get(10));
		
		
		
		
}}
