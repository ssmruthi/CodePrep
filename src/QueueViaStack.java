import java.util.Stack;

/*
 * Perform Queue through 2 Stack
 * Push into stack 1 
 * When popping, copy contents to stack 2, pop top
 * 
 * When new elements are added while popping, the stack 2 order is not going to change
 * so retain all elements until stack 2 is empty. Once stack2 is empty, copy again from stack1 and pop
 * This will prevent copying back and forth between 2 stacks.
 * 
 */
public class QueueViaStack {

	Stack<Integer> s1= new Stack<Integer>();
	Stack<Integer> s2= new Stack<Integer>();
	
	public void push(int x){
		s1.push(x);	
	}
	
	public int pop(){
	
		if(s2.isEmpty()){
			while(!s1.isEmpty()){
				s2.push(s1.pop());
			}
		}		
		return s2.pop();
	}
	
	public void print(){		
		System.out.println(s2.toString());
	}
	
	
}
