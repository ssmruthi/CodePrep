
public class Queue {

	class QueueNode{
		
		int data;
		QueueNode next;
	}
	
	QueueNode last;
	QueueNode first;
	
	public void add(int x){
		
		QueueNode t= new QueueNode();
		t.data=x;
	
		if(last!=null){
			last.next=t;			
		}else{				
			first=t;
		}
		
		last=t;
		
	}
	
	public QueueNode remove(){
		

		if(first==null)
			return null;
		
		QueueNode t= first;
		first=first.next;
				
		return t;
	}
	
	public void printQueue(){
		
		QueueNode q=first;
		System.out.println();
		while(q!=null){
			System.out.print(q.data+" ,");
			q=q.next;
		}
		
	}
}
