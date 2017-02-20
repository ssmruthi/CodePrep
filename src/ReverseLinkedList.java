

public class ReverseLinkedList {

	
//new list
	static Node reverse(Node head){
		
		Node prev=null;
		
		while(head!=null){
			
			Node newNode= new Node(head.data);
			newNode.next=prev;
			prev=newNode;			
			head=head.next;
		}
		
		return prev;
		
			
	}
		
	static Node reverseRecursively(Node head){
		
		if(head.next ==null){			
			return head;
		}			
		
		Node newHead=reverseRecursively(head.next);
		head.next.next=head;
		head.next=null;
		return newHead;				
			
	}
	
  static void print(Node head){
		
		while(head!=null){

			System.out.print(head.data+",");
			head=head.next;
		
		}
		
	}
  
  static Node reverseKNodes(int k, Node head){
	  
	  int count=0;
	  Node current=head;
	  Node prev=null;
	  Node next=null;
	  
	  while(count<k && current!=null){
		  
		  next=current.next;
		  current.next=prev;
		  prev=current;
		  current=next;
		  count++;
	  }
	  
	  if(next!=null)
	  head.next=reverseKNodes(k,next);
	  
	  return prev;
  }
  
  //swap nodes
  static Node reverseList(Node head){
	  
	  Node prev=null;
	  Node next=null;
	  
	  while(head!=null){
		  next=head.next;
		  head.next=prev;
		  prev=head;
		  head=next;
	  }
	  
	  return prev;
  }
  
  //iteratively
  static Node reverseKNodesItera(int k, Node head){
	  
	  int count=0;
	  Node current=head;
	  Node prev=null;
	  Node next=null;
	  
	 while(head!=null){
		 
	  current=head;
	  while(count<k && current!=null){
		  
		  next=current.next;
		  current.next=prev;
		  prev=current;
		  current=next;
		  count++;
	  }
	  head.next=prev;
	  head=next;
	 }
	  
	  return prev;
  }
  
  
	
}



