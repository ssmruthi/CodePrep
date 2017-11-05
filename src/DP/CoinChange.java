package DP;

class CoinChange {
	public static void main (String[] args) {
		int[] a={1,2,3};
		
		System.out.println(coinCount(a,-1,2));
		System.out.println(coinCount(a,-1,3));
		System.out.println(coinCount(a,-1,4));
		System.out.println(coinCount(a,-1,5));
		System.out.println(coinCount(a,-1,6));
		
	}
	
	
	private static int coinCount(int[] arr, int index, int val){
	    int result=0;
	    
	    if(val==0)
	    	return 1;
	    
	    if((index>=arr.length-1 &&val>=1) || val<0)
	    	return 0;
	    
	    
	    		// excluding the curr index			// including curr index
	    result = coinCount( arr, index+1, val) + coinCount( arr, index, val-arr[index+1] );
	   
	    return result;
	}
}