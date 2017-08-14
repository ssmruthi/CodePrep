package Stack;

import java.util.Stack;

/*
 * Minimum value in stack
 */
public class MinOfStack2 extends Stack<Integer>{
	
	Stack<Integer> minStack= null;
	
	public MinOfStack2() {
		super();
		minStack=new Stack<Integer>();
	}
	
	public int min(){
		return minStack.peek();
	}
	
	public void push(int value){
		super.push(value);
		
		if(minStack.isEmpty() || value<minStack.peek())
			minStack.push(value);
	}
	
	public Integer pop(){

		if(this.peek()==minStack.peek()){
			minStack.pop();
		}
		return super.pop();
	}
}

