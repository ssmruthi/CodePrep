package DP;

public class RecursiveMultiply {


	public long multiply(int a,int b){
		if(a<b)
			return recursiveAdd(b,a);
		else
			return recursiveAdd(a,b);
	}
	
	private long recursiveAdd(int a,int b){
		
		if(b==0)
			return 0;
		if(b==1)
			return a;
		
		long x= recursiveAdd(a,b/2);
		x=x+x;
		
		if(b%2==0)
			return x;
		else
			return x+a;
	}
	
	public static void main(String[] args) {

		long v=new RecursiveMultiply().recursiveAdd(100000,200000);
		System.out.println(v);
		
	}

}
