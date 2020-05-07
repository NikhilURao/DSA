package exercise;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
//import javafx.util.Pair;
//import org.javatuples.Pair;

public class FractionalKnapsack 
{	
    private static double getOptimalValue(int capacity, 
    		int[] values, int[] weights) 
    {
        double value = 0;
        ArrayList <List<Double>> valperunit = new ArrayList<List<Double>>();
        //int[] valperunit = new Pair[values.length];
        int max = Integer.MIN_VALUE;
        for (int i=0; i<values.length; i++)
        {	
        	//Pair<Integer, Integer> p = new Pair<Integer, Integer>(values[i]/weights[i],i);	
        	List<Double> ls = new ArrayList<Double>();
        	double v = (double)values[i]/weights[i];
        	double index = (double)(i);
        	ls.add(v);
        	ls.add(index);
        	valperunit.add(ls);
        	
        }
        /*
        for (int i=0;i<valperunit.size();i++)
        {
        	System.out.print(valperunit.get(i)+" ");
        }
        
        Arrays.sort(valperunit, new Comparator<Pair>() {
        	   @Override
        	   public int compare(Pair p1, Pair p2) {
        	       return ((Integer) p1.getValue0()).compareTo((Integer) p2.getValue0());
        	   }
        	});
        */
       
   
 	
// Bubble Sort
		List<Double> temp;
		boolean flag = true;
		for (int i=0;i<valperunit.size();i++) {
			for(int j=0;j<valperunit.size()-1-i;j++) 
			{
				double a = valperunit.get(j).get(0);
				double b = valperunit.get(j+1).get(0);
				
				if(a < b) 
				{
					flag = false;
					temp= valperunit.get(j+1);
					valperunit.set(j+1, valperunit.get(j));
					valperunit.set(j, temp);
				}
			}
			if (flag)
				break;
		}
		/*
        for (int i=0;i<valperunit.size();i++)
        {
        	System.out.print(valperunit.get(i)+" ");
        }
        */
        for (int j=0; j<values.length; j++)
        {
        	if (capacity == 0)
        		return value;
        	else
        	{	
        		int val = valperunit.get(j).get(1).intValue();
        		int amount = Integer.min(capacity, weights[val]);
        		value = value + (amount * (valperunit.get(j).get(0)));
        		weights[val] = 
        				weights[val] - amount;
        		values[val] = 
        				values[val] - amount;
        		capacity = capacity - amount;
        		
        	}
        }
        BigDecimal bdval = new BigDecimal(value);
        value =bdval.setScale(3, RoundingMode.CEILING).doubleValue();
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        //getOptimalValue(capacity, values, weights);
        System.out.println(getOptimalValue(capacity, values, weights));
    }
	
	
}
