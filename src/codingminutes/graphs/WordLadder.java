/*
 * 127. Word Ladder
Hard

7970

1648

Add to List

Share
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
 * 
 * 
 * 
 */

package codingminutes.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;


public class WordLadder {
	/**
	 * Container to ease passing around a tuple of two objects. This object provides a sensible
	 * implementation of equals(), returning true if equals() is true on each of the contained
	 * objects.
	 */
	public class Pair<F, S> {
	    public final F first;
	    public final S second;

	    /**
	     * Constructor for a Pair.
	     *
	     * @param first the first object in the Pair
	     * @param second the second object in the pair
	     */
	    public Pair(F first, S second) {
	        this.first = first;
	        this.second = second;
	    }

	    /**
	     * Checks the two objects for equality by delegating to their respective
	     * {@link Object#equals(Object)} methods.
	     *
	     * @param o the {@link Pair} to which this one is to be checked for equality
	     * @return true if the underlying objects of the Pair are both considered
	     *         equal
	     */
	    @Override
	    public boolean equals(Object o) {
	        if (!(o instanceof Pair)) {
	            return false;
	        }
	        Pair<?, ?> p = (Pair<?, ?>) o;
	        return Objects.equals(p.first, first) && Objects.equals(p.second, second);
	    }

	    /**
	     * Compute a hash code using the hash codes of the underlying objects
	     *
	     * @return a hashcode of the Pair
	     */
	    @Override
	    public int hashCode() {
	        return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode());
	    }
	    
	    public F getKey() {
	    	return first;
	    }
	    
	    public S getValue() {
	    	return second;
	    }

	}
	
	
	// BFS TC: O(M^2*N) where M is the length of the beginWord and N is the number of words in the wordList
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> set = new HashSet<String>(wordList);
        if (!set.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        set.remove(beginWord);
        int level = 0;
        while (!queue.isEmpty()){
            level++;
            for (int i=0; i<queue.size(); i++){
                String curWord = queue.poll();
                if (curWord.equals(endWord)) return level;
                ArrayList<String> neighbors = getNeighborsList(curWord);
                for (String neigh: neighbors){
                    if (set.contains(neigh)){
                        queue.add(neigh);
                        set.remove(neigh);
                    }
                }
            }

        } 
        return 0;
        
        
    }
    
    public ArrayList<String> getNeighborsList(String word){
        ArrayList<String> neighborList = new ArrayList<>();
        char[] chars = word.toCharArray();
        
        for (int i=0; i<chars.length; i++){
            char temp = chars[i]; 
            for (int c = 'a'; c<='z'; c++){
                chars[i] = (char)(c);
                String newWord = new String(chars);
                neighborList.add(newWord);
            }
            chars[i] = temp;
        }
        return neighborList;
    }
    
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {

        // Since all words are of same length.
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        Map<String, List<String>> allComboDict = new HashMap<>();

        wordList.forEach( word -> {
            for (int i = 0; i < L; i++) {
                // Key is the generic word
                // Value is a list of words which have the same intermediate generic word.
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                allComboDict.put(newWord, transformations);
            }
        });

        // Queue for BFS
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair(beginWord, 1));

        // Visited to make sure we don't repeat processing same word.
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {

                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }
    

	public static void main(String[] args) {
		WordLadder wl = new WordLadder();
		String beginWord = "hit"; String endWord = "cog";
		String [] wordList = {"hot","dot","dog","lot","log","cog"};
		List<String> wordsList = Arrays.asList(wordList);
		
		System.out.println(wl.ladderLength(beginWord, endWord, wordsList));

	}

}
