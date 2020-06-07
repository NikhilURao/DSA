package com.array;

import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class solution1 {
	
	
	

	public static void main(String[] args) {
		String [] string_arr = {"akash","scaler","problem","distance"};
		String special_string = "rishabh";
		char [] c = special_string.toCharArray();
		ArrayList String_pow = new ArrayList();
		HashMap char_pow = new HashMap<>();
		for (char ch : c)
		{
			if (!char_pow.containsKey(ch))
			{
				char_pow.put(ch, 1);
			}
			else 
			{
				char_pow.put(ch, (int)char_pow.get(ch)+1);
			}
			
		}
		
		for (String s: string_arr)
		{
			StringCharacterIterator sci = new StringCharacterIterator(s);
			int count=0;
			while(sci.current() != sci.DONE)
			{
				count += (int)char_pow.getOrDefault(sci.current(), 0);
				sci.next();
			}
			String_pow.add(count);
		}
		String_pow.sort(null);
		int min = Integer.MAX_VALUE;
		
		for (int i=0; i<String_pow.size()-1; i++)
		{
			min = Math.min(min, (int)String_pow.get(i+1) - (int)String_pow.get(i));
		}
		
		//System.out.println(min);
/////////////------Longest Substring with repeating------////////////////////
		
		String s = "Wnb9z9dMc7E8v1RTUaZPoDNIAXRlzkqLaa97KMWLzbitaCkRpiE4J4hJWhRcGnC8H6mwasgDfZ76VKdXhvEYmYrZY4Cfmf4HoSlchYWFEb1xllGKyEEmZOLPh1V6RuM7Mxd7xK72aNrWS4MEaUmgEn7L4rW3o14Nq9l2EN4HH6uJWljI8a5irvuODHY7A7ku4PJY2anSWnfJJE1w8p12Ks3oZRxAF3atqGBlzVQ0gltOwYmeynttUmQ4QBDLDrS4zn4VRZLosOITo4JlIqPD6t4NjhHThOjJxpMp9fICkrgJeGiDAwsb8a3I7Txz5BBKV9bEfMsKNhCuY3W0ZHqY0MhBfz1CbYCzwZZdM4p65ppP9s5QJcfjadmMMi26JKz0TVVwvNA8LP5Vi1QsxId4SI19jfcUH97wmZu0pbw1zFtyJ8GAp5yjjQTzFIboC1iRzklnOJzJld9TMaxqvBNBJKIyDjWrdfLOY8FGMOcPhfJ97Dph35zfxYyUf4DIqFi94lm9J0skYqGz9JT0kiAABQZDazZcNi80dSSdveSl6h3dJjHmlK8qHIlDsqFd5FMhlEirax8WA0v3NDPT8vPhwKpxcnVeu14Gcxr3h1wAXXV0y7Xy9qqB2NQ5HQLJ7cyXAckEYHsLCPSy28xcdNJatx1KLWohOQado4WywJbGvsFR17rKmvOPABweXnFD3odrbSMD4Na4nuBBswvMmFRTUOcf7jZi4z5JnJqXz6hitaPnaEtjoSEBq82a52nvqYy7hhldBoxen2et2OMadVEHeTYLL7GLsIhTP6UizHIuzcJMljo4lFgW5AyrfUlIBPAlhwaSiJtTvcbVZynDSM6RO1PqFKWKg2MHIgNhjuzENg2oFCfW7z5KJvEL9qWqKzZNc0o3BMRjS04NCHFvhtsteQoQRgz84XZBHBJRdekCdcVVXu9c01gYRAz7oIAxN3zKZb64EFKssfQ4HW971jv3H7x5E9dAszA0HrKTONyZDGYtHWt4QLhNsIs8mo4AIN7ecFKewyvGECAnaJpDn1MTTS4yTgZnm6N6qnmfjVt6ZU51F9BxH0jVG0kovTGSjTUkmb1mRTLQE5mTlVHcEz3yBOh4WiFFJjKJdi1HBIBaDL4r45HzaBvmYJPlWIomkqKEmQ4rLAbYG7C5rFfpMu8rHvjU7hP0JVvteGtaGn7mqeKsn7CgrJX1tb8t0ldaS3iUy8SEKAo5IZHNKOfEaij3nI4oRVzeVOZsH91pMsA4jRYgEohubPW8ciXwVrFi1qEWjvB8gfalyP60n1fHyjsiLW0T5uY1JzQWHKCbLVh7QFoJFAEV0L516XmzIo556yRH1vhPnceOCjebqgsmO78AQ8Ir2d4pHFFHAGB9lESn3OtJye1Lcyq9D6X93UakA3JKVKEt6JZDLVBMp4msOefkPKSw59Uix9d9kOQm8WCepJTangdNSOKaxblZDNJ5eHvEroYacBhd9UdafEitdF3nfStF7AhkSfQVC61YWWkKTNdx96OoJGTnxuqt4oFZNFtO7aMuN3IJAkw3m3kgZFRGyd3D3wweagNL9XlYtvZwejbjpkDOZz33C0jbEWaMEaUPw6BG49XqyQoUwtriguO0yvWyaJqD4ye3o0E46huKYAsdKAq6MLWMxF6tfyPVaoqOGd0eOBHbAF89XXmDd4AIkoFPXkAOW8hln5nXnIWP6RBbfEkPPbxoToMbV";
		int size = s.length();
		int l=0, len =0;
		HashMap<Character, Integer> c_map = new HashMap<>(); 
		
		for(int r=0; r<size; r++)
		{
			if (!c_map.containsKey(s.charAt(r)))
			{
				c_map.put(s.charAt(r), 1);
				len++;
			}
			else
				c_map.put(s.charAt(r), (c_map.get(s.charAt(r))+1));
			
			while (c_map.get(s.charAt(r)) >= 2)
			{
				c_map.put(s.charAt(l), c_map.get(s.charAt(l))-1);
				l++;
			}
			
			len = Math.max(len, r-l+1);
					
		}
		//System.out.println(len);
		solution1 sol1 = new solution1();

		
	}

}