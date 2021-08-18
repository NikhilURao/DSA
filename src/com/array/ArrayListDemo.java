package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class ArrayListDemo {

	public static void main (String [] args){
		// array initialization 
		int [] a = new int[10];
		Arrays.fill(a, -1); // initialize array elements with -1
		
		// 1D ArrayList
		// Initialization 
		ArrayList<Integer> arr = new ArrayList<Integer>();
		// initialize arraylist elements with 0
		List<Integer> list = new ArrayList<Integer>(Collections.nCopies(60, 0));
		List<Integer> arr1 = new ArrayList<Integer>();
		List<Integer> arr2 = new ArrayList<Integer>(10);
		ArrayList<Integer> arr3 = new ArrayList<Integer>(
			Arrays.asList(1,2,3));
		System.out.println(arr.size());
		
		System.out.println(arr.isEmpty());
		arr.add(10);
		arr.forEach(i->System.out.print(i+" "));
		for (int x: arr) {
			System.out.print(x+" ");
		}
		System.out.println();
		System.out.println(arr.size());
		arr.add(15);
		arr.add(2,20);
		arr.forEach(i->System.out.print(i+" "));
		System.out.println();
		arr.remove(2);
		System.out.println(arr.size());
		Consumer<Integer> printElements = x -> System.out.print(x+" ");
		arr.forEach(printElements);
		// converting array to ArrayList
		String[] names = {"nikhil", "megha","vinay"};
		List<String> al = new ArrayList<String>(Arrays.asList(names));
		List<String> al1 = new ArrayList<String>();
		Collections.addAll(al1, names);
		// conversion of ArrayList to array
		String[] names_arr = (String[]) al.toArray();
		
		String[] ar = new String[al1.size()];
        ar = al1.toArray(ar);
		// 2D ArrayList
		ArrayList<ArrayList<Integer>> ar2 = new ArrayList<ArrayList<Integer>>();
		/*Declaring 2D ArrayList*/
        ArrayList<ArrayList<Integer> > x
            = new ArrayList<ArrayList<Integer> >();
  
        /*one space allocated for 0th row*/
        x.add(new ArrayList<Integer>());
  
        /*Adding 3 to 0th row created above x(0, 0)*/
        x.get(0).add(0, 3);
  
        /*Creating 1st row and adding values 
       (another way for adding values in 2D collections)*/
        x.add(new ArrayList<Integer>(Arrays.asList(3, 4, 6)));
  
        /*Add 366 to 1st row 0th column x(1, 0)*/
        x.get(1).add(0, 366);
  
        /*Add 576 to 1st row 4th column x(1, 4)*/
        x.get(1).add(4, 576);
  
        /*Adding values to 2nd row*/
        x.add(2, new ArrayList<>(Arrays.asList(3, 84)));
  
        /*Adding values to 3rd row*/
        x.add(new ArrayList<Integer>(Arrays.asList(83, 6684, 776)));
  
        /*Adding values to 4th row*/
        x.add(new ArrayList<>(Arrays.asList(8)));
        // print x
        System.out.println("");
        for (int i=0; i<x.size(); i++) {
        	for (int j=0; j< x.get(i).size(); j++) {
        		System.out.print(x.get(i).get(j)+" ");
        	}
        	System.out.println("");
        }
        
		
	}
}

