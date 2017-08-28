package Tree;

import java.util.ArrayList;
import java.util.List;

/*
 * Using Array
 */
public class Trie {

	TrieNode root;

	public Trie() {
		this.root = new TrieNode();
	}

	public void insert(String value) {

		TrieNode temp = root;
		for (char a : value.toCharArray()) {

			a = Character.toLowerCase(a);
			if (temp.child[a - 'a'] == null) {
				temp.child[a - 'a'] = new TrieNode();
			}
			temp = temp.child[a - 'a'];
		}
		temp.end = true;
	}

	public boolean search(String value) {

		TrieNode temp = root;

		for (char a : value.toCharArray()) {
			a = Character.toLowerCase(a);

			if (temp.child[a - 'a'] != null) {
				temp = temp.child[a - 'a'];
			} else {
				return false;
			}
		}

		return temp.end;
	}

	public boolean delete(String value) {

		TrieNode temp = root;

		for (char c : value.toCharArray()) {

			temp = temp.child[c - 'a'];
			if (temp == null)
				return false;
			else {
				temp.child[c - 'a'] = null;
			}
		}

		if (temp.end) {
			temp.end = false;
			return true;
		}

		return false;

	}

	public void displayContactsUtil(TrieNode curNode, String prefix) {

		// Check if the string 'prefix' ends at this Node
		// If yes then display the string found so far
		if (curNode.end)
			System.out.println(prefix);

		// Find all the adjacent Nodes to the current
		// Node and then call the function recursively
		// This is similar to performing DFS on a graph
		for (char i = 0; i < 26; i++) {
			TrieNode nextNode = curNode.child[i];
			if (nextNode != null) {
				displayContactsUtil(nextNode, prefix + i);
			}
		}
	}

	public void displayContacts() {
		displayContacts(root, new ArrayList<Character>(),"");
	}
	
	
	/*
	 * Displays all values startwith prefix
	 * Traverse till child node of prefix. 
	 * 
	 * Call display contact from child.
	 * Print it prepended with prefix
	 */
	public void startsWith(String s){
		TrieNode temp=root;
		
		for(char c:s.toCharArray()){
			temp=temp.child[c-'a'];
			
			if(temp==null)
				return;
		}
		
		displayContacts(temp,new ArrayList<Character>(),s);
	}

	/*
	 * Traverse each child of a TrieNode until leaf, add each node to a list until leaf
	 * If leaf node is encountered print the entire list so far.
	 * Return and remove the last added element.  This is to manage strings like 'abc' and 'abe' where c and e are in same level
	 * 
	 */
	private void displayContacts(TrieNode node, ArrayList<Character> c, String prefix) {

		if (node == null) {
			return;
		}
		
		if (node.end) {
			System.out.print(prefix);
			for (int i = 0; i < c.size(); i++)
				System.out.print(c.get(i));

			System.out.println();
		}

		for (int i = 0; i < node.child.length; i++) {

			if (node.child[i] != null) {
				c.add((char) (i + 97));
				displayContacts(node.child[i], c,prefix);
				c.remove(c.size()-1); 
			}
		}

	}
}

class TrieNode {

	TrieNode[] child = new TrieNode[26];
	boolean end;
}