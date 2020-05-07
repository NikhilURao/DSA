package exercise;
import java.util.*;
import java.io.*;

public class CarFueling 
{
    static int computeMinRefills(int dist, int tank, int[] stops) 
    {
    	int currentStop = 0;
    	int numRefills = 0;
    	int [] new_stops = new int [stops.length + 2];
    	new_stops[0] = 0;
    	for (int i=0; i<stops.length; i++)
    	{
    		new_stops[i+1] = stops[i];
    	}
    	new_stops[stops.length + 1] = dist;
    	int n = new_stops.length;
    	
    	//System.out.println("Stops len "+n);
    	if(tank > dist)
    	{
    		return 0;
    	}
    	
    	while (currentStop < n && currentStop+1 < n)
    	{
    		int prevStop = currentStop;
    		
    		while (currentStop < n && currentStop+1 < n &&
    			new_stops[currentStop+1] - new_stops[prevStop] <= tank)
    		{
    			currentStop = currentStop + 1;
    			
    		}
    		
    		if (currentStop < n && currentStop+1 < n)
    			numRefills = numRefills + 1;
    		
    		if (currentStop == prevStop)
    			return -1;
    		
    	}
    	return numRefills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }

}
