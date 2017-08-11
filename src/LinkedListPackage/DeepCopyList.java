package LinkedListPackage;

import java.util.HashMap;

public class DeepCopyList {
	
	public static DoublyNode deepcopyList(DoublyNode head){
		
		if(null==head)
			return null;
		
		DoublyNode newHead=new DoublyNode(0);
		DoublyNode result=newHead;
		DoublyNode inputHead=head;

		HashMap<DoublyNode, DoublyNode> randomMap= new HashMap<DoublyNode, DoublyNode>();
		
		while(inputHead!=null){
			newHead.next=new DoublyNode(inputHead.data);		
			randomMap.put(inputHead,newHead.next);		

			inputHead=inputHead.next;
			newHead=newHead.next;
		
		}
		
		newHead=result.next;
		inputHead=head;
				
		while(inputHead!=null){
			
			if(inputHead.random!=null){
				DoublyNode random=randomMap.get(inputHead.random);
				newHead.random=random;
			}
			
			inputHead=inputHead.next;
			newHead=newHead.next;
			
			
		}
		
		return result.next;
		
	}
	
	
}