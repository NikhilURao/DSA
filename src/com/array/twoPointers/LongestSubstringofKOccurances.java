package com.array.twoPointers;

import java.util.*;

public class LongestSubstringofKOccurances 
{
	/*
	 * Return 0 if the string is empty or k is equal to zero.
		Set both set pointers in the beginning of the string left = 0 and right = 0 and init max substring 
		length max_len = 1.
		While right pointer is less than N:
		Add the current character s[right] in the hashmap and move right pointer to the right.
		If hashmap contains k + 1 distinct characters, remove the leftmost character from the hashmap and 
		move the left pointer so that sliding window contains again k distinct characters only.
		Update max_len.
	 * 
	 * 
	 */
	
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n * k == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;

        Map<Character, Integer> rightmostPosition = new HashMap<>();

        int maxLength = 1;

        while (right < n) {
            rightmostPosition.put(s.charAt(right), right++);

            if (rightmostPosition.size() == k + 1) {
                int lowestIndex = Collections.min(rightmostPosition.values());
                rightmostPosition.remove(s.charAt(lowestIndex));
                left = lowestIndex + 1;
            }

            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
    
	public int findMaxLenSubstringofKOccurances(String s, int k)
	{
		int n = s.length();
		int left=0;int right=0;
		HashMap<Character, Integer> hm = new HashMap<>();
		int len = Integer.MIN_VALUE;
		
		while (right<n)
		{
			Character rightChar = s.charAt(right);
			Character leftChar = s.charAt(right);
			if (!hm.containsKey(rightChar))
				hm.put(rightChar, 1);
			else
				hm.put(rightChar, (hm.get(rightChar) + 1));
			
			
			while (hm.get(rightChar) > k)
			{
				hm.put(leftChar, (hm.get(rightChar)-1));
				left++;
			}
			right++;
			len = Math.max(len, right-left);
		}
		if (len == Integer.MIN_VALUE) return 0;
		else return len;
	}
	public static void main(String[] args) 
	{
		LongestSubstringofKOccurances lsv = new LongestSubstringofKOccurances();
		System.out.println(lsv.findMaxLenSubstringofKOccurances("aabbccaaad", 2));

	}

}
