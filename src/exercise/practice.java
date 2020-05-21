package exercise;

import java.util.HashMap;

/*
 * n! = n*(n-1)*........*1
 */

public class practice {
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
	
	

	public static void main(String[] args) {
		
		practice p = new practice();
		HashMap hmap = new HashMap<>();
		
		hmap.put("nik", 10);
		hmap.put("nik", 11);
		
		System.out.println(hmap);
		
		}
		

}
