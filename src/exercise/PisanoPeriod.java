package exercise;
import java.util.Scanner;

/*
 * In this problem, your goal is to compute Fn modulo m, 
 * where n may be really huge: up to 1014. For such values of n, an algorithm looping
 * for n iterations will not fit into one second for sure. Therefore we need to 
 * avoid such a loop.To get an idea how to solve this problem without going through
 *  all Fi for i from 0 to n, let’s see what happens when m is small — say, m=2 or m=3.
 *	i	  |	0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
 *--------|------------------------------------------
 *	Fi	  |	0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610
 *	Fi mod  	2 0 1 1 0 1 1 0 1 1 0 1 1 0 1 1 0
 *	Fi mod 	3 0 1 1 2 0 2 2 1 0 1 1 2 0 2 2 1
 * Take a detailed look at this table. Do you see? Both these sequences are periodic! 
 * For m = 2, the period is 011 and has length 3, while for m = 3 
 * the period is 01120221 and has length 8. Therefore, to compute, say, F2015 mod 3 
 * we just need to find the remainder of 2015 when divided by 8. Since 2015 = 251 ·
 *  8 + 7, we conclude that F2015 mod 3 = F7 mod 3 = 1.
 *  This is true in general: for any integer m >= 2, the sequence Fn mod m is periodic. 
 *  The period always starts with 01 and is known as Pisano period.
 */


public class PisanoPeriod {
	static long getPisanoSeries(long n, long m) {
		long pisano_series[]= new long [(int) (n+1)];
		System.out.println(pisano_series.length);
		pisano_series[0]=0;
		pisano_series[1]=1;
		int pisano_period = 0;
		
		if (n<=1) {
			return n;
		}
		for (int i=2;;++i) {
			pisano_series[i] = ((pisano_series[i-1]) + (pisano_series[i-2])) % m;
			if (pisano_series[i-1]==0 && pisano_series[i]==1) {
				pisano_period = i-1;
				break;
				}
			}
		
		for (int j=0;j<pisano_period;j++) {
			System.out.print(pisano_series[j]+" ");
		}
		System.out.println();
		System.out.println("Length "+pisano_period);
		
		return pisano_series[(int) (n % pisano_period)];
		}


	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		long n = ip.nextLong();
		long m = ip.nextLong();
		System.out.println(getPisanoSeries(n, m));

	}

}
