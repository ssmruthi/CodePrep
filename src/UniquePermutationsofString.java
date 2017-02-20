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


public class UniquePermutationsofString {
	

	public static List<String> uniquePerm(String input){
		
		List<String> allperm= new ArrayList<String>();
			uniquePerm(input, allperm);
		return allperm;
	}
		
	public static List<String> uniquePerm(String input,List<String> allperm){
		
		List<String> perm= new ArrayList<String>();
		
		if(input.trim().length()==0){
			perm.add("");
			return perm;
		}
		
		for(int i=0;i<input.length();i++){
			char fixed=input.charAt(i);
			String before=input.substring(0,i);
			String after =input.substring(i+1,input.length());
			
			List<String> subStringPermList= uniquePerm(before+after,allperm);
			
			for(String permutation:subStringPermList){
				perm.add(permutation+fixed);
			}
					
		}
		allperm.addAll(perm); //use treeset to get rid of duplicates
		return perm;
	}
	
	
	
}
