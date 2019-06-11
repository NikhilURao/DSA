package com.recursion;

public class Cube {

	int cube(int a,int n) {
		
		if (a==0)
			return 1;
		else if (n==1)
			return a;
		else return a * cube(a,n-1);
	
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 Cube c = new Cube();

 System.out.println( c.cube(4, 4));
	}

}
