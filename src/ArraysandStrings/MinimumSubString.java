package ArraysandStrings;

import java.util.HashMap;
import java.util.Map;

public class MinimumSubString {

	// xxyz
	private String smallestSubstring(char[] arr, String input) {

		String result = "";
		
		Map<Character, Integer> count = new HashMap<Character, Integer>();
		Map<Character, Integer> occurance = new HashMap<Character, Integer>();
		
		for (char x : arr) {
			count.put(x, 0);
			
			if(occurance.containsKey(x))
				occurance.put(x, occurance.get(x)+1);
			else
				occurance.put(x, 1);
		}

		int left = 0;
		int right = 0;
		int uniqueCounter = occurance.keySet().size();
		
		while (right < input.length()) {

			char currChar = input.charAt(right);

			if (count.containsKey(currChar)) {
				
				count.put(currChar, count.get(currChar) + 1);

				if (count.get(currChar) == occurance.get(currChar)) {
					uniqueCounter--;
				}

				while (uniqueCounter == 0) {

					if (result.isEmpty() || result.length() > (right - left + 1)) {
						result = input.substring(left, right + 1);

						if (result.length() == arr.length)
							return result;
					}

					char c = input.charAt(left);
					if (count.containsKey(c)) {
						count.put(c, count.get(c) - 1);
						if (count.get(c) < occurance.get(c))
							uniqueCounter++;
					}

					left++;
				}
			}
			right++;

		}

		return result;

	}

	public static void main(String[] args) {
		
		
		char[] a = { 'a', 'a'};
		String i = "aba";

		String r = new MinimumSubString().smallestSubstring(a, i);
		System.out.println(r);

	}
}