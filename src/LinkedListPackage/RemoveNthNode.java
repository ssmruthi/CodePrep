package LinkedListPackage;

/**
 * Definition for singly-linked list. class ListNode { public int val; public
 * ListNode next; ListNode(int x) { val = x; next = null; } }
 */
public class RemoveNthNode {
	public Node removeNthFromEnd(Node a, int b) {

		if(b<1 || a==null)
			return a;
			
		Node first=a;
		Node second=a;
		
		//1 2 3
		while(b>1){
			second=second.next;
			b--;
			
			if(second==null){
				return a;
			}
		}
		
		while(second.next!=null){
			first=first.next;
			second=second.next;
		}
		
		if(a==first)
			return a.next;
		
		first=first.next;
		
		return a;
		
	}
}
