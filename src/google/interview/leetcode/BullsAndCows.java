package google.interview.leetcode;

import java.util.HashMap;
import java.util.ArrayList;

public class BullsAndCows {
	
    public static String getHint2Pass(String secret, String guess) {
    	
        HashMap<Character, Integer> charFreq = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<secret.length(); i++) {
        	Character secretChar = secret.charAt(i);
        	charFreq.put(secretChar, charFreq.getOrDefault(secretChar, 0)+1);
        	}       	
        
        int bulls = 0;
        int cows = 0;
        
        for (int i=0; i<guess.length(); i++) {
        	
        	Character guessChar = guess.charAt(i);
        	
        	if (charFreq.containsKey(guessChar)) {
        		
            	if (guessChar == secret.charAt(i)) {
            		// increment bulls
            		bulls++;
            		
            		if (charFreq.get(guessChar) <= 0) {
            			cows--;
            		}
            	}
            	else if(charFreq.get(guessChar) > 0){
            		cows++;
            	}
            	
            	
            	charFreq.put(guessChar, charFreq.get(guessChar)-1);
        	}

        	
        }
        
        sb.append(bulls).append("A").append(cows).append("B");
        
        return sb.toString();
        
    }

	public static void main(String[] args) {
		System.out.println(getHint2Pass("1123", "0111"));

	}

}
