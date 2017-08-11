package LinkedListPackage;


public class LinkedList {

	static Node head=null;
	static Node currHead=null;
	static DoublyNode doublyhead=null;
	static DoublyNode doublycurrhead=null;
	
	
	public static Node createList(int[] arr){
	
		head= new Node(arr[0]);
		currHead=head;
		
		for(int i=1;i<arr.length;i++){
			currHead.next=new Node(arr[i]);
			currHead=currHead.next;
		}
		
		return head;
		
	}
	
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
	
	public static void print(Node head){
		
		while(head!=null){

			System.out.print(head.data+",");
			head=head.next;
		
		}	
	}
	
	public static void print(DoublyNode head){
		
		while(head!=null){

			if(head.random!=null)
				System.out.print(head.data+" ("+head.random.data+")-->");
			else
				System.out.print(head.data+"-->");

			
			head=head.next;
		
		}	
	}
	
	public static DoublyNode createList2(int[] arr){
		
		doublyhead= new DoublyNode(arr[0]);
		doublycurrhead=doublyhead;
		
		for(int i=1;i<arr.length;i++){
			doublycurrhead.next=new DoublyNode(arr[i]);
			doublycurrhead=doublycurrhead.next;
		}
		
		return doublycurrhead;
		
	}
}


