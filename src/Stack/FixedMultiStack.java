package Stack;

import java.util.Arrays;

/*
 * 3 stacks using 1 array
 * Stacks identified as 0,1,2,
 */
public class FixedMultiStack {

	 int[] index = null;
	 int stackCapacity;
	 int numberOfStacks;
	 int[] arr = null;
	
	

	public FixedMultiStack(int stackCapacity, int numberofstacks) {

		this.stackCapacity = stackCapacity;
		this.numberOfStacks = numberofstacks;
		arr = new int[numberOfStacks * stackCapacity];
		Arrays.fill(arr, -1);
		
		index = new int[numberOfStacks];

		for (int i = 0; i < index.length; i++) {
			index[i] = i * stackCapacity;
		}
	}
	
	private boolean isEmpty(int stack){
		int min=(stack*stackCapacity);
		return index[stack]<=min;
		
	}
	
	private  boolean isFull(int stack){
		int max=(stack*stackCapacity+stackCapacity);
		return index[stack]==max;
	}
	
	
	public  void push(int stack, int value) throws Exception {

		int pointer = index[stack];
		
		if(isFull(stack))
			throw new Exception("Stack Overflow");

		arr[pointer] = value;
		index[stack]++;

	}

	public  int pop(int stack) throws Exception {

		index[stack]--;
		int pointer = index[stack] ;
		
		if (isEmpty(stack))
			throw new Exception("Empty Stack");
		
		
		int value=arr[pointer];
		arr[pointer]=-1;
		
		return value;
	}
	
	
	public  void print(){
		for(int x:arr){
			System.out.print(x+",");
		}
	}

}