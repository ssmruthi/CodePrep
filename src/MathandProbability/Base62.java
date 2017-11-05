package MathandProbability;

public class Base62 {

	public static String toBase(int num, int base) { // between 1 to 7

		String baseString = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String res = "";

		while (num != 0) {

			int r = num % base;
			num = num / base;
			res = baseString.charAt(r) + res;

		}

		return res;
	}
	
	public static int toDecimal(String num, int base){ //Z
		int res=0;
		String baseString = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		for(int i=num.length()-1;i>=0;i--){
			
			char c=num.charAt(i);
			res=(res*base)+baseString.indexOf(c);
			
			
		}
		
		return res;
	}

	public static void main(String[] args) {
		String base=Base62.toBase(63,62);
		int decimal=Base62.toDecimal(base,62);
		
		System.out.println(base);
		System.out.println(decimal);
		
	}
}
