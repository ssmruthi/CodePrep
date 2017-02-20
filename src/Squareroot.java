public class Squareroot {
	
	public static float sqrt(int num){
	
		//find the interval where sqrt value lies, return the lowest.
		
		int value=num/2;
		int start=num/2;
		int end=0;
		while(Math.abs(start-end)>1){
			
			if (value*value == num)
				return value;
			
			if(value*value <num){
				start=value;
				value=value+1;
			}else if(value*value > num){
				value=value-1;
				end=value;
			}
		}
		
		return start;
	}
}