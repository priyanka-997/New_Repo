package api.test;

import java.util.HashMap;

public class Test1 {
	
	public static void main(String[] args) {
		
		String s="interview";
		
		HashMap<Character, Integer> charCount = new HashMap<>();
		
		char[] ch = s.toCharArray();
		
		for(char c : ch) {
			
			if(Character.isAlphabetic(c)) {
				
				if (charCount.containsKey(c)) {
					
					charCount.put(c, charCount.get(c)+1);						
				}			
				else {				
					charCount.put(c, 1);
				}			
						}			
		}	
		System.out.println("The characters count is " +charCount);		
		}		
	}
	
	

