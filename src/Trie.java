public class Trie {
}

class TrieNode {

	TrieNode[] child = new TrieNode[27];
	char data;
	
	
	TrieNode(){
		data='*';
	}
	
	public TrieNode add(char val) {

		int asciivalue = Character.toLowerCase(val);
		TrieNode childNode = new TrieNode();
		childNode.data=val;

		if(asciivalue >=97 && asciivalue <=122 ){
			
			if(child[asciivalue - 97] != null && child[asciivalue - 97].data==val)
				return child[asciivalue - 97];
			else{
				child[asciivalue - 97] = childNode;
				return child[asciivalue - 97];
			}
			
			

		}else{
			if(child[26] != null && child[26].data==val)
				return child[26];
			else{
				child[26]=childNode;
				return child[26];
			}
		}	

	}
	public void insert(String val) {

		char[] name= val.toCharArray();
		TrieNode node= new TrieNode();
		
		node=this.add(name[0]);
		int i = 1;
		while (i < name.length) {
			node = node.add(name[i]);
			i++;
		}
		node.add('*');		
	}
	
	public boolean validate(String val){
	
		val=val.concat("*");
		char[] name= val.toCharArray();
		TrieNode node= this.isValid(name[0]);
		int i = 1;
		while (i < name.length) {
			node = node.isValid(name[i]);
			if(node==null){
				System.out.println("not valid");
				return false;
			}
			i++;
		}
		
		System.out.println("valid");
		return true;
	}
	
	public TrieNode isValid(char val){
		
				
		if(val=='*' && this.child[26]!=null && this.child[26].data==val)
			return this.child[26];
			
		else if(val !='*' && this.child!=null && this.child[val-97] != null && this.child[val-97].data==val)
			return this.child[val-97];
		
		else
			return null;
		
	}
	
	
public void printTrie() {

		System.out.print(data+",");

		for (TrieNode t :child){
				if(t!=null)
				t.printTrie();
		}

	}
}