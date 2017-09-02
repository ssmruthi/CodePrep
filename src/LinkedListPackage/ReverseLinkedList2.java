package LinkedListPackage;
public class ReverseLinkedList2{
	
	public static Node reverse(Node head){
		
		Node result=null;
		Node next=null;
		
		while(head!=null){
			next=head.next;
			head.next=result;
			result=head;
			head=next;
		}
		
		return result;
	}
	
	public static Node reverse2(Node head){
		
		Node result=null;
		Node next=null;
		
		while(head!=null){ 
			next=result;  
			result=head; 
			head=head.next; 
			result.next=next; 
		}
		
		return result;
	}
	
	public static Node reverseRecursion(Node head){
		
		if(head.next==null)
			return head;
		
		Node next=head.next;
		Node newhead=reverseRecursion(head.next);
		head.next=null;
		next.next=head;
		
		return newhead;
	}
	
	
	
}