/* Star Pattern Programming
 * Obtain the below star pattern in the console
 * 
 *                   *
 *                   **
 *                   ***
 *                   ****
 *                   *****
 *                 
 */


package com.star_patterns;

public class S2 {

	public static void main(String[] args) {
		int n=5;
		for (int i=1;i<=n;i++)
		{
			for (int j=1;j<=i;j++)
			{
				System.out.print("*");
			}
		System.out.println();
		}

	}

}
