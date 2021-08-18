/*
 * Bitwise AND :
Syntax :
A & B
Values for bit combinations
            a      b         a & b 
           ------------------------
            0      0         0
            0      1         0
            1      0         0
            1      1         1
 * Bitwise OR :
Syntax :
A | B
Values for bit combinations
            a      b      a | b 
           ------------------------
            0      0         0
            0      1         1
            1      0         1
            1      1         1
            
 * Bitwise XOR :
Syntax :
A ^ B
Values for bit a, b :
            a      b      a ^ b 
          ------------------------
            0      0         0
            0      1         1
            1      0         1
            1      1         0 
 */

package com.NumberSysAndBitManipulation;

import java.util.Scanner;

public class BitwiseOperators {

	public static void main(String[] args) {
		int A = 34;                  // 4 bits/ 1byte => 0011
		int B = 2;                 // 4 bits/ 1byte  => 0010
		System.out.println(A | B);//        A|B      => 0011 OR
		System.out.println(A & B);//        A&B      => 0010 AND
		System.out.println(A ^ B);//        A^B      => 0001 XOR
/*
		 * Left shift operators
		 * A << x implies shifting the bits of A to the left by x positions. 
		 * The first x bits are lost this way.
		 * The last x bits have 0.
		 * A << x is equal to multiplication by pow(2, x).
		 * A << 1 A is left shifted by 1 positions.
		 * A -> 0 0 1 1
		 *     / / / /|
   Overflow<-|0|0 1 1 0 <- 0 added to the left
                0 1 1 0-> 6
		 */      
 		System.out.println(A << 1);// 0 1 1 0-> 6
/*
		 * Left shift operators
		 * A >> x implies shifting the bits of A to the right by x positions.
		 * The last x bits are lost this way.
		 * A >> 1 A is right shifted by 1 positions.
		 * A >> x is equal to division by pow(2, x).
		 * A -> 0 0 1 1
		 *      |\ \ \ \
		 *      0 0 0 1|1|-> Overflow to right
                0 0 0 1-> 1
		 */  
 		System.out.println(A >> 1);// 0 0 0 1-> 1
 		


	}

}
