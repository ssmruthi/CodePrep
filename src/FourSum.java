import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourSum {

	/*
	 * O(N^2) naive approach 
	 */
	public static List<Integer> foursum1(int[] arr, int sum){
		
		List<Integer> result= new ArrayList<Integer>();
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				for(int k=j+1;k<arr.length;k++){
					for(int m=k+1;m<arr.length;m++){
						if(arr[i]+arr[j]+arr[k]+arr[m]==sum){
							result.add(arr[i]);
							result.add(arr[j]);
							result.add(arr[k]);
							result.add(arr[m]);
							return result;
						}
					}
					
				}
			}
		}
		
		result.add(-1);
		return result;
	}
	
		
	/*
	 * O(n) HashMap complement of the sum
	 */
	public static List<Integer> foursum2(int[] arr, int sum){
		
		Map<Integer,Integer[]> complement = new HashMap<Integer,Integer[]>(); 		 
		List<Integer> result= new ArrayList<Integer>();
		
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){	
				Integer[] index= new Integer[2];
				index[0]=i;
				index[1]=j;
				complement.put(arr[i]+arr[j], index);
			}
		}
			
		for(int a: complement.keySet()){
			
			int diff=sum-a;
			Integer[] currentIndexValue=complement.get(a);
			
			if(complement.containsKey(diff) && complement.get(diff) != currentIndexValue){
				
				//first pair
				result.add(arr[currentIndexValue[0]]);
				result.add(arr[currentIndexValue[1]]);
				
				//complement pair
				currentIndexValue=complement.get(diff);
				
				result.add(arr[currentIndexValue[0]]);
				result.add(arr[currentIndexValue[1]]);
				
				return result;
			}
			
		}
		
		
		result.add(-1);
		return result;
	}
	
	
}
