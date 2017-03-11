import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class MaxTimefrom4intgers {

	public static String timeformatIntegers(int[] arr){
			
				
		List<Integer> comb=getCombinations(arr);
		int maxHour=-1;
		int maxMinutes=-1;
		
		for(int a:comb){
			if(a<=23){
				maxHour=Math.max(a, maxHour);
			}
		}
				
		int digit=maxHour%10;
		int count=1;
		
		for(int i=0;i<arr.length && count<=2 ;i++){
			
			if(arr[i]==digit){
				arr[i]=-1;
				digit=maxHour/10;
				count++;				
			}
			
		}
		
		comb=getCombinations(arr);
		
		for(int a:comb){
			if(a<60){
				maxMinutes=Math.max(a, maxMinutes);
			}
		}
		
		StringBuilder result= new StringBuilder();

		if(maxHour< 0 || maxMinutes < 0){
			return "No Combination";
		}
		if(maxHour<10 && maxHour>0)
			result.append("0");
			result.append(maxHour).append(":");
			
		if(maxMinutes<10 && maxMinutes >0)
			result.append("0");
			result.append(maxMinutes);
		
		
		return result.toString();
	}
	
	private static List<Integer> getCombinations(int[] arr){
		
		List<Integer> comb= new ArrayList<Integer>();
		
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]!=-1 && arr[j]!=-1)
				comb.add(arr[i]*10+arr[j]);
			}
		}
		
		for(int i=arr.length-1;i>=0;i--){
			for(int j=i-1;j>=0;j--){
				if(arr[i]!=-1 && arr[j]!=-1)
				comb.add(arr[i]*10+arr[j]);
			}
		}
		
		return comb;
	}
	
	/*
	 * O(n) solution
	 * Validates based HH:MM position
	 */
	
	public static String getTimeFormat(int[] arr){
		
		StringBuilder result=new StringBuilder();
		
		if(arr.length<4){
			return null;
		}
		
		List<Integer> input= new ArrayList<Integer>();
				
		for(int a: arr){
			input.add(a);
		}
		
		int hourPosOne=getMaxValue(input,2); //validates for hours upto //23
		int hourPosTwo=-1;
		
		if(hourPosOne==2){ 
			hourPosTwo=getMaxValue(input,3); 
		}else if(hourPosOne==1 || hourPosOne==0){ //validate for hours raning from 00 to 19
			hourPosTwo=getMaxValue(input,9);
		}else{
			return null;
		}
		
		int minPosOne=getMaxValue(input, 5); //validates for minutues upto 59
		int minPosTwo=getMaxValue(input, 9);
		
		
		if(minPosOne==-1 || hourPosTwo==-1 || minPosTwo==-1)
			return null;
		
		result.append(hourPosOne).append(hourPosTwo).append(":").append(minPosOne).append(minPosTwo);
		
		return result.toString();
	}
	
	
	private static int getMaxValue(List<Integer> input, int upperBound){
		
		while(upperBound>=0){
			
			if(input.contains(upperBound)){
				int i=input.indexOf(upperBound);
				input.remove(i);
				return upperBound;
			}
			upperBound--;
		}
		
		return -1;
	}

	

}
