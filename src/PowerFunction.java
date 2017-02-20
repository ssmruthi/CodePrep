public class PowerFunction {
	
	public static int pow(int pow,int num){
	
		
		if(pow==0 || pow==1){
			return pow;
		}
		
		if(num==0)
			return 1;
		
		int i=0;
		int value=1;
		while(i<num){
			value=value*pow;			
			i++;
		}
		return value;
	}
		
	
	public static int recursivePow(int pow,int num){
		

		if(num==0)
			return 1;
		
		if(num==1)
			return pow;
				
		int value=recursivePow(pow, num/2);
		
		if(num%2==0)
			return value*value;
		else
			return pow*value*value;
		
		
	}
}