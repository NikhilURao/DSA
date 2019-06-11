/*
 * Check if a number is a Palindrome
 */

package com.recursion;
import java.util.Scanner;
// Recursive function that returns the reverse of a number
public class Palindrome_Rec {
	static int IsPalindrome (int num,int rev) {
		if (num==0) return rev;
		rev = (rev *10) + (num % 10);
		return IsPalindrome(num/10, rev);
}
//Driver Class
	public static void main(String[] args) {
		
	Scanner input  = new Scanner(System.in);
	System.out.println("Enter the number");
	int num = input.nextInt();
	input.close();
	
	int reversed_num = IsPalindrome(num,0);
	//System.out.println(rev);
	if (reversed_num == num) System.out.println("Given num is a Palindrome");
	else System.out.println("Given num is not a Palindrome");
	
		
		
//Iterative Approach
/*int num = 1211;
int org,rev=0,rem;
org = num;
		while (num!= 0) {
			
			rem = num%10;// Separating and storing units digit of num in rem
			rev = rev *10 +rem;
			num = num/10;
		}
		if (rev == org) System.out.println("Given num is a Palindrome");
		else System.out.println("Given num is not a Palindrome");
*/
	
	
	}

}
