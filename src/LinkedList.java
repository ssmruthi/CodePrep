
public class LinkedList {

	static Node head=null;
	static Node currHead=null;
	
	
	static Node add(int x){
		
		Node newNode= new Node(x);
		if(head==null){
			head=newNode;
			currHead=head;
		}else{		
			while(head.next!=null){
				head=head.next;
			}
			head.next=newNode;		
			newNode.next=null;	
		}		
		return head;		
	}
	
	static void print(Node head){
		
		while(head!=null){

			System.out.print(head.data+",");
			head=head.next;
		
		}	
	}
}


class Node{
	
	Node next=null;
	Integer data;
	
	Node(){
		data=null;
	}
	Node(int x){
		data=Integer.valueOf(x);
		
	}
	
}

