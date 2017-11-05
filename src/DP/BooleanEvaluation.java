package DP;
//Algorithm

// recursion

// split into 2 exp a and b
// recursively count 'a' for  T and f. .. call twice with true
// recursively evlaute b for both T and F... call twice

// based on  operator, find the combination of a true/false with b true false
// Eg : if the whole operation is a| b , it means 3 combination (a==true and b==true or a==f and b=true or a==t and b=f)
// multipl each county as each combination of a could be pair with each combination of B

public class BooleanEvaluation {

	
	public static int countEval(String input, boolean result) {

		if(input.trim().length()==0)
			return 0;
		
		if(input.length()==1){
			
			boolean value=input.equals("1");
			
			return(value==result)?1:0;
		}
			 
		
		int ways = 0;

		for (int i = 1; i < input.length(); i += 2) {

			String a = input.substring(0, i);
			char op = input.charAt(i);
			String b = input.substring(i + 1);

			int aTrue = countEval(a, true);
			int aFalse = countEval(a, false);
			int bTrue = countEval(b, true);
			int bFalse = countEval(b, false);
			int count = 0;

			switch (op) {

			case '|':
				if (result)
					count = (aTrue * bTrue) + (aTrue * bFalse) + (aFalse * bTrue);
				else
					count = aFalse * bFalse;
				break;

			case '&':
				if (result)
					count = (aTrue * bTrue);
				else
					count = (aTrue * bFalse) + (aFalse * bTrue) + (aFalse * bFalse);
				
				break;

			case '^':

				if (result)
					count = (aTrue * bFalse) + (aFalse * bTrue);
				else
					count = (aTrue * bTrue) + (aFalse * bFalse);
				break;

			}

			
			ways += count;
		}

		return ways;
	}
	
	public static void main(String[] args) {
		
		int a=countEval("1^0|0|1", false);
		System.out.println(a);
		
		a=countEval("0&0&0&1^1|0", true);
		System.out.println(a);
		
	}
}
