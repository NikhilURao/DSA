/*
 * There are 3 variations with 3 different difficult level of problem of 
 * finding the length of longest Consecutive ones in a Binary array 
 * (an array with 0s and 1s).
 * ------------------------------------------------------------------------------
 * 1) Given a number n, find the length of the longest consecutive 1s in its 
 * binary representation.
 * 
 * Eg: n= 222
 * Output: 4 (11011110)
 * 
 * Solution:
 * In the naive or brute force approach we can first convert the decimal number 
 * to its binary form and then iterate once over the binary number to find the 
 * number of consecutive 1s.
 * 
 * AND a bit sequence with a shifted version of itself, 
 * we're effectively removing the trailing 1 from every sequence of 
 * consecutive 1s.
 * 
 * For N=222
 * 
 * 					128 64 32 16 8 4 2 1
 *                 ( 1  1  0  1  1 1 1 0 ) -> x in binary
 *     overflow<-1 ( 1  0  1  1  1 1 0 0 ) -> x << 1 ->x ls 1
 *------------------------------------------------------
 *                 ( 1  0  0  1  1 1 0 0) -> x & (x<<1) compare with x. operation x = (x & (x << 1)) reduces length of every sequence of 1s by one in binary representation of x. If we keep doing this operation in a loop, we end up with x = 0. The number of iterations required to reach 0 is actually length of the longest consecutive sequence of 1s. 
 *	    overflow<-1( 0  0  1  1  1 0 0 0) -> x << 1
 *------------------------------------------------------
 *                 ( 0  0  0  1  1 0 0 0) -> x & (x<<1)
 *      overflow<-0( 0  0  1  1  0 0 0 0) -> x << 1
 *------------------------------------------------------
 *                 ( 0  0  0  1  0 0 0 0) -> x & (x<<1)
 *      overflow<-0( 0  0  1  0  0 0 0 0) -> x << 1
 *------------------------------------------------------
 *                 ( 0  0  0  0  0 0 0 0) -> x & (x<<1)      
 *      
 * So, no of iterations taken for the number to be 0 is equal 
 * to the length of the longest consecutive 1s in the number.
 * 
 * TC => O(k) k being the length of the longest consecutive 1s in the number.
 * SC => O(1)
 *-------------------------------------------------------------------------------
 * 2) Given a binary string A. It is allowed to do at most one swap 
 * between any 0 and 1. Find and return the length of the longest consecutive 1’s 
 * that can be achieved.
 * 
Input Format

The only argument given is string A.
Output Format

Return the length of the longest consecutive 1’s that can be achieved.
Constraints

1 <= length of string <= 1000000
A contains only characters 0 and 1.
For Example

Input 1:
    A = "111000"
Output 1:
    3

Input 2:
    A = "111011101"
Output 2:
    7
 * 
 *  Solution: 
 *  1. Find the number of 1s in the given string.
 *  2. Create 2 arrays left and right, calculate the left and right prefix sum or
 *  cumulative sum of consecutive 1s.
 *  3. Now iterate over the given string, if character at a particular index is 0
 *  then 
 *  if (left[i-1]+right[i+1] < cnt_one) store max_count = left[i-1] + right [i+1] + 1, as by swapping we will get one extra one in place of 0.
 *  else max_count = left[i-1] + right[i+1].
 */
package com.array;
import java.util.Arrays;
public class LengthOfLongestConsecutiveOnes {
	
	// returns length of longest consecutive ones in the binary representation of decimal number n.
	// arguments: int n
	public static int get_LengthOfLongestConsecutiveOnes_V1(int n) {
		int count = 0;
		while (n>0) {
			n = n & (n << 1); // reduces length of every sequence of consecutive 1s by one in binary representation of N
			count ++;
		}
		return count;
	}
	
	// returns length of longest consecutive ones in the binary string A by doing at most one swap between a 0 and 1.
	// argument: Binary String A
	public static int get_LengthOfLongestConsecutiveOnes_V2(String A) {

		int max_cons_one_cnt = 0;
		int total_one_cnt = 0;
		int temp = 0; // to calculate the original longest length of consecutive 1s before swapping
		int n = A.length();
		
		// calculate total number of 1s in string A
		for (int i=0; i<n; i++) {
			if (A.charAt(i) == '1') {
				total_one_cnt++;
				temp++;
			}
			else {
				max_cons_one_cnt = Math.max(max_cons_one_cnt, temp);
				temp = 0;
			}
		}
		max_cons_one_cnt = Math.max(max_cons_one_cnt, temp); // At this point it holds original longest length of consecutive 1s before swapping. We will return this if we are not able can't swap and get higher value. testcase: 01
		
		int [] left = new int [n]; // to store left cumulative sum of consecutive 1s
		int [] right = new int [n]; // to store right cumulative sum of consecutive 1s
		Arrays.fill(left,0);
		Arrays.fill(right,0);
		
		if (A.charAt(0)=='1')
			left[0] = 1;
		else left[0] = 0;
		
		if (A.charAt(n-1)=='1')
			right[n-1] = 1;
		else right[n-1] = 0;
		
		// calculate left cumulative sum of consecutive 1s
		for (int i=1; i<n; i++) {
			if (A.charAt(i)=='1')
				left[i] = left[i-1]+1;
		}
		
		// calculate left cumulative sum of consecutive 1s
		for (int i=n-2; i>=0; i--) {
			if (A.charAt(i)=='1')
				right[i] = right[i+1]+1;
		}
		
		// iterate over characters of string A, if 0 check if len of consecutive ones by swapping this 0 with 1 is greater than max_cons_one_cnt 
		
		for (int i=1; i<n-1; i++) {
			if (A.charAt(i)=='0') {
				int sum  = left[i-1] + right[i+1];
				
				if (sum < total_one_cnt) // to check if we can swap 0 at index i with any other 1, its possible only if the sum < total number of ones in the string test case:11100
					max_cons_one_cnt = Math.max(max_cons_one_cnt, sum+1);
				else
					max_cons_one_cnt = Math.max(max_cons_one_cnt, sum);
			}
		}
		return max_cons_one_cnt;
	}
	
	public static int solve(String A) {
        int max_cons_one = 0; int count_one = 0; int cons_one=0;
        
        for (int i=0; i<A.length();i++){
            if (A.charAt(i) == '1'){
                count_one++;
                cons_one++;
            }
            else{
                max_cons_one = Math.max(max_cons_one, cons_one);
                cons_one = 0;
            }
        }
        max_cons_one = Math.max(max_cons_one, cons_one);
        
        int [] left = new int [A.length()];
        Arrays.fill(left,0);
        int [] right = new int [A.length()];
        Arrays.fill(right,0);
        
        if(A.charAt(0) == '1')
            left[0] = 1;
        else left[0] = 0;
        
        if (A.charAt(A.length()-1)=='1')
            right[A.length()-1] = 1;
        else right[A.length()-1] = 0;
        
        for (int i=1; i<A.length(); i++){
            if (A.charAt(i)=='1')
                left[i] = left[i-1] + 1;
            else left[i] = 0;
        }
        
        for (int i=A.length()-2; i>=0; i--){
            if (A.charAt(i)=='1')
                right[i] = right[i+1] + 1;
            else right[i] = 0;
        }
        
        for (int i = 1; i < A.length() - 1; i++) {
            if (A.charAt(i) == '0') {
                int sum = left[i - 1] + right[i + 1];
     
                if (sum < count_one)
                     max_cons_one = Math.max(max_cons_one, sum+1);
     
                else
                     max_cons_one = Math.max(max_cons_one, sum);
            }
        }
        return max_cons_one;
    }
	
	public static int get_LengthOfLongestConsecutiveOnes_V2_slidingWindow (String S) {
		int max = 0;
		char [] c = S.toCharArray(); 
		int k=1;
		int i=0;
		int j=0;
		
		while (j<c.length) {
			if (c[j]=='0') k--;
			if (k<0) {
				if (c[i]=='0') {
					k++;
				}
				i++;
			}
			j++;
		}
		return j-i;
		
	}
	
	

	public static void main(String[] args) {
		System.out.println(get_LengthOfLongestConsecutiveOnes_V1(222));
		System.out.println(get_LengthOfLongestConsecutiveOnes_V2("111011101"));
		// if second variation question was slightly changed: instead of swap 0 and 1, if we are allowed to change any one 0 to 1 we can use sliding window technique.
		System.out.println(
				get_LengthOfLongestConsecutiveOnes_V2_slidingWindow("111011101"));
		

	}

}
