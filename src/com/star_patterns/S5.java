/* Star Pattern Programming
 * Obtain the below star pattern in the console
 * 
 *                 ******
 *                  *    *
 *                   *    *
 *                    *    *
 *                     ******  
 *                 
 */

package com.star_patterns;

public class S5 {

	public static void main(String[] args) {
		int n=5;
		for (int i=1;i<=n;i++) {
			
			for (int k=1;k<=i;k++) {
				System.out.print(" ");
			}
			for(int j=1;j<=n;j++) {
				if (i==1||j==1||i==n||j==n) System.out.print("*");
				else System.out.print(" ");
				}
		System.out.println();
		}

	}

}
