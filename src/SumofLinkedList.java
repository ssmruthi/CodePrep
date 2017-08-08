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
	
	
	/*
	 *Sum of two linked list
	 *Values stored forward 
	 * Eg : 213 is represented as 2->1->3
	 *      521 is represented as 5->2->1
	 *      Sum 7>3>4 is 734
	 */
	public static Node sum2(Node h1, Node h2){
		
		int n1=0;
		int n2=0;
		
		Node r=null;
		
		Node head1=h1;
		Node head2=h2;
		
		while(head1!=null){
			n1++;
			head1=head1.next;
		}
		
		while(head2!=null){
			n2++;
			head2=head2.next;
		}
		
		while(n1<n2){
			Node node=new Node(0);
			node.next=h1;
			h1=node;
			n1++;
		}
		while(n2<n1){
			Node node=new Node(0);
			node.next=h2;
			h2=node;
			n2++;
		}
		
		r=recurseSum(null,h1,h2,0);
		return r;
		
	}



	private static Node recurseSum(Node r,Node h1, Node h2,int carry) {

	
		if(h1==null && h2==null){
			return null;
		}
			
		r=recurseSum(r,h1.next,h2.next,carry);
		int value=	h1.data+h2.data+carry;
		carry=value>10?1:0;
		
		Node newNode= new Node(value%10);
		newNode.next=r;
		r=newNode;

		return r;
	}
	
}









