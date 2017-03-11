import java.util.*;

/*
 * Input: arr[] = {1, 9, 3, 10, 4, 20, 2};, Output: 4
 * The subsequence 1, 3, 4, 2 is the longest subsequence 
 * of consecutive elements
 */

public class LongestSubsequence {
	
	public static int lengthOfLongestSubsequence(int[] arr) {
		
		int max=0; // maxLength
		int length=0; //currentLength in a sequence
		Set<Integer> inputArr= new HashSet<Integer>();
		
		for(int a: arr){
			inputArr.add(a);
		}
		
		for(int i=0;i<arr.length;i++){
			length=0;
			if(!inputArr.contains(arr[i]-1)){
				
				int j=arr[i];
				while(inputArr.contains(j)){
					length++;
					j++;
				}
				
			max=Math.max(length,max);			
			}
		}
		
		return max;
	   
	}
	
	
	public static int lengthOfLongestSubsequenceBySorting(int[] arr) {
		
		int max=0; // maxLength
		int length=1; //currentLength in a sequence
		
		Arrays.sort(arr);;
				
		for(int i=1;i<arr.length;i++){
			if(Math.abs(arr[i-1] -arr[i])==1 ){
				length++;
			}else{
				max=Math.max(length, max);
				length=1;
			}
		}
		
		
		return max;
	   
	}
	   
}