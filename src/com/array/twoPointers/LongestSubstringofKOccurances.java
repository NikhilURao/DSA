package com.array.twoPointers;

import java.util.HashMap;

public class LongestSubstringofKOccurances 
{
	public int findMaxLenSubstringofKOccurances(String s, int k)
	{
		int n = s.length();
		int i=0;int j=0;
		HashMap<Character, Integer> hm = new HashMap<>();
		int len = Integer.MIN_VALUE;
		
		while (j<n)
		{
			if (!hm.containsKey(s.charAt(j)))
				hm.put(s.charAt(j), 1);
			else
				hm.put(s.charAt(j), (hm.get(s.charAt(j)) + 1));
			
			
			while (hm.get(s.charAt(j)) > k)
			{
				hm.put(s.charAt(i), (hm.get(s.charAt(i))-1));
				i++;
			}
			j++;
			len = Math.max(len, j-i);
		}
		if (len == Integer.MIN_VALUE) return 0;
		else return len;
	}
	public static void main(String[] args) 
	{
		LongestSubstringofKOccurances lsv = new LongestSubstringofKOccurances();
		System.out.println(lsv.findMaxLenSubstringofKOccurances("abcdaklmairnibb", 2));

	}

}
