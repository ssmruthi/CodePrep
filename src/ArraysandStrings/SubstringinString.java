package ArraysandStrings;

/*
 * Given a dictionary
 * [i, like, ice],see if it could form a word ilikeice and ice
 */
public class SubstringinString {
	
	public boolean checkifSubstring(String sub,String input){
		
		int subSize=sub.length();
		
		for(int i=0;i<=input.length()-subSize;i++){
			
			String temp=input.substring(i,i+subSize);
			if(temp.equals(sub)){
				System.out.println(i);
				return true;
			}
		}
		return false;		
	}
	
	
	public static void main(String[] args) {
			System.out.println(new SubstringinString().checkifSubstring("abcd", "abcabcdefg"));
	}

}
