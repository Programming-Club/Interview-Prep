package programming_club;

import java.util.HashMap;
import java.util.Map;

public class StringPattern {

	public static int stringPattern(String s) {
		
		String[] split = s.split(" ");
		String number = split[0];
		String pattern = split[1];
		// using a set doesn't work?
		// edit: oh, it's map that has a key and a value, not a set
		// Set<Character> set = new HashSet();
		Map<Character, Integer> map = new HashMap();
		int charOfPattern = 0;
		
		for (int i = 0; i < pattern.length(); i++) {
			
			Character letter = pattern.charAt(i);
			
			if (!letter.equals('+') && !letter.equals('-')) {
				
				if (!map.containsKey(letter)) {
					
					// using parseInt for now, but would using a stack to pop off digits would be efficient?
					// edit: nvm, forgot + and - are in between the numbers, can't use % and / to get single digits lol
					map.put(letter, Integer.parseInt(Character.toString(number.charAt(charOfPattern))));
					charOfPattern = charOfPattern + 1;
					
				}
			}
		}
		
		return findAnswer(pattern, map);
		
	}
	
	public static int findAnswer(String pattern, Map<Character, Integer> map) {
		
		String[] splittedPattern = null;
		String operator = ""; // could use a boolean but maybe there will be a similar challenge with multiplication and division
		Character letter;
		StringBuilder beforeOperator = new StringBuilder();
		StringBuilder afterOperator = new StringBuilder();
		
		if (pattern.contains("+")) {
			
			// wth is a dangling meta character near index 0 error
			// ok, had to use \\
			splittedPattern = pattern.split("\\+");
			operator = "+";
			
		}
		
		else {
			
			splittedPattern = pattern.split("-");
			
		}
		
		for (int i = 0; i < splittedPattern[0].length(); i++) {
			
			letter = splittedPattern[0].charAt(i);
			beforeOperator.append(map.get(letter));
			
		}
		
		for (int i = 0; i < splittedPattern[1].length(); i++) {
			
			letter = splittedPattern[1].charAt(i);
			afterOperator.append(map.get(letter));
			
		}
		
		if (operator == "+") {
			
			return Integer.parseInt(beforeOperator.toString()) + Integer.parseInt(afterOperator.toString());
			
		}
		
		else {
			
			return Integer.parseInt(beforeOperator.toString()) - Integer.parseInt(afterOperator.toString());
			
		}	
	}
}