package exercise;

import java.util.Scanner;

public class CarFuelRefills {
	static int MinRefills(long x[], long n, long l) {
		int currentRefills = 0; int numRefills = 0;
		while (currentRefills < n) {
			int lastRefills = currentRefills;
			while (currentRefills < n && x[currentRefills + 1] - x[currentRefills] <= l) {
				currentRefills = currentRefills + 1;
			}
			if (currentRefills == lastRefills) {
				return 0;
			}
			if (currentRefills <= n) {
				numRefills = numRefills + 1;
			}
		}
		return numRefills;
	}

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		long n = ip.nextLong();
		long l = ip.nextLong();
		long x[] = new long [(int) n];
		for (int i=0;i<n;i++) {
			x[i] = ip.nextLong();
			System.out.print(x[i]+" ");
		}
		
		System.out.println(MinRefills(x, n, l));
		

	}

}
