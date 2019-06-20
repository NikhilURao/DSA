package com.core;

public class MyArrayList {
	int arr [] = new int[5];
	int size=0;
	
	public void add(int data) {
		if (this.size < arr.length) {
			arr[size]= data;
			size++;
		}
		else {
			int newSize=(int)(size+size*0.75);
			int arr1[] = new int [newSize];
			
			for (int i=0;i<arr.length;i++) {
				arr1[i] = arr[i];
			}
			arr1[size] = data;
			size++;
			
			this.arr=arr1;
			
		}
	}
	public void display() {
		for(int i=0;i<size;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}


