public class LongestValidParenthesis {
	
/*	public static int longestValidParentheses(String s) {
		java.util.Stack<int[]> stack = new java.util.Stack<int[]>();
		
		int result = 0;

		for (int i = 0; i <= s.length() - 1; i++) {
			char c = s.charAt(i);
			if (c == '(') {
				int[] a = { i, 0 };
				stack.push(a);
			} else {
				if (stack.empty() || stack.peek()[1] == 1) {
					int[] a = { i, 1 };
					stack.push(a);
				} else {
					stack.pop();
					int currentLen = 0;
					if (stack.empty()) {
						currentLen = i + 1;
					} else {
						currentLen = i - stack.peek()[0];
					}
					result = Math.max(result, currentLen);
				}
			}
		}

		return result;
	}
	*/
	public static int longestValidParentheses(String s){
				
		if(s.length()==0 || null==s)
			return 0;		
		
		char[] input=s.toCharArray();
		
		java.util.Stack<Integer> stack= new java.util.Stack<Integer>();
		int result=0;
		
		for(int index=0;index<input.length;index++){
			
			if(input[index]=='('){				
				stack.push(index); //Push index of open bracket
				
			}else if(input[index]==')'){
				if(stack.isEmpty()){
					/*
					 * When stack is empty, whatever traversed so far is a valid string. simply take current index position as length.
					 */
					result=Math.max(result, (index+1));  
				}else{
					
					/*
					 * When stack is not empty, subtract current index from prev encountered open bracket.
					 */
					
					int stackIndex=stack.pop();
					result=Math.max(result, (index-stackIndex)+1);
				}
				
			}
						
		}
		
		return result;
	}
}