package Design;

import java.util.HashMap;
import java.util.Map;

class LRUNode {
	LRUNode prev;
	LRUNode next;
	int value;
	int key;

	public LRUNode(int key,int value) {
		this.value = value;
		this.key=key;
	}
}

public class LRUCache {

	LRUNode head;
	LRUNode tail;
	int capacity = 0;
	int size=0;
	Map<Integer, LRUNode> map = new HashMap<>();

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	private void put(int key, int value) {

		LRUNode node = new LRUNode(key,value);
		size++;
		
		map.put(key, node);
		

		if (head == null || tail ==null) {
			head = node;
			tail = node;
		} else {
			node.prev = null;
			node.next = head;
			head.prev = node;
			head = head.prev;
		}

		// Remove from Tail move tail ahead
		if (size > capacity) {

			map.remove(tail.key);
			tail = tail.prev;
			
			if(tail!=null)
			 tail.next = null;
			
			size--;
		}

	}

	private int get(int key) {
		if (map.containsKey(key)) {

			// move node to head
			LRUNode node = map.get(key);


			
			if(node==head){
				return node.value;
			}
			
			LRUNode prev = node.prev;
			LRUNode next = node.next;

			if(prev!=null)
			prev.next = next;
			
			if(next!=null)
			next.prev = prev;

			node.prev=null;
			node.next = head;
			head.prev = node;
			head=head.prev;

			return node.value;

		} else {
			return -1;
		}

	}

	private void printLRU() {
		LRUNode node = head;

		while (node != null) {
			System.out.print(node.value + "->");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(1);

		cache.put(2, 1); cache.printLRU();
		System.out.println("::::"+cache.get(2));    
		cache.put(3, 2); cache.printLRU();      
		System.out.println("::::"+cache.get(2));       // returns 4
		System.out.println("::::"+cache.get(3));       // returns 4
		

	}

}
