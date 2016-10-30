import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

	public boolean isPalinPermutation(String input){
		
		Map<Character,Integer> charSet= new HashMap<>(); 
		int flag=0;
		for(int i=0;i<input.length();i++){
			
			char currentChar=input.charAt(i);			
			
			if(charSet.containsKey(currentChar) && charSet.get(currentChar)==0){
				flag=1;
			}else{
				flag=0;
			}
			charSet.put(input.charAt(i),flag);					
		}
		
		int count=0;
		for(int temp:charSet.values()){
			if(temp==0){
				count++;
			}
		}
		if(count >1)
			return false;
		
		return true;
	}
}
