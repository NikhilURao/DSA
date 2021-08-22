/*
 * Add One To Number
Problem Description

Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, following are some good questions to ask :

Q : Can the input have 0's before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0's before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.


Problem Constraints
1 <= size of the array <= 1000000



Input Format
First argument is an array of digits.



Output Format
Return the array of digits after adding one.



Example Input
Input 1:

[1, 2, 3]


Example Output
Output 1:

[1, 2, 4]

Solution:

Maintain a carry which is initialized to 1 ( Denoting that we need to add one to the number ).
Run a loop on the digit array ( which is now reversed ), and add carry to the current digit. If the digit D exceeds 10 on doing so, store the last digit in current position ( D % 10 ), and make carry = rest of the digits ( D / 10 ). Continue the process till you have covered all the digits.
Now if at the end, carry = 0, we are done, and we can return the array.

If not, we need to add one more digit, with carry in it

 */
package com.array;

import java.util.Arrays;

public class AddOneToNumber {
	
	public int[] plusOne(int[] arr) {
		if (arr.length != 0) {
			boolean carryExists = true;
			int carry=0;
			int digit=arr.length -1;
			while(digit >= 0 && carryExists) {
				int sum = 0;
				sum = (digit==arr.length-1)? (arr[digit] + carry + 1) : 
					(arr[digit] + carry);
				if (sum/10 != 0) {
					arr[digit] = sum%10;
					carry = sum/10;
				}
				else {
					carryExists = false;
					arr[digit] = sum;
				}
				digit --;
			}
			if (carryExists) {
				int[] res = new int [arr.length + 1];
				for (int i=0; i<arr.length; i++) {
					res[i+1] = arr[i];
				}
				res[0] = carry;
				return res;
			}
			else if (arr[0] == 0) {
				int num0sinMSB = 0;
				for (int i=0; i<arr.length; i++) {
					if (arr[i]==0) {
						num0sinMSB++;
						}
					else break;
					}
				int[] res = new int [arr.length - num0sinMSB];
				Arrays.fill(res, 0);
					for (int i=num0sinMSB; i<arr.length; i++) {
						res[i-num0sinMSB] = arr[i];
					}
				return res;
			}
			else return arr;
				
		}
		
		return arr;
	}

	public static void main(String[] args) {
		int [] arr = {0,0,2,9};
		AddOneToNumber a1n = new AddOneToNumber();
		int [] res =a1n.plusOne(arr);
		
		for (int i=0; i<res.length; i++) {
			System.out.print(res[i]+" ");
		}

	}

}
