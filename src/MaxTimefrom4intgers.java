import java.util.ArrayList;
import java.util.List;

public class MaxTimefrom4intgers {

	public static String timeformatIntegers(int[] arr){
				
		List<Integer> comb=getCombinations(arr);
		int maxHour=0;
		int maxMinutes=0;
		
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

		if(maxHour<10)
			result.append("0");
			result.append(maxHour).append(":");
			
		if(maxMinutes<10)
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

}
