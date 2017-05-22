import java.util.Arrays;

public class UniqueString {

	//O(nlogn)
	public static boolean isUniqueString(String inputStr){
		
		if(inputStr.length()>128)
			return false;
		
		char[] input= inputStr.toLowerCase().toCharArray();
		Arrays.sort(input);
		
		for(int i=0;i<input.length-1;i++){
			if(input[i]==input[i+1])
				return false;
		}
		return true;
	}
	
	public static boolean isUniqueBitVector(String input){
		
		int counter=0;
		char[] inputStr= input.toLowerCase().toCharArray();
		
		for(char x:inputStr){
			int val=x-'a';
			if((counter & (1<<val)) >0) {			
				
				return false;
			}
			
			counter|=1<<val;
		}
		
		return true;
		
	}
}
