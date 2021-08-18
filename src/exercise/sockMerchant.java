/*
 * There is a large pile of socks that must be paired by color. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.

Example


There is one pair of color  and one of color . There are three odd socks left, one of each color. The number of pairs is .

Function Description

Complete the sockMerchant function in the editor below.

sockMerchant has the following parameter(s):

int n: the number of socks in the pile
int ar[n]: the colors of each sock
Returns

int: the number of pairs
Input Format

The first line contains an integer , the number of socks represented in .
The second line contains  space-separated integers, , the colors of the socks in the pile.
 */
package exercise;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class sockMerchant {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */
    
    
    
    public static int getSockMerchant(int n, List<Integer> ar) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int count=0;
        for (int i=0; i<ar.size(); i++){
            if (!hm.containsKey(ar.get(i))){
                hm.put(ar.get(i),1);
            }
            else{
                hm.replace(ar.get(i), hm.get(ar.get(i))+1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue() >= 2 ){
                count = count + entry.getValue()/2;
            }
        }
        
        return count;
    }
    
    public static void main(String [] args) {
    	//int [] array = {1,2,1,3,4,1,2,3,4,2,1,4,4,9,2}; 
    	ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,1,3,4,1,2,3,4,2,1,4,4,9,2));
    	System.out.println(getSockMerchant(arr.size(), arr));
    }

}
/*
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
        
        1,2,1,3,4,1,2,3,4,2,1,4,4,9,2
        
        1 - 4
        2- 4
        3-2
        4-4
        
    }}
    */

