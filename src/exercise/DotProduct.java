package exercise;

import java.util.Scanner;

public class DotProduct 
{
	private static long maxDotProduct(long[] a, long[] b) {
		boolean flag = true;
		for (int i=0;i<a.length;i++) {
			for(int j=0;j<a.length-1-i;j++) 
			{	
				if(a[j] < a[j+1]) 
				{
					flag = false;
					long temp= a[j+1];
					a[j+1] = a[j];
					a[j] = temp;
				}
			}
			if (flag)
				break;
		}
		boolean flag1 = true;
		for (int i=0;i<b.length;i++) {
			for(int j=0;j<b.length-1-i;j++) 
			{	
				if(b[j] < b[j+1]) 
				{
					flag1 = false;
					long temp1= b[j+1];
					b[j+1] = b[j];
					b[j] = temp1;
				}
			}
			if (flag1)
				break;
		}
        long result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextLong();
        }
        System.out.println(maxDotProduct(a, b));
    }
}
