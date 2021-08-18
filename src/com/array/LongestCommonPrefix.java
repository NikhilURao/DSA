package com.array;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(ArrayList<String> A) {
        String ans = A.get(0);
        for (int i=1;i<A.size();i++){
            String s = A.get(i);
            int len = s.length() < ans.length()? s.length():ans.length();
            for(int j=1; j<=len;j++){
            	String substr_ans = ans.substring(0,j);
            	String substr_s = s.substring(0,j);
                if (!substr_ans.equals(substr_s)){
                    ans = j==1? "" : ans.substring(0,j-1);
                    break;
                }
                if (j==len) {
                	ans = s.substring(0,j);
                }
            }
        }
        return ans;
    }

	public static void main(String[] args) {
		ArrayList<String> inp = new ArrayList<String>(Arrays.asList("aaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		//System.out.println(longestCommonPrefix(inp));
		String A = "AbcaZeoB";
		StringBuilder res = new StringBuilder(A+A);
		for (int i=0; i<res.length();i++) {
			int ascii = res.charAt(i);
			if (ascii>=65 && ascii<=90) {
				res.deleteCharAt(i);
			}
			else if (ascii==97 || ascii==101|| ascii==105|| ascii==111|| ascii==117) {
				res.setCharAt(i,'#');
			}
		}
		System.out.println(res.toString());

	}}

