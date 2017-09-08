package LinkedListPackage;


//Given a singly linked list L: L0 L1 ... Ln-1 Ln,
//reorder it to: L0 Ln L1 Ln-1 L2 Ln-2 ...

////For example, given {1,2,3,4}, reorder it to {1,4,2,3}. You must do this in-place without altering the nodes' values


public class ReorderLinkedList {
	
	public static Node reorder(Node head){
		
		Node slow=head;
		Node fast=head;
		
		while(fast.next!=null && fast.next.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		

		Node second=ReverseLinkedList2.reverse(slow.next);

		slow.next=null;
		Node first=head;
		
		Node newHead= mergeLists(first,second);
		return newHead;
	}

	private static Node mergeLists(Node first, Node second) {


		Node newHead= new Node(0);
		Node result=newHead;
		int i=0;
	
		while(first!=null || second!=null){
			
			if(i%2==0){
				newHead.next=first;
				first=first.next;
			}else{
				newHead.next=second;
				second=second.next;
			}
			
			newHead=newHead.next;
			i++;
		}
		return result.next;
	}
	
}



