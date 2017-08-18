package Stack;

import java.util.Stack;

public class QueueViaStack {
	
	Stack<Integer> stack1= new Stack<Integer>();
	Stack<Integer> stack2= new Stack<Integer>();
	
	public void push(Integer a){
		stack1.push(a);
	}
	
	public Integer pop(){
		
		if(stack1.isEmpty() && stack2.isEmpty())
			return null;
		
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}
}



