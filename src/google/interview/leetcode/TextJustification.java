package google.interview.leetcode;
/*
 * 68. Text Justification
Hard

1760

2884

Add to List

Share
Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
 

Example 1:

Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Example 2:

Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified becase it contains only one word.
Example 3:

Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
 

Constraints:

1 <= words.length <= 300
1 <= words[i].length <= 20
words[i] consists of only English letters and symbols.
1 <= maxWidth <= 100
words[i].length <= maxWidth
 */
import java.util.*;

public class TextJustification {
	/*
	 * ["This", "is", "an", "example", "of", "text", "justification."]
	 */
	  public List<String> fullJustify(String[] words, int maxWidth) {
	      List<String> text = new ArrayList<>();
	      int lineStart = 0;
	      int lineEnd = 0;
	      while(lineEnd < words.length) {
	          boolean lastLine = false;
	          int spaceLeft = maxWidth;
	          int nonSpaceLength = 0;
	          while(spaceLeft > 0) {
	              if(lineEnd == words.length) {
	                  lastLine = true;
	                  break;
	              }
	              int currWordLen = words[lineEnd].length();
	              if(spaceLeft >= currWordLen) {
	                  spaceLeft -= currWordLen + 1;
	                  nonSpaceLength += currWordLen;
	                  lineEnd++;
	              } else {
	                  break;
	              }
	          }
	          if(lastLine) {
	              text.add(alignLeft(words, lineStart, lineEnd, nonSpaceLength, maxWidth));
	          } else {
	              text.add(alignJustify(words, lineStart, lineEnd, nonSpaceLength, maxWidth));
	          }
	          lineStart = lineEnd;
	      }
	      return text;
	  }
	  
	  private String alignLeft(String[] words, int start, int end, int nonSpaceLength, int width) {
	      int wordCount = end - start;
	      int[] spaces = new int[wordCount];
	      width -= nonSpaceLength;
	      for(int i = 0; i < wordCount-1; i++) {
	          spaces[i] = 1;
	          width--;
	      }
	      spaces[wordCount-1] += width;
	      return createLine(words, start, end, spaces);
	  }
	  
	  private String alignJustify(String[] words, int start, int end, int nonSpaceLength, int width) {
	      int wordCount = end - start;
	      int[] spaces = new int[wordCount];
	      int spaceLeft = width - nonSpaceLength;
	      if(wordCount == 1) {
	          spaces[0] = spaceLeft;
	      } else {
	          int lesserGap = spaceLeft / (wordCount - 1);
	          int largeGapTill = spaceLeft % (wordCount - 1);
	          int i = 0;
	          while(i < largeGapTill) {
	              spaces[i] = lesserGap+1;
	              i++;
	          }
	          while(i < wordCount-1) {
	              spaces[i] = lesserGap;
	              i++;
	          }
	      }
	      return createLine(words, start, end, spaces);
	  }
	  
	  private String createLine(String[] words, int start, int end, int[] spaces) {
	      StringBuilder line = new StringBuilder();
	      Map<Integer, String> gaps = new HashMap<>();
	      for(int i = start; i < end; i++) {
	          line.append(words[i]);
	          int gapSize = spaces[i-start];
	          line.append(gaps.getOrDefault(gapSize, createGap(gapSize)));
	      }
	      return line.toString();
	  }
	  
	  public String createGap(int size) {
	      StringBuilder sb = new StringBuilder();
	      for(int i = 0; i < size; i++) {
	          sb.append(" ");
	      }
	      return sb.toString();
	  }

	public static void main(String[] args) {
		TextJustification tj = new TextJustification();
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		List<String> out = tj.fullJustify(words, 16);
		out.forEach(a-> System.out.println(a));

	}

}
