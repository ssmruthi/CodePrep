
public class PartitionLinkedList {


	

	static void print(Node head){
		
	
		while(head!=null){

			System.out.println(head.data);
			head=head.next;
		
		}
		
	}
	
	static Node partition(Node head, Node part){
		
		Node leftPartition=new Node();
		Node rightPartition=new Node();
		
		rightPartition.data=part.data;
		rightPartition.next=null;
		
		Node leftPointer= null;
		Node rightPointer=rightPartition;
		
		while(head!=null){
			
			//create new node and copy values
			Node newNode= new Node();
			newNode.data=head.data;
			newNode.next=null;
			
			if(head.data < part.data && head!=part && head.data != part.data){
				if(leftPointer ==null){
					leftPointer=newNode;
					leftPartition=leftPointer;					
				}else{
					leftPointer.next=newNode;
					leftPointer=newNode;
					System.out.println(leftPointer.data);
				}
			}else if(head.data>= part.data && head!=part){
				rightPointer.next=newNode;
				rightPointer=newNode;
			}
			
			head=head.next;
		}
		
		if(leftPointer!=null)
			leftPointer.next=rightPartition;
		else{
			leftPartition=rightPartition;
		}
		return leftPartition;
	}
		
}
