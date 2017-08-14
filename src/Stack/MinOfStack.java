package Stack;

import java.util.Stack;

/*
 * Minimum value in stack
 */
public class MinOfStack extends Stack<StackNode>{
	
	
	public void push(int value){
		
		int min;
		
		if(this.isEmpty()){
			min=value;
		}else{
			min=Math.min(super.peek().min, value);
		}
		
		StackNode node= new StackNode(value, min);
		super.push(node);

	}
	public int min(){
		
		if(this.isEmpty()){
			return Integer.MAX_VALUE;
		}else{
			return super.peek().min;
		}
	}
	
}


class StackNode{
	
	int value;
	int min;
	
	StackNode(int value, int min){
		this.value=value;
		this.min=min;
	}
}