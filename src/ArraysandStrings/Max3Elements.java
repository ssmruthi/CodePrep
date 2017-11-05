package ArraysandStrings;

public class Max3Elements {
	
	private static void max3sum(int[] arr){
		
		int m1=0,m2=0,m3=0;
		
		//2,4,1,5   --542
		for(int a: arr){
			
			if(a>m1){
				m3=m2;   //
				m2=m1;	//2
				m1=a;  	//4
			}else if(a> m2){
				m3=m2;
				m2=a; //1
			}else if(a > m3){
				m3=a; //1
			}
		}
		System.out.println(m3);
		System.out.println(m2);
		System.out.println(m1);
	
	}
	
	public static void main(String[] args) {
		
		int[] a= {21,2,36,45,185,6,7,89};
		max3sum(a);
	}
}

