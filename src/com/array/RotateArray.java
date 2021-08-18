package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class RotateArray {

	public ArrayList<Integer> reverseArray(ArrayList<Integer> arr){
		if (arr.size()>0) {
			int size = arr.size()-1;
			ArrayList<Integer> rev= new ArrayList<>
			(Arrays.asList(new Integer[size+1]));
			Collections.fill(rev, 0);
			for (int i=arr.size()-1; i>=0; i--) {
				rev.set((size - i), arr.get(i));
			}
			
			return rev;
		}
		else return new ArrayList<Integer>();
		
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num_test_cases = sc.nextInt();
		
		int num=0;
		
		while (num < num_test_cases ) {
			int n = sc.nextInt();
			
			ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(new Integer[n]));
			Collections.fill(array, 0);
			
			for (int i=0; i<n; i++) {
				array.set(i, sc.nextInt());
			}
			
			int b = sc.nextInt()%n;
			
			// System.out.println("num_test_cases "+num_test_cases);
			// System.out.println("n "+n);
			// array.forEach(no -> System.out.print(no+" "));
			// System.out.println("b "+b);
			
			// ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7));
			// int k=3;
			
			RotateArray ra = new RotateArray();
			ArrayList<Integer> rev = ra.reverseArray(array);
			// rev.forEach(i-> System.out.print(i+" "));
			ArrayList<Integer> k1 = new ArrayList<Integer>(Arrays.asList(new Integer[b]));
			Collections.fill(k1, 0);
			ArrayList<Integer> k2 = new ArrayList<Integer>(Arrays.asList(new Integer[rev.size()-b]));
			Collections.fill(k2, 0);
			for (int i=0; i<b; i++) {
				k1.set(i,rev.get(i));
			}
			// System.out.println("");
			// k1.forEach(no-> System.out.print(no+" "));
			ArrayList<Integer> k1rev = ra.reverseArray(k1);
			// System.out.println("");
			// k1rev.forEach(no-> System.out.print(no+" "));
			for (int i=b; i<rev.size(); i++) {
				k2.set(i-b,rev.get(i));
			}
			// System.out.println("");
			// k2.forEach(no-> System.out.print(no+" "));
			ArrayList<Integer> k2rev = ra.reverseArray(k2);
			// System.out.println("");
			// k2rev.forEach(no-> System.out.print(no+" "));
			
			ArrayList<Integer> b_rotated_array = new ArrayList<Integer>(Arrays.asList(new Integer [n]));
			
			for (int i=0; i<k1rev.size();i++) {
				b_rotated_array.set(i,k1rev.get(i));
			}
			for (int i=0; i<k2rev.size();i++) {
				b_rotated_array.set(i+b,k2rev.get(i));
			}
			// System.out.println("");
			// System.out.println("B Rotated Arrays");
			b_rotated_array.forEach(no-> System.out.print(no+" "));
			
			num++;
		}

	}

}
