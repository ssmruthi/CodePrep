import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

	/*
	 * O(N^2) naive approach 
	 */
	public static List<Integer> twosum1(int[] arr, int sum){
		
		List<Integer> result= new ArrayList<Integer>();
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]+arr[j]==sum){
					result.add(arr[i]);
					result.add(arr[j]);
					return result;
				}
					
			}
		}
		
		result.add(-1);
		return result;
	}
	
	/*
	 * O(nlogn +n) sorting, start and end pointer
	 */
	public static List<Integer> twosum2(int[] arr, int sum){
		
		Arrays.sort(arr);
		int start=0;
		int end=arr.length-1;
		
		List<Integer> result= new ArrayList<Integer>();
		
		while(start<end){
			
			if(arr[start]+arr[end]==sum){
				result.add(arr[start]);
				result.add(arr[end]);
				return result;
			}else if(arr[start]+arr[end]<sum){
				start++;
			}else if(arr[start]+arr[end]>sum){
				end--;
			}
		}
		
		result.add(-1);
		return result;
	}
	
	
	/*
	 * O(n) HashMap complement of the sum
	 */
	public static List<Integer> twosum3(int[] arr, int sum){
		
		Map<Integer,Integer> complement = new HashMap<Integer,Integer>(); 
		 
		List<Integer> result= new ArrayList<Integer>();
		
		for(int i=0;i<arr.length;i++){
			complement.put(arr[i], i);
		}
			
		for(int i=0;i<arr.length;i++){
			
			int diff=sum-arr[i];
			if(complement.containsKey(diff) && complement.get(diff)!=i){
				result.add(arr[i]);
				result.add(diff);
				return result;
			}
			
		}
		
		
		result.add(-1);
		return result;
	}
	
	
}
