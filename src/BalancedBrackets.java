import java.util.Stack;

public class BalancedBrackets {
   
	
	public static boolean isBalanced(String expression) {
      Stack<Character> stackopen= new Stack<Character>();
      Stack<Character> stackclose= new Stack<Character>();
      
      int i=0;
      int j=expression.length()/2;
      
      if(expression.length()%2 > 0)
    	  return false;
      
      while(i <j && j<expression.length()){    	     
    	  stackopen.push(expression.charAt(i));
    	  stackclose.push(expression.charAt(j));
    	  i++;
    	  j++;
      }
      
      while(!stackopen.isEmpty()){
    	 
    	  char open=stackopen.pop();
    	  char close=stackclose.pop();
    	      	  
      }
      System.out.println(stackclose.toString());      
      return false;

		
	
	}
	
	
	public static boolean checkValidParanthesis(String input){
		
		Stack<Character> stackOpen= new Stack<Character>();
		char[] inputChar= input.toCharArray();
		
		for(char x: inputChar){
			
			if(x=='('){
				stackOpen.push(x);
			}
			
			if(x==')'){
				if(stackOpen.isEmpty())
					return false;
				else
					stackOpen.pop();
			}
			
		}
		
		if(!stackOpen.isEmpty()){
			return false;
		}
		
		
		return true;
	}
  
   
}
