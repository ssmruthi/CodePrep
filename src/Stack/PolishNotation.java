package Stack;

import java.util.Stack;

/*
 * Convert infix to postfix. 
 * Inclusive of (,),+-,*,/
 * 
 * Eg : (5+3)-8 ===> 53+8-
 */
public class PolishNotation {
	
	
	public String StringBuffer(String[] arr){
		
		StringBuffer result= new StringBuffer();
		Stack<String> op= new Stack<String>();
		String operator="+-*/^";
		
		for(String c:arr){
			
			if(c.equals("(")){
				op.push(c);
				
			}else if(c.equals(")")){
			
				while(!op.peek().equals("(")){
					result.append(op.pop().toString());
				}
				op.pop();
			}else if(operator.indexOf(c)>-1){
				
//				while(rankOperator(c.charAt(0))<=op.peek()){
//					result.append(op.pop().toString());
//				}
//				
			}else{
				result.append(c);
			}
			
			
			
		}
		
		
		return result.toString();
	}
	
	private int rankOperator(char c){
		
		switch(c){
		case '+':
			return 1;
		case '-':
			return 2;
		case '*':
			return 3;
		case '/':
			return 4;
		case '^':
			return 5;
		}
		return -1;
	}
	
}
