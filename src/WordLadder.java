import java.util.List;
import java.util.ListIterator;

class Word{
	String word;
	int level;
	
	Word(String word, int level){
		this.word=word;
		this.level=level;
	}
	
}

//BFS
public class WordLadder{
	
	public static int wordLadder(List<String> dict, String source, String dest){
	
	
		if(source.length() != dest.length())
			return 0;

		//convertToLowerCase and perform BFS
		ListIterator<String> iterator = dict.listIterator();
	    while (iterator.hasNext()){
	        iterator.set(iterator.next().toLowerCase());
	    }
	    
	    source=source.toLowerCase();
	    dest=dest.toLowerCase();
	    
	    
	    		    
	    //create a queue to add list of words which are one character away
		java.util.LinkedList<Word> words= new java.util.LinkedList<Word>();
			
		
		Word origin= new Word(source, 1);
		words.add(origin);
		
		while(!words.isEmpty()){
			
			Word temp = words.removeFirst(); // top of queue
			
			char[] top= temp.word.toCharArray();
			int currentLevel=temp.level;		
			
			for(int i=0;i<top.length;i++){
				
				top= temp.word.toCharArray(); // resets temp to the value from queue				
				for(char c='a';c<='z';c++){									
					top[i]=c;	
					if(String.valueOf(top).equals(dest)){
						return currentLevel+1;
					}
					if(dict.contains(String.valueOf(top)) && !words.contains(String.valueOf(top))){
						Word child= new Word(String.valueOf(top), currentLevel+1);
						words.add(child);						
						dict.remove(String.valueOf(top));
					}
					
				}
				
			}
			
		}
		
		return 0;
	}
}