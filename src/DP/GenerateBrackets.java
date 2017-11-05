package DP;

import java.util.HashSet;
import java.util.Set;

public class GenerateBrackets {

	private Set<String> generateBrackets(int n) {

		Set<String> result = null;

		if (n == 0) {
			result = new HashSet<String>();
			result.add("");
		}

		if (n > 0) {
			result = generateBrackets(n - 1);
			result = addOperation(result);
		}
		return result;

	}

	private Set<String> addOperation(Set<String> input) {

		Set<String> result = new HashSet<String>();
		for (String x : input) {
		
			StringBuilder temp= new StringBuilder();
			temp.append(x).append("()");
			result.add(temp.toString());
			
			temp= new StringBuilder();
			temp.append("(").append(x).append(")");
			result.add(temp.toString());
			
			temp= new StringBuilder();
			temp.append("()").append(x);
			result.add(temp.toString());
		}
		
		return result;

	}

	public static void main(String[] args) {

		System.out.println(new GenerateBrackets().generateBrackets(3));
		System.out.println(new GenerateBrackets().generateBrackets(1));
		System.out.println(new GenerateBrackets().generateBrackets(2));

	}

}