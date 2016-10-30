import java.util.HashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author smruthi
 *
 */
public class PermutationString {

	public boolean isPermuation(String inputString1, String inputString2){
			
		
		Map<Character, Integer> permutationcheck = new HashMap<>();
		int count=1;
		
		if(inputString1.length() != inputString2.length()){
			//Different length	
			return false;
		}
		
		//Put all the characters of the one input string into HashMap.
		//If same char is present more than once, increment counter
		
		for(int i=0;i< inputString2.length(); i++){
		
			if(null==permutationcheck.get(inputString2.charAt(i)))
				permutationcheck.put(inputString2.charAt(i), count);
			else{
				count=permutationcheck.get(inputString2.charAt(i));
				permutationcheck.put(inputString2.charAt(i), count+1);
			}
		}
		System.out.println("Map is"+permutationcheck);
		
		//Compare string two against the Hashmap. Check for key for every char in input2.
		//if present decrement counter in map to mark as read and continue checking
		//if not present break as not permutation
		
		for(int i=0;i< inputString1.length(); i++){			
			char x= inputString1.charAt(i);
			count=0;
			
			if(permutationcheck.containsKey(x)){
				count=permutationcheck.get(x);			
				if(count >= 1){
					permutationcheck.put(x,count-1);
					continue;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}
		return true;
	}
}
