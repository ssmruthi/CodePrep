import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {

	/*
	 * O(N^2) naive approach
	 */
	public static List<Integer> foursum1(int[] arr, int sum) {

		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					if (arr[i] + arr[j] + arr[k] == sum) {
						result.add(arr[i]);
						result.add(arr[j]);
						result.add(arr[k]);
						return result;
					}
				}
			}
		}

		result.add(-1);
		return result;
	}

	
	
	public static List<String> threesum3(int[] arr, int sum) {

		Map<Integer, List<Integer[]>> complement = new HashMap<Integer, List<Integer[]>>();
		List<String> result = new ArrayList<String>();

		//Find sum of all pairs of all numbers . Store it in a hashmap
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				
				int twosum=arr[i] + arr[j];
				List<Integer[]> indexList = new ArrayList<Integer[]>();
				
				if(complement.containsKey(twosum)){
					indexList = complement.get(twosum);				
				}
				Integer[] index= new Integer[2];
				index[0]=i;
				index[1]=j;
				indexList.add(index);
				
				complement.put(twosum, indexList);					
			}
		}
		
		//Iterate through the array and chk if a complement is available in the hasmap. If so return the index
		//Make sure to evaluate the complement is not pointing to itself.

		for (int i=0;i<arr.length;i++) {

			int diff = sum - arr[i];
			
			if (complement.containsKey(diff)) {

				List<Integer[]> indexList = complement.get(diff);
				
				for(Integer[] index: indexList){
					if(index[0]!=i && index[1]!=i){
						
						String threesum=arr[index[0]]+":"+arr[index[1]]+":"+arr[i];						
						result.add(threesum);
						
					}
				}
			}

		}

		if(result.isEmpty())
		result.add("-1");
		
		return result;
	}
	
	
	public static List<String> threesum(int[] arr, int sum) { //[4,3,1,2]

		Arrays.sort(arr); //[1,2,3,4]
		List<String> result = new ArrayList<String>();

		for(int i=0;i<arr.length;i++) { //i=0;0<4 => true
			
			int start=i+1; //start = 1
			int end= arr.length-1; //end = 3;
			
			while(start<end){ //1<3 => true
				
				if(arr[start]+arr[end]+arr[i]==sum){ 
					String temp=arr[start]+","+arr[end]+","+arr[i];
					result.add(temp);
					start++;
					end--;
					//break;
					//return result;
				}
				
				if(arr[start]+arr[end] > sum-arr[i]){
					end--;
				}
				
				if(arr[start]+arr[end] < sum-arr[i]){
					start++;
				}
				
				
			}
		}
		
		if(result.isEmpty())
			result.add("-1");
		
		return result;
		
	}

}
