

public class Robber {
	public static int rob(int[] nums) {
	    if(nums==null||nums.length==0)
	        return 0;
	 
	    if(nums.length==1)
	        return nums[0];
	 
	    int[] dp = new int[nums.length];
	    dp[0]=nums[0];
	    dp[1]=Math.max(nums[0], nums[1]);
	 
	    for(int i=2; i<nums.length; i++){
	        dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
	    }
	 
	    return dp[nums.length-1];
	}
	
	//{15,12,10,6,16,17}
	//takes 15,12 -> 15
	// takes 10,6 ->10
	//takes 16,17 ->17
	
	
	public static int rob2(int[] nums) {
	    if(nums==null||nums.length==0)
	        return 0;
	 
	    if(nums.length==1)
	        return nums[0];
	    
	 
	    int max=Math.max(nums[0],nums[1]);;
	    int lastIndex=nums[0];
	    
	    if(nums[0]>nums[1]){
	    	lastIndex=0;
	    }
	    
	    for(int i=2; i<nums.length-1; i=i+2){
	        
	    	if((lastIndex-i)==1){
	    		i++;
	    	}else{
	    		 if(nums[i]>nums[i+1]){
	    		    	lastIndex=i;
	    		 }else{
	    			 lastIndex=i+1;
	    		 }
	    		max+=Math.max(nums[i],nums[i+1]);
	    	}
	    	    	
	    	
	    }
	    
	    if(nums.length-lastIndex >2){
	    	max+=nums[nums.length-1];
	    }
	    
	 
	    return max;
	}
}