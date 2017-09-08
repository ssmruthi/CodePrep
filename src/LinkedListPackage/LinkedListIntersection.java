package LinkedListPackage;
public class LinkedListIntersection {
	
	public static boolean isIntersect(Node head1,Node head2){
		
		while(head1.next!=null){
			head1=head1.next;
		}
		
		while(head2.next!=null){
			head2=head2.next;
		}
		
		if(head1==head2)
			return true;
		
		return false;
		
	}
	
	
	public static Node findIntersect(Node head1,Node head2){
		
		int n1=0;
		int n2=0;
		Node h1=head1;
		Node h2=head2;
		
		while(head1!=null){
			head1=head1.next; n1++;
		}
		
		while(head2!=null){
			head2=head2.next; n2++;
		}
		
		while(n1<n2){
			h2=h2.next;
			n1++;
		}
		while(n2<n1){
			h1=h1.next;
			n2++;
		}
		
		while(h1!=null){
			if(h1==h2)
				return h1;
			
			h1=h1.next;
			h2=h2.next;
			
		}
		
		return null;
	}
	
}
