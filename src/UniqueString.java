
public class UniqueString {

	public boolean isUniqueString(String inputStr){
	
		//mergeSort(inputString);
		
		for(int i=1;i<inputStr.length();i++){
			if(inputStr.charAt(i)==inputStr.charAt(i-1)){
				System.out.println("cat");
				return false;
			}
		}
		return true;
	}
}
