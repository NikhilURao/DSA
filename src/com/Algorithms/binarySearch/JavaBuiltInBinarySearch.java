package com.Algorithms.binarySearch;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class JavaBuiltInBinarySearch {

	public static void main(String[] args) {
/*
 * Arrays.binarySearch()
 * Apply binary search on a sorted array (primitive data type like byte, char, double, int, float, short, long and Object).
 * Declaration: public static int binarySearch(data_type arr, data_type key )
 * This method searches the specified array of the given data type for the specified key
 *  using the binary search algorithm. 
 *  The array must be sorted before to making this call. If it is not sorted, the results are undefined. 
 *  If the array contains multiple elements with the specified value, there is no guarantee which one will be found. 
 *  Returns index of the key in the array if the key is present or else (-(insertion point) - 1). 
 *  The insertion point is defined as the point at which the key would be inserted into the array: 
 *  the index of the first element greater than the key, or a.length if all elements in the array are less than 
 *  the specified key. Note that this guarantees that the return value will be >= 0 if and only if the key is found.
*/
		// Input Array
        byte byteArr[] = {10,20,15,22,35};
        char charArr[] = {'g','p','q','c','i'};
        int intArr[] = {10,20,15,22,35};
        double doubleArr[] = {10.2,15.1,2.2,3.5};
        float floatArr[] = {10.2f,15.1f,2.2f,3.5f};
        short shortArr[] = {10,20,15,22,35};
        
        // Sorted Input Array
        Arrays.sort(byteArr);
        
        // keys
        byte byteKey = 11;
        char charKey = 'g';
        int intKey = 22;
        double doubleKey = 1.5;
        float floatKey = 35;
        short shortKey = 5;
        
        System.out.println(Arrays.binarySearch(byteArr, byteKey));
        System.out.println(+Arrays.binarySearch(charArr,charKey));
        System.out.println(Arrays.binarySearch(intArr,intKey));
        System.out.println(Arrays.binarySearch(doubleArr,doubleKey));
        System.out.println(Arrays.binarySearch(floatArr,floatKey));
        System.out.println(Arrays.binarySearch(shortArr,shortKey));
        
/*
 * Collections.binarySearch()
 * Apply binary search on Collection class objects like ArrayList and LinkedList.
 * Declaration:
 * Returns index of key in sorted list sorted in ascending order
 * public static int binarySearch(List ls, T key)
 * Returns index of key in sorted list sorted in order defined by Comparator c.
 * public static int binarySearch(List ls, T key, Comparator c)
 * If key is not present, the it returns "(-(insertion point) - 1)". The insertion point is defined as the point 
 * at which the key would be inserted into the list.
 */
        List al = new ArrayList();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(10);
        al.add(20);

        // 10 is present at index 3.
        int index = Collections.binarySearch(al, 10);
        System.out.println(index);

        // 13 is not present. 13 would have been inserted
        // at position 4. So the function returns (-4-1) 
        // which is -5.
        index = Collections.binarySearch(al, 15);
        System.out.println(index);
        
        // Searching an int key in a list sorted in descending order.
        List al1 = new ArrayList();
        al1.add(100);
        al1.add(50);
        al1.add(30);
        al1.add(10);
        al1.add(2);

        // The last parameter specifies the comparator method
        // used for sorting.
        int index1 = Collections.binarySearch(al1, 50, Collections.reverseOrder());

        System.out.println("Found at index " + index1);
	}

}
