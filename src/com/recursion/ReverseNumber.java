package com.recursion;

public class ReverseNumber {
	int rev(int num, int res) {
	
		if(num>0) 
		{
			res = res*10 +num%10;
		    return rev(num/10,res);
		}
		else
		{
			return res;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseNumber r = new ReverseNumber();
		System.out.println(r.rev(1359,0));

	}

}
