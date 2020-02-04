package exercise;
import java.io.BufferedReader;
import java.util.Scanner;
import java.lang.Math.*;
/*
 * GCD(a,b) = GCD(a',b) = GCD(b,a') where a and b are positive real numbers
 * and a' is the remainder when a is divided by b
 * Example : GCD(1344, 217)
 * 			=GCD(1344, 217)
 *			=GCD(217, 42)
 *			=GCD(42, 7)
 *			=GCD(7, 0)
 *			=7
 * Here a=1344,b=217 and remainder when a is divided by b a%b = 42
 * 			=> GCD(1344, 217) = GCD(217, 42) = GCD(42, 7) = GCD(7, 0) = 7
 * 			=> Continue this process until the remainder becomes 0
 * 
 * 			     |a*b| <- Absolute Product of a and b (Math.abs)
 * LCM(a,b) =  ---------
 * 			    GCD(a,b)
 */
public class GCDandLCM {
	static long getGCD_Euclidean(long a,long b){
		while (a % b != 0) {
			b=getGCD_Euclidean(b, a % b);
		}
		return b;
	}
	
	static long getLCM_Euclidean(long a, long b) {
		if (a== 0 || b==0) {
			return 0;
		}
		else {
			return Math.abs(a*b)/getGCD_Euclidean(a,b);
		}
	}

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		long anum = ip.nextLong();
		long bnum = ip.nextLong();
		//System.out.println(getGCD_Euclidean(anum, bnum));
		System.out.println(getLCM_Euclidean(anum, bnum));
	}

}
