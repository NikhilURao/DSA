package exercise;
import java.util.Scanner;

public class Change 
{
    private static int getChange(int m) 
    { 
    	int num_coins=0;
    	if (m < 5)
    	{
    		num_coins = num_coins + m;
    	}
    	else if(m >= 5 && m < 10)
    	{
    		num_coins = num_coins + m/5 + m%5;
    	}
    	else
    	{
    		num_coins = num_coins + m/10 + (m%10)/5 + (m%10)%5;
    	}
    	
    	return num_coins;
    	/*
    	if (m < 5)
    	{
    		return m;
    	}
    	else if (m >= 5 && m < 10)
    	{
    		return getChange(m%5);
    	}
    	else
    	{
    		return getChange(m%10);
    		 
    	}
    	*/
    	
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
        

    }

}
