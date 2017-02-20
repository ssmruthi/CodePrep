
public class FibonacciDP {

	static int cache[]= new int[100];
	
	public static int fib(int n){
		 
	 if(n==0)
		 return 0;
	 
	 if(n==1)
		 return 1;
	 
	 if(cache[n]==0)
		 cache[n]=(fib(n-1)+fib(n-2)); 

	 return cache[n];
	}


}
