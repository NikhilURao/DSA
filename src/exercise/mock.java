package exercise;

import java.util.*;

public class mock {
	public static ArrayList<String> solve(String str){
	    HashSet<Character> set = new HashSet<Character>();
	    ArrayList<Character> arr = new ArrayList<Character>();
	    ArrayList<String> out = new ArrayList<String>();
	    for (int n=0; n<str.length(); n++){
	        arr.add(str.charAt(n));
	        if (!set.contains(str.charAt(n)))
	            set.add(str.charAt(n));
	    }
	    int n=set.size();
	    for (int i=0; i<arr.size(); i++){
	        StringBuilder res = new StringBuilder();
	        StringBuilder res1 = new StringBuilder();
	        res.append(arr.get(i));
	        for (int j=0; j<arr.size(); j++){
	            if (j!=i){
	                res.append(arr.get(j));
	            }
	        }
	        res1.append(arr.get(i));
	        out.add(res.toString());
	        for (int j=arr.size()-1; j>=0; j--){
	            if (j!=i){
	                res1.append(arr.get(j));
	            }
	        }
	        out.add(res1.toString());
	    }
	    
	    return out;
	    
	}
	
	static void MergeSort(int []arr, int start, int end) {
		if (start<end) {
			int mid = (start+end)/2;
			MergeSort(arr, start, mid);
			MergeSort(arr, mid+1, end);
			Merge(arr, start, mid+1, end);
		}
	}
	
	static void Merge(int []arr, int start, int mid, int end) {
		int [] temp = new int [arr.length];
		int i=start;
		int j=end;
		int m=mid;
		int k=0;
		while (i<=mid && m<=j) {
			
			if (arr[i] < arr[m]) {
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
			temp[k] = arr[i];
			i++;
			k++;
		}
		while (m<=j) {
			temp[k] = arr[m];
			m++;
			k++;
		}
		
	}

	public static void main(String[] args) {
		solve("ABC").forEach(p -> System.out.println(p));

	}

}
