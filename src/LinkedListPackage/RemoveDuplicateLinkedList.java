package LinkedListPackage;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateLinkedList {
	
	
	//temp buffer
	public static Node removeDuplicates(Node head){
		
		Node tempHead=head;
		Node prev=null;
		
		Set<Integer> visited = new HashSet<Integer>();
		
		while(head !=null){
			
			if(visited.contains(head.data)){
				prev.next=head.next;
			}else{
				visited.add(head.data);
				prev=head;
			}
			
			head=head.next;
		}
		
		return tempHead;
	}
	
	/*
	 * Without temp buffer O(N2)
	 */
	public static Node removeDuplicatesWithoutBuffer(Node head){
		
		Node first=head;
		
		while(first !=null){
			
			Node prev=first;
			Node second=first.next;
			
			while(second !=null){
				if(first.data==second.data)
					prev.next=second.next;
				
				prev=second;
				second=second.next;
			}
			
			first=first.next;
		}
		
		return head;
	}

}