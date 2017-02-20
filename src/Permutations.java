import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 */

/**
 * @author smruthi
 *
 */


public class Permutations {
	
	static Set<String> allPerm= new TreeSet<String>();

	public static List<String> perumtations(String inputString){

		ArrayList<String> result= new ArrayList<String>();

		if(inputString.length()==0){
			result.add("");
			return result;
		}
		
		for(int i=0;i<inputString.length();i++){
			
			String before=inputString.substring(0,i);
			String after=inputString.substring(i+1);
			
			List<String> partials= perumtations(before+after);
			for(String s: partials){
				result.add(inputString.charAt(i)+s);
			}
		}
		
		allPerm.addAll(result);

		return result;		
		
	}
	
	
	
	public static List<String> permutations(String str){
		
		List<String> result= new ArrayList<String>(); 
		if(str.trim().equals("")){
			return null;
		}
		
		if(str.length()==2){
			result.add(str);
			result.add(new StringBuilder(str).reverse().toString());
			
			return result;
		}
		
		for(int i=0;i<str.length();i++){
			
			char fixed=str.charAt(i);
			
			String before=str.substring(0,i);
			String after=str.substring(i+1);
			
			List<String> tempPerm=permutations(before+after);
			
			for(String per:tempPerm){
				result.add(new StringBuilder().append(per).append(fixed).toString());
			}
			
		}
		
		return result;
	}
}
