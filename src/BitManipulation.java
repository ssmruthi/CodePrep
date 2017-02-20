public class BitManipulation {

	public static void main(String[] args) {
		
		
		//add
		int a= 0b1010;
		int b= 0b1011;
		int c= a+b;
		c=0b0110;
		System.out.println(c>>2);
		System.out.println(Integer.toBinaryString(c>>2));
		System.out.println(Integer.toBinaryString(c<<2));
		System.out.println(c<<2);
	}
	

	
}
