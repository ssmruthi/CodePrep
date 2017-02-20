public class PowerFunction {
	
	public static float pow(int pow,int num){
	
		
		if(pow==0 || pow==1){
			return pow;
		}
		
		if(num==0)
			return 1;
		
		int i=0;
		float value=1;
		while(i<Math.abs(num)){  // abs to check if num is negative
			value=value*pow;			
			i++;
		}
		if(num<0)
			return 1/value;
		
		return value;
	}
		
	/*
	 * (base^pow )Works as a recursive call using divide and conquer method
	 * if pow= even, divide by 2 
	 * if pow is odd , do an additional multiplication with pow value
	 * 
	 * works for float and negative pow value.
	 * If pow is negative do the same , inverse value before returning
	 */
	
	public static float recursivePow(int base,int pow){
		
		boolean negativePower=false;
		
		if(pow<0){
			negativePower=true;
			pow=pow*-1;
		}
		
		if(pow==0)
			return 1;
		
		if(pow==1)
			return base;
				
		float value=recursivePow(base, pow/2);
		
		if(pow%2==0){
			value=value*value;				
		}else{
			value=base*value*value;
		}	
		
		if(negativePower)  //the negativePower flag will be the false for rest of recursive calls except for the base
			return 1/value;
		else
			return value;
			
	}
	
}