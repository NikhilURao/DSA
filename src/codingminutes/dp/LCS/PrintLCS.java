package codingminutes.dp.LCS;

import java.util.Arrays;

public class PrintLCS {
	
	public static String printLCS(String text1, String text2) {
    	int l1 = text1.length();
    	int l2 = text2.length();
    	if (l1==0 || l2==0) return "";
    	
    	int [][] dp = new int [l1+1][l2+1];
    	for (int i=0; i<l1+1; i++) {
    		int [] temp = new int [l2+1];
    		Arrays.fill(temp, 0);
    		dp[i] = temp;
    	}
    	
    	for (int row = 0; row<l1+1; row++) {
    		for (int col=0; col<l2+1; col++) {
    			if (row==0 || col==0) dp[row][col] = 0;
    			
    			else if (text1.charAt(row-1) == text2.charAt(col-1)) {
    				dp[row][col] = 1 + dp[row-1][col-1];
    			}
    			
    			else dp[row][col] = Math.max(dp[row-1][col], dp[row][col-1]);
    		}
    	}
    	StringBuilder LCS = new StringBuilder();
    	int row = l1; int col = l2;
    	while (row>0 && col>0) {	
    		Character c1 = text1.charAt(row-1);
    		Character c2 = text2.charAt(col-1);
    		if (c1 == c2) {
    			LCS.append(text1.charAt(row-1));
    			row--;
    			col--;
    		}
    		else {
    			if (dp[row-1][col] >= dp[row][col-1]) {
    				row--;
    			}
    			else {
    				col--;
    			}
    		}
    	}
    	
    	return LCS.reverse().toString();
	}

	public static void main(String[] args) {
		String text1 = "abcde", text2 = "ace" ;
		System.out.println(printLCS(text1, text2));

	}

}
