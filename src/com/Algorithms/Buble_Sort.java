package com.Algorithms;

import java.util.Random;

public class Buble_Sort {

	public static void main(String[] args) {
		Random ran = new Random();
		int [] test = new int [15];
		for (int i=0;i<test.length;i++) {
			test[i]=ran.nextInt(100);
		}
		System.out.println("Array  before sorting : ");
		for (int i=0;i<test.length;i++) {
			System.out.print(test[i]);
			System.out.print(" ");
		}
		System.out.println("");
		//Bubble Sort Logic
		int temp=0;
		boolean flag = true;
		for (int i=0;i<test.length;i++) {
			for(int j=0;j<test.length-1-i;j++) 
			{
				if(test[j]>test[j+1]) 
				{
					flag = false;
					temp=test[j+1];
					test[j+1]=test[j];
					test[j]=temp;
				}
			}
			if (flag)
				break;
		}
		System.out.println("Array after BubleSort : ");
		for (int i=0;i<test.length;i++) {
			System.out.print(test[i]);
			System.out.print(" ");
		}
	}

}
