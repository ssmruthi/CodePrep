package Stack;

import java.util.EmptyStackException;
import java.util.Stack;


public class SetofStacks {
	
	Stack<Stack<Integer>> stackSet= null;
	int subStackSize=0;
	
	public SetofStacks(int capacity) {
		stackSet= new Stack<Stack<Integer>>();
		this.subStackSize=capacity;
	}
	
	public void push(int a){
		if(stackSet.isEmpty() || stackSet.peek().size()==subStackSize){
			Stack<Integer> s= new Stack<Integer>();
			s.setSize(subStackSize);
			stackSet.push(new Stack<Integer>());
		}
		stackSet.peek().push(a);
	}
	
	public int pop(){
		
		if(stackSet.isEmpty())
			throw new EmptyStackException();
		
		int value=stackSet.peek().pop();
		
		if(stackSet.peek().isEmpty())
			stackSet.pop();
		return value;
		
	}
	
	@Override
	public String toString(){
		
		StringBuilder str= new StringBuilder();
		for(Stack<Integer> s: stackSet){
			str.append("\n");
			for(int i=0;i<s.size();i++)
				str.append(","+s.elementAt(i));
		}
		
		return str.toString();
	}
	
	
	public int popAt(int index){
		
		int stackNumber=(int) Math.ceil(index/subStackSize);
		int subIndex=index%subStackSize;
		
		Stack<Integer> temp=stackSet.elementAt(stackNumber);
		int value=temp.elementAt(subIndex);
		
		//temp.remove(subIndex);
		shiftStack(subIndex);
		
		return value;
	}

	/*
	 * Shifts stack by popping elments after index to a new stack and pushing them back to the old SetoFStacks
	 */
	private void shiftStack(int subIndex) {

		Stack<Integer> buffer= new Stack<Integer>();
		
		/* Exclude last stack count and add at the end as it could be less popoulated*/
		
		int count=(stackSet.size()-1)*subStackSize+stackSet.peek().size();
		
		int i=count-1;
		while(i>subIndex){
			buffer.push(this.pop());
			i--;
		}
		stackSet.peek().pop();
		while(!buffer.isEmpty()){
			this.push(buffer.pop());
		}
		
	}
	
}

