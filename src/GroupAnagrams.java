import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static Collection<List<String>> groupAnagrams(List<String> input){
		
		Map<String,List<String>> anagram= new LinkedHashMap<String,List<String>>();
		List<String> wordList=null;
				
		for(String word: input){
			
		//treats all ABC and abc as anagram.. case insensitive comparison
			//No need to sort. keeps counter of characters
			
			char[] count = new char[26];			
			for(int i=0;i<word.toLowerCase().length();i++){
				count[word.toLowerCase().charAt(i)-'a']++;
			}
						
			String anagramKey= new String(count);
			
			if(anagram.containsKey(anagramKey)){
				wordList=anagram.get(anagramKey);
				wordList.add(word);
			}else{	
				wordList=new ArrayList<String>(); 
				wordList.add(word);
			}
			 anagram.put(anagramKey, wordList);
		}
		
		return anagram.values();
		
	}
}
