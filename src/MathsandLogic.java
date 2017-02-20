public class MathsandLogic {

	public static void main(String[] args) {
		
		System.out.println(atoi("-327899999999999"));

		
	}

	public int gcd(int value1,int value2){
		
		int r=value1 % value2;
		
		while(r!=0){
		 value1=value2;
		 value2=r;
		 r=value1 % value2;
		}
		return value2;
	}
	
	public static boolean isInteger(double a){
		
		if(a%1==0){
			return true;
		}
		
		return false;
	}
	
	public static String convertDoubleToString(double a){
		
		StringBuilder sb= new StringBuilder();
		
		double fraction=a%1;
		double decimal=a-fraction;
		
		sb.append(decimal).append(".").append(fraction);
		
		return sb.toString();
	}
	
	public static int atoi(String s){
		
		boolean isNegative=false;
		
		if(s==null || s.equals("0"))
			return 0;
		
		char[] str= s.toCharArray();
			
		int i=str.length-1;
		int k=1;
		double result=0;
		
		while(i >= 0){
			
			if(str[i]=='-'){
				isNegative=true;
				break;
			}else if(str[i]=='+'){
				isNegative=false;
				break;
			}else if(str[i]=='.'){
				result=result/k;
				k=1;
			}else if(str[i]>=48 && str[i]<=57){			
				int value=str[i]-48;
				result+=(value*k);
				k*=10;
			}else{
				result=0.0;
				break;
			}
			
			i--;
		}
		
		if(isNegative){
			result*=-1;
		}
		
		return (int)result;
	}
	
}
