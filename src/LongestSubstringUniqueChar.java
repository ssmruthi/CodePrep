import java.util.HashMap;
import java.util.Map;

public class LongestSubstringUniqueChar {
	
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
	    int max=0;
	    HashMap<Character,Integer> map = new HashMap<Character, Integer>();
	    int start=0;
	 
	    for(int i=0; i<s.length(); i++){
	        char c = s.charAt(i);
	        if(map.containsKey(c)){
	            map.put(c, map.get(c)+1);
	        }else{
	            map.put(c,1);
	        }
	 
	        if(map.size()>2){
	            max = Math.max(max, i-start);
	 
	            while(map.size()>2){
	                char t = s.charAt(start);
	                int count = map.get(t);
	                if(count>1){
	                    map.put(t, count-1);
	                }else{
	                    map.remove(t);
	                }
	                start++;
	            }
	        }
	    }
	 
	    max = Math.max(max, s.length()-start);
	 
	    return max;
	}
	
	
	//Returns longest substring containng only k unique characters.
	//Eg : ababababacdefghi   longest substring containign k=2 unique charctters : ababababa
	
	public static int longestSubstringwithKUniq(String s,int k){
		
		int max=0;
		int start=0;
		int i=0;
		Map<Character,Integer>  charCount= new HashMap<Character, Integer>();
		
		while(i<s.length()){
			
			char c= s.charAt(i);
			
			if(charCount.containsKey(c)){
				
				charCount.put(c, (charCount.get(c)+1));
			}else{
				charCount.put(c, 1);
			}
			
			if(charCount.size()>k){
				max= Math.max(max,i-start);		
				
				while(charCount.size()>k){
					
					int count=charCount.get(s.charAt(start));
					
					if(count>1)
						charCount.put(s.charAt(start),count-1);
					else
						charCount.remove(s.charAt(start));
					
					start++;
				}
				
									

			}
			
			i++;
		}
		
		if(charCount.size()==k){
			max=Math.max(max, i-start);
		}else{
			max=0;
		}

		return max;
	}
}