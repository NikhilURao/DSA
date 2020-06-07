package com.array.twoPointers;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters 
{
	public int findMaxLenSubstringWithoutRepeats(String s)
	{
		int len = s.length();
		int i = 0;
		int j = 0;
		HashSet<Character> hash_set = new HashSet<Character>();
		int max_len = Integer.MIN_VALUE;
		
		while (j<len)
		{
			if (!hash_set.contains(s.charAt(j)))
			{
				hash_set.add(s.charAt(j));
				max_len = Math.max(max_len, j-i+1);
			}
			else
			{
				while (s.charAt(i) != s.charAt(j))
				{
					hash_set.remove(s.charAt(i));
					i++;
				}
				i++;
			}
			j++;
		}
		if (max_len == Integer.MIN_VALUE) return 0;
		else return max_len;
		
	}
	
	public int findMaxLenSubstringWithoutRepeats1(String s)
	{
		int len = s.length();
		int i = 0;
		int j = 0;
		HashSet<Character> hash_set = new HashSet<Character>();
		int max_len = Integer.MIN_VALUE;
		
		while (j<len)
		{
			if (!hash_set.contains(s.charAt(j)))
			{
				hash_set.add(s.charAt(j));
				j++;
				max_len = Math.max(max_len, hash_set.size());
			}
			else
			{
					hash_set.remove(s.charAt(i));
					i++;
			}
		}
		if (max_len == Integer.MIN_VALUE) return 0;
		else return max_len;
		
	}
	public static void main(String[] args) 
	{
		LongestSubstringWithoutRepeatingCharacters lswr = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(lswr.findMaxLenSubstringWithoutRepeats("abcabcbb"));
		System.out.println(lswr.findMaxLenSubstringWithoutRepeats1("abcabcbb"));

	}

}
