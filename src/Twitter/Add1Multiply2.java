package Twitter;
import java.util.Scanner;

public class Add1Multiply2 {

    private static int minOperations(long n){
        
        if(n==0)
            return 0;
        
        if(n==1)
            return 1;
        
        int val=minOperations(n/2)+1; // the plus 1 accounts ofr multiply by 2 which is 1 operation
        
        if(n%2>0){ // if there is a reminder, it can be accounted by adding 1
             val++;
        }
        
        return val;
    }
    
    public static void main(String[] args) {
    	/*Input values
    	5247234602369024
    	1472263200374784
    	5156046056980480
    	4610980628594688
    	3163942804193280
    	4866588180611072
    	4261740990365696
    	5442001300226048
    	2633127754334208
    	2812511182585856
    	7175144451997696
    	3386828310511616
    	
    	Output
    	66
		69
		68
		70
		75
		69
		71
		72
		68
		77
		68
		67
		70*/
    	
    	 Scanner in = new Scanner(System.in);
         int t=in.nextInt();
         int i=0;
         while(t>0){
             long n=in.nextLong();
             int val=minOperations(n);
             System.out.println(val);
             t--;
         }
    	
	}
}