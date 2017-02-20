
public class PowerOfTwo {

	public static boolean isPowOfTwoBitWise(int num){   
	    if (((num & (num-1)) == 0) || (num == 0))
	        return true;
	    else  
	        return false;
	}
	
	
	public static boolean isPowOfTwo(int num) {
	    
	    double val=Math.log(num)/Math.log(2);
	    
	    if(val%1==0)
	        return true;
	    else
	        return false;
	}
}

