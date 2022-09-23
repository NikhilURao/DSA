/*
 * 316. Remove Duplicate Letters
Medium

5272

346

Add to List

Share
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

 

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.

Complexity Analysis

Time complexity : O(N)O(N). Although there is a loop inside a loop, the time complexity is still O(N)O(N). This is because the inner while loop is bounded by the total number of elements added to the stack (each time it fires an element goes). This means that the total amount of time spent in the inner loop is bounded by O(N)O(N), giving us a total time complexity of O(N)O(N)

Space complexity : O(1)O(1). At first glance it looks like this is O(N)O(N), but that is not true! seen will only contain unique elements, so it's bounded by the number of characters in the alphabet (a constant). You can only add to stack if an element has not been seen, so stack also only consists of unique elements. This means that both stack and seen are bounded by constant, giving us O(1)O(1) space complexity.
 */
package google.interview.leetcode;

import java.util.*;

public class RemoveDuplicateLetters {
	
	public static String removeDuplicateLetters(String s){
	// array to maintain the frequency of occurrence of each character
	int [] freq = new int [26];
	Arrays.fill(freq, 0);

	for (int i=0; i<s.length(); i++){
		freq[s.charAt(i) - 'a']++;
	}
	// array to maintain visited characters
	boolean [] seen = new boolean[26];
	Arrays.fill(seen, false);

	// stack to maintain the order of characters 
		Stack<Character> orderedStack = new Stack<>();

		for(int i=0; i<s.length(); i++){
			int asciiCh = s.charAt(i) - 'a';
			// if already seen don’t process it
			if (seen[asciiCh]){
				freq[asciiCh]--;
				continue;
			}

	// pop all characters greater than current character in stack and push current char
	while (!orderedStack.isEmpty() && orderedStack.peek() > s.charAt(i) && freq[orderedStack.peek() - 'a']>0){
		seen[orderedStack.peek() - 'a'] = false;
		orderedStack.pop();
	}

	orderedStack.push(s.charAt(i));
	freq[asciiCh]--;
	seen[asciiCh] = true;
	}

	StringBuilder sb = new StringBuilder(orderedStack.size());
	for (Character c : orderedStack)  
		sb.append(c.charValue());
	return sb.toString();
	 
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDuplicateLetters("cbacdcbc"));

	}

}
