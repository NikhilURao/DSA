package exercise;

import java.util.*;

public class IsDictionary {
	
	public static int solve(ArrayList<String> A, String B) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(B.length());
        
        // hash the String B
        for(int i=0; i<B.length(); i++){
            map.put(B.charAt(i),i);
        }
        
        // compare each word in the array
        // for (int i=0; i<A.get(0).length(); i++) {
        	//for (int j=0; j<A.size(); j++) 
        	int i=0; // pointer for letters in word
        	int j=0; // pointer for words in array
        	while(j<A.size()-1) {
        		if (map.get(A.get(j).charAt(i))
        				> map.get(A.get(j+1).charAt(i))) {
        			return 0;
        		}
        		else if (map.get(A.get(j).charAt(i))
        				== map.get(A.get(j+1).charAt(i))) {
        			if (i>=A.get(j).length()-1 || i>=A.get(j+1).length()-1) return 0;
        			else i++;
        		}
        		else {
        			i=0;
        			j++;
        		}
        	}
        	
        	return 1;
}

	public static void main(String[] args) {
		System.out.println(solve(new ArrayList<String>(Arrays.asList("ipial", "qjqgt", "vfnue", "vjqfp", "eghva", "ufaeo", "atyqz", "chmxy", "ccvgv", "ghtow")), 
				"nbpfhmirzqxsjwdoveuacykltg"));

	}

}
