package LinkedListPackage;

public class CircularLinkedList{
	
	public static boolean isLoop(Node head){
		
		Node slow=head;
		Node fast=head;
		
		while(fast!=null && fast.next!=null){
			fast=fast.next.next;
			slow=slow.next;
			
			if(slow==fast)
				return true;
		}
		return false;
	}
	
	
}