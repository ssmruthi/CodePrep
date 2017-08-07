public class SumofLinkedList {
	
	/*
	 * Sum of list if numbers are stored in reverse. Rsult as reverse value
	 * Eg : 312 is represented as 2->1->3
	 *      125 is represented as 5->2->1
	 *      Sum 4->3->7 is 734
	 */
	public static Node sum(Node head1, Node head2){
		
		int carry=0;
		Node result=new Node();
		Node headResult=result;
		
		
		while(head1!=null && head2!=null){
			
			int value=(head1.data+head2.data)+carry;
			carry=value/10;
			result.data=value%10;
			
			head1=head1.next;
			head2=head2.next;
			result.next=new Node();
			result=result.next;
		}
		
		
		while(head1!=null){
			int value=head1.data+carry;
			carry=value/10;
			result.data=value%10;			
			head1=head1.next;
			result.next=new Node();
			result=result.next;
		}
		
		while(head2!=null){
			int value=head2.data+carry;
			carry=value/10;
			result.data=value%10;			
			head2=head2.next;
			result.next=new Node();
			result=result.next;
		}
		
		return headResult;
	
	}
	
}
