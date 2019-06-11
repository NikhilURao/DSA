package com.Algorithms;

import java.util.Random;

public class MergeSort {

	static void Merge(int []arr,int start,int mid,int end) {
		int i=start;
		int j=end;
		int m=mid;
		int [] temp = new int [j-i+1];
		int k=0;
		while (i<mid && m<=j) {
			if (arr[i]<arr[m]) {
				temp[k] = arr[i];
				i++;
				k++;
			}
			else {
				temp[k] = arr[m];
				m++;
				k++;
			}
		}
		while (i<mid) {
			temp[k]=arr[i];
			i++;
			k++;
		}
		while (m<=j) {
			temp[k]=arr[m];
			m++;
			k++;
		}
		for(int l=0;l<temp.length-1;l++) {
		arr[start]=temp[l];	
		start++;
		}
	}
	static void MergeSort (int []arr,int start,int end) {
		if (start<end) {
			int mid =(start+end)/2;
			MergeSort(arr, start,mid);
			MergeSort(arr, mid+1, end);
			Merge(arr, start, mid+1, end);
			
		}
	}
	public static void main(String[] args) {
		int [] test = new int[15];
		Random ran = new Random();
		for (int i=0;i<test.length;i++) {
			test[i]=ran.nextInt(10);
		}
		System.out.println("Array before MergeSort : ");
		for (int i=0;i<test.length;i++) {
			System.out.print(test[i]);
			System.out.print(" ");
		}
		System.out.println("");
		MergeSort(test, 0, test.length-1);
		System.out.println("Array after MergeSort : ");
		for (int i=0;i<test.length;i++) {
			System.out.print(test[i]);
			System.out.print(" ");
		}		
	}

}
