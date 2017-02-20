


/*
 * Performs push, pop and get min value from a stack in O(1) time
 */
public class Stack {

	class StackNode{
		
		int data;
		StackNode next;
	}
	
	StackNode last;
	StackNode min;
	
	public void push(int x){
		
		StackNode t= new StackNode();
		t.data=x;
			
		if(last!=null){
			t.next=last;
			last=t;
		}else if(last==null){
			last=t;
			min=t;
		}
				
		if(min.data > x){
			
			StackNode newMin= t;
			newMin.next=min;
			min=newMin;
			
		}
				
	}
	
	public int getMin(){
		return min.data;
	}
	
	public StackNode pop(){
		
		if(last.data == min.data){
			min=min.next;
		}
		
		StackNode t= last;
		last=last.next;		
					
		return t;
	}
	
	
	public void printStack(){
		
		StackNode q= last;
		while(q!=null){	
			System.out.println(q.data);
			q=q.next;
		}
		
	}
}
