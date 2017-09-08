package LinkedListPackage;


/*
 * Merge two sorted list
 */
public class MergeLinkedList {
	
	
	public static Node mergeList(Node head1, Node head2){
		
		Node newHead= new Node(0);
		Node returnhead=newHead;
		
		
		while(head1!=null && head2!=null){
			
			if(head1.data<head2.data){
				newHead.next=head1;
				head1=head1.next;
			}else{
				newHead.next=head2;
				head2=head2.next;
			}
			newHead=newHead.next;
		}
		
		while (head1 != null) {

			newHead.next = head1;
			head1 = head1.next;
			newHead=newHead.next;
		}

		while (head2 != null) {
			newHead.next = head2;
			head2 = head2.next;
			newHead=newHead.next;

		}
				
		return returnhead.next;
	}
}



