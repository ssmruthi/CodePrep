package LinkedListPackage;

public class PalindromeLinkedList {
	
	// Method 1 :reverse the list and compare the original and new list
	public static boolean isPalindrome(Node head){
		
		Node reverse=null;
		Node currentHead=head;
		
		while(head!=null){
			
			Node temp=reverse;
			reverse=new Node(head.data);
			reverse.next=temp;
			head=head.next;
		}
		
		while(currentHead!=null){
			if(currentHead.data!=reverse.data)
				return false;
			reverse=reverse.next;
			currentHead=currentHead.next;
		}
		return true;
	}
	
	
	//bacba
	public static boolean isPalindrome2(Node head){
		
		
		if(null==head)
			return true;
		
		Node slow=head;
		Node fast=head;
		
		while(fast.next!=null && fast.next.next!=null){
			fast=fast.next.next;
			slow=slow.next;
		}
		Node mid=slow;
		Node reverse=null;
		slow=slow.next;
		while(slow!=null){
			Node next=slow.next;
			slow.next=reverse;
			reverse=slow;
			slow=next;
		}
		mid.next=reverse;
		mid=mid.next;
				
		while(head!=null && mid!=null){
			
			if(head.data!=mid.data){
				return false;
			}
			
			head=head.next;
			mid=mid.next;
		}
		
		return true;
		
	}
	
	
	

	// using stack



	// using stack


	public static boolean isPalindrome3(Node head){

	if(head==null)
		return true;
		
	java.util.Stack<Node> nodestack= new java.util.Stack<Node>();
	Node slow=head;
	Node fast=head;

	while(fast.next!=null && fast.next.next!=null){
	  fast=fast.next.next;
	  slow=slow.next;
	}

	Node mid;

	if(fast.next==null)
	  mid=slow;
	else
	  mid=slow.next;
	  
	while(mid!=null){
	  nodestack.push(mid);
	  mid=mid.next;
	}


	while(!nodestack.isEmpty()){
	  if(head.data!=nodestack.pop().data)
	    return false;
	    
	    head=head.next;
	}

	return true;

	}



}
