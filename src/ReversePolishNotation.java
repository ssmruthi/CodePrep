import java.util.Stack;

/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation. Valid operators are +, -, *, /. Each operand may be an integer or another expression. For example:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class ReversePolishNotation {
	
	public static Integer evaluate(String[] input){
		Stack<Integer> number= new Stack<Integer>();
		
		for(String value:input){
			
			if(value.matches("\\d+")){   //Pushes into stack if its a number
				number.push(Integer.parseInt(value));
			} else if(value.matches("[+-\\\\*/]?") && number.size()>1){   //Pops 2 numbers if operator
								
				int a = number.pop();
				int b = number.pop();
				
				if (value.equals("+"))
					number.push(a + b);

				else if (value.equals("-"))
					number.push(b-a);

				else if (value.equals("*"))
					number.push(a * b);

				else if (value.equals("/"))
					number.push(b/a);

			}
		}
		
		return number.pop();
	}

}
