package com.dp;
import java.util.Scanner;

public class PlacingParentheses 
{
    private static long getMaximValue(String exp) 
    {
    	
        long n = exp.length() / 2 + 1;
        long[][] min = new long[(int) n][(int) n], max = new long[(int) n][(int) n];
        for(long i = 0; i < n; i++) {
            min[(int) i][(int) i] = exp.charAt((int) i * 2) - '0';
            max[(int) i][(int) i] = exp.charAt((int) i * 2) - '0';
        }

        for(long s=1; s<=n-1; s++) {
            for(long i=0; i<=n-1 -s; i++) {
                long j = s + i;  // maintain j - i = size
                long [] res = getMinAndMax(exp, i, j, min, max);
                min[(int) i][(int) j] = res[0];
                max[(int) i][(int) j] = res[1];
            }
        }
        return max[0][(int) (n-1)];
    }
    
    private static long [] getMinAndMax(String exp, long i, long j, long[][] min, long[][] max) 
    {
        long [] res = new long []{Integer.MAX_VALUE, Integer.MIN_VALUE};
        for(long index = i; index <= j - 1; index++) 
        {
            char oper = exp.charAt((int) (index * 2 + 1));
            
            long a = eval(min[(int) i][(int) index], min[(int) (index + 1)][(int) j], oper),
                    b  = eval(min[(int) i][(int) index], max[(int) (index + 1)][(int) j], oper),
                    c  = eval(max[(int) i][(int) index], min[(int) (index + 1)][(int) j], oper),
                    d  = eval(max[(int) i][(int) index], max[(int) (index + 1)][(int) j], oper);
            res[0] = Math.min(a, Math.min(b,Math.min(c, Math.min(d, res[0]))));
            res[1] = (Math.max(a, Math.max(b,Math.max(c, Math.max(d, res[1])))));
        }
        return res;
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}


