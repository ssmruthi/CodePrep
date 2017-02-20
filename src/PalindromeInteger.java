
public class PalindromeInteger {
	
	
	static boolean isPalindrome(int n){
		
		int i=0;
		int x=n;
		
		while(x>0){
			//units 
			
			int unit = x%10;
			x=x/10;
			i= i*10 +unit;
		
		}
		
		if(n==i){
			return true;
		}else
			return false;
		
	}
}
