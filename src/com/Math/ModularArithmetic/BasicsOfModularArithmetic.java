package com.Math.ModularArithmetic;

public class BasicsOfModularArithmetic {

	public static void main(String[] args) {
		
		// A % B => returns the remainder when A is divided by B.   
		System.out.println(14%5); // returns remainder as 4 when 14 is divided by 5.
		
		/* Value of A % B will always range from 0 to B-1.
		 *  i.e. 0 <= A % B <= B - 1
		 *  For example: 0 <= A % 7 <= 6
		 */
		
		/* Modulo of a negative number can be positive
		 * a % m = a - (largest multiple of m <= a)
		 * -30 % 7 = -30 -(-35) = 5 or -2
		 */
		System.out.println(-30 % 7);
		
		/* basic rules and properties that can be applied in Modular Arithmetic 
		 * (Addition, Subtraction, Multiplication, Division, power of etc.). 
		 * Consider numbers a and b operated under modulo M.
		 * 
		 * 	1. 	(a + b) % M = ((a % M) + (b % M)) % M or
		 * 		(a + b) mod M = ((a mod M) + (b mod M)) mod M.
		 */
		System.out.println((12+5)%5);
		System.out.println(((12%5)+(5%5))%5);
		
		/*
		 * 	2. 	(a - b) % M = ((a % M) - (b % M)) % M or
		 * 		(a - b) mod M = ((a mod M) - (b mod M)) mod M.
		 */
		System.out.println((12-6)%5);
		System.out.println(((12%5)-(6%5))%5);
		
		/*
		 * 	3. 	(a * b) % M = ((a % M) * (b % M)) % M or
		 * 		(a * b) mod M = ((a mod M) * (b mod M)) mod M.
		 */
		System.out.println((12*6)%5);
		System.out.println(((12%5)*(6%5))%5);
		
		/*
		 * 	4. 	(a ^ b) % M = ((a % M) ^ b) % M or
		 * 		(a ^ b) mod M = ((a mod M) ^ b) mod M.
		 */
		System.out.println((12*12*12)%5); // 12^3
		System.out.println(((12%5)*(12%5)*(12%5))%5);
		
		/* 5. (a / b) % M = [ (a % M) * (b^-1 % M)] % M
		 * 
		 * The term b^-1 % M is called as Inverse Mod M or Modular Inverse
		 * 
		 * Methods of finding Modular Inverse: 
		 * There are two very popular methods of finding modular inverse of any 
		 * number a under modulo M. 
		 * 	(i)	 Fermat Theorem: This method can be used when M is prime.
		 * 
		 * 	(ii) Extended Euclidean Algorithm: This method can be used 
		 * 		 when a and M are co-prime.
		 */
		
		/*
		 *  (i)	 Fermat Theorem:
		 *  
		 *  According to Fermet Theorem, if M is a prime number and 
		 *  b and M are co-primes, i.e. GCD(b, M) = 1, then 
		 *  			
		 *  => a^M-1 ≡ 1 (mod M) ('≡' means congruent => a ≡ b % x => a % x = b % x)
		 *  => a^M-1 * a^-1 ≡ a^-1 % M (multiplying both sides with a inverse, a^-1)
		 *  => a^M-2 ≡ a^-1 % M 
		 *  => a^M-2 % M = a^-1 % M (removing congruent a ≡ b % x => a % x = b % x)
		 *  
		 *  So, a^-1 % M = a^M-2 % M 
		 *  From property 5 wkt, 
		 *  (a / b) % M = [ (a % M) * (b^-1 % M)] % M
		 *  replacing (b^-1 % M) using Fermet theorem,
		 *  (a / b) % M = [ (a % M) * (a^M-2 % M)] % M
		 *  Therefore, if M is a prime number to find modulo inverse of a 
		 *  under M, find modular exponentiation of a^M-2 under modulo M.
		 */
		
		/*
		 * 	(ii)	Extended Euclidean algorithm
		 *  Takes two integers 'a' and 'b', finds their gcd and also find 'x' and 'y' such that,
		 *  ax + by = gcd(a, b) 
		 *  To find the modulo inverse of 'a' under 'M', we put b = M in the above formula. 
		 *  Since we know that a and M are relatively prime, we can put value of gcd as 1.
		 *  So, the formula becomes:
		 *  ax + My = 1 
		 *  If we take modulo M on both sides, we get
		 *  ax + My ≡ 1 (mod M)
		 *  We can remove the second term on the left side, as 'My (mod M)' would always be 0 for an integer y.
		 *  Therefore,
		 *  ax  ≡ 1 (mod M) 
		 *  So the 'x' that we can find using Extended Euclid Algorithm is modulo inverse of 'a'.
		 */
	}

}
